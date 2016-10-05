package com.kongkongmao.dots.game.render;

import com.kongkongmao.dots.game.map.location.Point;

public class RenderObj {

	/**
	 * Scale of the rendering model.
	 */
	private double scale;

	/**
	 * The object id in the current rendering.
	 */
	public int id;

	/**
	 * Location of the object.
	 */
	private Point loc;

	/**
	 * The angle that the object is facing.
	 */
	private double theta;

	private RenderObj() {
	}

	public RenderObj(Point _loc, double _theta) {
		this.loc = _loc;
		this.theta = _theta;
		render();
	}

	public RenderObj(double _x, double _y, double _z, double _theta) {
		this.loc = new Point(_x, _y, _z);
		this.theta = _theta;
		render();
	}

	/**
	 * Render the object.
	 */
	public void render() {
		// TODO 这里等模型系统做好了再做
	}

	/**
	 * Move the object to a location. <br>
	 * The sixth argument indicates the form of moving: <br>
	 * <b>1</b> <i>Instantly move to the location, with the angle of
	 * original;</i> <br>
	 * <b>2</b> <i>Instantly move to the location, with the new angle
	 * facing;</i> <br>
	 * <b>3</b> <i>Move to the location with the speed.</i> <br>
	 */
	public void move(Point target, double _theta, double _speed, int form) {
		// TODO 这里等模型系统做好了再做
	}

	/**
	 * Play an animation of the model on the current location.
	 */
	public void anime(int id) {
		// TODO 这里等模型系统做好了再做
	}

	public Point getLocation() {
		return this.loc;
	}

	public void setLocation(Point _loc) {
		this.loc.setX(_loc.getX());
		this.loc.setY(_loc.getY());
		this.loc.setZ(_loc.getZ());
	}

	public double getFacing() {
		return this.theta;
	}

	public double getScale() {
		return this.scale;
	}

	public void setScale(double _scale) {
		this.scale = _scale;
	}

}
