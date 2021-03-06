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

import java.net.URI;

import com.hp.hpl.jena.datatypes.BaseDatatype;
import com.hp.hpl.jena.datatypes.xsd.impl.XSDDouble;
import com.inn.trusthings.model.expression.ExpressionBuilder;
import com.inn.trusthings.model.factory.TrustModelFactory;
import com.inn.trusthings.model.pojo.SecurityAttribute;
import com.inn.trusthings.model.pojo.SecurityGoal;
import com.inn.trusthings.model.pojo.SecurityMechanism;
import com.inn.trusthings.model.pojo.SecurityTechnology;
import com.inn.trusthings.model.pojo.TrustAttribute;
import com.inn.trusthings.model.pojo.TrustCriteria;
import com.inn.trusthings.model.types.USDLSecExpression;
import com.inn.trusthings.model.vocabulary.Trust;
import com.inn.trusthings.model.vocabulary.UsdlSec;
import com.inn.util.json.IAFJSONParser;
import com.inn.util.uri.UIDGenerator;

public class Request {

	/**
	 * 
	 * @return
	 */
	protected static TrustCriteria request_Example_1() {
		final TrustModelFactory factory = new TrustModelFactory(UIDGenerator.instanceRequest);
		

		TrustAttribute att1 = factory.createTrustAttibute();
		att1.addType(URI.create(Trust.Reputation.getURI()));
		att1.setValue(Trust.medium.getURI());
		att1.setValueDatatype(new BaseDatatype(Trust.ReputationScale.getURI()));
		att1.setImportance(1);

		TrustAttribute att2 = factory.createTrustAttibute();
		att2.addType(URI.create(Trust.QoSAttribute.getURI()));
		att2.setValue("0.3");
		att2.setValueDatatype(XSDDouble.XSDdouble);
		att2.setImportance(1);

		SecurityAttribute att3 = factory.createSecurityAttribute();
		att3.setValueDatatype(USDLSecExpression.TYPE);
		att3.addType(URI.create(Trust.SecurityGuarantee.getURI()));
		SecurityGoal goal1 = new SecurityGoal(URI.create(UsdlSec.Authentication.getURI()));
		att3.addSecurityGoal(goal1);
		att3.setImportance(1);

		SecurityAttribute att4 = factory.createSecurityAttribute();
		att4.setValueDatatype(USDLSecExpression.TYPE);
		att4.addType(URI.create(Trust.SecurityGuarantee.getURI()));
		SecurityGoal goal2 = new SecurityGoal(URI.create(UsdlSec.Confidentiality.getURI()));
		att4.addSecurityGoal(goal2);
		att4.setImportance(1);
		
		return new ExpressionBuilder().startNewTrustCriteria()
			.attribute(att1).and().attribute(att2).and().attribute(att3).and().attribute(att4).build();

	}

	/**
	 * 
	 * @return
	 */
	protected static TrustCriteria request_Example_2() {

		final TrustModelFactory factory = new TrustModelFactory(UIDGenerator.instanceRequest);

		TrustAttribute att1 = factory.createTrustAttibute();
		att1.addType(URI.create(Trust.Reputation.getURI()));
		att1.setValue(Trust.medium.getURI());
		att1.setValueDatatype(new BaseDatatype(Trust.ReputationScale.getURI()));
		att1.setImportance(1);

		TrustAttribute att2 = factory.createTrustAttibute();
		att2.addType(URI.create(Trust.QoSAttribute.getURI()));
		att2.setValue("0.3");
		att2.setValueDatatype(XSDDouble.XSDdouble);
		att2.setImportance(1);

		SecurityAttribute att3 = factory.createSecurityAttribute();
		att3.setValueDatatype(USDLSecExpression.TYPE);
		att3.addType(URI.create(Trust.SecurityGuarantee.getURI()));
		SecurityGoal goal1 = new SecurityGoal(URI.create(UsdlSec.Authentication.getURI()));
		att3.addSecurityGoal(goal1);
		SecurityMechanism mechanism = factory.createSecurityMechanism();
		SecurityTechnology securityTechnology = new SecurityTechnology(
				URI.create("http://www.compose-project.eu/ns/web-of-things/" + "security/profiles#OAuth2"));
		att3.addRealizedByTechnology(securityTechnology);
		att3.addImplementedBy(mechanism);
		att3.setImportance(1);

		SecurityAttribute att4 = factory.createSecurityAttribute();
		att4.setValueDatatype(USDLSecExpression.TYPE);
		att4.addType(URI.create(Trust.SecurityGuarantee.getURI()));
		SecurityGoal goal2 = new SecurityGoal(URI.create(UsdlSec.Authentication.getURI()));
		SecurityMechanism mechanism2 = factory.createSecurityMechanism();
		SecurityTechnology securityTechnology2 = new SecurityTechnology(
				URI.create("http://www.compose-project.eu/ns/web-of-things/" + "security/profiles#HTTPBasicAuth"));
		att4.addRealizedByTechnology(securityTechnology2);
		att4.addImplementedBy(mechanism2);
		att4.addSecurityGoal(goal2);
		att4.setImportance(1);

		return new ExpressionBuilder().startNewTrustCriteria()
				.attribute(att1).and().attribute(att2).and().attribute(att3).and().attribute(att4).build();

	}

