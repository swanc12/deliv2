import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;


public class PlayerTest extends Player{

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
	
	/*
	 * The Player needs to be able to pick up coffee, which sets the coffee
	 * flag to True for the player. The player's inv boolean array has the
	 * inventory flags. inv[0] is Coffee.
	 */
	@Test
	public void testAddCoffee() {
		Player testPlayer = new Player();
		testPlayer.addCoffee();
		assertEquals(true, testPlayer.inv[0]);
	}
	
	/*
	 * The Player needs to be able to pick up cream, which sets the cream
	 * flag to True for the player. The player's inv boolean array has the
	 * inventory flags. inv[1] is Cream.
	 */
	@Test
	public void testAddCream() {
		Player testPlayer = new Player();
		testPlayer.addCream();
		assertEquals(true, testPlayer.inv[1]);
	}
	
	/*
	 * The Player needs to be able to pick up sugar, which sets the sugar
	 * flag to True for the player. The player's inv boolean array has the
	 * inventory flags. inv[2] is Sugar.
	 */
	@Test
	public void testAddSugar() {
		Player testPlayer = new Player();
		testPlayer.addSugar();
		assertEquals(true, testPlayer.inv[2]);
	}
	
	/*
	 * When the drink command is input, the inventory will need to be checked
	 * to determine whether or not all the required objects have been picked up.
	 * If all the elements in inv are true then the player has picked up every
	 * object, and the checkFullInv should return true.
	 */
	@Test
	public void testFullInvFull() {
		Player testPlayer = new Player();
		testPlayer.inv[0] = true;
		testPlayer.inv[1] = true;
		testPlayer.inv[2] = true;
		assertEquals(true, testPlayer.checkFullInv());
	}
	
	/*
	 * When the drink command is input, the inventory will need to be checked
	 * to determine whether or not all the required objects have been picked up.
	 * If not all the elements in inv are true, then the player has not picked up every
	 * object, and the checkFullInv method should return false.
	 */
	@Test
	public void testFullInvPartial() {
		Player testPlayer = new Player();
		testPlayer.inv[0] = true;
		testPlayer.inv[1] = true;
		assertEquals(false, testPlayer.checkFullInv());
	}
	
	/*
	 * When the drink command is input, the inventory will need to be checked
	 * to determine whether or not all the required objects have been picked up.
	 * If all the elements in inv are false then the player has not picked up any
	 * object, and the checkFullInv method should return false.
	 */
	@Test
	public void testFullInvEmpty() {
		Player testPlayer = new Player();
		assertEquals(false, testPlayer.checkFullInv());
	}
	
	
	/*
	 * When the player looks they should return a character to represent what object they
	 * found, and update their inventory to reflect that they have that object. This
	 * test checks that both of those events happen when a player finds Coffee, which
	 * should return 'C'.
	 */
	@Test
	public void testLookC(){
		Player testPlayer = new Player();
		Room mockedRoom = mock(Room.class);
		when(mockedRoom.hasObject()).thenReturn(true);
		when(mockedRoom.getObject()).thenReturn("Coffee");
		char result = testPlayer.look(mockedRoom);
		assertEquals(testPlayer.inv[0], true);
		assertEquals(testPlayer.inv[1], false);
		assertEquals(testPlayer.inv[2], false);
		assertEquals(result, 'C');
	}
	
	/*
	 * When the player looks they should return a character to represent what object they
	 * found, and update their inventory to reflect that they have that object. This
	 * test checks that both of those events happen when a player finds Cream, which
	 * should return 'M'.
	 */
	@Test
	public void testLookM(){
		Player testPlayer = new Player();
		Room mockedRoom = mock(Room.class);
		when(mockedRoom.hasObject()).thenReturn(true);
		when(mockedRoom.getObject()).thenReturn("Cream");
		char result = testPlayer.look(mockedRoom);
		assertEquals(testPlayer.inv[1], true);
		assertEquals(testPlayer.inv[0], false);
		assertEquals(testPlayer.inv[2], false);
		assertEquals(result, 'M');
	}
	
	/*
	 * When the player looks they should return a character to represent what object they
	 * found, and update their inventory to reflect that they have that object. This
	 * test checks that both of those events happen when a player finds Sugar, which
	 * should return 'S'.
	 */
	@Test
	public void testLookS(){
		Player testPlayer = new Player();
		Room mockedRoom = mock(Room.class);
		when(mockedRoom.hasObject()).thenReturn(true);
		when(mockedRoom.getObject()).thenReturn("Sugar");
		char result = testPlayer.look(mockedRoom);
		assertEquals(testPlayer.inv[0], false);
		assertEquals(testPlayer.inv[1], false);
		assertEquals(testPlayer.inv[2], true);
		assertEquals(result, 'S');
	}
	
	/*
	 * When the player looks they should return a character to represent what object they
	 * found, and update their inventory to reflect that they have that object. This
	 * test checks that neither of those events happen when a player finds nothing, which
	 * should return 'X' because the room's hasObject method should return false.
	 */
	@Test
	public void testLookEmpty(){
		Player testPlayer = new Player();
		Room mockedRoom = mock(Room.class);
		when(mockedRoom.hasObject()).thenReturn(false);
		char result = testPlayer.look(mockedRoom);
		assertEquals(testPlayer.inv[0], false);
		assertEquals(testPlayer.inv[1], false);
		assertEquals(testPlayer.inv[2], false);
		assertEquals(result, 'X');
	}
	
	/*
	 * When the player looks they should return a character to represent what object they
	 * found, and update their inventory to reflect that they have that object. This
	 * test checks that neither of those events happen when a player finds something else, which
	 * should return 'X' because the player's look method did not have a case for that object.
	 */
	@Test
	public void testLookOther(){
		Player testPlayer = new Player();
		Room mockedRoom = mock(Room.class);
		when(mockedRoom.hasObject()).thenReturn(true);
		when(mockedRoom.getObject()).thenReturn("Broccoli");
		char result = testPlayer.look(mockedRoom);
		assertEquals(testPlayer.inv[0], false);
		assertEquals(testPlayer.inv[1], false);
		assertEquals(testPlayer.inv[2], false);
		assertEquals(result, 'X');
	}

}