package com.kongkongmao.dots.game.map.location;

public class Rectangle {

	/**
	 * Coordinate of the top left corner.
	 */
	private Point crd_tl;

	/**
	 * Coordinate of the bottom right corner.
	 */
	private Point crd_br;

	private double height;

	private Rectangle() {
	}

	public Rectangle(Point _crd_tl, Point _crd_br) {
		this.crd_tl = _crd_tl;
		this.crd_br = _crd_br;
		if (_crd_tl.getY() != _crd_br.getY())
			this.height = Math.abs((_crd_tl.getY() - _crd_br.getY()) / 2);
		else
			this.height = _crd_tl.getY();
	}

	public Point getTLCrd() {
		return this.crd_tl;
	}

	public Point getBRCrd() {
		return this.crd_br;
	}

	public double getHeight() {
		return this.height;
	}

}
