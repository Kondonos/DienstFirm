package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class HauptMenü {
	
	ToolBar toolBar;

	private void init() {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(300, 200);

		Menu menubar = new Menu(shell, SWT.BAR);
		Menu menu;
		MenuItem item;
		menu = new Menu(menubar);
		
		item = new MenuItem(menu, SWT.PUSH);
		item.setText("Öffnen...");
		item.setData("oeffnen");
		
		item = new MenuItem(menu, SWT.PUSH);
		item.setText("Speichern\tStrg+S");
		item.setAccelerator(SWT.CTRL + 'S');
		item.setData("speichern");
	
		item = new MenuItem(menubar, SWT.CASCADE);
		item.setText("Menü");
		item.setMenu(menu);
		
		item = new MenuItem(menubar, SWT.CASCADE);
		item.setText("Datei");
		item.setMenu(menu);
	
		item = new MenuItem(menu, SWT.CHECK);
		item.setText("Testmodus");
		//mehr menu items
		
		item = new MenuItem(menubar, SWT.CASCADE);
		item.setText("Einstellungen");
		item.setMenu(menu);
	
		item = new MenuItem(menu, SWT.CHECK);
		item.setText("Testmodus");
		//mehr menu items
		
		item = new MenuItem(menubar, SWT.CASCADE);
		item.setText("Extras");
		item.setMenu(menu);
	
		item = new MenuItem(menu, SWT.CHECK);
		item.setText("Testmodus");
		//mehr menu items
		
//public Toolbar ?
		
		toolBar = new ToolBar(shell, SWT.FLAT | SWT.WRAP | SWT.RIGHT);
		
		final ToolItem itemDropDown = new ToolItem(toolBar, SWT.DROP_DOWN);
		itemDropDown.setText("Kategorie");
		itemDropDown.setToolTipText("Klick hier für Kategorien");
		
		final Menu dmenu = new Menu(shell, SWT.POP_UP);					//dmenu = drop down menu
		new MenuItem(dmenu, SWT.PUSH).setText("Gemüse");
		
		itemDropDown.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				if(event.detail == SWT.ARROW) {
					Rectangle bounds = itemDropDown.getBounds();
					Point point = toolBar.toDisplay(bounds.x, bounds.y + bounds.height);
					menu.setLocation(point);
					menu.setVisible(true);
				}
			}
		});
		
	}
}
