package org.inayat.novo.ringelweb.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection implements DBCredentials {
	static Connection con;
	public static Connection connect() {
		
		try {
		Class.forName(DRIVER);  
		con=DriverManager.getConnection(DBURL,USER,PASSWORD); 
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	
	
	

}
