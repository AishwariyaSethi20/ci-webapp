package com.lti.dao.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnManager {
	public static Connection connect(){
		
		 try{
			 Properties dbProps= new Properties();
			 dbProps.load(new FileReader("dev-db.properties"));
			 Class.forName("oracle.jdbc.driver.OracleDriver");
		  
		 return DriverManager.getConnection(dbProps.getProperty("url"), dbProps.getProperty("user"),dbProps.getProperty("pass"));
	}
	 catch(ClassNotFoundException | IOException | SQLException e) {
				e.printStackTrace();//not good, should be thrown rather
				return null;//very bad, should throw some user defined exceptions
				
			}

}
}
