package com.kongkongmao.dots.gui.control;

import org.lwjgl.glfw.GLFWMouseButtonCallback;

public abstract class GuiControl {

	/**
	 * ID of the control in the current form.
	 */
	private int id;

	private int x, y;
	private double w, h;

	public boolean isHidden;

	GuiControl() {

	}

	GuiControl(int _id) {

	}

	GuiControl(int _id, int _x, int _y, double _w, double _h) {

	}

	GuiControl(int _id, int _x, int _y, double _w, double _h, boolean _isHidden) {

	}

	abstract void render();

	abstract void update();

	abstract void hide();

	abstract void show();

	@Deprecated
	abstract void destroy();

	abstract void relocate(int _x, int _y);

	abstract void resize(double _w, double _h);

	abstract void onClick(GLFWMouseButtonCallback callback);

	public int x() {
		return this.x;
	}

	public int y() {
		return this.y;
	}

	public double w() {
		return this.w;
	}

	public double h() {
		return this.h;
	}

}
