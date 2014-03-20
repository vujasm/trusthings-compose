package com.inn.tests.jorequests;

/*
 * #%L
 * trusthings-client-simple
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

import com.inn.client.simple.TrustModuleTest;
import com.inn.common.Const;
import com.inn.trusthings.model.pojo.TrustRequest;

public class R1_S {
	
	public static void main(String[] args) {
		
		TrustRequest trustRequest = Request.request_Example_1();
		try {
			new TrustModuleTest().getTrustManager().obtainTrustIndex(URI.create(Const.Ts3), trustRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
