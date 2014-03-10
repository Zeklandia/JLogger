package zeklandia.desktop.logger.test;

import java.io.FileNotFoundException;
import zeklandia.desktop.logger.JLogger;

/**
 *
 * @author Zeklandia
 */
public class Test {

	private static final String app = "JLogger";
	private static final String classname = "Test";
	private static final String padding = "                ";
	private static final String destination = "JLogger.log";

	/**
	 * Tests JLogger
	 *
	 * @param args arguments to ignore
	 * @throws java.io.FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String string = "Hello world!";

		JLogger logger = new JLogger();
		logger.prepareConsole();
		logger.logMessage(app, classname, padding, string);
		logger.logMessage(app, classname, padding, string, destination);
		logger.logError(app, classname, padding, string);
		logger.logError(app, classname, padding, string, destination);
	}

}
