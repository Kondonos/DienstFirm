package Controll;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ResetProperties {
	Properties properties;
	
	public ResetProperties() {
		properties=new Properties();
		properties.setProperty("DB-User", "Connect");
		properties.setProperty("DB-Password", "1234");
		properties.setProperty("DB-URL", "localhost:3306");
		//weitere Eigenschaften
		
	}
	
	public void wirteProperties() {
		FileWriter writer=null;
		try {
			writer=new FileWriter("properties.conf");
			properties.store(writer, "Default");
		} catch ( IOException e) {
			e.printStackTrace();
		}finally{
			try {
				writer.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}
