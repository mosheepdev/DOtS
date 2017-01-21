package com.kongkongmao.dots.gui.control;

public abstract class GuiControl {

	/**
	 * ID of the control in the current form.
	 */
	public int id;

	private int x, y;
	private double w, h;

	public boolean isHidden;

	protected GuiControl() {
	}

	abstract void render();

	abstract void update();

	abstract void hide();

	abstract void show();

	abstract void destroy();

	abstract void relocate(int _x, int _y);

	abstract void resize(double _w, double _h);

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
