package gherkinchklist.model;

/**
 * A scenario step
 * 
 * @author leonardoluiz
 *
 */
public class Step {
	
	private StepType type;
	private String description;
	
	public StepType getType() {
		return type;
	}
	public void setType(StepType type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
