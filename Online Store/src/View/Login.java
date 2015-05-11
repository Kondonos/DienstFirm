package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class Login {
	Display display = new Display();
	Shell shell = new Shell(display);
	
	Text textUser;
	Text textPassword;

	private void init() {
		(new Label(shell, SWT.NULL)).setText("User name: ");
		
		
		textUser = new Text(shell, SWT.SINGLE | SWT.BORDER);
		textUser.setText("default_user");
		textUser.setTextLimit(16);
		
		(new Label(shell, SWT.NULL)).setText("Password: ");
		
		textPassword = new Text(shell, SWT.SINGLE | SWT.BORDER);
		System.out.println(textPassword.getEchoChar());
		textPassword.setEchoChar('*');
		textPassword.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
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
				System.out.println ("e.stateMask: " + e.stateMask + string);}
			public void keyReleased(KeyEvent e) {
				if (e.stateMask == SWT.CTRL && e.keyCode != SWT.CTRL)
					System.out.println("Taste losgelassen");} });
		
	
	Button ok = new Button (shell, SWT.PUSH);
	ok.setText ("OK");
	
	ok.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
			//nächste klasse / splash screen / datenverarbeitung
			
		}
	});
	
	Button cancel = new Button (shell, SWT.PUSH);
	cancel.setText ("Abbruch");
	
	cancel.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
			shell.close();
		}
	});
	}
	
	public Login() {
		shell.setLayout(new GridLayout(2, false));
		
		init();
		
		textUser.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		textPassword.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		
		shell.addListener (SWT.Close, new Listener () {
			public void handleEvent (Event event) {
				int style = SWT.APPLICATION_MODAL | SWT.YES | SWT.NO;
				MessageBox messageBox = new MessageBox (shell, style);
				messageBox.setText ("Information");
				messageBox.setMessage ("Wollen Sie den Login wikrlich beenden?");
				event.doit = messageBox.open () == SWT.YES;
			}
		});
		
		shell.pack();
		shell.open();
		//textUser.forceFocus();

		// Set up the event loop.
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				// If no more entries in event queue
				display.sleep();
			}
		}

		display.dispose();
	}



	public static void main(String[] args) {
		new Login();
	}
}
