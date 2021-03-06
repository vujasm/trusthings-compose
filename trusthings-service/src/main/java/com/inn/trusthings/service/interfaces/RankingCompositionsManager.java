package com.inn.trusthings.service.interfaces;

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


import org.jgrapht.experimental.dag.DirectedAcyclicGraph;

import com.inn.trusthings.model.graph.Edge;
import com.inn.trusthings.model.graph.Vertex;
import com.inn.trusthings.model.pojo.TrustCriteria;

public interface RankingCompositionsManager {

	Double computeScore(DirectedAcyclicGraph<Vertex, Edge> g, TrustCriteria criteria);

}
