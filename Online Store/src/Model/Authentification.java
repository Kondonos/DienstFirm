package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentification implements Data{
	private String username;
	private String password;
	private String group;
	private int id;
	
	@Override
	public void ResultSettoData(ResultSet rs) {
		try {
			username=rs.getString("VName");
			password=rs.getString("VPassword");
			group=rs.getString("group");
			id=rs.getInt("ID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
