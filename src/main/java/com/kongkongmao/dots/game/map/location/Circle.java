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

	public void setCenter(Point _center) {
		this.center.setX(_center.getX());
		this.center.setY(_center.getY());
		this.center.setZ(_center.getZ());
	}

	public double getRadius() {
		return this.radius;
	}

	public void setRadius(double _radius) {
		this.radius = _radius;
	}

	public double getHeight() {
		return this.center.getY();
	}

}
