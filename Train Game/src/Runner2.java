import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.*;

public class Runner2 {

	static ArrayList <ISetting> board = new ArrayList<ISetting>();
	static ArrayList <MyObject> objects = new ArrayList<MyObject>();
	static ArrayList <Character> characterList = new ArrayList<Character>();
	static Scanner file;
	static boolean game = true;

	static Player player;
	static int cha = 0;
	static Scanner userIntInput = new Scanner(System.in);
	static Scanner userInput = new Scanner(System.in);
	static String enter;
	
	private static final long serialVersionUID = 1L;
	static JFrame frame = new JFrame();
	
	static ArrayList <MyObject> inventory = new ArrayList<MyObject>();
	
//	int choice = 1;
//	static String choice2 = "";
	
	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001b[34;1m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_HGREEN = "\u001b[42;1m";
    public static final String ANSI_MAGENTA = "\u001b[35m";
    
    public static final String BLUE = "\u001b[44;1m";
    public static final String GREEN = "\u001b[42;1m";
    public static final String YELLOW = "\u001b[43;1m";
    public static final String RED = "\u001b[41;1m";
    public static final String ORANGE = "\033[48;2;255;165;0m";
    public static final String PINK = "\u001b[45;1m";
    public static final String LBLUE = "\u001b[46;1m";
    public static final String WHITE = "\u001b[47;1m";
    
    public static final String BOLD = "\u001b[1m";
    public static final String UNDERLINED = "\u001b[4m";
    public static final String REVERSE = "\u001b[7m;1m";
	
	public static void main(String[] args) {
	
		fillCharacters();
		fillObjects();
		fillBoard();
		intro();

	}
	
	public static void charResponse(int index){
		
		switch(index)
		{
			
			case 1: System.out.println(ANSI_CYAN + "Choo Choooooooooooooooooo. I like twains." + ANSI_RESET);
					enter = userInput.nextLine();
					break;
			case 2: System.out.println(ANSI_CYAN + "You seem like a rather amiable fellow. I'm glad for your presence on my humble little train. \nNothing secret here at all..." + ANSI_RESET);
					enter = userInput.nextLine();
					break;
			case 3: System.out.println(ANSI_CYAN + "Do you know what it's like down here. All alone.");
					enter = userInput.nextLine();
					System.out.println("Only living for the ebb and flow of pulling the brake.");
					enter = userInput.nextLine();
					System.out.println("I am trapped here for eternity. There is no one who loves me.");
					enter = userInput.nextLine();
					System.out.println("If only the bathroom was unlocked..." + ANSI_RESET);
					break;
			case 4: System.out.println(ANSI_CYAN + "Please you HAVE to get me away from Leonard. He really is a gross man-child" + ANSI_RESET);
					enter = userInput.nextLine();
					break;
			case 5: System.out.println(ANSI_CYAN + "Cook. Cook. Cook. I do love the smell of" + ANSI_RED + " blood " + ANSI_CYAN +  "in the morning." + ANSI_RESET);
					enter = userInput.nextLine();
					break;
			case 6: System.out.println(ANSI_CYAN + "Do you have any medical needs? I'd be happy to help!" + ANSI_RESET);
					enter = userInput.nextLine();
					break;
			case 7: System.out.println(ANSI_CYAN + "Honk Honk!" + ANSI_RESET);
					enter = userInput.nextLine();
					System.out.println("You get sprayed with water like a cat. The clown bounces bouncily away.");
					enter = userInput.nextLine();
					break;
			case 8: System.out.println(shakespeare());
					enter = userInput.nextLine();
					System.out.println("She doesn't seem to be doing much work.");
					enter = userInput.nextLine();
					break;
			case 9: System.out.println(ANSI_CYAN + "Have you heard of FL v. Sheila Keen-Warren? The killer clown trial?");
					enter = userInput.nextLine();
					System.out.println("Well now you do! I HATE CLOWNS!" + ANSI_RESET);
					break;
			case 10: System.out.println();
					break;
			case 11: System.out.println();
					break;
			case 12: System.out.println("Oh thank the Lord, someone finally found me. I have been alone in this void for far too long.");
					enter = userInput.nextLine();
					System.out.println("Clearly you know who I am...");
					enter = userInput.nextLine();
					System.out.println("YOU DON'T?");
					enter = userInput.nextLine();
					System.out.println("I'M GEORGE BLOODY WASHINGTON BRO!");
					enter = userInput.nextLine();
					System.out.println("Anyways, I've been here for a hot minute soooooo. Thanks for freeing me, homeskillet.");
					break;
			
		}
	}
	
	public static String shakespeare()
		{
			String shakespeare = "";
			int random = (int)(Math.random()*4);
			
			switch(random)
			{
				case 0: shakespeare = ANSI_CYAN + "Is this a dagger which I see before me, the handle toward my hand?" + ANSI_RESET;
						break;
				case 1: shakespeare = ANSI_CYAN + "Cry “havoc!” and let slip the dogs of war" + ANSI_RESET;
						break;
				case 2: shakespeare = ANSI_CYAN + "Full fathom five thy father lies, of his bones are coral made. Those are pearls that were his eyes. \nNothing of him that doth fade, but doth suffer a sea-change into something rich and strange." + ANSI_RESET;
						break;
				case 3: shakespeare = ANSI_CYAN + "A horse! a horse! My kingdom for a horse!" + ANSI_RESET;
						break;
				default: shakespeare = ANSI_CYAN + "If you prick us, do we not bleed? If you tickle us, do we not laugh? If you poison us, do we not die? And if you wrong us, shall we not revenge?" + ANSI_RESET;
						break;
			}
			return shakespeare; 
		}
	
	public static void mainCar(){
		
		player.setLocation(3);
		displayRoom();
		System.out.println("What would you like to do?");
		System.out.println("1) " + board.get(2).getName());
		System.out.println("2) " + board.get(4).getName());
		System.out.println("3) " + board.get(10).getName());
		System.out.println("4) " + board.get(11).getName());
		System.out.println("5) " + board.get(12).getName());
		System.out.println("6) " + board.get(13).getName());
		int choice = userIntInput.nextInt();
		
		switch(choice)
		{
		case 1:
				{
					kitchen();
					break;
				}
		case 2:
				{
					
					firstClass();
					break;
				}
		case 3:
				{
					if(board.get(10).isUnlocked()) {
						
						clownRoom();
					}else {
						
						mainCar();
					}
					break;
				}
		case 4:
				{
					myRoom();
					break;
				}
		case 5:
				{
					if(board.get(10).isUnlocked()) {
						
						writerRoom();
					}else {
						
						mainCar();
					}
					break;
				}
		case 6:
				{
					if(board.get(10).isUnlocked()) {
						
						prosecRoom();
					}else {
						
						mainCar();
					}
					break;
				}
		default:
				{
					mainCar();
				}
		}	
	}
	
	
	public static void clownRoom() {
		
		player.setLocation(10);
		displayRoom();
		System.out.println("What would you like to do?");
		System.out.println("1) " + board.get(3).getName());
		int choice = userIntInput.nextInt();
		
		switch(choice)
		{
		case 1:
				{
					mainCar();
					break;
				}
		default:
				{
					clownRoom();
				}
		}	
	}
	
	public static void myRoom() {
		
		player.setLocation(11);
		displayRoom();
		System.out.println("What would you like to do?");
		System.out.println("1) " + board.get(3).getName());
		int choice = userIntInput.nextInt();
		
		switch(choice)
		{
		case 1:
				{
					mainCar();
					break;
				}
		default:
				{
					myRoom();
				}
		}	
	}
	
	public static void writerRoom() {
		
		player.setLocation(12);
		displayRoom();
		System.out.println("What would you like to do?");
		System.out.println("1) " + board.get(3).getName());
		int choice = userIntInput.nextInt();
		
		switch(choice)
		{
		case 1:
				{
					mainCar();
					break;
				}
		default:
				{
					writerRoom();
				}
		}	
	}
	
	public static void prosecRoom() {
		
		player.setLocation(13);
		displayRoom();
		System.out.println("What would you like to do?");
		System.out.println("1) " + board.get(3).getName());
		int choice = userIntInput.nextInt();
		
		switch(choice)
		{
		case 1:
				{
					mainCar();
					break;
				}
		default:
				{
					prosecRoom();
				}
		}	
	}
	
	public static void kitchen() {
		
		player.setLocation(2);
		displayRoom();
		System.out.println("What would you like to do?");
		System.out.println("1) " + board.get(1).getName());
		System.out.println("2) " + board.get(3).getName());
		System.out.println("3) " + board.get(8).getName());
		System.out.println("4) " + board.get(9).getName());
		int choice = userIntInput.nextInt();
		
		switch(choice)
		{
		case 1:
				{
					caboose();
					break;
				}
		case 2:
				{
					mainCar();
					break;
				}
		case 3:
				{
					if(board.get(14).isUnlocked()) {
						
						bathroom();
					}else {
						
						kitchen();
					}
					break;
				}
		case 4:
				{
					if(board.get(15).isUnlocked()) {
						
						pantry();
					}else {
						
						kitchen();
					}
					break;
				}
		default:
				{
					kitchen();
				}
		}	
	}
	
	public static void bathroom() {
		
		player.setLocation(8);
		displayRoom();
		System.out.println("What would you like to do?");
		System.out.println("1) " + board.get(2).getName());
		int choice = userIntInput.nextInt();
		
		switch(choice)
		{
		case 1:
				{
					kitchen();
					break;
				}
		default:
				{
					bathroom();
				}
		}	
	}
	
	public static void pantry() {
		
		player.setLocation(9);
		displayRoom();
		System.out.println("What would you like to do?");
		System.out.println("1) " + board.get(2).getName());
		int choice = userIntInput.nextInt();
		
		switch(choice)
		{
		case 1:
				{
					kitchen();
					break;
				}
		default:
				{
					pantry();
				}
		}	
	}
	
	public static void caboose() {
		
		player.setLocation(1);
		displayRoom();
		System.out.println("What would you like to do?");
		System.out.println("1) " + board.get(2).getName());
		System.out.println("2) " + board.get(7).getName());
		System.out.println("3) " + board.get(6).getName());
		int choice = userIntInput.nextInt();
		
		switch(choice)
		{
		case 1:
				{
					kitchen();
					break;
				}
		case 2:
				{
					outside();
					break;
				}
		case 3:
				{
					if(board.get(6).isUnlocked()) {
						
						mystery();
					}else {
						
						caboose();
					}
					break;
				}
		default:
				{
					caboose();
				}
		}	
	}
	
	public static void outside() {
		
		player.setLocation(7);
		displayRoom();
		System.out.println("What would you like to do?");
		System.out.println("1) " + board.get(1).getName());
		int choice = userIntInput.nextInt();
		
		switch(choice)
		{
		case 1:
				{
					caboose();
					break;
				}
		default:
				{
					outside();
				}
		}	
	}
	
	public static void mystery() {
		
		player.setLocation(6);
		displayRoom();
		System.out.println("What would you like to do?");
		System.out.println("1) " + board.get(1).getName());
		int choice = userIntInput.nextInt();
		
		switch(choice)
		{
		case 1:
				{
					caboose();
					break;
				}
		default:
				{
					mystery();
				}
		}	
	}
	
	public static void firstClass() {
		
		player.setLocation(4);
		displayRoom();
		System.out.println("What would you like to do?");
		System.out.println("1) " + board.get(3).getName());
		System.out.println("2) " + board.get(5).getName());
		System.out.println("3) " + board.get(14).getName());
		System.out.println("4) " + board.get(15).getName());
		int choice = userIntInput.nextInt();
		
		switch(choice)
		{
		case 1:
				{
					mainCar();
					break;
				}
		case 2:
				{
					engine();
					break;
				}
		case 3:
				{
					if(board.get(14).isUnlocked()) {
						
						leoRoom();
					}else {
						
						firstClass();
					}
					break;
				}
		case 4:
				{
					if(board.get(15).isUnlocked()) {
						
						docRoom();
					}else {
						
						firstClass();
					}
					break;
				}
		default:
				{
					firstClass();
				}
		}	
	}
	
	public static void leoRoom() {
		
		player.setLocation(14);
		displayRoom();
		System.out.println("What would you like to do?");
		System.out.println("1) " + board.get(4).getName());
		int choice = userIntInput.nextInt();
		
		switch(choice)
		{
		case 1:
				{
					firstClass();
					break;
				}
		default:
				{
					leoRoom();
				}
		}	
	}

	public static void docRoom() {
		
		player.setLocation(15);
		displayRoom();
		System.out.println("What would you like to do?");
		System.out.println("1) " + board.get(4).getName());
		int choice = userIntInput.nextInt();
		
		switch(choice)
		{
		case 1:
				{
					firstClass();
					break;
				}
		default:
				{
					docRoom();
				}
		}	
	}
	
	public static void engine() {
		
		player.setLocation(5);
		displayRoom();
		System.out.println("What would you like to do?");
		System.out.println("1) " + board.get(4).getName());
		System.out.println("2) " + board.get(16).getName());
		int choice = userIntInput.nextInt();
		
		switch(choice)
		{
		case 1:
				{
					firstClass();
					break;
				}
		case 2:
				{
					driveCompart();
					break;
				}
		default:
				{
					engine();
				}
		}	
	}
	
	public static void driveCompart() {
		
		player.setLocation(16);
		displayRoom();
		System.out.println("What would you like to do?");
		System.out.println("1) " + board.get(5).getName());
		int choice = userIntInput.nextInt();
		
		switch(choice)
		{
		case 1:
				{
					engine();
					break;
				}
		default:
				{
					driveCompart();
				}
		}	
	}
	
	public static void intro() {
		
		charDisplay(0);
		makePlayer();
		player.setLocation(0);
		displayRoom();
		System.out.println(ANSI_CYAN + "Welcome to the waiting room! I hope you will enjoy your ride upon our humble little train.");
		enter = userInput.nextLine();
		System.out.println("You are welcome to look around, lots of interesting characters on the ride today." + ANSI_RESET);
		enter = userInput.nextLine();
		
		boolean exploring = true;
		int ring = 0;
		
		while(exploring){
			
				System.out.println("Would you like to: \n   1) Explore\n   2) Board the train");
				
				int answer = userIntInput.nextInt();
				
				if(answer == 1){
						System.out.println("Would you like to: \n   1) Talk to the conductor\n   2) Look in the box marked " + ANSI_RED + "SECRET" + ANSI_RESET + " \n   3) Run in a circle");
						answer = userIntInput.nextInt();
						
						if(answer == 1){
									System.out.println(ANSI_CYAN + "I really have nothing more to say to you" + ANSI_RESET);
									enter = userInput.nextLine();
						}
						else if(answer == 2){
									System.out.println("A bunch of moths fly in your face. There is nothing in this box, and there hasn't been anything there for a while.");
									enter = userInput.nextLine();
						}
						else if(answer == 3){
							
							if(ring == 5)
								{
									System.out.println("Running in a circle five times has made a small portal open up in front of you...");
									enter = userInput.nextLine();
									System.out.println("You reach in and pull out an engagement ring!");
									enter = userInput.nextLine();
									inventory.add(objects.get(11));
									System.out.println(ANSI_RED + "YOU HAVE ADDED ~ ENGAGEMENT RING ~ TO YOUR INVENTORY" + ANSI_RESET);
									enter = userInput.nextLine();
								}
							else
								{
									System.out.println("You run in a circle.");
									ring++;
									enter = userInput.nextLine();
								}
						}
						else
								{
									System.out.println("Well that's not an answer you silly goose!");
									enter = userInput.nextLine();
								}
						}
				else if(answer == 2){
						System.out.println(ANSI_CYAN + "Have a good ride!" + ANSI_RESET);
						
						enter = userInput.nextLine();
						System.out.print("Boarding Train");
						for(int i = 0; i < 3; i++) {
							
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.print(".");
						}
						System.out.println("");
						
						exploring = false;
					}
				else{
						System.out.println("Yeah dude that's not an option");
						enter = userInput.nextLine();
					}
			}
		player.setLocation(3);
		board.get(0).setName("Do you really want to jump out of a window bro? Really?");
		
		System.out.println("---------------------------------------");
		mainCar();
	}
	
	public static void displayRoom() {

//		Object[] options = {"Left Door", "Right Door", "Room 1", "My Room", "Room 3", "Room 4"};
//		choice = JOptionPane.showOptionDialog(
//				frame, 
//				ListLocations.locations.get(0).getDescription(),
//				ListLocations.locations.get(0).getName(),
//				JOptionPane.YES_NO_CANCEL_OPTION,
//				JOptionPane.QUESTION_MESSAGE,
//				null, 
//				options, 
//				options);
		System.out.println("");
		System.out.println("_______________________________________");
		System.out.println("");
	    System.out.println(BOLD + "You are in: " + ANSI_RESET + board.get(player.getLocation()).getName());
	    System.out.println(BOLD + "It is day " + ANSI_RESET + board.get(player.getLocation()).getDay());
	    System.out.println(board.get(player.getLocation()).getDescription());
	    System.out.println(BOLD + "People in the room:" + ANSI_RESET);

//	    for(Character c : characterList){
//	        if(c.getLocation() == player.getLocation()) {
//
//	          //System.out.println("     " + c.getName() + " " + c.getSecondName());
//	          System.out.print(padRight(c.getName() + " " + c.getSecondName(), 30));
//	        }
//	          
//	      }
	    
	    int counter = 0;
		ArrayList<Character> here = new ArrayList<Character>();
		
		for(int c = 0; c < characterList.size(); c++) {
			
			Character ppro = characterList.get(c);
			
			if(characterList.get(c).getLocation() == player.getLocation()) {
				
				here.add(ppro);
				counter++;
			}
		}
		
		for(int j = 0; j < here.size(); j++) {
			
			Character ppro = here.get(j);
			
			if(j%2 == 0 && j > 0) {
				
				System.out.println("");
			}
			
			System.out.print(padRight(ppro.getName(), 30));
		}
		
		if(counter == 0) {
			
			System.out.println("No characters in this room");
		}
		System.out.println("");
	  
	    //
	    
	    counter = 0;
		ArrayList<MyObject> mine = new ArrayList<MyObject>();
		
		for(int i = 0; i < objects.size(); i++) {
			
			MyObject pro = objects.get(i);
			
			if(pro.getLocation() == player.getLocation()) {
				
				mine.add(pro);
				counter++;
			}
		}
		
		for(int z = 0; z < mine.size(); z++) {
			
			MyObject pro = mine.get(z);
			
			if(z%2 == 0 && z > 0) {
				
				System.out.println("");
			}
			
			System.out.print(padRight(pro.getName(), 30));
		}
		
		if(counter == 0) {
			
			System.out.println("No items in this room");
		}
		System.out.println("");
	  }
	
	public static void charDisplay(int cha) {
		
		System.out.println("---------------------------------------");
		System.out.println(characterList.get(cha).getName());
		
		if(characterList.get(cha).getBond() == 0) {
			
			System.out.println(BOLD + "Bond: " + ANSI_RESET + ANSI_RED + "Low" + ANSI_RESET);
		}else if(characterList.get(cha).getBond() == 1){
			
			System.out.println(BOLD + "Bond: " + ANSI_RESET + ANSI_MAGENTA + "Average" + ANSI_RESET);
		}else{
			
			System.out.println(BOLD + "Bond: " + ANSI_RESET + ANSI_GREEN + "High" + ANSI_RESET);
		}

		System.out.println("                    " + UNDERLINED + "Items" + ANSI_RESET);
		
		int counter = 0;
		ArrayList<MyObject> mine = new ArrayList<MyObject>();
		
		for(int i = 0; i < objects.size(); i++) {
			
			MyObject pro = objects.get(i);
			
			if(pro.getLocation() == cha) {
				
				mine.add(pro);
				counter++;
			}
		}
		
		for(int z = 0; z < mine.size(); z++) {
			
			MyObject pro = mine.get(z);
			
			if(z%2 == 0 && z > 0) {
				
				System.out.println("");
			}
			
			System.out.print(padRight(pro.getName(), 30));
		}
		
		if(counter == 0) {
			
			System.out.println("No items owned");
		}
		System.out.println("");
	}
	
	public static void fillCharacters() {
		
		//Crew
		characterList.add(new Character(ANSI_CYAN + "Ticket CLerk" + ANSI_RESET, "Unknown", 0, 0));
		characterList.add(new Character(ANSI_CYAN + "Engineer" + ANSI_RESET, "Unknown", 16, 0));
		characterList.add(new Character(ANSI_CYAN + "Conductor" + ANSI_RESET, "Unknown", 3, 0));
		characterList.add(new Character(ANSI_CYAN + "Brakeman" + ANSI_RESET, "Unknown", 5, 0));
		characterList.add(new Character(ANSI_CYAN + "Stewardess" + ANSI_RESET, "Unknown", 3, 0));
		characterList.add(new Character(ANSI_CYAN + "Cook" + ANSI_RESET, "Unknown", 2, 0));
		
		//Passengers
		characterList.add(new Character(ANSI_CYAN + "Doctor" + ANSI_RESET, "Valentine Booth", 4, 0));
		characterList.add(new Character(ANSI_CYAN + "Clown" + ANSI_RESET, "Bam Bam", 3, 0));
		characterList.add(new Character(ANSI_CYAN + "Author" + ANSI_RESET, "Harper Greene", 3, 0));
		characterList.add(new Character(ANSI_CYAN + "Clown Prosecutor" + ANSI_RESET, "Rosalind Francis", 4, 0));
		characterList.add(new Character(ANSI_CYAN + "Rich Dude" + ANSI_RESET, "Leonard Hill", 4, 0));
		characterList.add(new Character(ANSI_CYAN + "Butler" + ANSI_RESET, "Horace Armstrong", 4, 0));
		
		characterList.add(new Character(ANSI_CYAN + "Ghost" + ANSI_RESET, "George Washington", 6, 0));
		
	}
	
	public static void fillObjects() {
		
		//Cook
		objects.add(new MyObject(ANSI_RED + "Frying Pan" + ANSI_RESET, 22, 0));
		objects.add(new MyObject(ANSI_RED + "Jar of Pickles" + ANSI_RESET, 22, 1));
		
		//Stewardess
		objects.add(new MyObject(ANSI_RED + "Steak" + ANSI_RESET, 20, 2));
		objects.add(new MyObject(ANSI_RED + "Carrots" + ANSI_RESET, 20, 3));
		objects.add(new MyObject(ANSI_RED + "Apple" + ANSI_RESET, 20, 4));
		objects.add(new MyObject(ANSI_RED + "Mystery" + ANSI_RESET, 20, 5));
		
		//Richie
		objects.add(new MyObject(ANSI_RED + "Money $$$" + ANSI_RESET, 27, 6));
		
		//Doctor
		objects.add(new MyObject(ANSI_RED + "Pills" + ANSI_RESET, 23, 7));
		
		//Clown
		objects.add(new MyObject(ANSI_RED + "Questionable Flowers" + ANSI_RESET, 24, 8));
		
		//Room1
		objects.add(new MyObject(ANSI_RED + "Pair of Socks" + ANSI_RESET, 10, 9));
		
		//Room2
		objects.add(new MyObject(ANSI_RED + "Bed" + ANSI_RESET, 11, 10));
		
		//Intro
		objects.add(new MyObject(ANSI_RED + "Engagement Ring" + ANSI_RESET, 0, 11));
		
		//Kitchen
		objects.add(new MyObject(ANSI_RED + "Spice Bottle" + ANSI_RESET, 2, 12));
		objects.add(new MyObject(ANSI_RED + "Baby Carrots" + ANSI_RESET, 2, 13));
		
	}

	public static void fillBoard(){
		
		System.out.println("");
		System.out.print("Loading Game");
		
		for(int i = 0; i < 3; i++) {
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println("");
		
		//Boxcars
		board.add(new Boxcar(BLUE + "Intro" + ANSI_RESET, 0, 0, "You are in an incomprehensible void while waiting for the train. The appearence of the room is constantly changing. You may be able to talk to people and collect objects while waiting for the train's harrowing call."));
		board.add(new Boxcar(PINK + "Caboose" + ANSI_RESET, 1, 0, "You are in the back of the train. There is not much to see here, but there may be secrets to unlock."));
		board.add(new Boxcar(ORANGE + "Kitchen" + ANSI_RESET, 2, 0, "You are in the kitchen. You smell the wonderful smell of carmalizing carrots, but what else could lie under the spices?"));
		board.add(new Boxcar(GREEN + "Main" + ANSI_RESET, 3, 0, "Everyone gathers in the main room for conversations, but what could you access from her?"));
		board.add(new Boxcar(YELLOW + "First Class" + ANSI_RESET, 4, 0, "Do you really want to sit with snobs like these? Here sit people who pay money to simply sit on nicer fabric. \nBut money brings allies so do with them what you will."));
		board.add(new Boxcar(RED + "Engine" + ANSI_RESET, 5, 0, "It is so hot in this room. It feels like there is a portal to the pits of hell here. But if you want to burn, I say do it!"));
		
		//Compartments
		board.add(new Compartment(YELLOW + "???" + ANSI_RESET, 6, 0, false, "You are in a large white wall room with items from the Revolutionary War littered around it. You have no idea how there is room for \nthis room on the train but it doesn't seem to care how so you won't either."));
		board.add(new Compartment(LBLUE + "Outside" + ANSI_RESET, 7, 0, true, "You step out onto the balcony at the end of the train. As the wind whistles past your ears you begin to feel uneasy, \nimagining that you might fall off and go for a tumble. Maybe you should head back inside."));
		board.add(new Compartment(BLUE + "Bathroom" + ANSI_RESET, 8, 0, false, "It is a small bathroom with barely enough room for you to stretch out your arms. There is a single square of toilet paper on the roll. \nYou decide it's best to go later."));
		board.add(new Compartment(RED + "Pantry" + ANSI_RESET, 9, 0, false, "The moment you step in the room your nose gets hit by the scent of a hundred spices. \nYou don't know how you know there are exactly a hundred spices, but they sure are strong!"));
		board.add(new Compartment(GREEN + "Bam Bam's Room" + ANSI_RESET, 10, 0, false, "A lot of tomfoolery seems to have happened in this room. The floor seems to be on the ceiling and the ceiling seems to be on the floor. \nThere a a number of brightly colored bags on the floor."));
		board.add(new Compartment(PINK + "My Room" + ANSI_RESET, 11, 0, true, "Your room is small but clean. The bed looks cozy, the suitcase is neat, and the mice in the wall are comfortable. Wait, there's mice-?!"));
		board.add(new Compartment(BLUE + "Harper Greene's Room" + ANSI_RESET, 12, 0, false, "This room is cozy and warm. It makes you want to curl up with a book and read."));
		board.add(new Compartment(RED + "Rosalind Francis' Room" + ANSI_RESET, 13, 0, false, "This room is just as small as the others, case files litter the floor and a big poster of a clown wih a red 'X' is taped to the wall."));
		board.add(new Compartment(ORANGE + "The Room of Leonard Hill (and Horace, but he doesnt matter)" + ANSI_RESET, 14, 0, false, "This room appears to be made of marble, which doesn't surprise you since this is Leonard's Room... and Horace's too I guess. \nA number a stuffed animals make a pile in the corner."));
		board.add(new Compartment(GREEN + "Valentine Booth's Room" + ANSI_RESET, 15, 0, false, "Why did the matress go to the doctor? It had spring fever. No, but seriously, this is the bounciest bed I've ever seen."));
		
		board.add(new Boxcar(LBLUE + "The Driving Compartment" + ANSI_RESET, 16, 0, "Do you want to make the sound? Come on pull the lever. Make the train whistle. Nothing else to do here."));
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Game Loaded!");
		System.out.println("");
	}
	
	public static void makePlayer() {
		
		System.out.println("Hello! If you would like to buy a train ticket, please enter your name.");
		String name = userInput.nextLine();
		player = new Player(name, 200, 0);
		System.out.println("Sign here.");
		enter = userInput.nextLine();
		System.out.println("And here.");
		enter = userInput.nextLine();
		System.out.println("And here.");
		enter = userInput.nextLine();
		System.out.println("Your social security number here-");
		enter = userInput.nextLine();
		System.out.println("Thank you! Have a nice day.");
	}

	public static String padRight(String s, int n) {
	     return String.format("%-" + n + "s", s);  
	}
}
