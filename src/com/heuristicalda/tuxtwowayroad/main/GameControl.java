package com.heuristicalda.tuxtwowayroad.main;

import com.heuristicalda.tuxtwowayroad.graphics.interfaces.GraphicsEngineInterface;
import com.heuristicalda.tuxtwowayroad.shapes.Board;
import com.heuristicalda.tuxtwowayroad.shapes.Player;
import com.heuristicalda.tuxtwowayroad.shapes.Position;
import com.heuristicalda.tuxtwowayroad.shapes.Shape;
import com.heuristicalda.tuxtwowayroad.graphics.interfaces.*;

/**
 * This class coordinate the game loop and initializes main objects needed to ensure the game operation.
 * The game state represented by the board and accesses a generic graphics library interface to give orders 
 * for redering the current game state.
 * @author nlauchande
 */
public class GameControl implements GraphicsKeyEventListener {

	private GraphicsEngineInterface graphicsEngineInterface;
	private Board board;
	private Shape background;
	
	public GameControl(GraphicsEngineInterface graphicsEngineImpl)
	{
		background = new Shape(new Position(0,0), TwoWayRoadConstants.BACKGROUND_FILE_PATH);
		this.graphicsEngineInterface = graphicsEngineImpl;
		this.graphicsEngineInterface.setGraphicsKeyEventListener(this);
		this.graphicsEngineInterface.initUi(background);
		Shape goalShapeArea = generateGoalShapeArea();
		this.board = new Board(new Position(0,0),null,null ,goalShapeArea,graphicsEngineInterface);
	}
	
	public Shape generateGoalShapeArea()
	{
		Shape goalShapeArea = new Shape(new Position(TwoWayRoadConstants.DEFAULT_GOALSHAPE_INITIAL_POSITION_X,
				TwoWayRoadConstants.DEFAULT_GOALSHAPE_INITIAL_POSITION_Y),null);
		return goalShapeArea;
	}
	
	public Shape generateGameOverShape()
	{
		Shape gameOverShape = new Shape(new Position(TwoWayRoadConstants.DEFAULT_PLAYER_INITIAL_POSITION_X-200,
				0),TwoWayRoadConstants.GAMEOVER_FILE_PATH );
		return gameOverShape;
	}
	
	
	public  void gameLoop()
	{
		
		int threadTimer = TwoWayRoadConstants.UPDATE_RATE; 
		//In principle the end of the game is defined by an exit interface
		while (true)
		{
			if (this.board.isGameOverStatus())
			{
				board.resetBoard();
			}
			
			threadTimer = TwoWayRoadConstants.UPDATE_RATE;
			this.board.update();
			
			if (!this.board.isGameOverStatus())
			{
				graphicsEngineInterface.draw(this.board.getListDrawableElements());
			}
			else{
				graphicsEngineInterface.draw(generateGameOverShape());
				threadTimer = TwoWayRoadConstants.GAMEOVER_DELAY;
			}

			graphicsEngineInterface.executeRepaint();
			try {
				Thread.sleep(threadTimer);
			} catch (InterruptedException e) {
				System.out.println("ERROR IN THE TREAD");
			}
			
		}
		
	}
	

	@Override
	public void keyLeft() {
		board.executePlayerMoveCommand(Player.Commands.MOVE_LEFT);
	}

	@Override
	public void keyRight() {
		board.executePlayerMoveCommand(Player.Commands.MOVE_RIGHT);
	}

	@Override
	public void keyUp() {
		board.executePlayerMoveCommand(Player.Commands.MOVE_UP);
	}

	@Override
	public void keyDown() {
		board.executePlayerMoveCommand(Player.Commands.MOVE_DOWN);
	}
	
}
