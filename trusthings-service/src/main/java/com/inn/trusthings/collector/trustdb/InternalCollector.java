package com.inn.trusthings.collector.trustdb;

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
import java.util.Map;

import javax.ws.rs.NotSupportedException;

import com.hp.hpl.jena.rdf.model.Model;
import com.inn.trusthings.bdg.ABridge;
import com.inn.trusthings.bdg.BridgeDB;
import com.inn.trusthings.collector.AbstractCollector;
import com.mv.util.vcap.VCAPParser;


public class InternalCollector extends AbstractCollector {
	
	private ABridge b ;

	public InternalCollector(String sourceUri) {
		setSourceUri(sourceUri);
		initBridge();
	}

	private void initBridge() {
//		System.out.println("init internal collector");
		String databaseUrl = null;
		try {
			if (VCAPParser.parseVcap_Services()!=null){
				System.out.println(InternalCollector.class+": trust service - vcap service env exists");
				 String username = VCAPParser.obtainDBServiceUsername(VCAPParser.parseVcap_Services());
				 String password = VCAPParser.obtainDBServicePassword(VCAPParser.parseVcap_Services());
				 databaseUrl = VCAPParser.obtainDBServiceJDBCURI(VCAPParser.parseVcap_Services())
						  + "?user="+username+"&password="+password;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		b = new BridgeDB(databaseUrl);
	}

	@Override
	public Model collectInformation(String resourceIdentifier) {
		return b.obtainTrustProfile((resourceIdentifier));
	}

	@Override
	public String getName() {
		return "InternalCollector";
	}
	
	@Override
	public void shutDown() {
		b.stop();
	}
	
	@Override
	public void collectInformation(List<URI> resources, Map<URI, Model> map) {
		//OK - does nothing.
	}

}
