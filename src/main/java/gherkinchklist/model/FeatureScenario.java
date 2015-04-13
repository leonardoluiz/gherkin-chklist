package gherkinchklist.model;

import java.util.List;

/**
 * A feature scenario
 * 
 * @author leonardoluiz
 *
 */
public class FeatureScenario {
	
	private String name;
	private List<Step> steps;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Step> getSteps() {
		return steps;
	}
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

}
