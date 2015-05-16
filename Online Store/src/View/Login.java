package View;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import Controll.LoginControll;


public class Login {
	Display display = new Display();
	Shell shell = new Shell(display);
	
	Text textUser;
	Text textPassword;
	
	LoginControll controll;			//Controllhandler
	
	private void init() {
		(new Label(shell, SWT.NULL)).setText("User name: ");
		
		
		textUser = new Text(shell, SWT.SINGLE | SWT.BORDER);
		textUser.setText("default_user");
		textUser.setTextLimit(16);
		
		(new Label(shell, SWT.NULL)).setText("Password: ");
		
		textPassword = new Text(shell, SWT.SINGLE | SWT.BORDER);
		System.out.println(textPassword.getEchoChar());
		textPassword.setEchoChar('*');
		controll=new LoginControll();
		textPassword.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				controll.KeyPressed(e);
			}
			public void keyReleased(KeyEvent e) {
					controll.KeyReleased(e);
			}
		});
		
	
	Button ok = new Button (shell, SWT.PUSH);
	ok.setText ("OK");
	
	ok.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
			controll.OKselect(e);
			
		}
	});
	
	Button cancel = new Button (shell, SWT.PUSH);
	cancel.setText ("Abbruch");
	
	cancel.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
			controll.CANCELSelect(e);
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
				controll.CLOSEShell(event, shell);
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
}
