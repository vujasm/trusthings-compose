package restserver;

/*
 * #%L
 * trusthings-webservice
 * %%
 * Copyright (C) 2014 - 2015 INNOVA S.p.A
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

import javax.ws.rs.core.UriBuilder;

import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

import com.inn.trusthings.rest.app.ApplicationConfiguration;
 
public class App {
	public static void main(String[] args) throws Exception {
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
//		ResourceConfig config = new ResourceConfig(TrustRESTService.class);
		Server server = JettyHttpContainerFactory.createServer(baseUri, new ApplicationConfiguration());
		server.join();
		
		/* alternative way
		  Server server = new Server(9998);
          ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
          context.setContextPath("/");
          server.setHandler(context);
          ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
          jerseyServlet.setInitOrder(0);
          //This parameter tells the Jersey Servlet which of your REST resources to load. In this example we're adding the TestResource class. Jersey will then invoke this class for requests coming into paths denoted by the @Path parameter within the TestResource class. If you have multiple classes, you can either list them all comma separated, of use "jersey.config.server.provider.packages" and list the package name instead 
          jerseyServlet.setInitParameter("jersey.config.server.provider.packages", "com.inn.trusthings.rest");
          server.start();
          server.join();
          */
    }
 
}