package com.kongkongmao.dots.main;

import com.kongkongmao.dots.gui.window.MainWindow;
import com.kongkongmao.dots.util.Configuration;
import com.kongkongmao.dots.util.I18n;
import com.kongkongmao.dots.util.Logger;

import static org.lwjgl.glfw.GLFW.*;

/**
 * The main, scilicet, the starting point of the client.
 */
public class Main {

	private static final Logger logger = new Logger("Main");

	public static void main(String[] args) {
		logger.logFile();
		logger.info("Welcome to DOtS!");
		logger.info("Initializing the client...");
		Configuration.initialize();
		I18n.initialize();

		if (!glfwInit())
			throw new IllegalStateException("Failed to initialize GLFW.");

		MainWindow.window();
		logger.info("Shutting down client...");
		Configuration.closeUp();
		glfwTerminate();
		logger.info("The client is shut down. Thank you for playing!");
	}

}
