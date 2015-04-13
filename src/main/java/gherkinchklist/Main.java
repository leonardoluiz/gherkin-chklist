package gherkinchklist;

import gherkin.lexer.I18nLexer;
import gherkin.lexer.Lexer;
import gherkin.parser.FormatterListener;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Main class
 * 
 * @author leonardo.cruz
 *
 */
public class Main {

	private static final String LINE_BREAK = "\n";
	private static final String APP_ENCODING = "UTF-8";
	private static final String DEFAULT_OUTPUT_NAME = "featurechecklist.xls";
	private static String inputFile;
	private static String outputFile;
 
	public static void main(String... args) throws Exception {
		loadArgs(args);
		String feature = loadFeatureContent();
	    
		System.out.println(Messages.get("app.loading"));
	    
		CheckListFormater formater = createAndRunFormater(feature);
		new ExcelCheckListRenderer(outputFile).render(formater.getModel());
		
		System.out.println(Messages.get("app.ok"));
	}

	private static CheckListFormater createAndRunFormater(String feature) {
		CheckListFormater formater = new CheckListFormater();
		Lexer lexer = new I18nLexer(new FormatterListener(formater));
		lexer.scan(feature);
		return formater;
	}

	private static String loadFeatureContent() throws IOException {
		try {
			Path path = Paths.get(inputFile);
			String feature = java.nio.file.Files.lines(path).collect(
					Collectors.joining(LINE_BREAK));
			
			feature = new String(feature.getBytes(Charset.forName(APP_ENCODING)));
			return feature;
		} catch (NoSuchFileException e) {
			fatal(Messages.get("app.fileinnotfound"));
			return null;
		}
	}

	public static void fatal(String msg) {
		System.err.println(msg);
		System.exit(1);
	}

	private static void loadArgs(String... args) {
		if (args.length==0) {
			fatal(Messages.get("app.invalid.command"));
			return;
		}
		inputFile = args[0];
		outputFile = args.length > 1 ? args[1]: DEFAULT_OUTPUT_NAME;
	}
}
