package com.kongkongmao.dots.gui;

import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Camera {

	/**
	 * The position of the camera.
	 */
	private Vector3f position;

	/**
	 * Graphic projection.
	 */
	private Matrix4f projection;

	public Camera(int width, int height) {
		this.position = new Vector3f(0.0f, 0.0f, 0.0f);
		this.projection = new Matrix4f().setOrtho2D(-width / 2, width / 2, -height / 2, height / 2);
	}

	public void setPos(Vector3f pos) {
		this.position = pos;
	}

	public void addPos(Vector3f pos) {
		this.position.add(pos);
	}

	public Vector3f getPos() {
		return this.position;
	}

	public Matrix4f getProj() {
		Matrix4f pos = new Matrix4f().setTranslation(position);
		Matrix4f target = new Matrix4f();
		return projection.mul(pos, target);
	}

}
