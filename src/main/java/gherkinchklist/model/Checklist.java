package gherkinchklist.model;

import gherkinchklist.model.FeatureScenario;

import java.util.ArrayList;
import java.util.List;

/**
 * Checklist model root class
 * 
 * @author leonardoluiz
 *
 */
public class Checklist {
	
	private String id;
	private String feature;
	private String description;
	private List<FeatureScenario> scenarios = new ArrayList<FeatureScenario>();
	
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public List<FeatureScenario> getScenarios() {
		return scenarios;
	}
	public void setScenarios(List<FeatureScenario> scenarios) {
		this.scenarios = scenarios;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
