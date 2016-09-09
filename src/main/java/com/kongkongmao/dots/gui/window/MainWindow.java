package com.kongkongmao.dots.gui.window;

import org.lwjgl.glfw.*;
import com.kongkongmao.dots.util.I18n;
import com.kongkongmao.dots.util.References;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

/**
 * Class: Window <br>
 * Package: com.kongkongmao.dots.gui.window <br>
 * Description: The game window.
 */
public class MainWindow {

	public static long win;

	public static void window() {
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
		GLFWVidMode vid = glfwGetVideoMode(glfwGetPrimaryMonitor());
		win = glfwCreateWindow(vid.width(), vid.height(), I18n.t(References.NAME), glfwGetPrimaryMonitor(), NULL);
		if (win == NULL)
			throw new RuntimeException("Failed to create the GLFW window.");
		glfwMakeContextCurrent(win);
		glfwSwapInterval(1);
		glfwShowWindow(win);
	}

}
