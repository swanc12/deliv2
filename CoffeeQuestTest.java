import static org.junit.Assert.*;
import org.junit.Test;

public class CoffeeQuestTest extends Player{

	
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

}