package com.heuristicalda.tuxtwowayroad.graphics.interfaces;

import java.util.ArrayList;

/**
 * Main interface that defines how Graphics library sould be implemented to be compatible with 
 * the game control unit. Allows the Graphics library to hook a listener to key events implemented
 * by GraphicsKeyEvent listener.
 *  
 * @author nlauchande
 *
 */
public interface GraphicsEngineInterface {

	/**
	 * Method to set a keyEventListener to the graphics library a GameControl unit is expected
	 * to be listening to the key events.
	 * @param keyEventListener
	 */
	void setGraphicsKeyEventListener(GraphicsKeyEventListener keyEventListener);

	
	/**
	 * The interaction of drawing an object that implements the drawable interface. 
	 * @param drawableObject
	 */
	void draw(Drawable drawableObject);

	/**
	 * Get the width of the screen  implemented by the graphics library.
	 * @return
	 */
	public int  getWidth();
	
	/**
	 * The the height of the screen implemented by the graphics library.
	 * @return
	 */
	public int getHeight();
	
	/**
	 * Initialize the user interface.
	 * @param background
	 */
	public void initUi(Drawable background);
	
	/**
	 * Executes a refresh of the screen based on the new drawable elements available.
	 */
	public void executeRepaint();

	/**
	 * Provides the graphics library with a list of drawable elements to be rendered on the screen.
	 * @param listDrawableElements
	 */
	public void draw(ArrayList<Drawable> listDrawableElements);

}
