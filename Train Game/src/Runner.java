import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.*;

public class Runner {

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
	
	int choice = 1;
	static String choice2 = "";
	
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
		//charDisplay(22);
		makePlayer();
		displayRoom();

	}
//	public static void gameOn() {
//		
//		int counter= 0;
//		while(game) {
//			
//			for(int i = 0; i < playersList.size(); i++) {
//				
//				if(playersList.get(i).isBankrupt() == false) {
//					
//					System.out.println("-----------------------------------------");
//					//System.out.println(playersList.get(i).getCharacter());
//					display(i);
//					rollDice();
//					move(i);
//					getSpace(i);
//					display(i);
//					//System.out.println("_________________________________________");
//				}
//				counter++;
////				if(counter == 50) {
////					
////					game = false;
////				}
//				
//			}
//			
//			
//			if(playersList.size() == 1)
//				continue;
//			
//			
//			int bCounter = 0;
//			for(int j = 0; j < playersList.size(); j++) {
//				
//				if(playersList.get(j).isBankrupt()) {
//					
//					bCounter++;
//				}
//			}
//			
//			if(bCounter >= playersList.size() - 1) {
//				
//				game = false;
//			}
//		}
//	}
//	
	
	public static void main(){
		
		displayRoom();
		System.out.println("What would you like to do?");
		System.out.println("1) Left Door");
		System.out.println("1) Left Door");
		
		switch(choice)
		{
		case 0:
				{
					bedroom();
					break;
				}
		case 1:
				{
					hall();
					break;
				}
		case 2:
				{
					lawn();
					break;
				}
		}	
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
		
	    System.out.println("You are in: " + board.get(player.getLocation()).getName());
	    System.out.println("It is day " + board.get(player.getLocation()).getDay());
	    System.out.println(board.get(player.getLocation()).getDescription());
	    System.out.println("People in the room:");

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
		board.add(new Boxcar("Intro", 0, "You are in an incomprehensible void while waiting for the train. The appearence of the room is constantly changing. You may be able to talk to people and collect objects while waiting for the train's harrowing call."));
		board.add(new Boxcar("Caboose", 0, "You are in the back of the train. There is not much to see here, but there may be secrets to unlock."));
		board.add(new Boxcar("Kitchen", 0, "You are in the kitchen. You smell the wonderful smell of carmalizing carrots, but what else could lie under the spices?"));
		board.add(new Boxcar("Main", 0, "Everyone gathers in the main room for conversations, but what could you access from her?"));
		board.add(new Boxcar("First Class", 0, "Do you really want to sit with snobs like these? Here sit people who pay money to simply sit on nicer fabric. \nBut money brings allies so do with them what you will."));
		board.add(new Boxcar("Engine", 0, "It is so hot in this room. It feels like there is a portal to the pits of hell here. But if you want to burn, I say do it!"));
		board.add(new Boxcar("The Driving Compartment", 0, "Do you want to make the sound? Come on pull the lever. Make the train whistle. Nothing else to do here."));
		//Compartments
		board.add(new Compartment("???", 0, false, "You are in a large white wall room with items from the Revolutionary War littered around it. You have no idea how there is room for \nthis room on the train but it doesn't seem to care how so you won't either."));
		board.add(new Compartment("Outside", 0, true, "You step out onto the balcony at the end of the train. As the wind whistles past your ears you begin to feel uneasy, \nimagining that you might fall off and go for a tumble. Maybe you should head back inside."));
		board.add(new Compartment("Bathroom", 0, false, "It is a small bathroom with barely enough room for you to stretch out your arms. There is a single square of toilet paper on the roll. \nYou decide it's best to go later."));
		board.add(new Compartment("Pantry", 0, false, "The moment you step in the room your nose gets hit by the scent of a hundred spices. \nYou don't know how you know there are exactly a hundred spices, but they sure are strong!"));
		board.add(new Compartment("Bam Bam's Room", 0, false, "A lot of tomfoolery seems to have happened in this room. The floor seems to be on the ceiling and the ceiling seems to be on the floor. \nThere a a number of brightly colored bags on the floor."));
		board.add(new Compartment("My Room", 0, true, "Your room is small but clean. The bed looks cozy, the suitcase is neat, and the mice in the wall are comfortable. Wait, there's mice-?!"));
		board.add(new Compartment("Harper Greene's Room", 0, false, "This room is cozy and warm. It makes you want to curl up with a book and read."));
		board.add(new Compartment("Rosalind Francis' Room", 0, false, "This room is just as small as the others, case files litter the floor and a big poster of a clown wih a red 'X' is taped to the wall."));
		board.add(new Compartment("The Room of Leonard Hill (and Horace, but he doesnt matter)", 0, false, "This room appears to be made of marble, which doesn't surprise you since this is Leonard's Room... and Horace's too I guess. \nA number a stuffed animals make a pile in the corner."));
		board.add(new Compartment("Valentine Booth's Room", 0, false, "Why did the matress go to the doctor? It had spring fever. No, but seriously, this is the bounciest bed I've ever seen."));
		
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
