package com.kongkongmao.dots.game.map.location;

public class Circle {

	/**
	 * Coordinate of the center.
	 */
	private Point center;

	/**
	 * Radius of the circle.
	 */
	private double radius;

	/**
	 * Height of the polygon, indicates the y value.
	 */
	private double height;

	private Circle() {
	}

	public Circle(Point _center, double _radius) {
		this.center = _center;
		this.radius = _radius;
		this.height = 0.00d;
	}

	public Circle(Point _center, double _radius, double _height) {
		this.center = _center;
		this.radius = _radius;
		this.height = _height;
	}

	public Point getCenter() {
		return this.center;
	}

	public double getRadius() {
		return this.radius;
	}

	public double getHeight() {
		return this.height;
	}

}
