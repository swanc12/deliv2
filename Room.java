/*
 * Room class for the Coffee Quest project (Deliverable 2). Basically creating
 * a doubly linked list for the rooms, since it seemed intuitive and makes testing
 * straight-forward.
 * 
 * Author: Colin Swan
 * Due Date: February 15, 2016
 */

public class Room{
	
	public Room north;
	public String nDoor; //Door adjs. aren't required but they're fun :)
	
	public Room south;
	public String sDoor;
	
	public String adjective;
	public String furnishing;
	public String object; //object to be picked up by player if they input "L" / "l"
	
	/*
	 * Constructor. Room must at least be created with an adjective and a furnishing.
	 */
	public Room(String adj, String furn){
		
		north = null;
		south = null;
		adjective = adj;
		furnishing = furn;
		object = null;
		
	}
	
	/*
	 * Creates a "door" (link) to a room North of this one. Door must have an adjective.
	 */
	public void setNorth(Room n, String nd){
		north = n;
		nDoor = nd;
	}
	
	/*
	 * Creates a "door" (link) to a room south of this one. Door must have an adjective.
	 */
	public void setSouth(Room s, String sd){
		south = s;
		sDoor = sd;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * 
	 * Returns a string representation of this Room. Prints the adjective and furnishing for the room as well
	 * as doors and their adjectives, if present.
	 */
	public String toString(){
		String returnString = "";
		returnString = returnString + "You see a " + adjective + " room.\nIt has a " + furnishing + ".\n";
		if(north != null){
			returnString = returnString + "The room has a " + nDoor + " door leading North.\n";
		}
		if(south != null){
			returnString = returnString + "The room has a " + sDoor + " door leading South.\n";
		}
		return returnString;
	}
}