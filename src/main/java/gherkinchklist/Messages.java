package gherkinchklist;

import java.util.ResourceBundle;

public class Messages {
	
	static ResourceBundle rb = ResourceBundle.getBundle("gherkinchklist.resources");
	
	public static String get(String key) {
		return rb.getString(key);
	}

}
