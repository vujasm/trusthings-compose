/*
 * #%L
 * trusthings-client-simple
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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import com.google.common.io.CharStreams;
import com.inn.trusthings.integration.fat.TrustFilterByExclusion;
import com.inn.trusthings.integration.fat.TrustScorer;
import com.inn.trusthings.module.Factory;
import com.inn.trusthings.service.interfaces.TrustSimpleManager;


public class TrustEngineExample {
	
//	public void runExample(){
//		
//		try {
//			//create trust manager
//			TrustManager trustManager =  Factory.createInstance(TrustManager.class);
//			//load (from json file) and set trust criteria 
//			InputStream is = TrustEngineExample.class.getResourceAsStream("/criteria/criteria1.json");
//			String	criteria = CharStreams.toString(new InputStreamReader(is));
//			trustManager.setGlobalTrustCriteria(criteria);
//			is.close();
//			
//			//add some descriptions (trust profiles)
//			URI service_a = URI.create("http://localhost/services/CITY_TRAFFIC_SERVICE_A");			
//			URI service_b = URI.create("http://localhost/services/CITY_TRAFFIC_SERVICE_B");
//			URI service_d = URI.create("http://localhost/services/CITY_TRAFFIC_SERVICE_D");
//			
//			Set<URI> services = new HashSet<URI>();
//			services.add(service_a);
//			services.add(service_b);
//			services.add(service_d);
//			
//			
//			InputStream r1is = TrustEngineExample.class.getResourceAsStream("/modelrepo/city_traffic_service_A.ttl");
//			trustManager.addResourceDescription(service_a,r1is);
//			InputStream r2is = TrustEngineExample.class.getResourceAsStream("/modelrepo/city_traffic_service_B.ttl");
//			trustManager.addResourceDescription(service_b, r2is);
//			r2is.close();
//			InputStream r3is = TrustEngineExample.class.getResourceAsStream("/modelrepo/city_traffic_service_D.ttl");
//			trustManager.addResourceDescription(service_d, r3is);
//			r3is.close();
//			/*
//			 * SCORING
//			 */
//			//create trust scorer and pass trustManager
//			TrustScorer s = new TrustScorer(trustManager);
//			//obtain and print trust indexes for resources
//			System.out.println(service_a.toASCIIString()+" has trust index value:"+s.apply(services));
//			System.out.println(service_b.toASCIIString()+" has trust index value:"+s.apply(services));
//			System.out.println(service_b.toASCIIString()+" has trust index value:"+s.apply(services));
//			
//			/*
//			 * FILTERING
//			 */
//			//create trust filer to filter out those not trusted
//			TrustFilterByExclusion f = new TrustFilterByExclusion(trustManager);
//			//obtain trust indexes for resources
//			System.out.println(service_a.toASCIIString()+" is trusted = "+f.apply(services));
//			System.out.println(service_b.toASCIIString()+" is trusted = "+f.apply(services));
//			System.out.println(service_b.toASCIIString()+" is trusted = "+f.apply(services));
//			
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public static void main(String[] args) {
//		new TrustEngineExample().runExample();
//	}

}

