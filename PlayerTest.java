import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest{

	@Test
	public void testSetNorth() {
		Room troom = new Room("test", "test");
		Room nroom = new Room("n", "n");
		troom.setNorth(nroom, "test");
		assertEquals(troom.north, nroom);
		assertEquals(troom.nDoor, "test");
	}

}