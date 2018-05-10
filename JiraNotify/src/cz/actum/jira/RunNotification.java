package cz.actum.jira;


import java.awt.*;
import java.awt.AWTException;
import java.net.MalformedURLException;



public class RunNotification {
	
	public static void main(String[] args) throws AWTException, MalformedURLException {
		
		if (SystemTray.isSupported()) {
	        SysTray st = new SysTray();
	        st.displayTray();
	    } else {
	        System.err.println("System tray not supported!");
	    	}
		
			
	}
	
	

}
