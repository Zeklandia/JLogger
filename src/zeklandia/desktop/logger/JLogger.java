package zeklandia.desktop.logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import org.fusesource.jansi.AnsiConsole;

public class JLogger {

	private static final String app = "JLogger";
	private static final String classname = "LogOutput";
	private static final String padding = "        ";
	private static final String destination = "JLogger.log";

	/**
	 * Prepares the console with JANSI This must be called before anything
	 * is printed to the console
	 */
	public static void prepareConsole() {
		System.out.println("Installing JANSI...");
		AnsiConsole.systemInstall();
		logMessage(app, classname, padding, "JANSI loaded");
	}

	/**
	 * Logs an error message to the console
	 *
	 * @param padding aligns text with other output
	 * @param app name of the program containing the class
	 * @param classname name of the class calling this method
	 * @param error error message to be output
	 */
	public static void logError(String app, String classname,
		String padding, String error) {
		AnsiConsole.system_err.println("\033[1;30m[\033[0;37m" + System.currentTimeMillis() + "\033[1;30m]"
			+ " \033[1;30m[\033[1;37m" + app + "\033[1;30m]"
			+ " \033[1;30m[\033[1;31m" + "Error" + "\033[1;30m]"
			+ " \033[1;30m[\033[0;37m" + classname + "\033[1;30m]"
			+ padding
			+ " \033[0;31m" + error + "\033[0;0m");
	}

	/**
	 * Logs an error message to a file
	 *
	 * @param padding aligns text with other output
	 * @param app name of the program containing the class
	 * @param classname name of the class producing the output
	 * @param error error message to be written
	 * @param destination file the message is to be written to
	 * @throws java.io.FileNotFoundException
	 */
	public static void logError(String app, String classname,
		String padding, String error, String destination) throws FileNotFoundException {
		PrintWriter logFile = new PrintWriter(destination);
		logFile.println("[" + System.currentTimeMillis() + "]"
			+ " [" + app + "]"
			+ " [Error]"
			+ " [" + classname + "]"
			+ padding
			+ " " + error);
	}

	/**
	 * Logs a message to the console
	 *
	 * @param padding aligns text with other output
	 * @param app name of the program containing the class
	 * @param classname name of the class calling this method
	 * @param message message to be written
	 */
	public static void logMessage(String app, String classname,
		String padding, String message) {
		AnsiConsole.system_out.println("\033[1;30m[\033[0;37m" + System.currentTimeMillis() + "\033[1;30m]"
			+ " \033[1;30m[\033[1;37m" + app + "\033[1;30m]"
			+ " \033[1;30m[\033[1;32m" + " Msg " + "\033[1;30m]"
			+ " \033[1;30m[\033[0;37m" + classname + "\033[1;30m]"
			+ padding
			+ " \033[0;0m" + message + "\033[0;0m");
	}

	/**
	 * Logs a message to a file
	 *
	 * @param padding aligns text with other output
	 * @param app name of the program containing the class
	 * @param classname name of the class calling this method
	 * @param message message to be written
	 * @param destination file the message is to be written to
	 * @throws java.io.FileNotFoundException
	 */
	public static void logMessage(String app, String classname,
		String padding, String message, String destination) throws FileNotFoundException {
		PrintWriter logFile = new PrintWriter(destination);
		logFile.println("[" + System.currentTimeMillis() + "]"
			+ " [" + app + "]"
			+ " [" + " Msg " + "]"
			+ " [" + classname + "]"
			+ padding
			+ " " + message);
	}
}
