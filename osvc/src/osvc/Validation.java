package osvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Validation {

	JFrame jf = new JFrame("Username & Password");
	
	JTextField tfName = new JTextField();
	JPasswordField tfPass = new JPasswordField(10);
	
	JLabel labelName = new JLabel("username:");
	JLabel labelPass = new JLabel("password:");
	
	JButton okButton = new JButton("OK");
	
	OracleDB oDB;
	Form form = new Form();
	
public void validate() {
	
	labelName.setBounds(10, 10, 80, 20);
	labelPass.setBounds(10, 40, 80, 20);
	
	tfName.setBounds(80, 10, 80, 20);
	tfPass.setBounds(80, 41, 80, 20);
	
	okButton.setBounds(180, 26, 70, 25);
	
	jf.add(tfName);jf.add(tfPass);
	jf.add(labelName);jf.add(labelPass);
	
	jf.add(okButton);
	
	jf.setSize(300, 120);
	jf.setLocationRelativeTo(null);
	jf.setLayout(null);
	jf.setVisible(true);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
// add action listener for okButton
	
	okButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String username = tfName.getText();
			char[] password = tfPass.getPassword();
			
		/*	if (oDB.connect(username, password)) {
				form.Formular(); // call main window
				Arrays.fill(password, '0'); //set char[] password to null
				jf.dispose(); // close login window
			} else {
				JOptionPane.showMessageDialog(jf,"bad username or password","Alert",JOptionPane.WARNING_MESSAGE);
				tfName.setText("");
				tfPass.setText("");
			} */
			
			try {
				 Connection c = OracleDB.getConn(username, password);
				 if (c.isClosed() == false) {
					form.Formular(); // call main window
					//Arrays.fill(password, '0'); //set char[] password to null
					jf.dispose(); // close login window
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
				
				JOptionPane.showMessageDialog(jf,"bad username or password","Alert",JOptionPane.WARNING_MESSAGE);
				tfName.setText("");
				tfPass.setText("");
			} 
							
		}
	});
		
}
}
