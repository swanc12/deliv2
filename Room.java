public class Room{
	
	public Room north;
	public Room south;
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
	
	public Room(Room n, Room s, String adj, String furn){
		
		if(n != null){
			north = n;
		}
		
		if(s != null){
			south = s;
		}
		
		adjective = adj;
		furnishing = furn;
		
	}
	
	public void setNorth(Room n){
		north = n;
	}
	
	public void setSouth(Room s){
		south = s;
	}
	
	public String toString(){
		String returnString = "";
		if(north != null){
			returnString = returnString + "The room has a door leading North.\n";
		}
		if(south != null){
			returnString = returnString + "The room has a door leading South.\n";
		}
		returnString = returnString + "The room is " + adjective + ".\nIt has a " + furnishing + ".";
		return returnString;
	}
}