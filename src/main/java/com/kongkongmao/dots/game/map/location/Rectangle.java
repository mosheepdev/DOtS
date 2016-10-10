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
		if (Double.compare(_crd_tl.getY(), _crd_br.getY()) != 0)
			this.height = Math.abs((_crd_tl.getY() - _crd_br.getY()) / 2);
		// Gets the average height for the height of the rectangle.
		else
			this.height = _crd_tl.getY();
	}

	public Point getTLCrd() {
		return this.crd_tl;
	}

	public Point getBRCrd() {
		return this.crd_br;
	}

	public void setTLCrd(Point _crd_tl) {
		this.crd_tl.setX(_crd_tl.getX());
		this.crd_tl.setY(_crd_tl.getY());
		this.crd_tl.setZ(_crd_tl.getZ());
		if (Double.compare(_crd_tl.getY(), crd_br.getY()) != 0)
			this.height = Math.abs((_crd_tl.getY() - crd_br.getY()) / 2);
		else
			this.height = _crd_tl.getY();
	}

	public void setBRCrd(Point _crd_br) {
		this.crd_br.setX(_crd_br.getX());
		this.crd_br.setY(_crd_br.getY());
		this.crd_br.setZ(_crd_br.getZ());
		if (Double.compare(crd_tl.getY(), _crd_br.getY()) != 0)
			this.height = Math.abs((crd_tl.getY() - _crd_br.getY()) / 2);
		else
			this.height = crd_br.getY();
	}

	public double getHeight() {
		return this.height;
	}

}
