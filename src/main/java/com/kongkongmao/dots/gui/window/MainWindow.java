package com.kongkongmao.dots.gui.window;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;

import com.kongkongmao.dots.util.I18n;
import com.kongkongmao.dots.util.Logger;
import com.kongkongmao.dots.util.References;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

/**
 * The game window.
 */
public class MainWindow {

	private static final Logger logger = new Logger("Client/Render");

	public static long win;

	/**
	 * Initialize the game window.
	 */
	public static void window() {
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
		GLFWVidMode vid = glfwGetVideoMode(glfwGetPrimaryMonitor());
		win = glfwCreateWindow(vid.width(), vid.height(), I18n.t(References.NAME), glfwGetPrimaryMonitor(), NULL);
		if (win == NULL)
			throw new RuntimeException("Failed to create the GLFW window.");
		logger.info("Successfully created the GLFW window.");
		glfwMakeContextCurrent(win);
		glfwSwapInterval(1);
		glfwShowWindow(win);
		GL.createCapabilities();
		MainLoop.doLoop();
	}

}
