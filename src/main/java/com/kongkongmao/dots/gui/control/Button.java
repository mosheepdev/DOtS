package com.kongkongmao.dots.gui.control;

import org.lwjgl.glfw.GLFWMouseButtonCallback;

import com.kongkongmao.dots.gui.render.RText;

public class Button extends GuiControl implements Clickable {

	public int id;

	private int x, y;
	private double w, h;

	public boolean isHidden;

	private RText text;

	private Button() {
	}

	public Button(int _x, int _y, double _w, double _h) {
		this.x = _x;
		this.y = _y;
		this.w = _w;
		this.h = _h;
		// TODO = =
	}

	public Button(int _x, int _y, double _w, double _h, RText _text) {
		this.x = _x;
		this.y = _y;
		this.w = _w;
		this.h = _h;
		this.text = _text.clone();
		// TODO = =
	}

	@Override
	public void render() {
	}

	@Override
	public void update() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void show() {
	}

	@Override
	@Deprecated
	public void destroy() {
	}

	@Override
	public void relocate(int _x, int _y) {
	}

	@Override
	public void resize(double _w, double _h) {
	}

	@Override
	public void onClick(GLFWMouseButtonCallback callback) {
	}

	@Override
	public void onPress(GLFWMouseButtonCallback _callback) {
	}

	@Override
	public void onRelease(GLFWMouseButtonCallback _callback) {
	}

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
