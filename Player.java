/*
 * Player class for the Coffee Quest project (Deliverable 2). Simply contains the player's inventory, location, and
 * methods for possible inputs.
 * 
 * Author: Colin Swan
 * Due Date: February 15th, 2016
 */

public class Player{
	
	/*
	 * Boolean array to work as flags for each possible inventory item.
	 * inv[0] should be coffee, inv[1] should be cream, inv[2] should be sugar.
	 * Protected so that only subclasses should be able to access it directly;
	 * PlayerTest extends Player allowing it to access inv while testing
	 * the add methods.
	 */
	protected boolean[] inv;
	
	/*
	 * Constructor. Sets inventory to three, all false by default.
	 * Methods will be used to set inventory. The following should be observed:
	 * inv[0] is coffee, inv[1] is cream, inv[2] is sugar.
	 */
	public Player(){
		inv = new boolean[3];
	}
	
	public void addCoffee(){
		inv[0] = true;
	}
	
	public void addCream(){
		inv[1] = true;
	}

	public void addSugar(){
		inv[2] = true;
	}
	
	/*
	 * Returns the inventory flags that the player currently has set.
	 */
	public boolean[] getInv(){
		return inv;
	}
	
	/*
	 * Player looks for an object in the room. Returns 'X' if nothing is
	 * found, 'C' if coffee is found, 'M' if cream is found, and 'S' if
	 * sugar is found. If any objects are found they are added to the inventory.
	 */
	public char look(Room aRoom){
		if(!aRoom.hasObject()){
			return 'X';
		}
		String obj = aRoom.getObject();
		
		if(obj.equals("Cream")){
			addCream();
			return 'M';
		}
		if(obj.equals("Sugar")){
			addSugar();
			return 'S';
		}
		if(obj.equals("Coffee")){
			addCoffee();
			return 'C';
		}
		return 'X';
	}
	
	/*
	 * Checks each flag in inv to determine if the inventory
	 * is full or not. If every element in inv is true, then the
	 * inventory is full and every item has been acquired, else
	 * items have been missed.
	 */
	public boolean checkFullInv(){
		
		for(boolean flag : inv){
			if(!flag){
				return false;
			}
		}
		return true;
	}
	
	
}