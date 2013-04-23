package com.heuristicalda.tuxtwowayroad.main;

import com.heuristicalda.tuxtwowayroad.graphics.interfaces.GraphicsEngineInterface;
import com.heuristicalda.tuxtwowayroad.shapes.Board;


/**
 * This class coordinate the game mechanics mainly the game loop.
 * @author nlauchande
 *
 */
public class GameControl {

	private GraphicsEngineInterface graphicsEngineInterface;
	private Board board;
	
	public GameControl(GraphicsEngineInterface graphicsEngineImpl,Board board)
	{
		this.graphicsEngineInterface = graphicsEngineImpl;
		this.board = board;
	}
	
	
	
	
}
