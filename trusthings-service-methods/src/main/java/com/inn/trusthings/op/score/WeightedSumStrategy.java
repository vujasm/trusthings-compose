package com.inn.trusthings.op.score;

/*
 * #%L
 * trusthings-methods
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


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inn.trusthings.model.expression.Element;
import com.inn.trusthings.model.expression.SingleElement;
import com.inn.trusthings.model.pojo.Agent;
import com.inn.trusthings.model.pojo.TrustAttribute;
import com.inn.trusthings.model.pojo.TrustCriteria;
import com.inn.trusthings.op.enums.EnumNormalizationType;
import com.inn.util.tuple.Tuple2;

/**
 * 
 * 
 *@author markov
 * 
 */

public class WeightedSumStrategy extends AbstractScoreStrategy {

	private static final Logger log = LoggerFactory.getLogger(WeightedSumStrategy.class);
	protected EnumNormalizationType enumNormalizationType;
	

	protected WeightedSumStrategy(final List<SingleElement> listCriteria, final List<Tuple2<Agent, List<Tuple2<TrustAttribute, Double>>>> dataSet,
			final EnumNormalizationType enumNormalizationType) {
		super(listCriteria, dataSet);
		this.enumNormalizationType = enumNormalizationType;
	}
	
	@Override
	protected void init() {
		identifyMaxValues(dataSet, attributeList);
		identifyMinValues(dataSet, attributeList);
		log.info("WeightedSumStrategy initialized");
	}

	/**
	 * 
	 * @param agent
	 * @return
	 */
	public Double getScore(Agent agent) {
		final List<Tuple2<TrustAttribute, Double>> agentDataSet = obtainDataSetForAgent(agent);
		Double score = 0D;
		for (TrustAttribute attribute : attributeList) {
				Tuple2<TrustAttribute, Double> t = obtainTuple(agentDataSet, attribute);
				if (t==null){
					System.out.println();
				}
				Double scaledVal = scaleTo01(t);
				Double scaledImportance =  t.getT1().getImportance() / weightsSum;
				score = score + (scaledVal * scaledImportance);
				log.info("** "+attribute.obtainType().getUri()+" "+score +" as score = "+(score - (scaledVal * scaledImportance))
						+" + ("+scaledVal+" * "+ t.getT1().getImportance()+" / "+weightsSum+")");
		}
		return score;
	}

	
	private Double scaleTo01(Tuple2<TrustAttribute, Double> t) {
		Double attributeValue  = t.getT2();
		if (enumNormalizationType == EnumNormalizationType.Zero_One_by_divMax){
			return (attributeValue/maxValues.get(t.getT1()));
		}
		else{
			return attributeValue;
		}
	}
	
	@Override
	protected Logger getLogger() {
		return log;
	}

	
}

// final List<Tuple2<TrustAttribute, Double>> aggregatedList =
// ControlObjects.createListGeneric();
// for (Tuple2<Agent, List<Tuple2<TrustAttribute, Double>>> t :
// dataList) {
// aggregatedList.addAll(t.getT2());
// }
// Ordering<Tuple2<TrustAttribute, Double>> o = new
// Ordering<Tuple2<TrustAttribute,Double>>() {
// @Override
// public int compare(Tuple2<TrustAttribute, Double> left,
// Tuple2<TrustAttribute, Double> right) {
// return left.getT2().compareTo(right.getT2());
// }
// };
// o.max(aggregatedList);
