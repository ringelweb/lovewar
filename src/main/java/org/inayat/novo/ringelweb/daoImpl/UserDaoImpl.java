package org.inayat.novo.ringelweb.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.inayat.novo.ringelweb.dao.UserDao;
import org.inayat.novo.ringelweb.database.DBConnection;
import org.inayat.novo.ringelweb.model.UserModel;

public class UserDaoImpl implements UserDao {
	
	public UserModel doSave(UserModel model) {
		System.out.println("Entered in userDaoImpl:doSave.");
		try{  
		    Connection con=	DBConnection.connect();
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

	@Override
	public String doAuthenticate(UserModel userModel) {
		 Connection con=DBConnection.connect();
		String userid= userModel.getUsername();
		String password=userModel.getPassword();
		 try {
		String query="select *FROM user WHERE (username='"+userid+"' OR mobile='"+userid+"' OR email='"+userid+"') AND password='"+password+"'";
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery(query);
	
	    if(rs.next()) {
	    	con.close();
	    	return "success";
	       }
	    else {
	    	con.close();
	    	return "failed";
	    }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return null;
	}

}
