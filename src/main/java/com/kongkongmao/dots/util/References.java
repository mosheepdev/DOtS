package com.kongkongmao.dots.util;

/**
 * Class: References <br>
 * Package: com.kongkongmao.dots.util <br>
 * Description: Provides the references to the program.
 */
public class References {

	/**
	 * The Main class of the program, scilicet, the starting point of the
	 * program.
	 * 
	 * @see com.kongkongmao.dots.main.Main
	 */
	public static final String MAIN_CLASS = "com.kongkongmao.dots.main.Main";

	public static final String ARCHIVE_NAME = "DOtS-001.jar";

	/**
	 * The default characters encoding method of the program.
	 */
	public static final String DEFAULT_ENCODE = "utf-8";

	/**
	 * The name of the program refers to the users.
	 */
	public static final String NAME = "dots.name";
	/**
	 * The name of the program refers to the developers.
	 */
	public static final String REF = "DOtS";

	/**
	 * The stage number of the program, indicates the progress <br>
	 * of the whole program.
	 */
	/*
	 * Planning stages: Indev; Adopt; Alpha; Beta; Formal. (Extension?)
	 */
	public static final String VERSION_REF = "Indev";
	/**
	 * The major version number of the program, indicates the features and <br>
	 * stability.
	 */
	public static final String VERSION_MAJOR = "1.0.0.000";
	/**
	 * The minor version number of the program, indicates the bugs fixing.
	 */
	public static final String VERSION_MINOR = "a";

	/**
	 * The version number used between the developers. EVERY change of the
	 * program that are built should be reported as a new build, and the build
	 * number would increase by 1. <br>
	 * The first number indicates the first number of the VERSION_MAJOR,
	 * scilicet the biggest version number. <br>
	 * The last three numbers indicate the build number. <br>
	 * Before every 'gradle build', all the developers should be noticed to
	 * avoid conflict. <br>
	 * If the situation occurs, please revert the project to the nearest
	 * percipient version number.
	 */
	public static final String BUILD_NUMBER = "1-001";

}
