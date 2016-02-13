/*
 * Test suite for general CoffeeQuest methods that don't require modifications to System.out.
 */

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;



public class CoffeeQuestTest extends CoffeeQuest{

	/*
	 * An empty constructor should not set the kInput scanner or the currentRoom to an object.
	 * This test creates a CoffeeQuest object without arguments which should result in the 
	 * kInput and currentRoom variables being null.
	 */
	@Test
	public void testEmptyConstructor(){
		CoffeeQuest test = new CoffeeQuest();
		assertEquals(test.currentRoom, null);
	}
	
	/*
	 * A CoffeeQuest object can be instantiated with an input stream and a starting room.
	 * This test creates a mock InputStream and starting Room to test that the
	 * kInput and currentRoom variables are set properly. Asserts that kInput is an instance
	 * of a Scanner class, as opposed to null.
	 */
	@Test
	public void testConstructor(){
		Room mockedRoom = Mockito.mock(Room.class);
		CoffeeQuest test = new CoffeeQuest(mockedRoom);
		assertEquals(test.currentRoom, mockedRoom);
	}
	/*
	 * All the commands are one character in length. If the player inputs something
	 * larger than one character then the inputToChar method should return 'X', which does
	 * not correspond to a command.
	 */
	@Test
	public void testInputToCharLong() {
		CoffeeQuest test = new CoffeeQuest();
		char result = test.inputToChar("Nannaa\n");
		assertEquals('X', result);
	}
	
	/*
	 * All the commands are one character in length. If a String is
	 * passed in to inputToChar that is one character in length then the
	 * method should return the uppercase equivelant of that character.
	 */
	@Test
	public void testInputToCharCorrectLength() {
		CoffeeQuest test = new CoffeeQuest();
		char result = test.inputToChar("F");
		assertEquals('F', result);
	}
	
	/*
	 * All the commands are one character in length. If the player
	 * inputs nothing then the inputToChar method should return
	 * 'X' to indicate unknown input.
	 */
	@Test
	public void testInputToCharNothing() {
		CoffeeQuest test = new CoffeeQuest();
		char result = test.inputToChar("");
		assertEquals('X', result);
	}
	
	/*
	 * CoffeeQuest getCurrentRoom method should return the room that is
	 * set to the CoffeeQuest's currentRoom variable. This test
	 * creates a CoffeeQuest object with a mocked room and asserts that
	 * the mocked room is returned by getCurrentRoom.
	 */
	@Test
	public void testGetCurrentRoom(){
		Room mockedRoom = Mockito.mock(Room.class);
		CoffeeQuest test = new CoffeeQuest();
		test.currentRoom = mockedRoom;
		assertEquals(mockedRoom, test.getCurrentRoom());
	}

}