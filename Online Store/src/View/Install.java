package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import Controll.Configuration;
import Controll.InstallControll;
import Controll.ResetProperties;

public class Install {
	public Display display;
	public Shell shell;
	public Label[] labels;
	public Text[] texts;
	public Button buttons[];
	public Combo combo;
	public String[] brands;
	public ResetProperties conf;
	
	
	public Install() {
		if(InstallControll.isDone())
			InstallControll.openlogin(shell);;
		display=new Display();
		this.shell=new Shell(display,SWT.APPLICATION_MODAL);
		shell.setText("Datenbankverbindung");
		GridLayout gl=new GridLayout(2, false);
		labels=new Label[3];
		texts=new Text[3];
		String[] text={"URL:","Username:","Passwort:"};
		brands=new String[]{"MySQL","Microsoft Access"};
		for(int i=0;i<4;i++){
			labels[i]=new Label(shell,SWT.NONE);
			labels[i].setText(text[i]);
			texts[i]=new Text(shell,SWT.BORDER);
			
		}
		buttons=new Button[2];
		Button b=buttons[0];
		b=new Button(shell, SWT.PUSH);
		b.setText("Abbrechen");
		b.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				MessageBox msg=new MessageBox(shell, SWT.ICON_QUESTION|SWT.YES|SWT.CANCEL);
				msg.setMessage("Wollen Sie wirklich das Programm beenden");
				int resp=msg.open();
				InstallControll.msg(resp,shell);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		b=buttons[1];
		b=new Button(shell, SWT.PUSH);
		b.setText("Fertig");
		b.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent event) {
				String[] props={texts[0].getText().toString(),
						texts[1].getText().toString(),
						texts[2].getText().toString()};
				conf.initialConf(props);
				InstallControll.openlogin(shell);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
	}
	public void run(){
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
