package com.kongkongmao.dots.gui;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

/**
 * VBO of Eucild figures.
 */
public class Model2DEucild extends Model2D {

	/**
	 * The vertices that 'Really' need to draw.
	 */
	private int d_count;

	private int v_id;

	public Model2DEucild(float[] vertices) {
		d_count = vertices.length / 3;
		v_id = glGenBuffers();

		FloatBuffer data = BufferUtils.createFloatBuffer(vertices.length);
		data.put(vertices);
		data.flip();

		glBindBuffer(GL_ARRAY_BUFFER, v_id);
		glBufferData(GL_ARRAY_BUFFER, data, GL_STATIC_DRAW);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}

	@Override
	public void render() {
		glEnableClientState(GL_VERTEX_ARRAY);

		glBindBuffer(GL_ARRAY_BUFFER, v_id);

		glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
		// glVertexPointer(3, GL_FLOAT, 0, 0);
		glDrawArrays(GL_TRIANGLES, 0, d_count);

		glBindBuffer(GL_ARRAY_BUFFER, 0);

		glDisableClientState(GL_VERTEX_ARRAY);
	}

}
