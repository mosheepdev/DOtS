package com.kongkongmao.dots.gui.render;

import java.util.HashMap;
import java.util.Map;

import com.kongkongmao.dots.util.I18n;

public class TextRenderer {

	private static Map<Integer, String> strings = new HashMap<>();

	public static void drawStr(String _string, int _x, int _y, int _renderID) {
		drawStr(new RText(_string, 12.0f), _x, _y, _renderID);
	}

	public static void drawStr(RText _text, int _x, int _y, int _renderID) {
		String rT = I18n.t(_text.content);
		strings.put(_renderID, rT);
		// TODO Miking...
	}

	public static void delStr(int _renderID) {
		if (!strings.containsKey(_renderID))
			throw new IllegalStateException(
					"Failed to search rendering ID in an attemption on deleting a rendered string.");
		else
			strings.remove(_renderID);
		// TODO Miking...
	}

}
