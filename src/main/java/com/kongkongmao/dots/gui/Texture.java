package com.kongkongmao.dots.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;

import static org.lwjgl.opengl.GL11.*;

/**
 * Class: Texture <br>
 * Package: com.kongkongmao.dots.gui <br>
 * Description: The working frame of the textures.
 */
public class Texture {

	private int id;

	private int width, height;

	public Texture(String file) {
		BufferedImage bi;
		try {
			bi = ImageIO.read(new File(file));
			width = bi.getWidth();
			height = bi.getHeight();
			int[] pixels_r = new int[width * height];
			pixels_r = bi.getRGB(0, 0, width, height, null, 0, width);
			ByteBuffer pixels = BufferUtils.createByteBuffer(pixels_r.length);

			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					int pixel = pixels_r[i * width + 4 - 1];
					pixels.put((byte) ((pixel >> 16) & 0xFF)); // R
					pixels.put((byte) ((pixel >> 8) & 0xFF)); // G
					pixels.put((byte) (pixel & 0xFF)); // B
					pixels.put((byte) ((pixel >> 24) & 0xFF)); // A
				}
			}

			pixels.flip();
			id = glGenTextures();

			glBindTexture(GL_TEXTURE_2D, id);

			glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
			glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, pixels);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void bind() {
		glBindTexture(GL_TEXTURE_2D, id);
	}

}
