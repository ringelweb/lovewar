package org.inayat.novo.ringelweb.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import org.inayat.novo.ringelweb.dao.UserDao;
import org.inayat.novo.ringelweb.model.UserModel;

public class UserDaoImpl implements UserDao {
	
	public UserModel doSave(UserModel model) {
		System.out.println("Entered in userDaoImpl:doSave.");
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/loversdb","root","");  
			
			PreparedStatement stmt=con.prepareStatement("insert into user(first_name,last_name,username,password,email,mobile,usertype) values(?,?,?,?,?,?,?)");    
			stmt.setString(1,model.getFname()); 
			stmt.setString(2,model.getLname()); 
			stmt.setString(3,model.getUsername()); 
			stmt.setString(4,model.getPassword()); 
			stmt.setString(5,model.getEmail()); 
			stmt.setString(6,model.getMobile()); 
			stmt.setString(7,model.getUserType()); 
			int i=stmt.executeUpdate();
			if(i>0) 
			{
			model.setUserMessage("success");
			}
			con.close(); 
			return model;  
			}
		   catch(Exception e){ 
			   System.out.println(e);
			   model.setException(e.toString());
		 } 
		return model;
		
	}

}
