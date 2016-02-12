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

public class CoffeeQuest{
	Room currentRoom;
	public char inputToChar(String in){
		String input = in.toUpperCase().trim();
		//If the player inputs a command with more than 1 character it is invalid.
		if(input.length() > 1){
			return 'X';
		}
		//Getting the character for the input
		char inputChar = input.charAt(0);
		if(inputChar == 'N'){
			return 'N';
		}
		else if(inputChar == 'S'){
			return 'S';
		}
		else if(inputChar == 'L'){
			return 'L';
		}
		else if(inputChar == 'I'){
			return 'I';
		}
		else if(inputChar == 'H'){
			return 'H';
		}
		else if(inputChar == 'D'){
			return 'D';
		}
		
		return 'X';
	}

	public boolean parseInput(String input, Player player, Room room){
		char command = inputToChar(input);
		if(command == 'N'){
			currentRoom = currentRoom.
		}
		return false;
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
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
		
		currentRoom = room1;
		
		Player readyPlayerOne = new Player();
		
		System.out.println("Welcome to Coffee Quest");
		
		//Used for do while loop.
		boolean proceed;
		do{
			System.out.println("\n" + currentRoom);
			System.out.println("Instructions: (N)orth, (S)outh, (L)ook, (I)nventory, (D)rink, (H)elp");
			String input = in.nextLine();
			
			//Could have just put parseInput in while loop but this is a bit easier to follow.
			proceed = parseInput(input, readyPlayerOne, currentRoom);			
		}
		while(proceed);
		
	}

}

