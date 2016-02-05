import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class CoffeeTest{

	@Test
	public void testSetNorth() {
		Room troom = new Room("test", "test");
		Room nroom = new Room("n", "n");
		troom.setNorth(nroom);
		assertEquals(troom.north, nroom);
	}

	@Test
	public void testSetSouth() {
		Room troom = new Room("test", "test");
		Room sroom = new Room("s", "s");
		troom.setSouth(sroom);
		assertEquals(troom.south, sroom);
	}

	@Test
	public void testToString() {
		Room troom = new Room("test", "test");
		String expectedStr = "The room is test.\nIt has a test.";
		assertEquals(troom.toString(), expectedStr);
	}
	@Test
	public void testToStringN() {
		Room troom = new Room("test", "test");
		Room nroom = new Room("n", "n");
		troom.north = nroom;
		String expectedStr = "The room is test.\nIt has a test.";
		fail("Not yet implemented");
	}
	@Test
	public void testToStringS() {
		fail("Not yet implemented");
	}
	@Test
	public void testToStringNS() {
		fail("Not yet implemented");
	}

}