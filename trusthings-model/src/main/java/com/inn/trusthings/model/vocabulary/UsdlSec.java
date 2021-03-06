/* CVS $Id: $ */
package com.inn.trusthings.model.vocabulary; 
import com.hp.hpl.jena.rdf.model.*;
 
/**
 * Vocabulary definitions from file:/C:/D-Data/git/itrust/trusthings-model/../trusthings-kbase/src/main/resources/ontologies/usdl-sec.ttl 
 * @author Auto-generated by schemagen on 28 Apr 2015 14:36 
 */
public class UsdlSec {
    /** <p>The RDF model that holds the vocabulary terms</p> */
    private static Model m_model = ModelFactory.createDefaultModel();
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://www.linked-usdl.org/ns/usdl-sec#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
    /** <p>The ontology's owl:versionInfo as a string</p> */
    public static final String VERSION_INFO = "0.9.5";
    
    /** <p>This relation connects a Security Profile with an high-level Security Goal; 
     *  a vocabulary for Security Goals can be found using the sec-goal taxonomy.</p>
     */
    public static final Property hasSecurityGoal = m_model.createProperty( "http://www.linked-usdl.org/ns/usdl-sec#hasSecurityGoal" );
    
    public static final Property hasSecurityMeasure = m_model.createProperty( "http://www.linked-usdl.org/ns/usdl-sec#hasSecurityMeasure" );
    
    /** <p>this relation binds a USDL service description with its USDL-SEC security 
     *  profile.</p>
     */
    public static final Property hasSecurityProfile = m_model.createProperty( "http://www.linked-usdl.org/ns/usdl-sec#hasSecurityProfile" );
    
    /** <p>This relation describes at which level a Security Mechanism operates. It ideally 
     *  refers to an ISO/OSI protocol stack, in order to understand in which layer 
     *  a certain mechanism is active.</p>
     */
    public static final Property hasSecurityRealizationType = m_model.createProperty( "http://www.linked-usdl.org/ns/usdl-sec#hasSecurityRealizationType" );
    
    /** <p>This relation associates to a Security Goal, a Security Mechanism that is 
     *  used to implement the former or, alternatively, a USDL description of another 
     *  service, that is used to implement the Security Goal.</p>
     */
    public static final Property isImplementedBy = m_model.createProperty( "http://www.linked-usdl.org/ns/usdl-sec#isImplementedBy" );
    
    /** <p>This relation expresses how a certain Security Mechanism is implemented, by 
     *  means of a Security Technology.</p>
     */
    public static final Property isRealizedByTechnology = m_model.createProperty( "http://www.linked-usdl.org/ns/usdl-sec#isRealizedByTechnology" );
    
    public static final Property usesMechanism = m_model.createProperty( "http://www.linked-usdl.org/ns/usdl-sec#usesMechanism" );
    
    public static final Resource SecurityMeasure = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#SecurityMeasure" );
    
    /** <p>A Security Profile is the root node of the model and the entry point from 
     *  a service description language to USDL-SEC. This node can conceptually be 
     *  similar to a pointer element from the general service description, to the 
     *  security properties of the service.</p>
     */
    public static final Resource SecurityProfile = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#SecurityProfile" );
    
    /** <p>This field explains where the Security Mechanism operates, referring to an 
     *  ISO/OSI-like stack model. Network, Application and Service are valid values.</p>
     */
    public static final Resource SecurityRealizationType = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#SecurityRealizationType" );
    
    public static final Resource Access_Control = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Access_Control" );
    
    /** <p>The property that ensures that the actions of an entity may be traced uniquely 
     *  to the entity. (CCITT) The process allowing for the auditing of IS activities 
     *  to be traced to a source that may then be held responsible. (Phoha)</p>
     */
    public static final Resource Accountability = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Accountability" );
    
    /** <p>A condition in which an individual's true identity is unknown. (www.microsoft.com/security/glossary.mspx)</p> */
    public static final Resource Anonymity = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Anonymity" );
    
    public static final Resource Auditing = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Auditing" );
    
