import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner2 {

	static ArrayList <ISetting> board = new ArrayList<ISetting>();
	static ArrayList <Object> objects = new ArrayList<Object>();
	static ArrayList <Character> characterList = new ArrayList<Character>();
	static Scanner file;
	
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
		fillBoard();

	}
	
public static void charDisplay(/*int char*/) {
		
		//System.out.println("______________________________________________________");
		System.out.println(characterList().getName());
		System.out.println(BOLD + "Bond: $" + ANSI_RESET + playersList.get(0).getBank());
		
		if(playersList.get(player).isJail() == true) {
			
			System.out.println(BOLD + "Jail Status: " + ANSI_RESET + ANSI_RED + "ARRESTED" + ANSI_RESET);
		}else {
			
			System.out.println(BOLD + "Jail Status: " + ANSI_RESET + ANSI_CYAN + "FREE" + ANSI_RESET);
		}

		System.out.println("                    " + UNDERLINED + "Assets" + ANSI_RESET);
		
		int counter = 0;
		ArrayList<IProperty> mine = new ArrayList<IProperty>();
		
		for(int i = 0; i < board.size(); i++) {
			
			IProperty pro = board.get(i);
			
			if(pro.getOwner() == player) {
				
				//System.out.println("Name " + pro.getName());
				mine.add(pro);
				counter++;
			}
			
//			if(pro.getOwner() != 5) {
//				
//				System.out.println("Owner " + pro.getOwner());
//				System.out.println("Name " + pro.getName());
//			}
		}
		
		for(int z = 0; z < mine.size(); z++) {
			
			ISetting pro = mine.get(z);
			
			if(z%2 == 0 && z > 0) {
				
				System.out.println("");
			}
			
			System.out.print(padRight(pro.getName(), 30));
		}
		
		if(counter == 0) {
			
			System.out.println("No properties owned");
		}
		System.out.println("");
		//System.out.println("______________________________________________________");
	}
	
	public static void fillCharacters() {
		
		characterList.add(new Character(ANSI_CYAN + "Ticket CLerk" + ANSI_RESET, "Unknown", 0));
		characterList.add(new Character(ANSI_CYAN + "Engineer" + ANSI_RESET, "Unknown", 0));
		characterList.add(new Character(ANSI_CYAN + "Conductor" + ANSI_RESET, "Unknown", 0));
		characterList.add(new Character(ANSI_CYAN + "Brakeman" + ANSI_RESET, "Unknown", 0));
		characterList.add(new Character(ANSI_CYAN + "Stewardess" + ANSI_RESET, "Unknown", 0));
		characterList.add(new Character(ANSI_CYAN + "Cook" + ANSI_RESET, "Unknown", 0));
		
		characterList.add(new Character(ANSI_CYAN + "Doctor" + ANSI_RESET, "Valentine Booth", 0));
		characterList.add(new Character(ANSI_CYAN + "Clown" + ANSI_RESET, "Bonobo", 0));
		characterList.add(new Character(ANSI_CYAN + "Author" + ANSI_RESET, "Harper Greene", 0));
		characterList.add(new Character(ANSI_CYAN + "Clown Prosecutor" + ANSI_RESET, "Rosalind Francis", 0));
		characterList.add(new Character(ANSI_CYAN + "Rich Dude" + ANSI_RESET, "Leonard Hill", 0));
		characterList.add(new Character(ANSI_CYAN + "Butler" + ANSI_RESET, "Horace Armstrong", 0));
		
	}

	public static void fillBoard(){

		//Boxcars
		board.add(new Boxcar("Intro", 0));
		board.add(new Boxcar("Caboose", 0));
		board.add(new Boxcar("Kitchen", 0));
		board.add(new Boxcar("Main", 0));
		board.add(new Boxcar("First Class", 0));
		board.add(new Boxcar("Engine", 0));
		//Compartments
		board.add(new Compartment("???", 0, false));
		board.add(new Compartment("Outside", 0, false));
		board.add(new Compartment("Bathroom", 0, false));
		board.add(new Compartment("Pantry", 0, false));
		board.add(new Compartment("Bam Bam's Room", 0, false));
		board.add(new Compartment("My Room", 0, true));
		board.add(new Compartment("Harper Greene's Room", 0, false));
		board.add(new Compartment("Rosalind Francis' Room", 0, false));
		board.add(new Compartment("The Room of Leonard Hill (and Horace, but he doesnt matter)", 0, false));
		board.add(new Compartment("Valentine Booth's Room", 0, false));
		//One more boxcar
		board.add(new Boxcar("Driving Area", 0));
	}

	public static String padRight(String s, int n) {
	     return String.format("%-" + n + "s", s);  
	}
}
