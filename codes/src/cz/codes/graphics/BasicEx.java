package cz.codes.graphics;

import java.awt.EventQueue;
import javax.swing.JFrame;




public class BasicEx extends JFrame {
	
	public BasicEx() {
        
        add(new SimpleObj());

        setTitle("Hit testing");
        setSize(250, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);           
    }
	
	

	public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
            	BasicEx ex = new BasicEx();
                ex.setVisible(true);
            }
        });
    }

	
}


