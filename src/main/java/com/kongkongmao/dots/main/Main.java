package com.kongkongmao.dots.main;

import com.kongkongmao.dots.util.Configuration;
import com.kongkongmao.dots.util.I18n;
import com.kongkongmao.dots.util.Logger;
import com.kongkongmao.dots.util.References;

/**
 * The main, scilicet, the starting point of the client.
 */
public class Main {

	private static final Logger logger = new Logger("Main");

	public static void main(String[] args) {
		Machining.initialize();
		logger.logFile();
		logger.info("Initializing the program...");
		Configuration.initialize();
		I18n.initialize();
		Machining.libInit();
		logger.info("Welcome to " + I18n.t(References.NAME) + " !");
		logger.info("Initializing the client...");
		
		logger.info("Shutting down client...");
		Configuration.closeUp();
		Machining.libAbrogate();
		logger.info("The client is shut down. Thank you for playing!");
	}

}
