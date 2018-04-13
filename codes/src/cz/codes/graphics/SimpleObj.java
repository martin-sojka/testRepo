package cz.codes.graphics;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;


public class SimpleObj extends JPanel {

	private Rectangle2D rect;
	private Ellipse2D ellipse;
	private float alfa_rect;
	private float alfa_ellipse;
	
	public SimpleObj() {
		
		initSurface();
		
	}
	
	public void initSurface() {
		
		addMouseListener(new HitTestAdapter());
			
				
		rect = new Rectangle2D.Float(20f, 20f, 80f, 50f);
		ellipse = new Ellipse2D.Float(120f, 30f, 60f, 60f);
		
		alfa_rect = 0.1f;
		alfa_ellipse = 1f;
		
	}
	
	
	public void paint (Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g.create();
			//g2d.setPaint(new Color(50, 50, 50));
			g2d.setPaint(Color.black);
			
			RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);	
			
			rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

	        g2d.setRenderingHints(rh);

	        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alfa_rect));
	        g2d.fill(rect);
	        
	        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alfa_ellipse));
	        g2d.fill(ellipse);
	        
	        g2d.dispose();
				
	}
	
	@Override
	public void paintComponents(Graphics g) {
		
		super.paintComponents(g);
		paint(g);
	}
	
	class RectRunnable implements Runnable {

	    private Thread runner;

	    public RectRunnable() {
	        
	        initThread();
	    }
	    
	    private void initThread() {
	        
	        runner = new Thread(this);
	        runner.start();
	    }

	    @Override
	    public void run() {

	        while (alfa_rect >= 0) {
	            
	            repaint();
	            alfa_rect += -0.01f;

	            if (alfa_rect < 0) {
	                alfa_rect = 0;
	            }

	            try {
	                
	                Thread.sleep(50);
	            } catch (InterruptedException ex) {
	                
	                 Logger.getLogger(SimpleObj.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	}
	
	class HitTestAdapter extends MouseAdapter implements Runnable {

private RectRunnable rectAnimator;
private Thread ellipseAnimator;

@Override
public void mousePressed(MouseEvent e) {
    
    int x = e.getX();
    int y = e.getY();

    if (rect.contains(x, y)) {

        rectAnimator = new RectRunnable();
    }

    if (ellipse.contains(x, y)) {

        ellipseAnimator = new Thread(this);
        ellipseAnimator.start();
    }
}

@Override
public void run() {

    while (alfa_ellipse >= 0) {

        repaint();
        alfa_ellipse += -0.01f;

        if (alfa_ellipse < 0) {

            alfa_ellipse = 0;
        }

        try {
            
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            
            Logger.getLogger(SimpleObj.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
}




}
