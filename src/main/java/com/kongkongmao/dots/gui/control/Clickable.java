package com.kongkongmao.dots.gui.control;

import org.lwjgl.glfw.GLFWMouseButtonCallback;

public interface Clickable {

	void onClick(GLFWMouseButtonCallback _callback);

	void onPress(GLFWMouseButtonCallback _callback);

	void onRelease(GLFWMouseButtonCallback _callback);

}
