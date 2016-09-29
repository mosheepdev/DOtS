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

	private Circle() {
	}

	public Circle(Point _center, double _radius) {
		this.center = _center;
		this.radius = _radius;
	}

	public Point getCenter() {
		return this.center;
	}

	public double getRadius() {
		return this.radius;
	}

}
