package com.kongkongmao.dots.gui.window;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import com.kongkongmao.dots.util.Logger;

/**
 * The main loop of rendering things.
 */
public class MainLoop {

	private static final Logger logger = new Logger("Client/Render");

	public static void doLoop() {
		logger.info("Starting main rendering loop...");
		while (!glfwWindowShouldClose(MainWindow.win)) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			/* Render things here. */
			glfwPollEvents();
			glfwSwapBuffers(MainWindow.win);
		}
		logger.info("Graphical loop is broke, the program is now cleaning up...");
	}

}
