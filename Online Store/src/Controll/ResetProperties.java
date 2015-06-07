package Controll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.Properties;

public class ResetProperties implements Serializable{
	Properties properties;
	
	public ResetProperties() {
		try {
			FileInputStream in=new FileInputStream(new File("reset.bin")); 
			ObjectInputStream ois=new ObjectInputStream(in);
			properties=(Properties) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			//fehlerausgabe
		}
	}
	
	public void wirteProperties() {
		FileWriter writer=null;
		try {
			writer=new FileWriter("properties.bin");
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
	
	public void initialConf(String[] conf){
		properties=new Properties();
		properties.put("DB-Driver", "org.gjt.mm.mysql.Driver");
		properties.put("DB-URL", conf[0]);
		properties.put("DB-User", conf[1]);
		properties.put("DB-Password", conf[2]);
		
		File file=new File("reset.conf");
		try {
			file.createNewFile();
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(properties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		file=new File("properties.conf");
		try {
			file.createNewFile();
			FileOutputStream fos=new FileOutputStream(file);
			OutputStreamWriter osw=new OutputStreamWriter(fos);
			properties.store(osw, "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
