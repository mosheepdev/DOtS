package com.kongkongmao.dots.gui.render;

public class RText implements Cloneable {

	public String content;

	/**
	 * The font size.
	 */
	public int scale;

	private RText() {
	}

	public RText(String _cont) {
		this.content = _cont;
		this.scale = 1;
	}

	public RText(String _cont, int _scale) {
		this.content = _cont;
		this.scale = _scale;
	}

	@Override
	public RText clone() {
		return new RText(this.content, this.scale);
	}

}
