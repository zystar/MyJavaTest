package com.test.log;

import org.apache.log4j.Logger;

/**
 * @author STAR
 * log4j的基本使用
 */
public class Log4jTest {
	static Logger logger = Logger.getLogger(Log4jTest.class);
	public static void main(String[] args) {
		logger.debug("this is debug message");
		logger.info("this is info message");
		logger.warn("this is warn message");
		logger.error("this is error message");
	}

}
