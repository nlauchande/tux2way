package com.heuristicalda.tuxtwowayroad.shapes;



import com.heuristicalda.tuxtwowayroad.main.TwoWayRoadConstants;
import com.heuristicalda.tuxtwowayroad.shapes.Shape;
/**
 *  A class that extends Shape and is able to to hold th  state of a car in addition to it's direction and type. 
 *   @author nlauchande
 */
public class Car extends Shape {

	enum Direction{LEFT_TO_RIGHT,RIGHT_TO_LEFT};

	enum CarType{
			BLUE_CAR,
			RED_CAR,
			YELLOW_CAR,WINDOWS_CAR,EMPTY_CAR;
	} ;
	
	private CarType carType;
	
	private Direction direction;
	
	//Basically for the creation of the EMPTY OBJECT
	public Car(CarType carType)
	{
		super(new Position(-1,-1),
				  getCarImageSource(carType));
		this.carType = carType;
	}
	
	public Car(Position initialPosition,Direction direction,CarType carType)
	{
		super(initialPosition,
			  getCarImageSource(carType));
		this.direction = direction;
		this.carType = carType;
	}
	
	public void setCar(Car car)
	{
		this.currentPosition = new Position(car.getCoordinateX(),car.getCoordinateY());
		this.imageResource = car.getImageSrc();
		this.direction = car.direction;
		this.carType = car.carType;
	}
	
	public Car(Car car)
	{
		super(car.currentPosition,
				  car.getImageSrc());
		this.direction = car.getDirection();
		this.carType = car.getCarType();
	}

	public Direction getDirection()
	{
		return direction;
	}
	
	private static String getCarImageSource(CarType carType)
	{
		if (carType == CarType.BLUE_CAR){
			return TwoWayRoadConstants.BLUE_CAR_FILE_PATH;
		}
		else if (carType == CarType.RED_CAR)
		{
			return TwoWayRoadConstants.RED_CAR_FILE_PATH;
		}
		else if (carType == CarType.YELLOW_CAR)
		{
			return TwoWayRoadConstants.YELLOW_CAR_FILE_PATH;
		}
		else if (carType == CarType.WINDOWS_CAR)
		{
			return TwoWayRoadConstants.WINDOWS_CAR_FILE_PATH;
		}
		
		return null;
		
	}
	
	public Car(Position initialPosition, String imageResource,
			RectangularDimension dimension,Car.Direction direction) {
		super(initialPosition, imageResource);
		this.direction = direction;
	}
	
	public void update()
	{
		if (direction == Direction.LEFT_TO_RIGHT)
		{
			this.currentPosition.incX(TwoWayRoadConstants.CAR_HORIZONTAL_MOVE_DEFAULT);
		}
		else if (direction == Direction.RIGHT_TO_LEFT)
		{
			this.currentPosition.decX(TwoWayRoadConstants.CAR_HORIZONTAL_MOVE_DEFAULT);
		}
	}
	
	public CarType getCarType()
	{
		return this.carType;
	}
	
	
	
}
