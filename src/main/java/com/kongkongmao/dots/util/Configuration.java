package com.kongkongmao.dots.util;

import static com.kongkongmao.dots.util.Utils.getDir;
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
 * Class: Configuration <br>
 * Package: com.kongkongmao.dots.util <br>
 * Description: Allow users to change the runtime.
 */
// A "standard" configuration file should be:
//
// lang:[The language preference setting]
//
// Default "TNAI-Config.txt".
//
public class Configuration {

	/**
	 * The configuration file.
	 */
	private static File config = new File(getDir() + "\\TNAI-Config.txt");

	/**
	 * The byte size of the configuration file.
	 */
	private static final int CONFIG_FILE_SIZE = 12;

	/**
	 * The settings are recored inside this HashMap. <br>
	 * The map will be initialized when first loading the config file. <br>
	 * When a setting is modified, the value in the map will be changed, and
	 * <br>
	 * the config file will be modified only when the program is closing. <br>
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
		writeLine(config.toString(), ConfigLang.NAME + ":" + "en_US");
		settings.put(ConfigLang.NAME, ConfigLang.DEFAULT);
	}

	/**
	 * Read the configs of the configuration file.
	 */
	private static void readConfigs() {
		try {
			settings.put(ConfigLang.NAME, readLineSP(config.toString(), ConfigLang.ID, 6));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialize() {
		configFile();
		readConfigs();
		ConfigLang.initialize(settings.get(ConfigLang.NAME));
	}

	/**
	 * This method must be casted in the closing of the program, <br>
	 * Otherwise the changing of the user would not be saved!
	 */
	public static void closeUp() {
		createFile(config.toString(), true);
		writeLine(config.toString(), ConfigLang.NAME + ":" + settings.get(ConfigLang.NAME));
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
		static final int ID = 0;

		/**
		 * The name of the configuration.
		 */
		static final String NAME = "name_of_configuration";

		/**
		 * Default value of the configuration.
		 */
		static final String DEFAULT = "default_value";

		static String value;

		abstract String get();

		abstract void set(String $value);

	}

	public static class ConfigLang extends Config {

		protected static final int ID = 1;

		protected static final String NAME = "lang";

		protected static final String DEFAULT = "en_US";

		private static String value;

		private static final List<String> LEGAL_VAL = new ArrayList<String>() {
			private static final long serialVersionUID = 684925698209892946L;
			{
				add("en_US");
				add("zh_CN");
				add("zh_TW");
			}
		};

		protected static void initialize(String $value) {
			if (LEGAL_VAL.contains($value))
				value = $value;
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
		public void set(String $value) {
			value = $value;
			settings.put(NAME, $value);
		}

	}

}
