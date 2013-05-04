package com.heuristicalda.tuxtwowayroad.graphics.implementations;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.heuristicalda.tuxtwowayroad.graphics.interfaces.Drawable;
/**
 * A class aggregated to the main Graphics Engine implementation to enhance the principle of segragation of functions,
 * this class deals with the management of the writing in the screen the Drawable elements available. 
 * @author nlauchande
 *
 */
class DrawPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3115027118603494997L;
	ArrayList<Drawable> drawableElements = new ArrayList<Drawable>() ;
	private Drawable background;
	final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	HashMap<String,Image> imageCache = new HashMap();
	
	
	public  DrawPanel(Drawable background)
	{
//		setBackground(Color.BLACK);
        setDoubleBuffered(true);
        this.background = background;
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //Draw Background
        g2d.drawImage(getImage( background.getImageSrc() ), 0, 0,screenSize.width,screenSize.height,null);
        //g2d.drawImage(getImage( background.getImageSrc() ), 0, 0,screenSize.width,screenSize.height,null);
        
        //Draw the game sprites
        for (Drawable drawable:drawableElements)
        {
        	g2d.drawImage(getImage(drawable.getImageSrc()) , drawable.getCoordinateX(),drawable.getCoordinateY(),null);
        }
        //Clear the sprites elements 
        drawableElements.clear();
    }
   
    //Get an image and uses a cache for the image resources already read from disk
    private Image getImage(String resource)
    {
    	Image imageResult = imageCache.get(resource);
    	
    	if (imageResult==null)
    	{
	    	 System.out.println(resource);
	    	 byte[] buffer = new byte[200000];
	    	 InputStream imageStream = getClass().getClassLoader().getResourceAsStream(resource);
	    	 try {
				imageStream.read(buffer, 0, 200000);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	 ImageIcon placeHolder = new ImageIcon(buffer);
	    	 imageResult = placeHolder.getImage();
	    	 if (imageResult!=null)
	    	 {
	    		 imageCache.put(resource, imageResult);
	    	 }
    	}
    	
    	 return imageResult;
    	
    }
    
    protected void addDrawable(Drawable drawable)
    {
    	drawableElements.add(drawable);
    }

	protected void addDrawableList(ArrayList<Drawable> listDrawableElements) {
		drawableElements = listDrawableElements;
	}
}
