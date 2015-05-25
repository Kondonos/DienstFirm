package Controll;

import java.sql.*;
import java.util.ArrayList;

import Model.Data;

public class DBConnection{
	Connection con;
	ResultSet resultset;
	
	public DBConnection(String url,String user, String password) {
		con=null;
		String driverClass="org.gjt.mm.mysql.Driver";
		try {
			Class.forName(driverClass).newInstance();
			con=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.print(e.toString());
		}
	}
	
	public ResultSet sendquery(String query) throws SQLException{
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		return rs;
	}
	
}
