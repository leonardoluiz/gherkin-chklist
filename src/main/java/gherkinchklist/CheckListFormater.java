package gherkinchklist;

import gherkin.formatter.Formatter;
import gherkin.formatter.model.Background;
import gherkin.formatter.model.Examples;
import gherkin.formatter.model.Feature;
import gherkin.formatter.model.Scenario;
import gherkin.formatter.model.ScenarioOutline;
import gherkin.formatter.model.Step;
import gherkinchklist.model.Checklist;
import gherkinchklist.model.FeatureScenario;

import java.util.List;

/**
 * A Formatter for a simple checklist model
 * 
 * @author leonardoluiz
 *
 */
public class CheckListFormater implements Formatter {
	
	private Checklist checklist;
	
	public CheckListFormater() {
		init();
	}
	
	private void init() {
		checklist = new Checklist();
	}

	public void syntaxError(String state, String event,
			List<String> legalEvents, String uri, Integer line) {
		// TODO Auto-generated method stub
		
	}

	public void uri(String uri) {
		// TODO Auto-generated method stub
		
	}

	public void feature(Feature feature) {
		checklist.setId(feature.getId());
		checklist.setFeature(feature.getName());
		checklist.setDescription(feature.getDescription());
	}

	public void scenarioOutline(ScenarioOutline scenarioOutline) {
		// TODO Auto-generated method stub
		
	}

	public void examples(Examples examples) {
		// TODO Auto-generated method stub
		
	}

	public void startOfScenarioLifeCycle(Scenario scenario) {
		// TODO Auto-generated method stub
		
	}

	public void background(Background background) {
		// TODO Auto-generated method stub
		
	}

	public void scenario(Scenario scenario) {
		FeatureScenario s = new FeatureScenario();
		s.setName(scenario.getName());
		checklist.getScenarios().add(s);
		
	}

	public void step(Step step) {
		// TODO Auto-generated method stub
		
	}

	public void endOfScenarioLifeCycle(Scenario scenario) {
		// TODO Auto-generated method stub
		
	}

	public void done() {
		// TODO Auto-generated method stub
		
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public void eof() {
		// TODO Auto-generated method stub
		
	}
	public Checklist getModel() {
		return checklist;
	}
	

}
