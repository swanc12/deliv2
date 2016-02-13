/*
 * Test suite for the parseInput method in CoffeeQuest, as it has numerous calls to System.out.
 */

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;

public class CoffeeQuestOutputTest extends CoffeeQuest{
	
	private ByteArrayOutputStream out = new ByteArrayOutputStream();
	
	/*
	 * Setting up System.out for testing. Necessary for testing the parseInput method in CoffeeQuest.
	 */
	@Before
	public void setUp(){
		System.setOut(new PrintStream(out));
	}
	
	/*
	 * Tear down the changes to System.out.
	 */
	@After
	public void tearDown(){
		System.setOut(null);
	}
	
	/*
	 * parseInput is a method that takes the Player's command and provides a response to it. This test
	 * checks the N command to make sure it moves the room to the northern room. It does this by passing
	 * a ByteArrayInputStream into CoffeeQuest to pass in "N" to the scanner, and then by checking that the new room
	 * is equal to the old room's North room.
	 */
	@Test
	public void testParseInputN(){
		Room mockedRoom = Mockito.mock(Room.class);
		Room mockedNorthRoom = Mockito.mock(Room.class);
		Player mockedPlayer = Mockito.mock(Player.class);
		
		when(mockedRoom.isRoomNorth()).thenReturn(true);
		when(mockedRoom.getNorth()).thenReturn(mockedNorthRoom);
		
		CoffeeQuest test = new CoffeeQuest(mockedRoom);
		boolean cont = test.parseInput(mockedPlayer, 'N');
		assertEquals(true, cont);
		assertEquals(mockedNorthRoom, test.currentRoom);
	}
	
	
	/*
	 * parseInput is a method that takes the Player's command and provides a response to it. This test
	 * checks the S command to make sure it moves the room to the southern room by checking that the new room
	 * is equal to the old room's South room.
	 */
	@Test
	public void testParseInputS(){
		Room mockedRoom = Mockito.mock(Room.class);
		Room mockedSouthRoom = Mockito.mock(Room.class);
		Player mockedPlayer = Mockito.mock(Player.class);
		
		when(mockedRoom.isRoomSouth()).thenReturn(true);
		when(mockedRoom.getSouth()).thenReturn(mockedSouthRoom);
		
		CoffeeQuest test = new CoffeeQuest(mockedRoom);
		boolean cont = test.parseInput(mockedPlayer, 'S');
		assertEquals(true, cont);
		assertEquals(mockedSouthRoom, test.currentRoom);
	}
	
	/*
	 * parseInput is a method that takes the Player's command and provides a response to it. This test
	 * checks the I command to make sure that the player's inventory is printed out. It does this using
	 * the ByteArrayOutputStream in the test setUp.
	 */
	@Test
	public void testParseInputI(){
		Player mockedPlayer = Mockito.mock(Player.class);
		when(mockedPlayer.invStr()).thenReturn("Test!1");
		
		CoffeeQuest test = new CoffeeQuest();
		boolean cont = test.parseInput(mockedPlayer, 'I');
		assertEquals(true, cont);
		assertEquals("Test!1", out.toString().trim());
	}
	
	/*
	 * parseInput is a method that takes the Player's command and provides a response to it. This checks
	 * the L command in the case of Cream, to make sure the player is notified that Cream has been picked up.
	 */
	@Test
	public void testParseInputLM(){
		Player mockedPlayer = Mockito.mock(Player.class);
		Room mockedRoom = Mockito.mock(Room.class);
		when(mockedPlayer.look(mockedRoom)).thenReturn('M');
		
		CoffeeQuest test = new CoffeeQuest(mockedRoom);
		boolean cont = test.parseInput(mockedPlayer, 'L');
		assertEquals(true, cont);
		assertEquals("You found Creamy cream!", out.toString().trim());
	}