    /** <p>The process of reliably determining the identify of a communicating party 
     *  or source of a message. (Phoha)</p>
     */
    public static final Resource Authentication = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Authentication" );
    
    /** <p>A security principle that ensures that a message is received in exactly the 
     *  form in which it was sent. (Phoha)</p>
     */
    public static final Resource Authenticity = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Authenticity" );
    
    /** <p>Permission to access a resource. (Phoha)</p> */
    public static final Resource Authorization = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Authorization" );
    
    /** <p>The property of being accessible and useable upon demand by an authorised 
     *  entity. (CCITT) Timely, reliable access to data and information services for 
     *  authorised users. (Phoha) The ability of a product to be in a state to perform 
     *  a required function under given conditions at a given instant of time or over 
     *  a given time interval assuming that the required external resources are provide. 
     *  (Meul) The prevention of the unauthorised withholding of information or resources 
     *  (ITSEC)</p>
     */
    public static final Resource Availability = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Availability" );
    
    public static final Resource BiometricData = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#BiometricData" );
    
    public static final Resource Certificate = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Certificate" );
    
    public static final Resource CertificateExchange = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#CertificateExchange" );
    
    public static final Resource Certification = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Certification" );
    
    public static final Resource Challenge_Response = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Challenge-Response" );
    
    public static final Resource Checksum = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Checksum" );
    
    /** <p>The property that information is not made available or disclosed to unauthorised 
     *  individuals, entities or processes. (CCITT) The property of not being divulged 
     *  to unauthorised parties. (Phoha) The prevention of the unauthorised disclosure 
     *  of information (ITSEC)</p>
     */
    public static final Resource Confidentiality = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Confidentiality" );
    
    public static final Resource Control_Code = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Control_Code" );
    
    /** <p>A property of a representation of a Target of Evaluation such thtat it accurately 
     *  reflects the stated security target for that system or product (ITSEC)</p>
     */
    public static final Resource Correctness = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Correctness" );
    
    public static final Resource Cryptography = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Cryptography" );
    
    public static final Resource Delegation = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Delegation" );
    
    public static final Resource Digest = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Digest" );
    
    public static final Resource DigitalSignature = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#DigitalSignature" );
    
    public static final Resource Filtering = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Filtering" );
    
    public static final Resource Francesco_Di_Cerbo = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Francesco_Di_Cerbo" );
    
    /** <p>Possibility to include a certain identifier in a request, but without starting 
     *  an authentication process involving credentials transmission.</p>
     */
    public static final Resource Identification = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Identification" );
    
    /** <p>The Service realization type explains that a certain Security Technology operates 
     *  at service level, if considering an ideal ISO/OSI stack protocol model.</p>
     */
    public static final Resource InStorageType = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#InStorageType" );
    
    /** <p>The Network realization type explains that a certain Security Technology operates 
     *  at network level, if considering an ideal ISO/OSI stack protocol model.</p>
     */
    public static final Resource InTransitType = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#InTransitType" );
    
    /** <p>The Application realization type explains that a certain Security Technology 
     *  operates at application level, if considering an ideal ISO/OSI stack protocol 
     *  model.</p>
     */
    public static final Resource InUsage = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#InUsage" );
    
    /** <p>A condition in which data (or a system itself) has not been modified or corrupted 
     *  without authorisation. A system protects the integrity of data if it prevents 
     *  unauthorised modification, as opposed to protecting the confidentiality of 
     *  data, which prevents unauthorised disclosure. (Phoha) The degree to which 
     *  a system or component prevents unauthorised access to, or modification of, 
     *  computer programs or data (IEEE Std 610.12)</p>
     */
    public static final Resource Integrity = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Integrity" );
    
    public static final Resource KeyManagement = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#KeyManagement" );
    
    public static final Resource Load_Balancing = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Load_Balancing" );
    
    public static final Resource Logging = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Logging" );
    
    public static final Resource Monitoring = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Monitoring" );
    
