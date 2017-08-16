package com.kongkongmao.dots.gui.window;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import com.kongkongmao.dots.util.Logger;

public class Window {

	private static final Logger logger = new Logger("Client/Render");

	private String title;

	public long handle;

	private int width, height;

	private boolean vSync;

	private boolean fullScreen;

	public Window(String _title, int _width, int _height, boolean _vSync, long _handle) {
		this.title = _title;
		this.width = _width;
		this.height = _height;
		this.vSync = _vSync;
		this.handle = _handle;
		this.fullScreen = true;
	}

	public Window(String _title, int _width, int _height, boolean _vSync, long _handle, boolean fs) {
		this.title = _title;
		this.width = _width;
		this.height = _height;
		this.vSync = _vSync;
		this.handle = _handle;
		this.fullScreen = fs;
	}

	public void init() {
		glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);
		glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE);

		GLFWVidMode vid = glfwGetVideoMode(glfwGetPrimaryMonitor());

		if (fullScreen)
			handle = glfwCreateWindow(vid.width(), vid.height(), title, glfwGetPrimaryMonitor(), NULL);
		else
			handle = glfwCreateWindow(width, height, title, NULL, NULL);
		if (handle == NULL)
			throw new RuntimeException("Failed to create the GLFW window.");

		logger.info("Successfully created the window.");
		glfwShowWindow(handle);
		glfwMakeContextCurrent(handle);

		if (vSync)
			glfwSwapInterval(1);

		GL.createCapabilities();
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
	}

	public void setClearColor(float r, float g, float b, float a) {
		glClearColor(r, g, b, a);
	}

	public String getTitle() {
		return title;
	}

	public int getwidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public long getHandle() {
		return handle;
	}

	public boolean isVSync() {
		return vSync;
	}

	public void setVSync(boolean _vSync) {
		vSync = _vSync;
	}

	public void update() {
		glfwSwapBuffers(handle);
		glfwPollEvents();
	}

}
