/*
 * Program: Coffee Quest!
 * Description: Another day, another quest for coffee. Embark on an epic
 * journey - to a magical land - filled - with coffee. Join Bob, the hero
 * of our tale, as he struggles to find the one thing he could never possibly
 * live without. Coffee, with sugar. And. Cream. Will he survive? Bob's fate
 * rests in your incapable hands.
 *
 * Author: Colin Swan
 * Due date: February 15, 2016
 */

public class CoffeeQuest{

	public static void main(String[] args){
		Room room1 = new Room("bravely", "shady chandelier");
		Room room2 = new Room("dastardly", "fantastic fence");
		Room room3 = new Room("typical", "boring branch");
		Room room4 = new Room("tyranical", "totalitarion tank");
		Room room5 = new Room("plastered", "half-full stein");
		Room room6 = new Room("regretful", "foolhardy student");
		
		//Setting the doors for each room!
		room1.setNorth(room2, "dreadful");
		
		room2.setNorth(room3, "terrifying");
		room2.setSouth(room1, "tranquil");
		
		room3.setNorth(room4, "forboding");
		room3.setSouth(room2, "tempting");
		
		room4.setNorth(room5, "horrific");
		room4.setSouth(room3, "seductive");
		
		room5.setNorth(room6, "devilish");
		room5.setSouth(room4, "holy");
		
		room6.setSouth(room5, "godly");
		
		Room currentRoom = room1;
		
		while(currentRoom != null){
			System.out.println(currentRoom);
			currentRoom = currentRoom.north;
		}
		
		
	}

}

