/*package org.inayat.novo.ringelweb.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.inayat.novo.ringelweb.dao.GfBfDao;
import org.inayat.novo.ringelweb.database.DBConnection;
import org.inayat.novo.ringelweb.model.GfBfDataModel;
import org.inayat.novo.ringelweb.model.UserModel;

public class GfBfDaoImpl  implements GfBfDao{

	@Override
	public GfBfDataModel doSave(GfBfDataModel gfBfDataModel) {
		

		System.out.println("Entered in userDaoImpl:doSave.");
		try{ 
		    Connection con=	DBConnection.connect();
			PreparedStatement stmt=con.prepareStatement("insert into gfbfdata(gfbf_id,name,age,sex,location,whatsappno) values(?,?,?,?,?,?)");    
			
			stmt.setString(1,gfBfDataModel.getId()); 
			stmt.setString(2,gfBfDataModel.getName()); 
			stmt.setInt(3,gfBfDataModel.getAge()); 
			stmt.setString(4,gfBfDataModel.getSex()); 
			stmt.setString(5,gfBfDataModel.getLocation()); 
			stmt.setString(6,gfBfDataModel.getWhatsappno()); 
			int i=stmt.executeUpdate();
			if(i>0) 
			{
				gfBfDataModel.setReturnedmsg("success");
				gfBfDataModel.setException("no exception");
			}
			con.close(); 
			return gfBfDataModel;  
			}
		   catch(Exception e){ 
			   System.out.println(e);
			   gfBfDataModel.setException("Exception occur in Saving data::"+e.toString());
		 } 
		gfBfDataModel.setReturnedmsg("Somethiing wrong saving DATA......");
		return gfBfDataModel;
		
	
	}
	
public String getAlldataFromUsername(UserModel userModel) {

		Connection con = DBConnection.connect();
		String username = userModel.getUsername();
		try {
			String query = "select *from user WHERE username='" + username + "'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				userModel.setId(rs.getInt(0));
				userModel.setFname(rs.getString(3));
				userModel.setLname(rs.getString(4));
				userModel.setEmail(rs.getString(5));
				userModel.setEmail(rs.getString(5));
				userModel.setEmail(rs.getString(5));
				userModel.setEmail(rs.getString(5));
				userModel.setEmail(rs.getString(5));

				return "success";
			} else {
				con.close();
				return "failed";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

@Override
public String getUserIdFromUserName(UserModel userModel) {
	// TODO Auto-generated method stub
	return null;
}

}
*/