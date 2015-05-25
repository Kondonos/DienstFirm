package Controll;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	Properties properties;
	
	public Configuration(){
		FileReader reader=null;
		try{
			reader= new FileReader("properties.conf");
			properties=new Properties();
			properties.load(reader);
		}catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void replace(String key,String value){
		properties.replace(key, value);
		update();
	}
	
	public void update(){
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
	
	public void reset(){
		this.properties=new ResetProperties().properties;
		update();
	}
	
	public void replaceAll(String keys[],String values[]){
		for(int i=0;i<keys.length;i++){
			properties.replace(keys[i], values[i]);
		}
		update();
	}
}
