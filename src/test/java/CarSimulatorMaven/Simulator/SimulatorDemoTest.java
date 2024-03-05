package CarSimulatorMaven.Simulator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.gic.simulator.SimulatorDemo;

public class SimulatorDemoTest {
	
	SimulatorDemo simulatorDemo = simulatorDemo = new SimulatorDemo();;

//	@BeforeAll
//	public void initializeClass() {
//		simulatorDemo = new SimulatorDemo();
//	}
	
	@Test
	public void testSimulator() {
		
		int[] endpoint = {10,10};
		int[] startPos = {1,2};
		char direction = 'N';
		String commands = "FFRFFFRRLF";
		
		int[] pos = simulatorDemo.executeCommands(endpoint,startPos,direction,commands);
		assertEquals(4, pos[0]);
		assertEquals(3, pos[1]);
		assertEquals('S', simulatorDemo.finalDirection);
	}
}
