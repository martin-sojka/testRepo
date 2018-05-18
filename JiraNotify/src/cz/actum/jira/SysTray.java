package cz.actum.jira;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.jira.rest.client.api.domain.User;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.util.concurrent.Promise;

public class SysTray {
	
	final String user = "martin.sojka";
	final String pass = "Asus#111";
	final String jira_url = "https://actumdigital.atlassian.net";
			
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
        

     
        
        try {
    		URI uri = new URI(jira_url);
    		final JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
    		final JiraRestClient rc = factory.createWithBasicHttpAuthentication(uri, user, pass);
    		
    		Promise<User> promise_user = rc.getUserClient().getUser(user);
    		User jira_user = promise_user.claim();
    		
    	/*	for (BasicProject bp : rc.getProjectClient().getAllProjects().claim()) {
    			System.out.println(bp.getKey() + ": " + bp.getName());
    		}  */
    		
    		//final Promise<Issue> issue = rc.getIssueClient().getIssue("IIS-353");
    		
    	//	System.out.println(String.format(jira_user.getEmailAddress()));
    		
    		// Promise<SearchResult> search = rc.getSearchClient().searchJql("project = IIS AND issuetype in (Bug, \"IT Help\", \"Service Request\", \"Service Request with Approvals\", Task, Sub-task) AND status in (\"In Progress\", Open, \"Waiting for 3rd Party\", \"Waiting for Approval\", \"Waiting for Client\") AND assignee in (L2, Lubomir.zalesak, martin.sojka, Tomas.lachout) order by created DESC");
    		Promise<SearchResult> search = rc.getSearchClient().searchJql("text ~ \"odchod\" order by created DESC");
    			for (Issue issue : search.claim().getIssues()) {
    				//System.out.println(issue.getKey() + " - " + issue.getSummary());
    				String name = issue.getSummary();
    				between(name);
    				//	trayIcon.displayMessage(issue.getKey(), issue.getSummary() , MessageType.INFO);
    				}
    			
    			System.exit(1);
    		
    	} catch (URISyntaxException e) {
    				System.out.println("URI" + " is not the right one");
    	}
        
        
    }
	
	public void between (String name) {
		
		String jmeno = "Jiří Draška";
		Integer pomJmeno = 0;
		Pattern p = Pattern.compile("([^o|Odchod\\s-\\s]+[A-Za-zŠšřŘěčžŽíáÁýéČ]+\\s[A-Za-zŠšřŘěčžŽíáÁýéČ]+)");
		Matcher m = p.matcher(name);
		String m2;
		Integer pom = 0;
		
		if (m.find()) {
			m2 = (String)m.group(0);
			//System.out.println(m2);
			//System.out.println(jmeno);
			
			if (m2.length() < jmeno.length())
				pomJmeno = m2.length();
			else pomJmeno = jmeno.length();
				
				for (int i = 0; i < pomJmeno; i++) {
					
					if (jmeno.charAt(i) == m2.charAt(i)) {
						pom ++;
						}
					}
				}
				if (pom >= 7)
					System.out.println(true);
				else
					System.out.println(false);
		}
		
		
		}
	
	
	
	

