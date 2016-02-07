import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class CoffeeTest{

	@Test
	public void testSetNorth() {
		Room troom = new Room("test", "test");
		Room nroom = new Room("n", "n");
		troom.setNorth(nroom, "test");
		assertEquals(troom.north, nroom);
		assertEquals(troom.nDoor, "test");
	}

	@Test
	public void testSetSouth() {
		Room troom = new Room("test", "test");
		Room sroom = new Room("s", "s");
		troom.setSouth(sroom, "test");
		assertEquals(troom.south, sroom);
		assertEquals(troom.sDoor, "test");
	}

	@Test
	public void testToString() {
		Room troom = new Room("test", "test");
		String expectedStr = "You see a test room.\nIt has a test.\n";
		assertEquals(troom.toString(), expectedStr);
	}
	@Test
	public void testToStringN() {
		Room troom = new Room("test", "test");
		Room nroom = new Room("n", "n");
		troom.north = nroom;
		troom.nDoor = "test";
		String expectedStr = "You see a test room.\nIt has a test.\nThe room has a test door leading North.\n";
		assertEquals(troom.toString(), expectedStr);
	}
	@Test
	public void testToStringS() {
		Room troom = new Room("test", "test");
		Room sroom = new Room("s", "s");
		troom.south = sroom;
		troom.sDoor = "test";
		String expectedStr = "You see a test room.\nIt has a test.\nThe room has a test door leading South.\n";
		assertEquals(troom.toString(), expectedStr);
	}
	@Test
	public void testToStringNS() {
		Room troom = new Room("test", "test");
		
		Room sroom = new Room("s", "s");
		Room nroom = new Room("n", "n");
		
		troom.south = sroom;
		troom.north = nroom;
		
		troom.sDoor = "test";
		troom.nDoor = "test";
		
		String expectedStr = "You see a test room.\nIt has a test.\nThe room has a test door leading North.\nThe room has a test door leading South.\n";
		assertEquals(troom.toString(), expectedStr);
	}

}