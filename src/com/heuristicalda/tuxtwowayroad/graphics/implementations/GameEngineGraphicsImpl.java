package com.heuristicalda.tuxtwowayroad.graphics.implementations;
import javax.swing.*;

import com.heuristicalda.tuxtwowayroad.graphics.interfaces.Drawable;
import com.heuristicalda.tuxtwowayroad.graphics.interfaces.GraphicsEngineInterface;
import com.heuristicalda.tuxtwowayroad.graphics.interfaces.GraphicsKeyEventListener;
import com.heuristicalda.tuxtwowayroad.main.TwoWayRoadConstants;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * This class implements the graphic Engine Interface based on java Swing graphics infrastructure 
 * and Java2D drawing library.
 * @author nlauchande
 *
 */
public class GameEngineGraphicsImpl extends JFrame implements GraphicsEngineInterface{

	private static final long serialVersionUID = 1673931896909920997L;
	GraphicsKeyEventListener keyEventListener;
	ArrayList<JLabel> listSprites = new ArrayList<JLabel>();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	DrawPanel dpnl;

	public GameEngineGraphicsImpl() {
	}
	
	public void initUi(Drawable background)
	{
			dpnl  = new DrawPanel(background);
	        setTitle("Points");
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setUndecorated(true);
			setBounds(0,0,screenSize.width, screenSize.height);
			System.out.println(screenSize.width+","+screenSize.height);
		    System.out.println(TwoWayRoadConstants.BACKGROUND_FILE_PATH);
			setTitle(TwoWayRoadConstants.GAME_TILE);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			addCurrentKeyListener();
			setExtendedState(MAXIMIZED_BOTH);
			setVisible(true);
	        add(dpnl);
	
	}
	
	private void addCurrentKeyListener()
	{
	      addKeyListener(new KeyAdapter() {
	          @Override
	          public void keyTyped(KeyEvent e) {
	             myKeyEvt(e, "keyTyped");
	          }

	          @Override
	          public void keyReleased(KeyEvent e) {
	             myKeyEvt(e, "keyReleased");
	          }

	          @Override
	          public void keyPressed(KeyEvent e) {
	             myKeyEvt(e, "keyPressed");
	          }

	          private void myKeyEvt(KeyEvent e, String text) {
	             int key = e.getKeyCode();

	             if (key == KeyEvent.VK_KP_LEFT || key == KeyEvent.VK_LEFT)
	             {
	            	 keyEventListener.keyLeft();
	             }
	             else if (key == KeyEvent.VK_KP_RIGHT || key == KeyEvent.VK_RIGHT)
	             {
	            	 keyEventListener.keyRight();
	             }
	             else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_KP_UP)
	             {
	            	 keyEventListener.keyUp();
	             }
	             else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_KP_DOWN)
	             {
	            	 keyEventListener.keyDown();
	             }
	          }
	       });
	}
	

	@Override
	public void setGraphicsKeyEventListener(
			GraphicsKeyEventListener keyEventListener) {
		this.keyEventListener = keyEventListener;
	}

	public int  getWidth()
	{
		return (int) Math.round(screenSize.getWidth());
	}
	
	public int getHeight()
	{
		return (int) Math.round(screenSize.getHeight());
	}

		
	public void executeRepaint()
	{
		dpnl.repaint();
	}

	@Override
	public void draw(Drawable drawableObject) {
		dpnl.addDrawable(drawableObject);
	}

	@Override
	public void draw(ArrayList<Drawable> listDrawableElements) {
		dpnl.addDrawableList(listDrawableElements);
	}
	
	public int getScreenWidth()
	{
		return screenSize.width;
	}
	
	public int getScreenHeight()
	{
		return screenSize.height;
	}
	
}