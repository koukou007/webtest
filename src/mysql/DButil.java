package mysql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DButil {
	private static String name = null;
	private static String password = null;
	private static String driver = null;
	private static String url = null;
	public static Connection getConn() {
		
		Connection conn = null;
		
		Properties prop = new Properties();
		try {
			prop.load(DButil.class.getClassLoader().getResourceAsStream(
					"mysql.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		name = prop.getProperty("name");
		password = prop.getProperty("password");
	
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = (Connection)DriverManager.getConnection(url, name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}