package com.rudra.dataaccess;

/**
 * jdbc:sqlserver://[DESKTOP-79KJ6GB\RUDRA[\instanceName][:portNumber]][;property=value[;property=value]]
 *
 */

import java.sql.Connection;
//import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Connection conn = null;

		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-79KJ6GB\\MSSQLSERVER;databaseName=ITCTraining;integratedSecurity=true";
			conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
			    System.out.println("Connected");
			}

			/*
			 * String dbURL = "jdbc:sqlserver://localhost\\sqlserver"; String user = "sa";
			 * String pass = "secret"; conn = DriverManager.getConnection(dbURL, user,
			 * pass); if (conn != null) { DatabaseMetaData dm = (DatabaseMetaData)
			 * conn.getMetaData(); System.out.println("Driver name: " + dm.getDriverName());
			 * System.out.println("Driver version: " + dm.getDriverVersion());
			 * System.out.println("Product name: " + dm.getDatabaseProductName());
			 * System.out.println("Product version: " + dm.getDatabaseProductVersion()); }
			 */
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}