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

import java.util.Scanner;
import java.io.*;

public class CoffeeQuest{
	
	Scanner kInput;
	Room currentRoom;
	
	public CoffeeQuest(){
	}
	
	public CoffeeQuest(InputStream in, Room startRoom){
		kInput = new Scanner(in);
		currentRoom = startRoom;
	}
	
	public char inputToChar(String in){
		String input = in.toUpperCase().trim();
		//If the player inputs a command with more than 1 character it is invalid.
		if(input.length() != 1){
			return 'X';
		}
		//Getting the character for the input
		char inputChar = input.charAt(0);
		return inputChar;
	}
	
	public boolean parseInput(Player player){
		System.out.println("Commands: (N)orth, (S)outh, (L)ook, (I)nventory, (D)rink, (H)elp");
		char command = inputToChar(kInput.nextLine());
		if(command == 'N'){
			if(currentRoom.isRoomNorth()){
				currentRoom = currentRoom.north;
			}
			else{
				System.out.println("There's no door there...");
			}
		}
		else if(command == 'S'){
			if(currentRoom.isRoomSouth()){
				currentRoom = currentRoom.south;
			}
			else{
				System.out.println("There's no door there...");
			}
		}
		else if(command == 'I'){
			
			System.out.println(player.invStr());
		}
		else if(command == 'L'){
			char lookResult = player.look(currentRoom);
			if(lookResult == 'M'){
				System.out.println("You found Creamy cream!");
			}
			else if(lookResult == 'C'){
				System.out.println("You found Caffeinated Coffee!");
			}
			else if (lookResult == 'S'){
				System.out.println("You found Sweet Sugar!");
			}
			else{
				System.out.println("You didn't find anything useful...");
			}
		}
		else if(command == 'D'){
			return false;
		}
		else if(command == 'H'){
			System.out.println("Goal: Hero, it is your goal to get everything Bob needs to brew his magical potion, named 'coffee'. Search the"
					+ " rooms for ingredients of this 'coffee'. When you have all you require to brew this potion, drink it and be sated.\n");
			System.out.println("Commands:");
			System.out.println("N - If the room has a door leading north, moves you through that door.");
			System.out.println("S - If the room has a door leading south, moves you through that door.");
			System.out.println("L - Looks for an object in the room");
			System.out.println("I - Displays the items you have picked up");
			System.out.println("D - Attempts to create coffee from items in your inventory. Beware the consequences if ye do not have all"
					+ "ye require.");
			System.out.println("H - Displays this help message\n");
		}
		else{
			System.out.println("What?");
		}
		return true;
	}
	
	public String currentRoomString(){
		return currentRoom.toString();
	}
	
	public static void main(String[] args){

		Room room1 = new Room("bravely", "shady chandelier", "Cream");
		Room room2 = new Room("dastardly", "fantastic fence");
		Room room3 = new Room("typical", "boring branch");
		Room room4 = new Room("tyranical", "totalitarion tank", "Sugar");
		Room room5 = new Room("plastered", "half-full stein");
		Room room6 = new Room("regretful", "foolhardy student", "Coffee");
		
		//Setting the doors for each room
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
		
		CoffeeQuest narrator = new CoffeeQuest(System.in, room1);
		Player readyPlayerOne = new Player();
		System.out.println("Welcome to Coffee Quest");
		
		//Used for do while loop.
		boolean proceed;
		do{
			System.out.println(narrator.currentRoomString());
			proceed = narrator.parseInput(readyPlayerOne);		

			//Could have just put parseInput in while loop but this is a bit easier to follow.
	
		}
		while(proceed);
		
		System.out.println(readyPlayerOne.invStr());
		if(readyPlayerOne.checkFullInv()){
			System.out.println("You mix the coffee, cream, and sugar togather and drink it!");
			System.out.println("You win! Congratulations!");
		}
		else{
			boolean[] inv = readyPlayerOne.getInv();
			boolean empty = true;
			for(boolean val : inv){
				if(val){
					empty = false;
				}
			}
			
			if(empty){
				System.out.println("You have nothing. You try to drink it. You die from drinking nothing. (This means you lost)");
			}
			else{
				System.out.println("You don't have all the ingredients for coffee. You run out of energy and fail to finish the cs1632 assignment on time. You die. You lose.");
			}
		}
		
	}

}

