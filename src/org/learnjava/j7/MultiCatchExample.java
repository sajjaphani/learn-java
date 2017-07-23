package org.learnjava.j7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * In Java SE 7 and later, a single catch block can handle more than one type of
 * exception. This feature can reduce code duplication and lessen the temptation
 * to catch an overly broad exception.
 * 
 * 
 * @author psajja
 *
 */
public class MultiCatchExample {

	/**
	 * This method tries to read the connection URL from a file (first line) and
	 * tries to create a DB connection and executes the given SQL query. This is
	 * only for demonstration purpose only.
	 * 
	 * @param file
	 *            the file to read from
	 *            
	 * @return true if the execution succeeds, false otherwise
	 * 
	 * @throws Exception
	 *             if any exception happens during reading
	 */
	private static boolean executeSqlStatementPreJava7(String file, String sql) throws Exception {
		BufferedReader br = null;
		Connection connection = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String firstLine = null;
			firstLine = br.readLine();

			connection = DriverManager.getConnection(firstLine);
			Statement stmt = connection.createStatement();

			return stmt.execute(sql);
		} catch (IOException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} finally {
			if (br != null)
				br.close();
			if(connection != null)
				connection.close();
		}
	}
	
	/**
	 * This method tries to read the connection URL from a file (first line) and
	 * tries to create a DB connection and executes the given SQL query. 
	 * This method uses the multi-catch. This is
	 * only for demonstration purpose only.
	 * 
	 * @param file
	 *            the file to read from
	 *            
	 * @return true if the execution succeeds, false otherwise
	 * 
	 * @throws Exception
	 *             if any exception happens during reading
	 */
	private static boolean executeSqlStatementJava7(String file, String sql) throws Exception {
		BufferedReader br = null;
		Connection connection = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String firstLine = null;
			firstLine = br.readLine();

			connection = DriverManager.getConnection(firstLine);
			Statement stmt = connection.createStatement();

			return stmt.execute(sql);
		} catch (IOException | SQLException e) {
			throw e;
		} finally {
			if (br != null)
				br.close();
			if(connection != null)
				connection.close();
		}
	}
	
	/**
	 * Main Client.
	 * 
	 * @param args
	 * 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		executeSqlStatementPreJava7("not-exists.txt", "sql-query");
		executeSqlStatementJava7("not-exists.txt", "sql-query");
		
	}

}
