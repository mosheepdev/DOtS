package com.kongkongmao.dots.main;

import com.kongkongmao.dots.util.Configuration;
import com.kongkongmao.dots.util.I18n;
import com.kongkongmao.dots.util.Logger;

/**
 * Class: Main <br>
 * Package: com.kongkongmao.dots.main <br>
 * Description: The main, scilicet, the starting point of the client.
 */
public class Main {

	private static final Logger logger = new Logger("Main");

	public static void main(String[] args) {
		logger.logFile();
		logger.info("Welcome to DOtS!");
		logger.info("Initializing the client...");
		Configuration.initialize();
		I18n.initialize();
		logger.info("Shutting down client...");
		Configuration.closeUp();
		logger.info("The client is shut down. Thank you for playing!");
	}

}
