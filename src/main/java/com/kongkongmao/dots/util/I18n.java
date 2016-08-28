package com.kongkongmao.dots.util;

import static com.kongkongmao.dots.util.Utils.getDir;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class: I18n <br>
 * Package: com.kongkongmao.dots.util <br>
 * Description: Internationalization and localization.
 */
public class I18n {

	private static final String IND = "=";

	private static String loc_name;

	private static Locales locale;

	private static final List<String> LEGAL_VAL = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
		{
			add("en_US");
			add("zh_CN");
			add("zh_TW");
		}
	};

	public static void initialize() {
		for (Locales l : Locales.values())
			try {
				l.readValues();
			} catch (IOException e) {
				e.printStackTrace();
			}
		loc_name = Configuration.cLanguage.get();
		locale = Locales.prase(loc_name);
	}

	/**
	 * Switch the locale of the internationalization.
	 */
	public static void switchLoc(String loc) {
		if (LEGAL_VAL.contains(loc)) {
			loc_name = loc;
			locale = Locales.prase(loc);
		} else
			throw new IllegalArgumentException("No such locale!");
	}

	/**
	 * Reveal the translated value of the "key".
	 */
	public static String t(String key) {
		return locale.reveal(key);
	}

	public static enum Locales {

		EN_US("en_US"), ZH_CN("zh_CN"), ZH_TW("zh_TW");

		private String name;

		private File langFile = new File(getDir() + "\\langs\\" + name + ".lang");

		private Map<String, String> values = new HashMap<String, String>();

		Locales() {
		}

		Locales(String x) {
			if (I18n.LEGAL_VAL.contains(x)) {
				name = x;
			}
		}

		public void readValues() throws IOException {
			List<String> trans = Utils.getContentRes("dots\\i18n\\" + name + ".lang");
			for (String x : trans) {
				int index = x.indexOf(IND);
				values.put(x.substring(0, index), x.substring(index));
			}
		}

		public String reveal(String key) {
			return values.get(key);
		}

		public static Locales prase(String x) {
			for (Locales loc : Locales.values()) {
				if (loc.name == x)
					return loc;
			}
			return EN_US;
		}
	}

}
