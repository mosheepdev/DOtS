package com.kongkongmao.dots.gui;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

public abstract class Model2D {

	abstract void render();

	protected FloatBuffer createFBuffer(float[] data) {
		return BufferUtils.createFloatBuffer(data.length).put(data);
	}

}
