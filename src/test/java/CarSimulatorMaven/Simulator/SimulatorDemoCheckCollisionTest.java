package CarSimulatorMaven.Simulator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gic.simulator.Car;
import com.gic.simulator.SimulatorDemoCheckCollision;

public class SimulatorDemoCheckCollisionTest {
	
	SimulatorDemoCheckCollision simulatorDemoCheckCollision = new SimulatorDemoCheckCollision();
	Car[] carArray = new Car[2];
	
	@BeforeEach
	public  void initialize() {
		Car car1= new Car();
		int[] endpoint = {10,10};
		car1.setEndPoint(endpoint);
		int[] startPos = {1,2};
		car1.setStartPos(startPos);
		car1.setDirection('N');
		car1.setCommands("FFRFFFFRRL");
		car1.setName("A");
		
		Car car2= new Car();
//		int[] endpoint = {10,10};
		car2.setEndPoint(endpoint.clone());
		int[] startPos1 = {7,8};
		car2.setStartPos(startPos1);
		car2.setDirection('W');
		car2.setCommands("FFLFFFFFFF");
		car2.setName("B");
		carArray[0] = car1;
		carArray[1] = car2;
		
	}
	
	@Test
	public void testSimulatorCollision() {
		
		for(Car car:carArray) {
			simulatorDemoCheckCollision.executeCommands(car);
		}
		boolean collision = simulatorDemoCheckCollision.checkCollision(carArray);
		assertEquals(true, collision);
	}

}
