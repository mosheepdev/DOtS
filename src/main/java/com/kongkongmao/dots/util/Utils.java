package com.kongkongmao.dots.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.List;

import com.google.common.io.Resources;

/**
 * Class: Utils <br>
 * Package: com.kongkongmao.dots.util <br>
 * Description: Some very useful utilities.
 */
public class Utils {

	/**
	 * The system time in the format of hh:mm:ss.
	 */
	public static String getSysTimeStr() {
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
	}

	/**
	 * The correct directory of the archive.
	 */
	public static String getDir() {
		return System.getProperty("user.dir");
	}

	/**
	 * Create a file.
	 * 
	 * @param path
	 *            The full path of the file.
	 * @param override
	 *            Whether override the old file if the file already exists.
	 */
	public static void createFile(String path, boolean override) {
		File f = new File(path);
		File parent = f.getParentFile();
		if (parent != null && !parent.exists())
			parent.mkdirs();
		if (f.exists())
			if (override == true)
				f.delete();
			else
				return;
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read the context of a specified line in a text file.
	 */
	public static String readLineS(String filePath, int line) throws IOException {
		File f = new File(filePath);
		List<String> lines = Files.readAllLines(f.toPath());
		return lines.get(line - 1);
	}

	/**
	 * Read the context after a specified position of a line in a text file.
	 */
	public static String readLineSP(String filePath, int line, int pos) throws IOException {
		pos = pos - 1;
		String l = readLineS(filePath, line);
		if (l.length() < pos)
			pos = l.length();
		l = l.substring(pos, l.length());
		return l;
	}

	/** Read the total lines of a text file. */
	public static int getTotalLines(String filePath) throws IOException {
		File f = new File(filePath);
		List<String> lines = Files.readAllLines(f.toPath());
		return lines.size() + 1;
	}

	/**
	 * Write a line to a text file. Automatically start a new line after the
	 * writing, <br>
	 * but will NOT start writing on a new line!
	 */
	public static void writeLine(String filePath, String msg) {
		File f = new File(filePath);
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true)));
			out.write(msg);
			out.write("\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Write data to a specific line of a text file. <br>
	 * Will override the old data.
	 */
	public static void writeLineS(String filePath, String msg, int line) throws IOException {
		File f = new File(filePath);
		List<String> lines = Files.readAllLines(f.toPath());
		lines.set(line - 1, msg);
		Files.write(f.toPath(), lines);
	}

	/**
	 * Write data to a specific position of a specific line of a text file. <br>
	 * The old data after the position will be erased. <br>
	 */
	public static void writeLineSP(String filePath, String msg, int line, int pos) throws IOException {
		pos = pos - 1;
		File f = new File(filePath);
		List<String> lines = Files.readAllLines(f.toPath());
		String l = lines.get(line - 1);
		if (l.length() < pos)
			pos = l.length();
		l = l.substring(l.length() - pos);
		l = l + msg;
		lines.set(line - 1, l);
		Files.write(f.toPath(), lines);
	}

	/**
	 * Get the content of a resource file as a array of bytes.
	 */
	public static byte[] getRes(String path) throws IOException {
		URL url = Resources.getResource(path);
		return Resources.toByteArray(url);
	}

	/**
	 * Get the content of a resource file as a list of string.
	 */
	public static List<String> getContentRes(String path) throws IOException {
		URL url = Resources.getResource(path);
		Charset cs = Charset.forName(References.DEFAULT_ENCODE);
		return Resources.readLines(url, cs);
	}

}
