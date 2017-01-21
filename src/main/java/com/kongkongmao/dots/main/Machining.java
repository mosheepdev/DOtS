package com.kongkongmao.dots.main;

import com.kongkongmao.dots.util.Logger;

import static org.lwjgl.glfw.GLFW.*;

public class Machining {

	public static boolean inJar;

	private static final Logger logger = new Logger("Main");

	protected static void libInit() {
		/* Library.initialize(); */
		if (!glfwInit())
			throw new IllegalStateException("Failed to initialize GLFW.");
		logger.info("Successfully initialized the Lwjgl library.");
	}

	protected static void libAbrogate() {
		glfwTerminate();
		logger.info("Successfully unloaded the Lwjgl library.");
	}

	protected static void initialize() {
		inJar = (Machining.class.getResource("Machining.class")).toString().startsWith("jar:");
	}

}
