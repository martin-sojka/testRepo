package osvc;

import java.awt.event.*;  
import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class Form {
	
	OracleDB oDB;
		
	public void Formular() {
		
// add JFrame
		JFrame f = new JFrame("vypocet dane pro Soc a Zdrav");
		
// add JTextFields
		final JTextField tf = new JTextField();
		final JTextField tf2 = new JTextField();
		final JTextField tf3 = new JTextField();
		final JTextField tf4 = new JTextField();
		final JTextField tf5 = new JTextField();
		final JTextField tf6 = new JTextField();
		final JTextField tfMesic = new JTextField();
		final JTextField tfCastka = new JTextField();
		tf.setBounds(50, 50, 150, 20);
		tf2.setBounds(50, 50, 150, 20);
		tf2.setEditable(false);
		tf3.setBounds(50, 50, 150, 20);
		tf3.setEditable(false);
		tf4.setBounds(50, 50, 150, 20);
		tf4.setEditable(false);
		tf5.setBounds(50, 50, 150, 20);
		tf5.setEditable(false);
		tf6.setBounds(50, 50, 80, 20);
		tf6.setEditable(false);
		tfMesic.setBounds(50, 50, 80, 20);
		tfCastka.setBounds(50, 50, 80, 20);
		tf.setLocation(130, 0);
		tf2.setLocation(130, 40);
		tf3.setLocation(130, 80);
		tf4.setLocation(130, 120);
		tf5.setLocation(130, 160);
		tf6.setLocation(100, 250);
		tfMesic.setLocation(100, 290);
		tfCastka.setLocation(100, 330);
	
// add JLabels
		JLabel jl1 = new JLabel("Rocni vydelek: ");
		JLabel jl2 = new JLabel("Socialni pojisteni: ");
		JLabel jl3 = new JLabel("Zdravotni pojisteni: ");
		JLabel jl4 = new JLabel("Mesicni Soc + Zdrav: ");
		JLabel jl5 = new JLabel("Rocni Soc + Zdrav: ");
		JLabel jlMesic = new JLabel("Pridat mesic: ");
		JLabel jlCastka = new JLabel("Pridat castku: ");
		jl1.setBounds(50, 50, 150, 20);
		jl1.setLocation(10, 0);
		jl2.setBounds(50, 50, 150, 20);
		jl2.setLocation(10, 40);
		jl3.setBounds(50, 50, 150, 20);
		jl3.setLocation(10, 80);
		jl4.setBounds(50, 50, 150, 20);
		jl4.setLocation(10, 120);
		jl5.setBounds(50, 50, 150, 20);
		jl5.setLocation(10, 160);
		jlMesic.setBounds(50, 50, 150, 20);
		jlMesic.setLocation(10, 290);
		jlCastka.setBounds(50, 50, 150, 20);
		jlCastka.setLocation(10, 330);
	
// add buttons
		JButton b = new JButton("vypocet");
		JButton bAdd = new JButton("pridat");
		JButton delete = new JButton("smazat");
		bAdd.setBounds(100, 300, 90, 30);
		bAdd.setLocation(200, 285);
		delete.setBounds(100, 300, 90, 30);
		delete.setLocation(200, 245);
		b.setBounds(50, 100, 95, 30);
		b.setLocation(130, 190);
		
// add JDatePicker
	/*	UtilDateModel model = new UtilDateModel();
		model.setDate(2018, 7, 25);
		JDatePanelImpl datePanel = new JDatePanelImpl(model, null);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null); */
				
// string for combobox
		String[] monthsArray = {"leden", "unor", "brezen", "duben", "kveten", "cerven", "cervenec", "srpen", "zari", "rijen", "listopad", "prosinec"};
	
// add combobox
		JComboBox<String> comboBox = new JComboBox<String>(monthsArray);
		comboBox.setBounds(10, 250, 80, 20);
		
// vypocet button		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String checkInt = "[0-9]+";
				String sal = tf.getText();
				
				if (sal.matches(checkInt)) {
					int num1 = Integer.parseInt(tf.getText());
					int sp = socPoj(num1);
					int zp = zdravPoj(num1);
					int yearly;
					int monthly;
					
					tf2.setText(sp + "");
					tf3.setText(zp + "");
					yearly = (sp + zp) * 12;
					tf5.setText(yearly + "");
					monthly = sp + zp;
					tf4.setText(monthly + "");
				} else {
					JOptionPane.showMessageDialog(f,"Only numbers allowed!","Alert",JOptionPane.WARNING_MESSAGE);
					tf.setText("");
				}
				
				
			}
		});
// pridat button					
		bAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String checkInt = "[0-9]+";
				String sal = tfCastka.getText();
				
				if (sal.matches(checkInt)) {
				
				String month = tfMesic.getText();
				int salary = Integer.parseInt(tfCastka.getText());
				try {
					OracleDB.connect(month, salary);
				} catch (Exception e1) {
					e1.printStackTrace();
				} 
				
				} else {
					JOptionPane.showMessageDialog(f,"Only numbers allowed!","Alert",JOptionPane.WARNING_MESSAGE);
					tf.setText("");
				}
				
				tfMesic.setText("");
				tfCastka.setText("");
			}
		});
// delete button		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String month = (String) comboBox.getSelectedItem();
								
				try {
				OracleDB.delete(month);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				tf6.setText("");
			}
		});
		
// combobox				
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id = (String) comboBox.getSelectedItem();
				
				try {
				int salary = OracleDB.connect(id);
				tf6.setText(salary + " ,-");
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		});
						
		f.add(b); 
		f.add(bAdd);
		f.add(delete);
		f.add(tf); f.add(tf2); f.add(tf3); f.add(tf4); f.add(tf5);f.add(tf6);f.add(tfMesic);f.add(tfCastka);
		f.add(jl1); f.add(jl2); f.add(jl3);f.add(jl4);f.add(jl5);f.add(jlMesic);f.add(jlCastka);
		f.add(comboBox);
		//f.add(datePicker);
				
		f.setSize(700, 500);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public int socPoj(int num1) {
		
		int pom = num1;
		int value = (pom * 60) / 100;
			if (value > 600000) value = 600000;
		value = pom - value;
		value *= 0.5;
		value *= 0.292 / 12;
		return value;
	}
	
	public int zdravPoj(int num1) {
		
		int pom = num1;
		int value = (pom * 60) / 100;
			if (value > 600000) value = 600000;
		value = pom - value;
		value *= 0.5;
		value *= 0.135 /12;
		return value;
	}
	
	
}
