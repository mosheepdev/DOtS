package com.kongkongmao.dots.game.map.location;

public class Point {

	/**
	 * Coordinate.
	 */
	private double x, y, z;

	public Point() {
		this.x = 0.00d;
		this.y = 0.00d;
		this.z = 0.00d;
	}

	public Point(double _x, double _y, double _z) {
		this.x = _x;
		this.y = _y;
		this.z = _z;
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

	public double setX(double _x) {
		this.x = _x;
		return this.x;
	}

	public double setY(double _y) {
		this.y = _y;
		return this.y;
	}

	public double setZ(double _z) {
		this.z = _z;
		return this.z;
	}

}