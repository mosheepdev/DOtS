package com.kongkongmao.dots.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kongkongmao.dots.main.Machining;

/**
 * Internationalization and localization.
 */
public class I18n {

	private static final String IND = "=";

	private static String loc_name;

	private static Locales locale;

	private static final List<String> LEGAL_VAL = new ArrayList<String>() {
		private static final long serialVersionUID = 233666998L;
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
		locale = Locales.parse(loc_name);
	}

	/**
	 * Switch the locale of the internationalization.
	 */
	public static void switchLoc(String loc) {
		if (LEGAL_VAL.contains(loc)) {
			loc_name = loc;
			locale = Locales.parse(loc);
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

		private Map<String, String> values = new HashMap<String, String>();

		Locales() {
		}

		Locales(String x) {
			if (I18n.LEGAL_VAL.contains(x))
				name = x;
		}

		public void readValues() throws IOException {
			List<String> trans = new ArrayList<String>();
			else
				trans = Files.readAllLines(new File("src\\main\\resources\\dots\\i18n\\" + name + ".lang").toPath());
			for (String x : trans) {
				if (x.indexOf(IND) != -1) {
					int index = x.indexOf(IND);
					values.put(x.substring(0, index), x.substring(index + 1));
				}
			}
		}

		public String reveal(String key) {
			if (values.containsKey(key))
				return values.get(key);
			return key;
		}

		public static Locales parse(String x) {
			for (Locales loc : Locales.values())
				if (loc.name.equals(x))
					return loc;
			return EN_US;
		}
	}

}
