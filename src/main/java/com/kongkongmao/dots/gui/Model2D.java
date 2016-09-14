package com.kongkongmao.dots.gui;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;

public class Model2D {

	private int d_count;

	private int v_id;

	private int t_id;

	private int i_id;

	public Model2D(float[] vertices, float[] tex_coords, int[] indices) {
		d_count = vertices.length / 3;

		v_id = glGenBuffers();
		FloatBuffer data_v = createFBuffer(vertices);
		data_v.flip();
		glBindBuffer(GL_ARRAY_BUFFER, v_id);
		glBufferData(GL_ARRAY_BUFFER, data_v, GL_STATIC_DRAW);
		glBindBuffer(GL_ARRAY_BUFFER, 0);

		t_id = glGenBuffers();
		FloatBuffer data_t = createFBuffer(vertices);
		data_t.flip();
		glBindBuffer(GL_ARRAY_BUFFER, t_id);
		glBufferData(GL_ARRAY_BUFFER, data_t, GL_STATIC_DRAW);
		glBindBuffer(GL_ARRAY_BUFFER, 0);

		i_id = glGenBuffers();
		IntBuffer data_i = createIBuffer(indices);
		data_i.flip();
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, i_id);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, data_i, GL_STATIC_DRAW);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
	}

	public void render() {
		glEnableClientState(GL_VERTEX_ARRAY);
		glEnableClientState(GL_TEXTURE_COORD_ARRAY);

		glBindBuffer(GL_ARRAY_BUFFER, v_id);
		glVertexPointer(3, GL_FLOAT, 0, 0);

		glBindBuffer(GL_ARRAY_BUFFER, t_id);
		glTexCoordPointer(2, GL_FLOAT, 0, 0);

		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, i_id);
		glDrawElements(GL_TRIANGLES, d_count, GL_UNSIGNED_INT, 0);

		glDrawArrays(GL_TRIANGLES, 0, d_count);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);

		glDisableClientState(GL_TEXTURE_COORD_ARRAY);
		glDisableClientState(GL_VERTEX_ARRAY);
	}

	protected FloatBuffer createFBuffer(float[] data) {
		return BufferUtils.createFloatBuffer(data.length).put(data);
	}

	protected IntBuffer createIBuffer(int[] data) {
		return BufferUtils.createIntBuffer(data.length).put(data);
	}

}
