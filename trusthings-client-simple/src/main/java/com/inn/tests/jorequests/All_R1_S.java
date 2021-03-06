package com.inn.tests.jorequests;

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


import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;
import com.inn.client.simple.TrustModuleTest;
import com.inn.common.OrderType;
import com.inn.testtemp.DescriptionsEnum;
import com.inn.trusthings.bdg.Bridge;
import com.inn.trusthings.json.TrustPOJOFactory;
import com.inn.trusthings.model.pojo.TrustCriteria;
import com.inn.trusthings.op.enums.EnumScoreStrategy;
import com.inn.trusthings.service.interfaces.TrustSimpleManager;

import fordemo.demo1;

public class All_R1_S {
	
		public static void main(String[] args) {
		
//		services.add(URI.create(Const.Ts3));
//		services.add(URI.create(Const.Ts4));
//		services.add(URI.create(Const.Ts5));
//		TrustCriteria trustRequest = Request.request_Example_1();
		try {
			 Stopwatch timer = new Stopwatch().start();
			 int size = 1;
			//load (from json file) and set trust criteria 
			InputStream is = demo1.class.getResourceAsStream("/criteria/demo/trust_demo_2.json");
			String	criteria = CharStreams.toString(new InputStreamReader(is));
			TrustSimpleManager t = new TrustModuleTest().getTrustManager();
			TrustCriteria criteriapojo = new TrustPOJOFactory().ofTrustCriteria(criteria);
			t.setGlobalTrustCriteria(criteriapojo);
//			for (int i = 0; i < size; i++) {
//				System.out.println(t.isTrusted(new URI("http://iserve.kmi.open.ac.uk/iserve/id/services/c006937c-2777-44d2-bd0a-7586c00a86ce/facebook")));
//				System.out.println(t.isTrusted(new URI("http://iserve.kmi.open.ac.uk/iserve/id/services/610b64a2-6cc0-4b5c-9d6e-a619bdf0c18f/twitter")));
//			}
			List<URI> l = Lists.newArrayList();
//			l.add(new URI("http://iserve.kmi.open.ac.uk/iserve/id/services/c006937c-2777-44d2-bd0a-7586c00a86ce/facebook"));
//			l.add(new URI("http://iserve.kmi.open.ac.uk/iserve/id/services/610b64a2-6cc0-4b5c-9d6e-a619bdf0c18f/twitter"));
			l.add(new URI("http://iserve.kmi.open.ac.uk/iserve/id/services/84bf044f-541e-4a93-886d-36ab4278bfe0/google-maps"));
//			l.add(new URI("http://iserve.kmi.open.ac.uk/iserve/id/services/c5a98129-8aa5-4b97-b53a-b0a5239b6372/microsoft-bing-maps"));
			
//			for (int i = 0; i < size; i++) {
//				l.add(new URI("http://iserve.kmi.open.ac.uk/iserve/id/services/c006937c-2777-44d2-bd0a-7586c00a86ce/facebook"));
//				l.add(new URI("http://iserve.kmi.open.ac.uk/iserve/id/services/610b64a2-6cc0-4b5c-9d6e-a619bdf0c18f/twitter"));
//			}
			t.obtainTrustIndexes(l);
			timer.stop();
		    System.out.println("For size of "+size+" "+timer.elapsed(TimeUnit.SECONDS)+" "+timer.elapsed(TimeUnit.MINUTES));
//		}
		

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//		private static void test(int size, TrustManager t) throws Exception {
//
//			TrustManager tt = new TrustModuleTest().getTrustManager();
//			List<URI> services = Lists.newArrayList();
//			for (int i = 0; i < size; i++) {
//				services.add(URI.create(DescriptionsEnum.TSA.getURI()));
//				services.add(URI.create(DescriptionsEnum.TSB.getURI()));
//				services.add(URI.create(DescriptionsEnum.TSC.getURI()));
//			}
//		    Stopwatch timer = new Stopwatch().start();
//			t.rankResources(services, t.getGlobalTrustCriteria(), EnumScoreStrategy.TOPSIS, false, OrderType.DESC);
////			tt.obtainTrustIndexes(services);
//			timer.stop();
//		    System.out.println("For size of "+size+" "+timer.elapsed(TimeUnit.MILLISECONDS));
//		}

}


