package zeklandia.desktop.logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import org.fusesource.jansi.AnsiConsole;
import static zeklandia.desktop.logger.test.Test.app;
import static zeklandia.desktop.logger.test.Test.time;

public class JLogger {

	private static final String classname = "JLogger";
	private static final String padding = "             ";
	private static final String destination = "JLogger.log";

	/**
	 * Prepares the console with JANSI This must be called before anything
	 * is printed to the console
	 */
	public static void prepareConsole() {
		AnsiConsole.systemInstall();
		logMessage(time, app, classname, padding, "JANSI loaded");
	}

	/**
	 * Logs an error message to the console
	 *
	 * @param time output system time in milliseconds
	 * @param padding aligns text with other output
	 * @param app name of the program containing the class
	 * @param classname name of the class calling this method
	 * @param error error message to be output
	 */
	public static void logError(Boolean time, String app, String classname,
		String padding, String error) {
		if (time == true) {
			AnsiConsole.system_err.print("\033[1;30m[\033[0;37m" + System.currentTimeMillis() + "\033[1;30m] ");
		}
		AnsiConsole.system_err.print("\033[1;30m[\033[1;37m" + app + "\033[1;30m] ");
		AnsiConsole.system_err.print("\033[1;30m[\033[1;31m" + "Error" + "\033[1;30m] ");
		AnsiConsole.system_err.print("\033[1;30m[\033[0;37m" + classname + "\033[1;30m] ");
		AnsiConsole.system_err.print(padding);
		AnsiConsole.system_err.println("\033[0;31m" + error + "\033[0;0m");
	}

	/**
	 * Logs an error message to a file
	 *
	 * @param time output system time in milliseconds
	 * @param padding aligns text with other output
	 * @param app name of the program containing the class
	 * @param classname name of the class producing the output
	 * @param error error message to be written
	 * @param destination file the message is to be written to
	 * @throws java.io.FileNotFoundException
	 */
	public static void logError(Boolean time, String app, String classname,
		String padding, String error, String destination) throws FileNotFoundException {
		PrintWriter logFile = new PrintWriter(destination);
		if (time == true) {
			logFile.print("[" + System.currentTimeMillis() + "] ");
		}
		logFile.print("[" + app + "] ");
		logFile.print("[" + "Error" + "] ");
		logFile.print("[" + classname + "] ");
		logFile.print(padding);
		logFile.println(error);
	}

	/**
	 * Logs a message to the console
	 *
	 * @param time output system time in milliseconds
	 * @param padding aligns text with other output
	 * @param app name of the program containing the class
	 * @param classname name of the class calling this method
	 * @param message message to be written
	 */
	public static void logMessage(Boolean time, String app, String classname,
		String padding, String message) {
		if (time == true) {
			AnsiConsole.system_out.print("\033[1;30m[\033[0;37m" + System.currentTimeMillis() + "\033[1;30m] ");
		}
		AnsiConsole.system_out.print("\033[1;30m[\033[1;37m" + app + "\033[1;30m] ");
		AnsiConsole.system_out.print("\033[1;30m[\033[1;32m" + "Info " + "\033[1;30m] ");
		AnsiConsole.system_out.print("\033[1;30m[\033[0;37m" + classname + "\033[1;30m] ");
		AnsiConsole.system_out.print(padding);
		AnsiConsole.system_out.println("\033[0;0m" + message + "\033[0;0m");
	}

	/**
	 * Logs a message to a file
	 *
	 * @param time output system time in milliseconds
	 * @param padding aligns text with other output
	 * @param app name of the program containing the class
	 * @param classname name of the class calling this method
	 * @param message message to be written
	 * @param destination file the message is to be written to
	 * @throws java.io.FileNotFoundException
	 */
	public static void logMessage(Boolean time, String app, String classname,
		String padding, String message, String destination) throws FileNotFoundException {
		PrintWriter logFile = new PrintWriter(destination);
		if (time == true) {
			logFile.print("[" + System.currentTimeMillis() + "] ");
		}
		logFile.print("[" + app + "] ");
		logFile.print("[" + "Info " + "] ");
		logFile.print("[" + classname + "] ");
		logFile.print(padding);
		logFile.println(message);
	}
}
