package zeklandia.desktop.logger.test;

import java.io.FileNotFoundException;
import zeklandia.desktop.logger.JLogger;

/**
 *
 * @author Zeklandia
 */
public class Test {

	public static final Boolean time = true;
	public static final String app = "JLogger";
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

		//Prepare console
		JLogger.prepareConsole();
		
		//Test messages: time, no time, time/file
		JLogger.logMessage(time, app, classname, padding, string);
		JLogger.logMessage(false, app, classname, padding, string);
		JLogger.logMessage(time, app, classname, padding, string, destination);

		//Test errors: time, no time, time/file
		JLogger.logError(time, app, classname, padding, string);
		JLogger.logError(false, app, classname, padding, string);
		JLogger.logError(time, app, classname, padding, string, destination);
	}
}