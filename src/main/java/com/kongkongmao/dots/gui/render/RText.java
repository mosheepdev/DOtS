package com.kongkongmao.dots.gui.render;

public class RText implements Cloneable {

	public String content;

	/**
	 * The font size.
	 */
	public float scale;

	private RText() {
	}

	public RText(String _cont) {
		this.content = _cont;
		this.scale = 1;
	}

	public RText(String _cont, float _scale) {
		this.content = _cont;
		this.scale = _scale;
	}

	@Override
	public RText clone() {
		return new RText(this.content, this.scale);
	}

}
