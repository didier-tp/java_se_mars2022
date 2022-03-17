package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MyJdbcUtil {
	    //dbType="mysql" or "h2" or ...
		public static Connection etablishConnection(String dbType) {
			Connection cn=null;
			try {
				ResourceBundle ressources = ResourceBundle.getBundle("paramDB-"+dbType) ; // paramDB.properties
				String driver = ressources.getString("driver"); 
				String chUrl = ressources.getString("url");
				String username = ressources.getString("username"); 
				String password = ressources.getString("password");
				Class.forName(driver); 
				cn = DriverManager.getConnection(chUrl,username,password) ;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return cn;
		}
		
		public static void closeConnection(Connection cn){
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
