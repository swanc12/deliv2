import static org.junit.Assert.*;
import org.junit.Test;

public class CoffeeQuestTest extends Player{

	
	/*
	 * All the commands are one character in length. If the player inputs something
	 * larger than one character then the getInput method should return 'X' which
	 * will tell the program to print "What?"
	 */
	@Test
	public void testGetInputLong() {
		CoffeeQuest test = new CoffeeQuest();
		char result = test.inputToChar("Nannaa\n");
		assertEquals('X', result);
	}
	
	/*
	 * The requirements specify the commands 'N', 'S', 'L', 'D', 'I', and 'H'. If something
	 * other than that is input then 'X' is returned by getInput.
	 */
	@Test
	public void testGetInputNonCommand() {
		CoffeeQuest test = new CoffeeQuest();
		char result = test.inputToChar("F");
		assertEquals('X', result);
	}
	
	/*
	 * When the user inputs N or n, getInput should return char N. The test
	 * mocks the Scanner object that getInput requests to read from and runs
	 * the getInput method, which should return a character
	 */
	@Test
	public void testGetInputN() {
		CoffeeQuest test = new CoffeeQuest();
		char result = test.inputToChar("N");
		assertEquals('N', result);
		result = test.inputToChar("n");
		assertEquals('N', result);
	}
	
	/*
	 * When the user inputs S or s, getInput should return char S. The test
	 * mocks the Scanner object that getInput requests to read from and runs
	 * the getInput method, which should return a character
	 */
	@Test
	public void testGetInputS() {
		CoffeeQuest test = new CoffeeQuest();
		char result = test.inputToChar("S");
		assertEquals('S', result);
		result = test.inputToChar("s");
		assertEquals('S', result);
	}
	
	/*
	 * When the user inputs L or l, getInput should return char L. The test
	 * mocks the Scanner object that getInput requests to read from and runs
	 * the getInput method, which should return a character
	 */
	@Test
	public void testGetInputL() {
		CoffeeQuest test = new CoffeeQuest();
		char result = test.inputToChar("L");
		assertEquals('L', result);
		result = test.inputToChar("l");
		assertEquals('L', result);
	}
	
	/*
	 * When the user inputs I or i, getInput should return char I. The test
	 * mocks the Scanner object that getInput requests to read from and runs
	 * the getInput method, which should return a character
	 */
	@Test
	public void testGetInputI() {
		CoffeeQuest test = new CoffeeQuest();
		char result = test.inputToChar("I");
		assertEquals('I', result);
		result = test.inputToChar("i");
		assertEquals('I', result);
	}
	
	/*
	 * When the user inputs H or h, getInput should return char H. The test
	 * mocks the Scanner object that getInput requests to read from and runs
	 * the getInput method, which should return a character
	 */
	@Test
	public void testGetInputH() {
		CoffeeQuest test = new CoffeeQuest();
		char result = test.inputToChar("H");
		assertEquals('H', result);
		result = test.inputToChar("h");
		assertEquals('H', result);
	}
	
	/*
	 * When the user inputs D or d, getInput should return char D. The test
	 * mocks the Scanner object that getInput requests to read from and runs
	 * the getInput method, which should return a character
	 */
	@Test
	public void testGetInputD() {
		CoffeeQuest test = new CoffeeQuest();
		char result = test.inputToChar("D");
		assertEquals('D', result);
		result = test.inputToChar("d");
		assertEquals('D', result);
	}

}