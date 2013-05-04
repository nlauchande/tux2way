package com.heuristicalda.tuxtwowayroad.shapes;

import java.util.ArrayList;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import com.heuristicalda.tuxtwowayroad.graphics.interfaces.Drawable;
import com.heuristicalda.tuxtwowayroad.graphics.interfaces.GraphicsEngineInterface;
import com.heuristicalda.tuxtwowayroad.main.TwoWayRoadConstants;
/**
 * Class that actively keeps the state of all the Drawable objects(Cars, Player) in the game maintaining
 * the physical constraint and the game loop state/world. It is instantiated and its methods are called
 * exclusively by the game control.  
 * @author nlauchande
 *
 */
public class Board {

	CarCollection carCollection;
	Player player;
	final Shape goalShapeArea;
	Position initialPosition;
	RectangularDimension dimension;
	String imageResource;
	GraphicsEngineInterface graphicsEngineInterface;
	Boolean gameOverStatus = false;
	
	public Board(Position initialPosition, String imageResource,
			RectangularDimension dimension,Shape goalShapeArea,GraphicsEngineInterface graphicsEngineInterface) {
		this.initialPosition = initialPosition;
		this.imageResource = imageResource;
		this.dimension = dimension;
		this.goalShapeArea = goalShapeArea;

		this.player = new Player(new Position(TwoWayRoadConstants.DEFAULT_PLAYER_INITIAL_POSITION_X,TwoWayRoadConstants.DEFAULT_PLAYER_INITIAL_POSITION_Y), 
											  TwoWayRoadConstants.PLAYER_FILE_PATH,
											  new RectangularDimension(TwoWayRoadConstants.PLAYER_FILE_HEIGHT,TwoWayRoadConstants.PLAYER_FILE_WIDTH));
		this.carCollection = new CarCollection(new Position(TwoWayRoadConstants.INITIAL_LEFT_CAR_POSITION_X,TwoWayRoadConstants.INITIAL_LEFT_CAR_POSITION_Y ),
																	  new Position(TwoWayRoadConstants.INITIAL_RIGHT_CAR_POSITION_X,TwoWayRoadConstants.INITIAL_RIGHT_CAR_POSITION_Y ));
	}

	public void init()
	{
		gameOverStatus = false;
		carCollection.initialize();
		player.setCurrentPosition(TwoWayRoadConstants.DEFAULT_PLAYER_INITIAL_POSITION_X,TwoWayRoadConstants.DEFAULT_PLAYER_INITIAL_POSITION_Y);
	}
	
	public void update()
	{
		System.out.println("Updating board : "+new Date());
		carCollection.update();
		if (carCollection.isColliding(player))
		{
			gameOverStatus = true;
		}
		else if ( hasPlayerReachedGoal()  )
		{
			resetBoard();
		}
	}
	


	/**
	 * The initial goas was to use goal shape area, but given the game mechanics was
	 * easy to consider if the player has completely crossed upper lane that can
	 * be considered as the initial position in the constant  TwoWayRoadConstants.INITIAL_LEFT_CAR_POSITION_Y
	 * @return
	 */
	private boolean hasPlayerReachedGoal()
	{
		boolean result = false;
		if (player.getCoordinateY() < TwoWayRoadConstants.INITIAL_LEFT_CAR_POSITION_Y - TwoWayRoadConstants.PLAYER_FILE_HEIGHT)
		{
			return true;
		}
		return result;
	}
	
	public boolean isGameOverStatus()
	{
		return gameOverStatus;
	}

	public void resetBoard()
	{
		init();
	}
	
	public void executePlayerMoveCommand(Player.Commands command)
	{
		player.executeCommand(command);
	}
	
	public void draw(GraphicsEngineInterface graphicsInterface)
	{
		System.out.println(player.currentPosition.getX()+" "+player.currentPosition.getY());
		graphicsInterface.draw(player);
	}
	
	public ArrayList<Drawable> getListDrawableElements()
	{
		ArrayList<Drawable> drawableList = new ArrayList<Drawable>();
		drawableList.add(player);
		
		ArrayList<Car>  carCollectionList = carCollection.getCarCollection();
		
		for (Car car: carCollectionList )
		{
			drawableList.add(car);
			
		}
		return drawableList;
	}

}
