package com.kongkongmao.dots.game.map.location;

import java.util.ArrayList;
import java.util.List;

public class Polygon {

	/**
	 * Number of edges.
	 */
	private int edges;

	/**
	 * Vertices of the polygon. <br>
	 * <i>It should me sorted in counter-clockwise.</i>
	 */
	private List<Point> vertices = new ArrayList<Point>();

	/**
	 * Height of the polygon, indicates the y value. <br>
	 * This is the average value of all the y value in the vertices.
	 */
	private double height;

	private Polygon() {
	}

	public Polygon(List<Point> _vertices) {
		this.vertices = _vertices;
		this.edges = ((_vertices.size()) * (_vertices.size() - 1)) / 2;
		double[] heights = new double[_vertices.size()];
		for (int i = 0; i < _vertices.size(); i++)
			heights[i] = _vertices.get(i).getY();
		double sum = 0;
		for (double x : heights)
			sum += x;
		this.height = sum / heights.length;
	}

	public int getEdges() {
		return this.edges;
	}

	public List<Point> getPoints() {
		return vertices;
	}

	public double getHeight() {
		return this.height;
	}

}
