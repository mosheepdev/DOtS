package com.kongkongmao.dots.util;

import static com.kongkongmao.dots.util.Utils.createFile;
import static com.kongkongmao.dots.util.Utils.writeLine;
import static com.kongkongmao.dots.util.Utils.readLineSP;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Allow users to change the runtime configuration.
 */
// A "standard" configuration file should be:
//
// lang:[The language preference setting]
//
// Default "DOtS-Config.txt".
//
public class Configuration {

	/**
	 * The configuration file.
	 */
	private static File config = new File(".\\DOtS-Config.txt");

	/**
	 * The byte size of the configuration file.
	 */
	private static final int CONFIG_FILE_SIZE = 12;

	/**
	 * The settings are recored inside this HashMap. <br>
	 * The map will be initialized when first loading the configuration file.
	 * <br>
	 * When a setting is modified, the value in the map will be changed, and
	 * <br>
	 * the configuration file will be modified only when the program is closing.
	 * <br>
	 * Developing should avoid getting options straight through this Map <br>
	 * for avoiding some critical IO issues.
	 */
	private static Map<String, String> settings = new HashMap<String, String>();

	/**
	 * Create the configuration file if it does not exist.
	 */
	private static void configFile() {
		if (config.exists())
			if (config.length() != CONFIG_FILE_SIZE) {
				createFile(config.toString(), true);
				writeDefaultConfig();
			} else
				return;
		else {
			createFile(config.toString(), true);
			writeDefaultConfig();
		}
	}

	/**
	 * Write the system default configuration.
	 */
	private static void writeDefaultConfig() {
		writeLine(config.toString(), cLanguage.NAME + ":" + cLanguage.DEFAULT);
		settings.put(cLanguage.NAME, cLanguage.DEFAULT);
	}

	/**
	 * Read the settings in the configuration file.
	 */
	private static void readConfigs() {
		try {
			settings.put(cLanguage.NAME, readLineSP(config.toString(), cLanguage.ID, 6));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialize() {
		configFile();
		readConfigs();
		cLanguage.initialize(settings.get(cLanguage.NAME));
	}

	/**
	 * Configuration of the language preference.
	 */
	public static ConfigLang cLanguage = new ConfigLang();

	/**
	 * This method must be casted in the closing of the program, <br>
	 * Otherwise the changing of the user would not be saved!
	 */
	public static void closeUp() {
		createFile(config.toString(), true);
		writeLine(config.toString(), cLanguage.NAME + ":" + settings.get(cLanguage.NAME));
	}

	/**
	 * Base of a configuration. Every configuration class should extend <br>
	 * this class, further has its own initializing value method to check <br>
	 * the values.
	 */
	protected static abstract class Config {

		/**
		 * The ID number of the configuration, indicates the line <br>
		 * of the configuration in the configuration file.
		 */
		final int ID = 0;

		/**
		 * The name of the configuration.
		 */
		final String NAME = "name_of_configuration";

		/**
		 * Default value of the configuration.
		 */
		final String DEFAULT = "default_value";

		String value;

		abstract String get();

		abstract void set(String $value);

	}

	public static class ConfigLang extends Config {

		protected final int ID = 1;

		protected final String NAME = "lang";

		protected final String DEFAULT = "en_US";

		private String value;

		private final List<String> LEGAL_VAL = new ArrayList<String>() {
			private static final long serialVersionUID = 684925698209892946L;
			{
				add("en_US");
				add("zh_CN");
				add("zh_TW");
			}
		};

		protected void initialize(String _value) {
			if (LEGAL_VAL.contains(_value))
				value = _value;
			else {
				value = DEFAULT;
				settings.put(NAME, DEFAULT);
			}
		}

		@Override
		public String get() {
			return value;
		}

		@Override
		public void set(String _value) {
			value = _value;
			settings.put(NAME, _value);
		}

	}

}
