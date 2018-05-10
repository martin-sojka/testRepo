package testShop;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.lang.reflect.*;
import java.net.MalformedURLException;

public class RunShop {

	public static void main(String[] args) throws MalformedURLException, AWTException {
		// TODO Auto-generated method stub

	/*	Users user = new Users("Martin", 20, false);
		System.out.println(user.getName());
		System.out.println("Logged: " + user.getLogged());
		user.setLogged();
		System.out.println("Logged: " + user.getLogged());
		System.out.println("Goods left: " + user.order());
		user.order(5);
		System.out.println("Goods left: " + user.order());
		
		System.out.println("----------------");
		
		Users user1 = new Users("Petr", 50, false);
		System.out.println(user1.getName());
		System.out.println("Logged: " + user1.getLogged());
		user1.setLogged();
		System.out.println("Logged: " + user1.getLogged());
		System.out.println("Goods left: " + user1.order());
		user1.order(5);
		System.out.println("Goods left: " + user1.order());
		
		System.out.println("----------------");
		
		Goods goods = new Goods();
		goods.addAmount(4);
		System.out.println("Goods add: " + goods.getAmount());
		
		System.out.println("----------------");
		
		System.out.println(user.getName());
		System.out.println("Logged: " + user.getLogged());
		user.setLogged();
		System.out.println("Logged: " + user.getLogged());
		System.out.println("Goods left: " + user.order());
		user.order(1);
		System.out.println("Goods left: " + user.order());
		
		System.out.println("----------------");
		
		System.out.println(user1.getName());
		System.out.println("Logged: " + user1.getLogged());
		user1.setLogged();
		System.out.println("Logged: " + user1.getLogged());
		System.out.println("Goods left: " + user1.order());
		user1.order(2);
		System.out.println("Goods left: " + user1.order());
		
		System.out.println("----------------");
		
		try {
			Class<?> c = Class.forName("testShop.Users");
			Method m[] = c.getDeclaredMethods();
			for (int i = 0; i < m.length; i++)
	            System.out.println(m[i].getName());
	         }
	         catch (Throwable e) {
	            System.err.println(e);
	         }
	      */
		
	/*	DbConn connection = new DbConn();
		connection.connect(); */
		
		
		if (SystemTray.isSupported()) {
            RunShop td = new RunShop();
            td.displayTray();
        } else {
            System.err.println("System tray not supported!");
        }		
	}
	
	public void displayTray() throws AWTException, MalformedURLException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);

        trayIcon.displayMessage("Hello, World", "notification demo", MessageType.INFO);
    }

}
