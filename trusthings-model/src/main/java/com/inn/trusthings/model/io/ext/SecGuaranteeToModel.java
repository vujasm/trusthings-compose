package com.inn.trusthings.model.io.ext;

/*
 * #%L
 * trusthings-model
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
import java.util.Iterator;
import java.util.List;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import com.hp.hpl.jena.util.iterator.Filter;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.OWL2;
import com.inn.trusthings.model.pojo.SecurityAttribute;
import com.inn.trusthings.model.pojo.SecurityGoal;
import com.inn.trusthings.model.pojo.SecurityMechanism;
import com.inn.trusthings.model.pojo.SecurityTechnology;
import com.inn.trusthings.model.vocabulary.Trust;
import com.inn.trusthings.model.vocabulary.UsdlSec;

/**
 * 
 * A parser to parse SecGuaranteeToModel onto Java Objects
 * 
 * @author marko
 * 
 */

public class SecGuaranteeToModel {



	public SecGuaranteeToModel() {
		
	}
	


	public void parse(Individual individual, SecurityAttribute attribute) {
		RDFNode securityDescriptionNode = individual.getPropertyValue(ModelFactory.createDefaultModel().createProperty(Trust.NS+"hasSecurityDescription"));
		Individual securityDescriptionIndividual = securityDescriptionNode.as(Individual.class);
		fillSecurityGoals(securityDescriptionIndividual, attribute);
		fillSecurityMechanism(securityDescriptionIndividual, attribute);
		fillSecurityTechnologies(securityDescriptionIndividual, attribute);
	}

	private void fillSecurityGoals(Individual individual, SecurityAttribute attribute) {
		NodeIterator goalNodes = individual.listPropertyValues(UsdlSec.hasSecurityGoal);
		while (goalNodes.hasNext()) {
			RDFNode rdfNode = (RDFNode) goalNodes.next();
			SecurityGoal goal = new SecurityGoal(URI.create(rdfNode.asNode().getURI()));
			fillTypes(goal, rdfNode.asResource());
			attribute.addSecurityGoal(goal);
		}
	}

	private void fillSecurityMechanism(Individual individual, SecurityAttribute attribute) {
		NodeIterator implementedByNodes = individual.listPropertyValues(UsdlSec.isImplementedBy);
		while (implementedByNodes.hasNext()) {
			RDFNode securityMechanismNode = (RDFNode) implementedByNodes.next();
			Individual securityMechanismIndividual = securityMechanismNode.as(Individual.class);
			List<Resource> list = listSectypes(securityMechanismIndividual);
			for (Resource usdlSecMechanism : list) {
				SecurityMechanism mechanism = new SecurityMechanism(URI.create(usdlSecMechanism.asNode().getURI()));
				attribute.addImplementedBy(mechanism);
				fillTypes(mechanism, securityMechanismIndividual.asResource());
			}
		}
	}

	private void fillSecurityTechnologies(Individual securityMechanismNode, SecurityAttribute mechanism) {
		NodeIterator realizedByNodes = securityMechanismNode.listPropertyValues(UsdlSec.isRealizedByTechnology);
		while (realizedByNodes.hasNext()) {
			RDFNode securityTechnologyNode = (RDFNode) realizedByNodes.next();
			SecurityTechnology technology = new SecurityTechnology(URI.create(securityTechnologyNode.asNode().getURI()));
			mechanism.addRealizedByTechnology(technology);
			Individual securityTechnologyIdvl = securityTechnologyNode.as(Individual.class);
			fillTypes(mechanism, securityTechnologyIdvl.asResource());
		}
	}

	private void fillTypes(com.inn.trusthings.model.pojo.TResource tResource, Resource asResource) {
		Iterator<Resource> types = asResource.as(Individual.class).listRDFTypes(true);
		while (types.hasNext()) {
			Resource type = (Resource) types.next();
			if (tResource != null) {
				tResource.addType(new com.inn.trusthings.model.pojo.TResource(URI.create(type.getURI())));
			}
		}
	}

	/**
	 * Lists types
	 * @param individual
	 * @return
	 */
	private List<Resource> listSectypes(Individual individual) {
		ExtendedIterator<Resource> types = individual.listRDFTypes(true);
		Filter<Resource> typeFilter = new Filter<Resource>() {
			@Override
			public boolean accept(Resource x) {
				if (x.getURI().startsWith(OWL.NS) || x.getURI().startsWith(OWL2.NS)) {
					return false;
				}
				return true;
			}
		};
		return types.filterKeep(typeFilter).toList();
	}

}
