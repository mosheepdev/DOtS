package com.kongkongmao.dots.main;

import com.kongkongmao.dots.util.Logger;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.system.Library;

public class Machining {

	public static boolean inJar;

	private static final Logger logger = new Logger("Main");

	/**
	 * Initialize the libraries.
	 */
	protected static void libInit() {
		Library.initialize();
		if (!glfwInit())
			throw new IllegalStateException("Failed to initialize GLFW.");
		logger.info("Successfully initialized the Lwjgl library.");
	}

	/**
	 * Abrogate the libraries.
	 */
	protected static void libAbrogate() {
		glfwTerminate();
		logger.info("Successfully unloaded the Lwjgl library.");
	}

	/**
	 * Check if the program is a jar archive.
	 */
	protected static void initialize() {
		inJar = (Machining.class.getResource("Machining.class")).toString().startsWith("jar:");
	}

}