	/**
	 * 
	 * @return
	 */
	protected static TrustCriteria request_Example_3(double... importance) {

		final TrustModelFactory factory = new TrustModelFactory(UIDGenerator.instanceRequest);

		TrustAttribute att1 = factory.createTrustAttibute();
		att1.addType(URI.create(Trust.Reputation.getURI()));
		att1.setValue(Trust.low.getURI());
		att1.setValueDatatype(new BaseDatatype(Trust.ReputationScale.getURI()));
		att1.setImportance(importance[2]);

		TrustAttribute att2 = factory.createTrustAttibute();
		att2.addType(URI.create(Trust.QoSAttribute.getURI()));
		att2.setValue("0.5");
		att2.setValueDatatype(XSDDouble.XSDdouble);
		att2.setImportance(importance[3]);

		SecurityAttribute att3 = factory.createSecurityAttribute();
		att3.setValueDatatype(USDLSecExpression.TYPE);
		att3.addType(URI.create(Trust.SecurityGuarantee.getURI()));
		SecurityGoal goal1 = new SecurityGoal(URI.create(UsdlSec.Authentication.getURI()));
		att3.addSecurityGoal(goal1);
		SecurityMechanism mechanism = factory.createSecurityMechanism();
		SecurityTechnology securityTechnology = new SecurityTechnology(
				URI.create("http://www.compose-project.eu/ns/web-of-things/" + "security/profiles#OAuth"));
		att3.addRealizedByTechnology(securityTechnology);
		att3.addImplementedBy(mechanism);
		att3.setImportance(importance[0]);

		SecurityAttribute att4 = factory.createSecurityAttribute();
		att4.setValueDatatype(USDLSecExpression.TYPE);
		att4.addType(URI.create(Trust.SecurityGuarantee.getURI()));
		SecurityGoal goal2 = new SecurityGoal(URI.create(UsdlSec.Authentication.getURI()));
		SecurityMechanism mechanism2 = factory.createSecurityMechanism();
		SecurityTechnology securityTechnology2 = new SecurityTechnology(
				URI.create("http://www.compose-project.eu/ns/web-of-things/" + "security/profiles#HTTPBasicAuth"));
		att4.addRealizedByTechnology(securityTechnology2);
		att4.addImplementedBy(mechanism2);
		att4.addSecurityGoal(goal2);
		att4.setImportance(importance[1]);

		return new ExpressionBuilder().startNewTrustCriteria()
				.attribute(att1).and().attribute(att2).and().attribute(att3).and().attribute(att4).build();

	}

	protected static TrustCriteria request_Example_4(double... importance) {

		final TrustModelFactory factory = new TrustModelFactory(UIDGenerator.instanceRequest);

		TrustAttribute att1 = factory.createTrustAttibute();
		att1.addType(URI.create(Trust.Reputation.getURI()));
		att1.setValue(Trust.medium.getURI());
		att1.setValueDatatype(new BaseDatatype(Trust.ReputationScale.getURI()));
		att1.setImportance(importance[2]);

		TrustAttribute att2 = factory.createTrustAttibute();
		att2.addType(URI.create(Trust.QoSAttribute.getURI()));
		att2.setValue("0.3");
		att2.setValueDatatype(XSDDouble.XSDdouble);
		att2.setImportance(importance[3]);

		SecurityAttribute att3 = factory.createSecurityAttribute();
		att3.setValueDatatype(USDLSecExpression.TYPE);
		att3.addType(URI.create(Trust.SecurityGuarantee.getURI()));
		SecurityGoal goal2 = new SecurityGoal(URI.create(UsdlSec.Authorization.getURI()));
		att3.addSecurityGoal(goal2);
		att3.setImportance(importance[0]);

		SecurityAttribute att4 = factory.createSecurityAttribute();
		att4.setValueDatatype(USDLSecExpression.TYPE);
		att4.addType(URI.create(Trust.SecurityGuarantee.getURI()));
		goal2 = new SecurityGoal(URI.create(UsdlSec.Authentication.getURI()));
		att4.addSecurityGoal(goal2);
		att4.setImportance(importance[1]);

		SecurityAttribute att5 = factory.createSecurityAttribute();
		att5.setValueDatatype(USDLSecExpression.TYPE);
		att5.addType(URI.create(Trust.SecurityGuarantee.getURI()));
		goal2 = new SecurityGoal(URI.create(UsdlSec.Confidentiality.getURI()));
		att5.addSecurityGoal(goal2);
		att5.setImportance(importance[1]);

		return new ExpressionBuilder().startNewTrustCriteria()
				.attribute(att1).and().attribute(att2).and().attribute(att3).and().attribute(att4).build();
	}
	
	public static void main(String[] args) {
	System.out.println( IAFJSONParser.toJson(request_Example_3(1,1,1,1)));
	}

}
