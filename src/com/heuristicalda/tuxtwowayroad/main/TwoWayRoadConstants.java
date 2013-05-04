package com.heuristicalda.tuxtwowayroad.main;

import java.io.File;
import java.io.IOException;
/**
 * Class with important constants, has the rule of a configuration element. In the future versions
 * should be refactored for a more kind of a more structured run time configuration.
 * @author nlauchande
 *
 */
public class TwoWayRoadConstants {

	//PLAYER CONSTANTS
	public static int PLAYER_VERTICAL_MOVE_DEFAULT = 3;
	public static int PLAYER_HORIZONTAL_MOVE_DEFAULT = 3;

	//GOAL SHAPE AREA
	public static int DEFAULT_GOALSHAPE_INITIAL_POSITION_X = 0;
	public static int DEFAULT_GOALSHAPE_INITIAL_POSITION_Y = 0;
	public static int HEIGHT = 200;
	public static int GOAL_RATIO = 4;
	
	//BOARD CONSTANTS
	public static int UPDATE_RATE = 1000/24; //More or less 24 frames per second
	public static int DEFAULT_BOARD_INITIAL_POSITION_X = 0;
	public static int DEFAULT_BOARD_INITIAL_POSITION_Y = 0;
	
	//IMAGES RESOURCES
	//public final static String OS_PATH_SEPARATOR =  System.getProperty("file.separator") ;
	//public final static String BASE_DIRECTORY=GetCanonicalPath();
	public final static String OS_PATH_SEPARATOR =  "";
	public final static String BASE_DIRECTORY="";
	
	public final static String RESOURCES_FOLDER="";

	//BACKGROUND RELATED FILES
	public static String BACKGROUND_FILE_NAME = "background2.png";
	//public static String BACKGROUND_FILE_PATH = BASE_DIRECTORY+OS_PATH_SEPARATOR+ BACKGROUND_FILE_NAME;
	public static String BACKGROUND_FILE_PATH =RESOURCES_FOLDER+ BACKGROUND_FILE_NAME;

	//GAME OVER 
	public static String GAMEOVER_FILE_PATH = "game_over.png";
	public static int  GAMEOVER_DELAY = 5000;
	
	//PLAYER CONSTANTS
	public static String PLAYER_FILE_NAME = "player.png";
	public static String PLAYER_FILE_PATH = PLAYER_FILE_NAME;
	public static int DEFAULT_PLAYER_INITIAL_POSITION_X = 600;
	public static int DEFAULT_PLAYER_INITIAL_POSITION_Y = 600;
	public static int PLAYER_COLLISION_CRITERIA_DISTANCE = 70;
	public static int PLAYER_FILE_HEIGHT = 58;
	public static int PLAYER_FILE_WIDTH = 60;
	
	//GAME CANVAS CONSTANTS
	public static int GAME_CANVAS_WIDTH = 1024;
	public static int GAME_CANVAS_HEIGHT = 768;
	
	public static String GAME_TILE = "tux2way - Run tux, Run";
	
	//CAR CONSTANTS
	public static int CAR_HORIZONTAL_MOVE_DEFAULT = 4;//SPEED	
	public static String BLUE_CAR_FILE_PATH =getResourcesAbsolutePath("blue_car.png");
	public static String YELLOW_CAR_FILE_PATH =getResourcesAbsolutePath("yellow_car.png") ;
	public static String RED_CAR_FILE_PATH =getResourcesAbsolutePath("red_car.png") ;
	public static String WINDOWS_CAR_FILE_PATH =getResourcesAbsolutePath("windows_car.png") ;
	
	public static int CAR_DEFAULT_WIDTH = 150 ;
	public static int CAR_DEFAULT_HEIGHT = 100 ;
	public static double PROBABILITY_GENERATE_CAR = 0.030;
	public static int INITIAL_LEFT_CAR_POSITION_X = 0 ;
	public static int INITIAL_LEFT_CAR_POSITION_Y = 280 ;
	public static int INITIAL_RIGHT_CAR_POSITION_X = 1266 ;
	public static int INITIAL_RIGHT_CAR_POSITION_Y = 400 ;
	
	public static int MINIMUM_COLLISION_DISTANCE = 5;

	
	public static String getResourcesAbsolutePath(String relativePath)
	{
		return relativePath;
	}
	public static String GetCanonicalPath()
	{
		try {
			return (new File(".").getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	private TwoWayRoadConstants()
	{}
}
