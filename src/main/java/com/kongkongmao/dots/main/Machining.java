package com.kongkongmao.dots.main;

import com.kongkongmao.dots.util.Logger;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.system.Library;

public class Machining {

	public static boolean inArchive;

	private static final Logger logger = new Logger("Main");

	/**
	 * Initialize the libraries.
	 */
	protected static void libInit() {
		Library.initialize();
		if (!glfwInit())
			throw new IllegalStateException("Failed to initialize GLFW.");
		GLFWErrorCallback.createPrint(System.err).set();
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
		inArchive = (Machining.class.getResource("Machining.class")).toString().startsWith("jar:");
	}

}
