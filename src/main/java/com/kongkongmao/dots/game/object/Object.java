package com.kongkongmao.dots.game.object;

public class Object {

	/**
	 * Name of the object.
	 */
	private String unlocName;

	/**
	 * The object id in the current rendering.
	 */
	public int id;

	/**
	 * Coordinate of the object.
	 */
	private double x, y, z;

	/**
	 * The angle that the object is facing.
	 */
	private double theta;

	private Object() {
	}

	public Object(String name) {
		this.unlocName = name;
	}

	public Object(String name, double _x, double _y, double _z, double _theta) {
		this.unlocName = name;
		this.x = _x;
		this.y = _y;
		this.z = _z;
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
	 * <b>3</b> <i>Move to the location with the speed;</i> <br>
	 */
	public void move(double _x, double y, double _z, double _theta, double _speed, int form) {
		// TODO 这里等模型系统做好了再做
	}

	/**
	 * Play an animation of the model on the current location.
	 */
	public void anime(int id) {
		// TODO 这里等模型系统做好了再做
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}

	public double getFacing() {
		return this.theta;
	}

	public String getName() {
		return unlocName;
	}

}
