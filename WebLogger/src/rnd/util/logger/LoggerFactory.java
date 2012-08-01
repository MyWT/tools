package rnd.util.logger;

import java.util.HashMap;
import java.util.Map;

import rnd.util.web.logger.WebLogger;

public class LoggerFactory {

	private static enum LoggerType {
		WEB, CONSOLE
	};

	private static Map<String, Logger> loggers = new HashMap<String, Logger>();

	public static Map<String, Logger> getLoggers() {
		return loggers;
	}

	public static synchronized Logger getWebLogger(Class clazz) {
		return getWebLogger(clazz.getSimpleName());
	}

	public static synchronized Logger getWebLogger(String name) {
		return getLogger(name, LoggerType.WEB);
	}

	public static synchronized Logger getConsoleLogger(Class clazz) {
		return getConsoleLogger(clazz.getSimpleName());
	}

	public static synchronized Logger getConsoleLogger(String name) {
		return getLogger(name, LoggerType.CONSOLE);
	}

	private static Logger getLogger(String name, LoggerType type) {
		Logger logger = loggers.get(name);
		if (logger == null) {
			if (type == LoggerType.WEB) {
				logger = new WebLogger();
			} else {
				//logger = new ConsoleLogger(System.out);
			}
			loggers.put(name, logger);
		}
		return logger;
	}

	public static void removeLogger(Class clazz) {
		removeLogger(clazz.getSimpleName());
	}

	public static void removeLogger(String name) {
		Logger logger = loggers.remove(name);
		if (logger != null) {
			logger.removeListner();
		}
	}

}
