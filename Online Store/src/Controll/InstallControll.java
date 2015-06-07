package Controll;



import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;

import View.Install;
import View.Login;

public class InstallControll{

	public static void msg(int respond,Shell shell){
		if(respond==SWT.CANCEL)
			;
		if(respond==SWT.OK)	
			shell.dispose();
			
	}
	
	public static void openlogin(Shell shell) {
		new Login(shell.getDisplay());
	}
	
	public static boolean isDone() {
		if( new File("properties.conf").isFile()){
			return true;
		}else
			return false;
	}
}