    /** <p>The property of a scheme ... in which the recipient is able to prove to a 
     *  third party that data has been sent by the sender or received by the receiver. 
     *  This property protects against the sender denying having sent the message 
     *  and the receiver denying having received the message. The sender is provided 
     *  with a proof of delivery and receiver is assured of sender's identity. (Phoha) 
     *  Repudiation: Denial by one of the entities involved in a communication of 
     *  having participated in all or part of the communication. (CCITT)</p>
     */
    public static final Resource Non_Repudiation = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Non-Repudiation" );
    
    public static final Resource OAuth2 = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#OAuth2" );
    
    public static final Resource Obfuscation = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Obfuscation" );
    
    public static final Resource Obligation = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Obligation" );
    
    public static final Resource PasswordExchange = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#PasswordExchange" );
    
    /** <p>also: compliance with laws, regulations</p> */
    public static final Resource PolicyCompliance = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#PolicyCompliance" );
    
    /** <p>Protection from the unauthorised disclosure of data. Security purists use 
     *  confidentiality for this and use privacy to refer to the protection of personal 
     *  information; privacy legislation consists of laws requiring government and 
     *  business to justify which data they keep about people, and to tell people 
     *  what information those organisations are storing about them. (Phoha) The right 
     *  of individuals to control or influence what information related to them may 
     *  be collected and stored and by whom and to whom that information may be disclosed. 
     *  Note: Because this term relates to the right of individuals, it cannot be 
     *  very precise and its use should be avoided except as a motivation for requiring 
     *  security. (CCITT)</p>
     */
    public static final Resource Privacy = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Privacy" );
    
    public static final Resource Pseudonym = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Pseudonym" );
    
    public static final Resource Recommendation = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Recommendation" );
    
    public static final Resource Replication = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Replication" );
    
    public static final Resource Reputation = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Reputation" );
    
    public static final Resource SecurityGoal = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#SecurityGoal" );
    
    /** <p>A Security Mechanism is a set of security solutions that can achieve a security 
     *  goal. These mechanisms are theoretical solutions that answer to specific security 
     *  requirements like Access control, Cryptography, Obligations, etc. These solutions 
     *  can be applied under three realization levels: The network level, the application 
     *  level, and the service level (expressed with the relation hasSecurityRealizationType).</p>
     */
    public static final Resource SecurityMechanism = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#SecurityMechanism" );
    
    /** <p>The Security Tecnology is a set of concrete implementations and tools that 
     *  realizes the Security Mechanisms. Like for example the encryption on the network 
     *  level is implemented by IPSec . Security Technology elements can be defined 
     *  by each vocabulary user.</p>
     */
    public static final Resource SecurityTechnology = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#SecurityTechnology" );
    
    public static final Resource SharedSecret = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#SharedSecret" );
    
    public static final Resource Slim_Trabelsi = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Slim_Trabelsi" );
    
    public static final Resource Steganography = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Steganography" );
    
    public static final Resource Token = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Token" );
    
    public static final Resource Torsten_Leidig = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Torsten_Leidig" );
    
    /** <p>The firm belief in the competence of an entity to act dependably, securely, 
     *  and reliably within a specified context. (Grandison, 2000) Trust is a particular 
     *  level of the subjective probability with which an agent will perform a particular 
     *  action, both before we can monitor such action (or independently of his capacity 
     *  of ever to be able to monitor it) and in a context in which it affects our 
     *  action. (Gambetta, 1990) Trust is a subjective expectation an agent has about 
     *  another agent�s future behavior. (L. Mui, 2003)</p>
     */
    public static final Resource Trust = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Trust" );
    
    public static final Resource Usage_Control = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#Usage_Control" );
    
    public static final Resource composeSecProfile1 = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#composeSecProfile1" );
    
    public static final Resource secmeasure1 = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#secmeasure1" );
    
    public static final Resource securityGoalsTaxonomy = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#securityGoalsTaxonomy" );
    
    public static final Resource securityMechanismsTaxonomy = m_model.createResource( "http://www.linked-usdl.org/ns/usdl-sec#securityMechanismsTaxonomy" );
    
}
