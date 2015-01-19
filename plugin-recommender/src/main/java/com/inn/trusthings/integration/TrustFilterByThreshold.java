package com.inn.trusthings.integration;

/*
 * #%L
 * trusthings-service
 * %%
 * Copyright (C) 2014 INNOVA S.p.A
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
import java.util.Set;

import com.google.common.collect.Sets;
import com.inn.trusthings.integration.util.RequestBody;



/**
 * TrustFilterByThreshold implements implements iServe Recommender Filter interface 
 * 
 * @author Marko Vujasinovic <m.vujasinovic@innova-eu.net>
 *
 */
public class TrustFilterByThreshold implements uk.ac.open.kmi.iserve.discovery.api.ranking.Filter {
	
	
	public TrustFilterByThreshold() {
	}

	
	/**
	 * returns true if resource identified with serviceId URI is evaluated as trusted in respect to the trust threshold value
	 */
	@Override
	public Set<URI> apply(Set<URI> arg0) {
		return apply(arg0, null);
	}
	
	@Override
	public Set<URI> apply(Set<URI> arg0, String arg1) {

		List<URI> filtered ;
		try {
			String requestBody = new RequestBody().createNew(arg0, arg1);
			System.out.println(requestBody);
			filtered = null;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return Sets.newHashSet(filtered);
	}

}
