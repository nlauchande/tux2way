package com.heuristicalda.tuxtwowayroad.shapes;

import com.heuristicalda.tuxtwowayroad.graphics.interfaces.Drawable;
/**
 * A base class that controls and has all the information needed to keep to state of an unitary game 
 * element and implements an interface that is able to be callable by the implemented Graphics Library,
 * in addition this class implements also a method to find a straight line distant that can be further
 * used for elementar collision detection.
 * @author nlauchande
 *
 */
 public class Shape implements Drawable{
	
	protected String imageResource;
	private final Position initialPosition;
	protected Position currentPosition;
	
	public Shape(Position initialPosition,String imageResource)
	{
		this.initialPosition = initialPosition;
		this.imageResource = imageResource;
		this.currentPosition = this.initialPosition;
	}

	

	protected void setCurrentPosition(Position newPosition)
	{
		this.currentPosition = newPosition;
	}
	
	protected void setCurrentPosition(int x,int y)
	{
		this.currentPosition = new Position(x, y);
	}
	
	
		
	public int aproximateIntegerDistance(Shape other) {
        

		int squareHorizontalDistance = Math.abs( this.getCoordinateX() - other.getCoordinateX() ) ;
		squareHorizontalDistance = squareHorizontalDistance*squareHorizontalDistance; 
		
		
		int squareVerticalDistance = Math.abs(    (this.getCoordinateY() - other.getCoordinateY()) )  ;
		squareVerticalDistance = squareVerticalDistance *squareVerticalDistance ;
		
		
		int result = (int)
        	Math.round( Math.sqrt( squareHorizontalDistance + squareVerticalDistance  ) );
        
        return result;
        
	}

	@Override
	public String getImageSrc() {
		return this.imageResource;
	}

	@Override
	public int getCoordinateX() {
		return currentPosition.getX();
	}

	@Override
	public int getCoordinateY() {
		return currentPosition.getY();
	}

}
