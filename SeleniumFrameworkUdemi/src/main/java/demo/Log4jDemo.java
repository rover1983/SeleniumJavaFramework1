package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	public static void main(String[]args) {
		
		System.out.println("Start\n");
		
		logger.info("Info message");
		logger.warn("warning message");
		logger.error("error message");		
		logger.fatal("fatal message");
		
		System.out.println("\nFinish");			
	}
}