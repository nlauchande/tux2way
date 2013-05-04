package com.heuristicalda.tuxtwowayroad.shapes;
/**
 * A utility micro class to handle positioning information.
 * @author nlauchande
 *
 */
public class Position {
	private int x;
	private int y;
	
	public Position(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public void setPosition(int x,int y)
	{
		this.x=x;
		this.y=y;
	}

	protected void incX(int value)
	{
		this.x += value ;
	}
	
	protected void incY(int value)
	{
		this.y += value ;
	}

	protected void decX(int value)
	{
		this.x -= value ;
	}
	
	protected void decY(int value)
	{
		this.y -= value ;
	}

	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
}
