import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import org.junit.Test;

public class CoffeeQuestTest extends Player{

	/*
	 * Makes sure the base player object is constructed correctly.
	 * The player should have an empty inventory upon creation.
	 */
	@Test
	public void testPlayerConstructor() {
		Player testPlayer = new Player();
		for(boolean flag : testPlayer.inv){
			assertEquals(false, flag);
		}
	}

}