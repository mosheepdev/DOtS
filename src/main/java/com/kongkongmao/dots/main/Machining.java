package com.kongkongmao.dots.main;

import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwTerminate;

import org.lwjgl.system.Library;

import com.kongkongmao.dots.util.Logger;

public class Machining {

	private static final Logger logger = new Logger("Main");

	protected static void libInit() {
		if (!glfwInit())
			throw new IllegalStateException("Failed to initialize GLFW.");
		Library.initialize();
		logger.info("Successfully initialized the Lwjgl library.");
	}

	protected static void libAbrogate() {
		glfwTerminate();
		logger.info("Successfully unloaded the Lwjgl library.");
	}

}
