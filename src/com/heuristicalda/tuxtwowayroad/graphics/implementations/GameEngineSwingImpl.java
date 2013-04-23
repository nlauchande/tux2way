package com.heuristicalda.tuxtwowayroad.graphics.implementations;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;

public class GameEngineSwingImpl extends JFrame {

	// The Rat

	JLabel lb;
	JLabel lb2;
	JLabel lb3;

	// Move it randomly!

	Random r;

	public GameEngineSwingImpl(int k) {

		// Set frame properties

		 final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	      setBounds(0,0,screenSize.width, screenSize.height);
		
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
	             System.out.println("TEST");

	             if (key == KeyEvent.VK_KP_LEFT || key == KeyEvent.VK_LEFT)
	             {
	 				lb3.setLocation(lb3.getLocation().x-10,610);

	            	 System.out.println(text + " LEFT");
	                 //Call some function
	             }
	             else if (key == KeyEvent.VK_KP_RIGHT || key == KeyEvent.VK_RIGHT)
	             {
		 				lb3.setLocation(lb3.getLocation().x+10,610);

	            	 System.out.println(text + " RIGHT");
	                 //Call some function
	             }
	          }


	       });

	      
		setTitle("Catch The Rat");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		// Set the background (just for a good look)

		JLabel jLabel =new JLabel(new ImageIcon(ClassLoader.getSystemResource("background.png"))); 
		jLabel.setBounds(0,0,screenSize.width, screenSize.height);
		setContentPane(jLabel);

		// Set layout to the content pane
		getContentPane().setLayout(new FlowLayout());

		// Create the rat
		lb = new JLabel(new ImageIcon(ClassLoader.getSystemResource("blue_car.png")));
		lb2 = new JLabel(new ImageIcon(ClassLoader.getSystemResource("red_car.png")));
		lb3 = new JLabel(new ImageIcon(ClassLoader.getSystemResource("playert.png")));

		// Add the rat

		getContentPane().add(lb);
		getContentPane().add(lb2);
		getContentPane().add(lb3);

		// Create Random object

		r = new Random();

		// Create a timer and call it for every k seconds


		lb.setLocation(0,110);
		lb2.setLocation(0,310);
		lb3.setLocation(0,610);
		
		lb3.setMaximumSize(new Dimension(10, 10));
		lb3.setBounds(0, 610, 0, 0);
		
		new Timer(k, new ActionListener() {

			public void actionPerformed(ActionEvent ae) {

				// Move the rat randomly, subtract 75, so that the rat should
				// not meet the edges

				lb.setLocation(lb.getLocation().x+1,
						110);

				lb2.setLocation(lb2.getLocation().x+1,
						310);

		

				if (lb.location().x>screenSize.width) 
				{
					lb.setLocation(0,110);
					lb2.setLocation(0,310);
				}

			}

		}).start();

		// Add mouselistener, notify when user clicks it!

		lb.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent me) {

				// Create a beep sound when clicked to notify

				Toolkit.getDefaultToolkit().beep();

				// Also print it!

				System.out.println("Caught!");

			}

		});

		// Maximize the frame

		setExtendedState(MAXIMIZED_BOTH);

	}

	public static void main(String args[]) {

		
		// Create Scanner object

		//Scanner s = new Scanner(System.in);

		// Let the user enter his capability of catching the rat!

		System.out.println("Enter the speed");

		// Read the input

		int k = 10;

		// Create the frame and send the value of k

		new GameEngineSwingImpl(k);

	}

}