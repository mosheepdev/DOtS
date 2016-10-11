package com.kongkongmao.dots.gui.render;

import java.util.HashMap;
import java.util.Map;

import com.kongkongmao.dots.util.I18n;

public class TextRenderer {

	private static Map<Integer, String> strings = new HashMap<Integer, String>();

	public static void drawStr(String _string, int _x, int _y, int _renderID) {
		_string = I18n.t(_string);
		strings.put(_renderID, _string);
		// TODO 在等小乔回答我问题= =
	}

	public static void delStr(int _renderID) {
		if (!strings.containsKey(_renderID))
			throw new IllegalStateException(
					"Failed to search rendering ID in an attemption on deleting a rendered string.");
		else
			strings.remove(_renderID);
		// TODO 所以说现在在等小乔回答问题= =
	}

}
