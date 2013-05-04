package com.heuristicalda.tuxtwowayroad.main;

import com.heuristicalda.tuxtwowayroad.graphics.implementations.GameEngineGraphicsImpl;

/**
 * The game entry point , it serves simples to initialize the GameControl and initialize to concrete 
 * implementation of the Graphics library. 
 * @author nlauchande
 *
 */
public class Main {
	
	public static void main(String[] args)
	{
		GameEngineGraphicsImpl gameEngine = new GameEngineGraphicsImpl( );
		GameControl gameControl = new GameControl(gameEngine);
		gameControl.gameLoop();
	}
	
}
