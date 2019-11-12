package home.kryvenkosergii.javacoreproject1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * The class 'FileUtil' for load and save database in file
 * 
 * @author 
 *
 */

public class FileUtil {

	/**
	 * The method 'load' database from file and return collection
	 * 
	 * @param fileName (string format)
	 * @param charset (type Charset)
	 * @return collection 'list' string type
	 */
	public static List<String> load(String fileName, Charset charset) {
		List<String> result = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), charset))) {
			String line = null;
			do {
				line = br.readLine();
				if (line != null) {
					result.add(line);
				}
			} while (line != null);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	/**
	 * The method 'save' saving database to file
	 * 
	 * @param fileName (string format)
	 * @param charset (type Charset)
	 * @param contents (collection string format)
	 */
	public static void save(String fileName, Charset charset, List<String> contents) {
		try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), charset))) {
			if (contents != null) {
				for (String line : contents) {
					br.write(line);
					br.write("\n");
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
