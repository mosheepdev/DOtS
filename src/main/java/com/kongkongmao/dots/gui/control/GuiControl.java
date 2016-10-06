package com.kongkongmao.dots.gui.control;

import org.lwjgl.glfw.GLFWMouseButtonCallback;

public abstract class GuiControl {

	private int x, y;
	private double w, h;

	abstract void render();

	abstract void update();

	abstract void relocate(int _x, int _y);

	abstract void resize(double _w, double _h);

	abstract void onClick(GLFWMouseButtonCallback callback);

	public int getX() {
		return this.x;
	}

	public void setX(int _x) {
		this.x = _x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int _y) {
		this.y = _y;
	}

	public double getW() {
		return this.w;
	}

	public void setW(double _w) {
		this.w = _w;
	}

	public double getH() {
		return this.h;
	}

	public void setH(double _h) {
		this.h = _h;
	}

}
