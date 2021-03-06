package com.inn.trusthings.model.pojo;

/*
 * #%L
 * trusthings-model
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

public class MetricValue extends TResource{

	public MetricValue(URI uri) {
		super(uri);
	}
	
	private MetricValue next;
	
	private Double rank;
	
	
	public MetricValue getNext() {
		return next;
	}
	
	public void setNext(MetricValue next) {
		this.next = next;
	}
	
	
	public void setRank(Double rank) {
		this.rank = rank;
	}
	
	public Double getRank() {
		return rank;
	}

}
