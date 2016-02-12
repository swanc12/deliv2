import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest extends Room{
	
	/*
	 * Test to ensure the constructor sets the proper variables. This test
	 * checks the constructor without any arguments passed in.
	 */
	@Test
	public void testConstructorEmpty(){
		Room troom = new Room();
		assertEquals(troom.adjective, null);
		assertEquals(troom.furnishing, null);
		assertEquals(troom.object, null);
		assertEquals(troom.north, null);
		assertEquals(troom.south, null);
		assertEquals(troom.nDoor, null);
	}
	
	/*
	 * Test to ensure the constructor sets the proper variables. This test
	 * checks the constructor with furniture and room adjective.
	 */
	@Test
	public void testConstructorAdjFurn(){
		Room troom = new Room("test", "test");
		assertEquals(troom.adjective, "test");
		assertEquals(troom.furnishing, "test");
		assertEquals(troom.north, null);
		assertEquals(troom.south, null);
		assertEquals(troom.nDoor, null);
		assertEquals(troom.object, null);
	}
	
	/*
	 * Test to ensure the constructor sets the proper variables. This test
	 * checks the constructor with furniture, room adjective and object set.
	 */
	@Test
	public void testConstructorObjAdjFurn(){
		Room troom = new Room("test1", "test2", "test3");
		assertEquals(troom.adjective, "test1");
		assertEquals(troom.furnishing, "test2");
		assertEquals(troom.object, "test3");
		assertEquals(troom.north, null);
		assertEquals(troom.south, null);
		assertEquals(troom.nDoor, null);
	}

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
	 * Test to ensure that setObject actually sets the object variable for a room.
	 * Creates a room and calls setObject, then compares the value in the
	 * room's object variable to what is expected to be there.
	 */
	@Test
	public void testSetObject(){
		Room troom = new Room("test", "test");
		troom.setObject("HelloTest");
		assertEquals(troom.object, "HelloTest");
	}
	
	/*
	 * Test to ensure that getNorth returns the value of a room's north variable.
	 * If a room's north Room object is set it should return that room.
	 */
	@Test
	public void testGetNorth(){
		Room troom = new Room("test", "test");
		Room nroom = new Room("n", "n");
		troom.north = nroom;
		assertEquals(troom.getNorth(), nroom);
	}
	
	/*
	 * Test to ensure that getNorth returns the value of a room's north variable.
	 * If a room's north Room object is set it should return that room.
	 */
	@Test
	public void testGetSouth(){
		Room troom = new Room("test", "test");
		Room sroom = new Room("s", "s");
		troom.south = sroom;
		assertEquals(troom.getSouth(), sroom);
	}
	
	/*
	 * Test to ensure that an object is returned correctly when getObject is
	 * called. Creates a room and adds an object before calling getObject,
	 * which should return whatever the room.object variable it set to.
	 */
	@Test
	public void testGetObject(){
		Room troom = new Room("test", "test");
		troom.object = "Test";
		assertEquals("Test", troom.getObject());
	}
	
	/*
	 * hasObject should return true if the room has an object, and false otherwise. This test
	 * checks to see if it returns true when the room has an object.
	 */
	@Test
	public void testHasObjectTrue(){
		Room troom = new Room("test", "test", "object");
		assertEquals(true, troom.hasObject());
	}
	
	/*
	 * hasObject should return true if the room has an object, and false otherwise. This test
	 * checks to see if it returns false when the room has no object.
	 */
	@Test
	public void testHasObjectFalse(){
		Room troom = new Room("test", "test");
		assertEquals(false, troom.hasObject());
	}
	
	/*
	 * isRoomSouth should return true if a room's south variable is not null.
	 * Test sets a room to another room's north variable, so the method should
	 * return true.
	 */
	@Test
	public void testIsRoomSouthTrue(){
		Room troom = new Room("test", "test");
		Room sroom = new Room("s", "s");
		troom.south = sroom;
		assertEquals(troom.isRoomSouth(), true);
	}
	
	/*
	 * isRoomNorth should return true if a room's north variable is not null.
	 * Test sets a room to another room's north variable, so the method should
	 * return true.
	 */
	@Test
	public void testIsRoomNorthTrue(){
		Room troom = new Room("test", "test");
		Room nroom = new Room("n", "n");
		troom.north = nroom;
		assertEquals(troom.isRoomNorth(), true);
	}
	
	/*
	 * isRoomNorth should return true if a room's south variable is not null.
	 * Test does not set a room for the test room's south variable, so isRoomSouth
	 * should return false.
	 */
	@Test
	public void testIsRoomSouthFalse(){
		Room troom = new Room("test", "test");
		assertEquals(troom.isRoomSouth(), false);
	}
	
	/*
	 * isRoomNorth should return true if a room's north variable is not null.
	 * Test does not set a room for the test room, so isRoomNorth should return false.
	 */
	@Test
	public void testIsRoomNorthFalse(){
		Room troom = new Room("test", "test");
		assertEquals(troom.isRoomNorth(), false);
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