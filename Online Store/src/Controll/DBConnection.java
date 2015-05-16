package Controll;

import java.sql.*;
import java.util.ArrayList;
import Model.Data;

public class DBConnection<Data>{
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
	
	public ArrayList<Data> sendquery(String query){
		ArrayList<Data> daten=new ArrayList<Data>();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()){
				Data tmp.ResultSettoData();		//ist Standdardm‰ﬂig keine Funktion von Object 
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return daten;
	}
	
}
