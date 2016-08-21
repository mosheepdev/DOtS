package com.kongkongmao.dots.util;

import static com.kongkongmao.dots.util.Utils.getDir;
import static com.kongkongmao.dots.util.Utils.createFile;
import static com.kongkongmao.dots.util.Utils.writeLine;
import static com.kongkongmao.dots.util.Utils.readLineS;
import static com.kongkongmao.dots.util.Utils.readLineSP;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
	private static File config = new File(getDir() + "TNAI-Config.txt");

	/**
	 * The byte size of the configuration file.
	 */
	private static final int CONFIG_FILE_SIZE = 12;

	/**
	 * The settings are recored inside this HashMap. <br>
	 * The map will be initialized when first loading the config file. <br>
	 * When a setting is modified, the value in the map will be changed, and
	 * <br>
	 * the config file will be modified.
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
		writeLine(config.toString(), "lang:en_US");
		settings.put("lang", "en_US");
	}

	/**
	 * Check if the configuration file is invalid. <br>
	 * This is only the first check.
	 */
	private static boolean checkBroken() {
		try {
			if (!readLineS(config.toString(), 1).startsWith("lang:"))
				return false;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Read the configs of the configuration file.
	 */
	private static void readConfigs() {
		try {
			settings.put("lang", readLineSP(config.toString(), 1, 6));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialize() {
		configFile();
		checkBroken();
		readConfigs();
	}

	public static String get(String key) {
		return settings.get(key);
	}

	public static void set(String key, String value) {
		settings.put(key, value);
	}

	/**
	 * This method must be casted in the closing of the program! <br>
	 * Otherwise the changing of the user would not be saved!
	 */
	public static void closeUp() {
		createFile(config.toString(), true);
		writeLine(config.toString(), "lang:" + settings.get("lang"));
	}

}
