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
	public String object;
	
	public Room(String adj, String furn){
		
		north = null;
		south = null;
		adjective = adj;
		furnishing = furn;
		object = null;
		
	}
	
	public Room(Room n, Room s, String adj, String furn, String nd, String sd){
		
		if(n != null){
			north = n;
			nDoor = nd;
		}
		
		if(s != null){
			south = s;
			sDoor = sd;
		}
		
		adjective = adj;
		furnishing = furn;
		
	}
	
	public void setNorth(Room n, String nd){
		north = n;
		nDoor = nd;
	}
	
	public void setSouth(Room s, String sd){
		south = s;
		sDoor = sd;
	}
	
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