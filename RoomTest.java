import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest{

	/*
	 * Tests to make sure that the setNorth mutator method mutates the object correctly.
	 * Creates two room objects and then uses setNorth to assign the second room to the
	 * first room's 'north' variable. Also tests that the adjective for the north
	 * door is set properly; an adjective for the door must be set when setNorth is
	 * called.
	 */
	@Test
	public void testSetNorth() {
		Room troom = new Room("test", "test");
		Room nroom = new Room("n", "n");
		troom.setNorth(nroom, "test");
		assertEquals(troom.north, nroom);
		assertEquals(troom.nDoor, "test");
	}

	/*
	 * Tests to make sure that the setSouth mutator method mutates the object correctly.
	 * Creates two room objects and then uses setSouth to assign the second room to the
	 * first room's 'south' variable. Also tests that the adjective for the south
	 * door is set properly; an adjective for the door must be set when setSouth is
	 * called.
	 */
	@Test
	public void testSetSouth() {
		Room troom = new Room("test", "test");
		Room sroom = new Room("s", "s");
		troom.setSouth(sroom, "test");
		assertEquals(troom.south, sroom);
		assertEquals(troom.sDoor, "test");
	}

	/*
	 * Tests to make sure the toString method behaves as expected. This test
	 * tests the method when no doors exist for the room. It should return
	 * a string that describes the room and an object in the room.
	 */
	@Test
	public void testToString() {
		Room troom = new Room("test", "test");
		String expectedStr = "You see a test room.\nIt has a test.\n";
		assertEquals(troom.toString(), expectedStr);
	}
	
	/*
	 * Tests to make sure the toString method behaves as expected. This test
	 * tests the method when a northern door exists for the room. It should return
	 * a string that describes the room and an object in the room, as well as
	 * the fact that a door leading North exists, with an adjective for the door present.
	 */
	@Test
	public void testToStringN() {
		Room troom = new Room("test", "test");
		Room nroom = new Room("n", "n");
		troom.north = nroom;
		troom.nDoor = "test";
		String expectedStr = "You see a test room.\nIt has a test.\nThe room has a test door leading North.\n";
		assertEquals(troom.toString(), expectedStr);
	}
	
	/*
	 * Tests to make sure the toString method behaves as expected. This test
	 * tests the method when a southern door exists for the room. It should return
	 * a string that describes the room and an object in the room, as well as
	 * the fact that a door leading South exists, with an adjective for the door present.
	 */
	@Test
	public void testToStringS() {
		Room troom = new Room("test", "test");
		Room sroom = new Room("s", "s");
		troom.south = sroom;
		troom.sDoor = "test";
		String expectedStr = "You see a test room.\nIt has a test.\nThe room has a test door leading South.\n";
		assertEquals(troom.toString(), expectedStr);
	}
	
	/*
	 * Tests to make sure the toString method behaves as expected. This test
	 * tests the method when a southern door and a northern door exist for the room. It should return
	 * a string that describes the room and an object in the room, as well as
	 * the fact that doors leading North and South exist, with adjectives for the doors present.
	 */
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