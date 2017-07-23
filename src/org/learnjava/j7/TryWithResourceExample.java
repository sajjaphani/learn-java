package org.learnjava.j7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * A resource is an object that must be closed after the program is finished
 * with it. The try-with-resources statement ensures that each resource is
 * closed at the end of the statement. Any object that implements
 * java.lang.AutoCloseable, which includes all objects which implement
 * java.io.Closeable, can be used as a resource.
 * 
 * @see <a href="https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html">Try With Resources</a>
 * 
 * @author psajja
 *
 */
public class TryWithResourceExample {

	/**
	 * Reads the first line from the given line. Pre Java 7.
	 * 
	 * @param path
	 * 		given file with path
	 * 
	 * @return
	 * 		the first line
	 * 
	 * @throws IOException
	 * 		if fails to read
	 */
	private static String readFirstLineFromFilePreJava7(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
			return br.readLine();
		} finally {
			if (br != null)
				br.close();
		}
	}

	/**
	 * Reads the first line from the given line. Java 7.
	 * 
	 * @param path
	 * 		given file with path
	 * 
	 * @return
	 * 		the first line
	 * 
	 * @throws IOException
	 * 		if fails to read
	 */
	private static String readFirstLineFromFileJava7(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}

	/**
	 * Main Client.
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println(readFirstLineFromFilePreJava7("not-exists.txt"));
		System.out.println(readFirstLineFromFileJava7("not-exists.txt"));
	}

}