	/*
	 * parseInput is a method that takes the Player's command and provides a response to it. This checks
	 * the L command in the case of Coffee, to make sure the player is notified that Coffee has been picked up.
	 */
	@Test
	public void testParseInputLC(){
		Player mockedPlayer = Mockito.mock(Player.class);
		Room mockedRoom = Mockito.mock(Room.class);
		when(mockedPlayer.look(mockedRoom)).thenReturn('C');
		
		CoffeeQuest test = new CoffeeQuest(mockedRoom);
		boolean cont = test.parseInput(mockedPlayer, 'L');
		assertEquals(true, cont);
		assertEquals("You found Caffeinated Coffee!", out.toString().trim());
	}

	/*
	 * parseInput is a method that takes the Player's command and provides a response to it. This checks
	 * the L command in the case of Sugar, to make sure the player is notified that Sugar has been picked up.
	 */
	@Test
	public void testParseInputLS(){
		Player mockedPlayer = Mockito.mock(Player.class);
		Room mockedRoom = Mockito.mock(Room.class);
		when(mockedPlayer.look(mockedRoom)).thenReturn('S');
		
		CoffeeQuest test = new CoffeeQuest(mockedRoom);
		boolean cont = test.parseInput(mockedPlayer, 'L');
		assertEquals(true, cont);
		assertEquals("You found Sweet Sugar!", out.toString().trim());
	}

	/*
	 * parseInput is a method that takes the Player's command and provides a response to it. This checks
	 * the L command in the case that nothing is found.
	 */
	@Test
	public void testParseInputLN(){
		Player mockedPlayer = Mockito.mock(Player.class);
		Room mockedRoom = Mockito.mock(Room.class);
		when(mockedPlayer.look(mockedRoom)).thenReturn('X');
		
		CoffeeQuest test = new CoffeeQuest(mockedRoom);
		boolean cont = test.parseInput(mockedPlayer, 'L');
		assertEquals(true, cont);
		assertEquals("You didn't find anything useful...", out.toString().trim());
	}

	/*
	 * parseInput is a method that takes the Player's command and provides a response to it. This test
	 * checks that false is returned when D is input.
	 */
	@Test
	public void testParseInputD(){
		Player mockedPlayer = Mockito.mock(Player.class);
		CoffeeQuest test = new CoffeeQuest();
		assertEquals(false, test.parseInput(mockedPlayer, 'D'));
	}
	
	/*
	 * parseInput is a method that takes the Player's command and provides a response to it. This test
	 * checks that the help message is printed when H is input.
	 */
	@Test
	public void testParseInputH(){
		Player mockedPlayer = Mockito.mock(Player.class);
		CoffeeQuest test = new CoffeeQuest();
		String expected = "Goal: Hero, it is your goal to get everything Bob needs to brew his magical potion,"
				+ " named 'coffee'. Search the rooms for ingredients of this 'coffee'. When you have all you require"
				+ " to brew this potion, drink it and be sated.\n\nCommands:\nN - If the room has a door leading north,"
				+ " moves you through that door.\nS - If the room has a door leading south, moves you through that door.\n"
				+ "L - Looks for an object in the room\nI - Displays the items you have picked up\nD - Attempts to create"
				+ " coffee from items in your inventory. Beware the consequences if ye do not have all ye require.\nH -"
				+ " Displays this help message\n\n";
		boolean cont = test.parseInput(mockedPlayer, 'H');
		assertEquals(true, cont);
		assertEquals(expected.trim(), out.toString().trim());
	}

	/*
	 * parseInput is a method that takes the Player's command and provides a response to it. This test
	 * checks that if an unsupported input is given that "What?" is printed and the program continues
	 * to run.
	 */
	@Test
	public void testParseInputNonCommand(){
		Player mockedPlayer = Mockito.mock(Player.class);
		CoffeeQuest test = new CoffeeQuest();
		String expected = "What?";
		boolean cont = test.parseInput(mockedPlayer, 'Z');
		assertEquals(true, cont);
		assertEquals(expected, out.toString().trim());
	}
}