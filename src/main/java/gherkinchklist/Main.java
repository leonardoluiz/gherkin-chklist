package gherkinchklist;

import gherkin.lexer.I18nLexer;
import gherkin.lexer.Lexer;
import gherkin.parser.FormatterListener;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Main class
 * 
 * @author leonardo.cruz
 *
 */
public class Main {

	private static final String UTF_8 = "utf-8";

	public static void main(String... args) throws Exception {
		String feature = new String(Files.readAllBytes(Paths.get(ClassLoader
				.getSystemResource("adding.feature").toURI())), UTF_8);
		CheckListFormater formater = new CheckListFormater();
		Lexer lexer = new I18nLexer(new FormatterListener(formater));
		lexer.scan(feature);

		new ExcelCheckListRenderer("out.xls").render(formater.getModel());
	}
}
