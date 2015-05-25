package Controll;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class LoginControll {
	Configuration conf;
	
	public LoginControll() {
		conf=new Configuration();
	}
	
	public void KeyPressed(KeyEvent e){
		String string = "";
		switch (e.character) {
			case 0: string += " '\\0'"; break;
			case SWT.BS: string += " '\\b'"; break;
			case SWT.CR: string += " '\\r'"; break;
			case SWT.DEL: string += " DEL"; break;
			case SWT.ESC: string += " ESC"; break;
			case SWT.LF: string += " '\\n'"; break;
			default: string += " '" + e.character +"'";
			break;	}
		System.out.println ("e.stateMask: " + e.stateMask + string);
	}
	
	public void KeyReleased(KeyEvent e){
		if (e.stateMask == SWT.CTRL && e.keyCode != SWT.CTRL)
			System.out.println("Taste losgelassen");
	}
	
	public void OKselect(SelectionEvent e){
		//nächste klasse / splash screen / datenverarbeitung
	}
	
	public void CANCELSelect(SelectionEvent e){
		Shell s=(Shell)((Button)e.getSource()).getParent();
		s.close();
	}
	public void CLOSEShell(Event e,Shell shell){
		int style = SWT.APPLICATION_MODAL | SWT.YES | SWT.NO;
		MessageBox messageBox = new MessageBox (shell, style);
		messageBox.setText ("Information");
		messageBox.setMessage ("Wollen Sie den Login wikrlich beenden?");
		e.doit = messageBox.open () == SWT.YES;
	}
	
}
