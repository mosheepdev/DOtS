package com.kongkongmao.dots.gui;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

/**
 * VBO of 2D textures.
 */
public class Model2DTexture extends Model2D {

	private int t_id;

	public Model2DTexture(float[] tex_coords) {
		t_id = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, t_id);
		glBufferData(GL_ARRAY_BUFFER, createFBuffer(tex_coords), GL_STATIC_DRAW);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}

	@Override
	public void render() {
		// glEnableClientState(GL_TEXTURE_COORD_ARRAY);
		glEnableVertexAttribArray(0);
		glEnableVertexAttribArray(1);

		glBindBuffer(GL_ARRAY_BUFFER, t_id);

		glVertexAttribPointer(1, 2, GL_FLOAT, false, 0, 0);
		// glTexCoordPointer(2, GL_FLOAT, 0, 0);
		glBindBuffer(GL_ARRAY_BUFFER, 0);

		glDisableVertexAttribArray(0);
		glDisableVertexAttribArray(1);
		// glDisableClientState(GL_TEXTURE_COORD_ARRAY);
	}

}
