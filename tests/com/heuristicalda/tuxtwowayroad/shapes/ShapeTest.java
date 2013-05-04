package com.heuristicalda.tuxtwowayroad.shapes;

import static org.junit.Assert.*;

import org.junit.Test;

import com.heuristicalda.tuxtwowayroad.shapes.Car.CarType;
import com.heuristicalda.tuxtwowayroad.shapes.Car.Direction;

public class ShapeTest {

	@Test
	public void aproximateIntegerDistanceTest() {
		Car car1;
		Car car2;
		
		//Obvious Case
		car1 = new Car(new Position(0,0), Direction.LEFT_TO_RIGHT, CarType.YELLOW_CAR);
		car2 = new Car(new Position(0,0), Direction.RIGHT_TO_LEFT, CarType.RED_CAR);	
		assertEquals("Test 1[Obvious]: Expected exact result ",0, car1.aproximateIntegerDistance(car2));
		
		//Straight Line as most of the cases
		car1 = new Car(new Position(5,20), Direction.LEFT_TO_RIGHT, CarType.YELLOW_CAR);
		car2 = new Car(new Position(5,20), Direction.RIGHT_TO_LEFT, CarType.RED_CAR);	
		assertEquals("Test 2[Obvious] : Expected exact result ",0, car1.aproximateIntegerDistance(car2));

		//Straight Line as most of the cases
		car1 = new Car(new Position(15,20), Direction.LEFT_TO_RIGHT, CarType.YELLOW_CAR);
		car2 = new Car(new Position(5,20), Direction.RIGHT_TO_LEFT, CarType.RED_CAR);	
		assertEquals("Test 2[Obvious] : Expected exact result ",10, car1.aproximateIntegerDistance(car2));

		
		
	}

}
