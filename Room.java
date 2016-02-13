/*
 * Room class for the Coffee Quest project (Deliverable 2). Basically creating
 * a doubly linked list for the rooms, since it seemed intuitive and makes testing
 * relatively straight-forward.
 * 
 * Author: Colin Swan
 * Due Date: February 15, 2016
 */

public class Room{
	
	protected Room north;
	protected String nDoor; //Door adjs. aren't required but they're fun :)
	
	protected Room south;
	protected String sDoor;
	
	protected String adjective;
	protected String furnishing;
	protected String object; //object to be picked up by player if they input "L" / "l" Does get
	//removed when its picked up because it is not a requirement.
	
	/*
	 * Constructor. Empty room. Should not be used in this program but required for
	 * RoomTest to extend Room, allowing it access to protected variables. Unsure
	 * if this is considered good practice or not, it seemed better to require
	 * the room to have an adjective and furniture defined always since its
	 * a requirement of the program as a whole. 
	 */
	public Room(){
		north = null;
		south = null;
		adjective = null;
		furnishing = null;
		object = null;
	}
	
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
	 * Constructor. Allows room to be defined with an object as well.
	 */
	public Room(String adj, String furn, String obj){
		
		north = null;
		south = null;
		adjective = adj;
		furnishing = furn;
		object = obj;
		
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
	 * Sets object to String passed into method.
	 */
	public void setObject(String obj){
		object = obj;
	}
	
	/*
	 * Returns the value for north, which is a room if there's an adjacent room north of this one
	 * or null if not.
	 */
	public Room getNorth(){
		return north;
	}
	
	/*
	 * Returns the value for south, which is a room if there's an adjacent room south of this one
	 * or null if not.
	 */
	public Room getSouth(){
		return south;
	}
	
	/*
	 * Returns object variable
	 */
	public String getObject(){
		return object;
	}
	
	/*
	 * Returns true if an object exists for the room, else false.
	 */
	public boolean hasObject(){
		if(object != null){
			return true;
		}
		return false;
	}
	
	/*
	 * Returns true if there's a room north of this one, false otherwise.
	 */
	public boolean isRoomNorth(){
		if(north != null){
			return true;
		}
		return false;
	}
	
	/*
	 * Returns true if there's a room north of this one, false otherwise.
	 */
	public boolean isRoomSouth(){
		if(south != null){
			return true;
		}
		return false;
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