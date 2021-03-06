package com.inn.trusthings.service.command;

/*
 * #%L
 * trusthings-service
 * %%
 * Copyright (C) 2015 COMPOSE project
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.net.URI;
import java.util.List;

import org.apache.jena.atlas.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.open.kmi.iserve.commons.io.Syntax;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.inn.trusthings.bdg.Bridge;
import com.inn.trusthings.kb.RDFModelsHandler;
import com.inn.trusthings.kb.SharedOntModelSpec;
import com.inn.trusthings.kb.SparqlGraphStoreManager;
import com.inn.trusthings.model.factory.TrustModelFactory;
import com.inn.trusthings.model.io.ToGraphParser;
import com.inn.trusthings.model.pojo.Agent;
import com.inn.trusthings.model.vocabulary.NSPrefixes;
import com.inn.trusthings.model.vocabulary.Trust;
import com.inn.trusthings.service.config.CollectorConfig;
import com.inn.util.uri.UIDGenerator;

/**
 * Metadata fetch command responsible for obtaining resource annotations either from local file system / online / triple
 * stores
 * 
 * @author markov
 * 
 */
public class SemanticMetaDataFetcher {

	private final SparqlGraphStoreManager graphStoreManager;
	private final List<SparqlGraphStoreManager> externalGraphStoreMgrs;
	private static final Logger log = LoggerFactory.getLogger(SemanticMetaDataFetcher.class);

	public SemanticMetaDataFetcher(final SparqlGraphStoreManager graphStoreManager, final List<SparqlGraphStoreManager> externalGraphStoreMgrs) {
		this.graphStoreManager = graphStoreManager;
		this.externalGraphStoreMgrs = externalGraphStoreMgrs;
	}

	/**
	 * 
	 * @param uri
	 * @param fetchFromExternalRegistries
	 * @param useMappedLocations
	 * @param fetchFromInternalRegirsty
	 * @return
	 */
	public OntModel apply(URI uri, boolean fetchFromExternalRegistries, boolean useMappedLocations, boolean fetchFromInternalRegirsty) {

		Model externalModel = null;
		// Try to get the service descr from the external registries.
		try {
			if (fetchFromExternalRegistries) {
				log.info("obtaining model from external registries using sparqlEndpoint");
				externalModel = fetchServiceFromExternalRegistry(uri);
			}
		} catch (Exception e) {
			// Not found. It is safe not to handle the exception.
		}
		// try to find it on the web or via location mapping
		if (externalModel == null && useMappedLocations) {
			log.info("obtaining model using com.inn.RDFModelHandler for loading / retrieving {cached} models. "
					+ "	Caching is "+RDFModelsHandler.getGlobalInstance().isCachingModels());
			try {
			   externalModel = RDFModelsHandler.getGlobalInstance().
							fetchDescriptionFromFileSystem(uri.toASCIIString(), Syntax.TTL.getName(), SharedOntModelSpec.getModelSpecShared());

				if ( externalModel == null){
						log.info("requested model for "+ uri.toASCIIString()+ " not found. If you have description use "
								+ "addResourceDescription(URI resourceURI, InputStream inputStream) of TrustManager to add it into module");

				}
				
//				return ModelFactory.createOntologyModel(SharedOntModelSpec.getModelSpecShared());
				
			} catch (org.apache.jena.atlas.web.HttpException e) {
				log.info(" There was model retrival failure. Failed to retrive model because " + e.getMessage());
			}
		}
		// try to find it in internal registry

		Model internalModel = null;
		try {
			if (fetchFromInternalRegirsty) {
//				Log.info(this, "obtaining model from internal registry using sparqlEndpoint");
//				internalModel = graphStoreManager.getGraph(uri);
				Log.info(this, "obtaining model from internal MYSQL using D2RQ Bridge or CustomBridge");
				internalModel = CollectorConfig.InternalCollector.getCollector().collectInformation(uri.toASCIIString());
			}
		} catch (Exception e) {
			//FIXME this log below is obsolute. now using mysql.
			if (e instanceof org.apache.jena.atlas.web.HttpException) {
				log.info("internal registry using sparqlEndpoint connection refused - sparqendpoint is not running //" + e.getMessage());
			} else if (e.getMessage()!=null && e.getMessage().contains("HTTP error code")) {
				throw new RuntimeException(e);
			}
				else {
				e.printStackTrace();
			}
		}
		
		Model modelUnion;
		if (internalModel != null) {
			modelUnion = internalModel;
			if (externalModel != null)
				modelUnion = internalModel.union(externalModel);
		} else {
			modelUnion = externalModel;
		}
		OntModel model = ModelFactory.createOntologyModel(SharedOntModelSpec.getModelSpecShared(), modelUnion);

		if (model.contains(null, Trust.hasProfile) == false) {
			model.setNsPrefixes(NSPrefixes.map);
			Agent service = new Agent(uri);
			TrustModelFactory trm = new TrustModelFactory(UIDGenerator.instanceTrust);
			service.setHasTrustProfile(trm.createTrustProfile());
			OntModel m = new ToGraphParser().parse(service);
			model = ModelFactory.createOntologyModel(SharedOntModelSpec.getModelSpecShared(), model.union(m));
		}
		return model;
	}

	/**
	 * goes thru a list of spaqrqlEndpoints and tries to find any metadata for the service
	 * 
	 * @param uri - service URI.
	 * @return
	 */
	private Model fetchServiceFromExternalRegistry(URI uri) {
		Model model = null;
		for (SparqlGraphStoreManager storeManager : externalGraphStoreMgrs) {
			model = storeManager.getGraph(uri);
			if (model.isEmpty() == false) // stop when model is found
				continue;
		}
		return model;
	}

}
