/* CVS $Id: $ */
package com.inn.itrust.model.vocabulary;

/*
 * #%L
 * itrust-model
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

import com.hp.hpl.jena.rdf.model.*;
 
/**
 * Vocabulary definitions from C:\D-Data\Git\itrust\itrust-model/src/main/resources/trustontology.ttl 
 * @author Auto-generated by schemagen on 13 Mar 2014 23:38 
 */
public class Trust {
    /** <p>The RDF model that holds the vocabulary terms</p> */
    private static Model m_model = ModelFactory.createDefaultModel();
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://www.compose-project.eu/ns/web-of-things/trust#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
    /** <p>The ontology's owl:versionInfo as a string</p> */
    public static final String VERSION_INFO = "1.1.0";
    
    public static final Property forContext = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#forContext" );
    
    public static final Property hasAttribute = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#hasAttribute" );
    
    public static final Property hasMaxValue = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#hasMaxValue" );
    
    public static final Property hasMetric = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#hasMetric" );
    
    public static final Property hasMetricValue = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#hasMetricValue" );
    
    public static final Property hasMinValue = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#hasMinValue" );
    
    /** <p>attaches to any instance</p> */
    public static final Property hasName = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#hasName" );
    
    public static final Property hasPreference = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#hasPreference" );
    
    public static final Property hasScore = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#hasScore" );
    
    public static final Property hasTimestamp = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#hasTimestamp" );
    
    public static final Property hasTrustProfile = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#hasTrustProfile" );
    
    public static final Property hasValue = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#hasValue" );
    
    public static final Property isTrustProfileOf = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#isTrustProfileOf" );
    
    public static final Property next = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#next" );
    
    public static final Property rank = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#rank" );
    
    public static final Property requiredTrustProfile = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#requiredTrustProfile" );
    
    public static final Property suggestedMatcher = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#suggestedMatcher" );
    
    public static final Property trustedParticipant = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#trustedParticipant" );
    
    public static final Property trustingParticipant = m_model.createProperty( "http://www.compose-project.eu/ns/web-of-things/trust#trustingParticipant" );
    
    public static final Resource ActivityMonitoring = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#ActivityMonitoring" );
    
    /** <p>An agent is a entity who participates in a trust relationship. An agent can 
     *  be any resource such as software agent, human, software service, etc. An agent 
     *  engages in relationships with other agents to meet certian goals withing some 
     *  context or domain, under belief (trust) that other agent will provide what 
     *  claimed to provide. Therefore, an agent may have trust requerments as a precondition 
     *  for engaging into a relationship with other agent. Each agent has a trust 
     *  profile, which is a set of capabilites (characteristics, aspects, attributes) 
     *  to meet trust requrments.</p>
     */
    public static final Resource Agent = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#Agent" );
    
    /** <p>A context within a trust relationship is being or to be established. E.g. 
     *  public transport, tourism, retail. For each context, there can be a recommended 
     *  req trust profile(s) provided, in general, or agent can have req trust profile 
     *  defined for the context. The term context defines the nature of the service 
     *  or service functions, and each Context has a name, a type and a functional 
     *  specification, such as �rent a car� or �buy a book� Context Type can be matched 
     *  to a Service Type.</p>
     */
    public static final Resource Context = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#Context" );
    
    /** <p>Feedback from agents about other agents. E.g. user feedback about some particular 
     *  service. Feedback can be in a form of rating with predefined rating scale 
     *  (e.g. poor, fair, good, very good, excellent)</p>
     */
    public static final Resource Feedback = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#Feedback" );
    
    /** <p>A matcher represents an matching technique or algorithm or strategy to compute 
     *  the level of trust between two agents. The agents expose their trust profiles 
     *  (capabilities) and impose their trust criteria (requirments), which are then 
     *  used by a matcher to assess whether trustworthy relationship can be established 
     *  or not. I.e., whether trust capabilities meet trust requirments.</p>
     */
    public static final Resource Matcher = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#Matcher" );
    
    public static final Resource MeasurableTrustAttribute = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#MeasurableTrustAttribute" );
    
    public static final Resource Metric = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#Metric" );
    
    public static final Resource MetricValue = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#MetricValue" );
    
    /** <p>Popularity of an agent. It may be provided as simple as enumeration of two 
     *  values - popular and no-popular - or as a numerical value e.g. any number 
     *  between 0 and 1. (In COMPOSE, provevance information can be used to calculate 
     *  popularity)</p>
     */
    public static final Resource Popularity = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#Popularity" );
    
    public static final Resource Price = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#Price" );
    
    /** <p>Any attribute about quality of service.</p> */
    public static final Resource QoSAttribute = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#QoSAttribute" );
    
    /** <p>Reputation of an agent. It may be provided as simple as enumeration of predefined 
     *  reputation values (unknown, bad, good, very good, excellent) or as a numerical 
     *  value e.g. any number between 0 and 1.</p>
     */
    public static final Resource Reputation = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#Reputation" );
    
    /** <p>Any attribute about security aspects. E.g. authentication, authorization, 
     *  identification, etc.</p>
     */
    public static final Resource SecurityAttribute = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#SecurityAttribute" );
    
    public static final Resource SecurityCapability = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#SecurityCapability" );
    
    public static final Resource SecurityRequirment = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#SecurityRequirment" );
    
    /** <p>Any parameter (feature, property, characteristics) that is relevant to a perception 
     *  of trust. E..g. security-related features (authorization mechanism, authentication 
     *  mechanism, data encryption), quality of service apects (reponse, data quality), 
     *  reputation, etc.</p>
     */
    public static final Resource TrustAttribute = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#TrustAttribute" );
    
    /** <p>A set of trust-relevant parameters of an agent. Collects together trust properties 
     *  (security, reputation, accuracy, range, precision, etc) , representing a specification 
     *  of a trust capability.</p>
     */
    public static final Resource TrustProfile = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#TrustProfile" );
    
    /** <p>TrustRelationship represents trust relationship as a 5-tuple &lt;Trusted Agent, 
     *  Trusting Agent, Context, RequiredTrustProfile, TrustScore&gt;. Each trust 
     *  relationship is established between two agents who wants to engange in some 
     *  form of communication or cooperation within a certian context (e.g. buying 
     *  or seeling goods, geting some information, etc). An trusting agent trusts 
     *  that trusted agent has certian characteristics (or features), which are defined 
     *  as a trust criteria by the trusting agent. TrustRelationship has a level of 
     *  trust, which can be numerical value within a range e.g. [0..1].</p>
     */
    public static final Resource TrustRelationship = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#TrustRelationship" );
    
    public static final Resource UnmeasurableTrustAttribute = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#UnmeasurableTrustAttribute" );
    
    public static final Resource ReputationScale = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#ReputationScale" );
    
    public static final Resource high = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#high" );
    
    public static final Resource low = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#low" );
    
    public static final Resource medium = m_model.createResource( "http://www.compose-project.eu/ns/web-of-things/trust#medium" );
    
}
