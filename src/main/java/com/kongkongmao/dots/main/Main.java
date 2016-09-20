package com.kongkongmao.dots.main;

import com.kongkongmao.dots.gui.window.MainWindow;
import com.kongkongmao.dots.util.Configuration;
import com.kongkongmao.dots.util.I18n;
import com.kongkongmao.dots.util.Logger;

/**
 * The main, scilicet, the starting point of the client.
 */
public class Main {

	private static final Logger logger = new Logger("Main");

	public static void main(String[] args) {
		logger.logFile();
		logger.info("Welcome to DOtS!");
		logger.info("Initializing the program...");
		Configuration.initialize();
		I18n.initialize();
		Machining.LibInit();
		logger.info("Initializing the client...");
		MainWindow.window();
		logger.info("Shutting down client...");
		Configuration.closeUp();
		Machining.LibAbrogate();
		logger.info("The client is shut down. Thank you for playing!");
	}

}
