package com.heuristicalda.tuxtwowayroad.shapes;

import java.util.ArrayList;
import java.util.Iterator;

import com.heuristicalda.tuxtwowayroad.main.TwoWayRoadConstants;
import com.heuristicalda.tuxtwowayroad.shapes.Car.CarType;
import com.heuristicalda.tuxtwowayroad.shapes.Car.Direction;

/**
 * The manager of all tasks related with cars and the concept of lanes. From generating randomically to 
 * eliminating when the cross the boundaries of the screen.
 * @author nlauchande
 *
 */
public class CarCollection  {

	ArrayList<Car> carList = new ArrayList<Car>();
	
	private Car lastLeftToRightGeneratedCar = null;
	private Car lastRightToLeftGeneratedCar = null;

	private final Position initialLeftCarPosition ;
	private final Position initialRightCarPosition ;
	
	public CarCollection(Position initialLeftCarPosition,Position initialRightCarPosition)
	{
		this.initialLeftCarPosition = initialLeftCarPosition; // Given from board it needs information about the sizes 
		this.initialRightCarPosition = initialRightCarPosition; // Given from the board it needs information about thesizes
		initialize();
	}
	
	public void initialize()
	{
		carList = new ArrayList<Car>();
		lastLeftToRightGeneratedCar = new Car(CarType.EMPTY_CAR);
		lastRightToLeftGeneratedCar = new Car(CarType.EMPTY_CAR);
	}
	
	public void update() {
		updateCars();
		addRandomGeneratedNewCars();
	}
	
	private void updateCars()
	{
		if (carList!=null)
		{
			for (Car car:carList)
			{
				car.update();
			}
		}
	}
	
	
	
	private void addRandomGeneratedNewCars()
	{
		// generate random left to right car
		Car currentGeneratedLeftCar = generateRandomCar(Direction.LEFT_TO_RIGHT);
		if (isPossibleToAddCarToLane( lastLeftToRightGeneratedCar , currentGeneratedLeftCar))
		{
			carList.add(currentGeneratedLeftCar);
			lastLeftToRightGeneratedCar  = currentGeneratedLeftCar;
		}
		
		// generate random right to left 
		Car currentGeneratedRightCar = generateRandomCar(Direction.RIGHT_TO_LEFT);
		if (isPossibleToAddCarToLane(lastRightToLeftGeneratedCar , currentGeneratedRightCar))
		{
			carList.add(currentGeneratedRightCar);
			lastRightToLeftGeneratedCar  = currentGeneratedRightCar;
		}
	}
	
	private boolean isPossibleToAddCarToLane(Car lastCarInLane,Car candidateCarToLane)
	{
		if (candidateCarToLane!=null)
		{
			if ( lastCarInLane.getCarType()!= CarType.EMPTY_CAR)
			{
				if (lastCarInLane.aproximateIntegerDistance(candidateCarToLane)>TwoWayRoadConstants.CAR_DEFAULT_WIDTH * 2)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return true;
			}
		}
		return false;

	}
	
	//This is the core method that in each run generates a random car in the system
	//In the initial line
	private Car generateRandomCar(Direction direction)
	{
		Car newCar = null;
		Double random = Math.random();
		if (random < TwoWayRoadConstants.PROBABILITY_GENERATE_CAR )
		{
			if (direction == Direction.LEFT_TO_RIGHT)
			{
				return new Car(new Position(this.initialLeftCarPosition.getX(),this.initialLeftCarPosition.getY()),direction,getRandomCarType() );
			}
			else
			{
				return new Car(new Position(this.initialRightCarPosition.getX(),this.initialRightCarPosition.getY()),direction,getRandomCarType());
			}
		}
		return newCar;
	}
	
	private CarType getRandomCarType()
	{
		CarType[] carTypeArray = CarType.values();
		CarType result =CarType.EMPTY_CAR;
		
		while (result==CarType.EMPTY_CAR)
		{
			int randomIndex = (int) (Math.random()*(carTypeArray.length-1));
			result = carTypeArray[randomIndex];
		}
		return result;
	}


	public ArrayList<Car> getCarCollection() {
		// TODO Auto-generated method stub
		return this.carList;
	}

	public boolean isColliding(Shape shape) {
		Iterator<Car> iterator = carList.iterator();
		Car currentCar= null;
		while (iterator.hasNext())
		{
			currentCar = iterator.next();
			if (currentCar.aproximateIntegerDistance(shape) <= TwoWayRoadConstants.PLAYER_COLLISION_CRITERIA_DISTANCE )
			{
				return true;
			}
		}
		
		return false;
	}
	
}
