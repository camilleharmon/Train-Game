import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Runner {

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
		//make game here

	}
	
	public static void display(int player) {
		
		//System.out.println("______________________________________________________");
		System.out.println(playersList.get(player).getCharacter());
		System.out.println(BOLD + "Bank: $" + ANSI_RESET + playersList.get(player).getBank());
		
		if(playersList.get(player).isJail() == true) {
			
			System.out.println(BOLD + "Jail Status: " + ANSI_RESET + ANSI_RED + "ARRESTED" + ANSI_RESET);
		}else {
			
			System.out.println(BOLD + "Jail Status: " + ANSI_RESET + ANSI_CYAN + "FREE" + ANSI_RESET);
		}

		System.out.println("                    " + UNDERLINED + "Assets" + ANSI_RESET);
		
		int counter = 0;
		ArrayList<ISetting> mine = new ArrayList<ISetting>();
		
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
			
			IProperty pro = mine.get(z);
			
			if(z%2 == 0 && z > 0) {
				
				System.out.println("");
			}
			
			System.out.print(padRight(pro.getName(), 30));
		}
		
		if(counter == 0) {
			
			System.out.println("No properties owned");
		}
		System.out.println("");
		
	}
	
public static void fillCharacters() {
		
		characterList.add(new String(ANSI_CYAN + "Fred" + ANSI_RESET));
		
	}

	public static void fillBoard() throws IOException{
		
		System.out.print("Making board");
		
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
		
		for(int i = 0; i<40; i++) {
			
			String type = file.next();
			
			if(type.equals("Estate")) {
				
				String name = file.next();
				int num = file.nextInt();
				int price = file.nextInt();
				int owner = file.nextInt();
				boolean fs = file.nextBoolean();
				int level = file.nextInt();
				String group = file.next();
				int rent1 = file.nextInt();
				
				if(group.equals("Brown")) {
					
					board.add(new Estate(ANSI_MAGENTA + name + ANSI_RESET, num, price, owner, fs, level, group, rent1));
				}else if(group.equals("Azure")) {
					
					board.add(new Estate(LBLUE + name + ANSI_RESET, num, price, owner, fs, level, group, rent1));
				}else if(group.equals("Pink")) {
					
					board.add(new Estate(PINK + name + ANSI_RESET, num, price, owner, fs, level, group, rent1));
				}else if(group.equals("Orange")) {
					
					board.add(new Estate(ORANGE + name + ANSI_RESET, num, price, owner, fs, level, group, rent1));
				}else if(group.equals("Red")) {
					
					board.add(new Estate(RED + name + ANSI_RESET, num, price, owner, fs, level, group, rent1));
				}else if(group.equals("Yellow")) {
					
					board.add(new Estate(YELLOW + name + ANSI_RESET, num, price, owner, fs, level, group, rent1));
				}else if(group.equals("Green")) {
					
					board.add(new Estate(GREEN + name + ANSI_RESET, num, price, owner, fs, level, group, rent1));
				}else if(group.equals("Green")) {
					
					board.add(new Estate(BLUE + name + ANSI_RESET, num, price, owner, fs, level, group, rent1));
				}
				
				board.add(new Estate(name, num, price, owner, fs, level, group, rent1));
				
			}else if(type.equals("Factory")) {
				
				String name = file.next();
				int num = file.nextInt();
				int price = file.nextInt();
				int owner = file.nextInt();
				boolean fs = file.nextBoolean();
				int level = file.nextInt();
				String group = file.next();
				int rent1 = file.nextInt();
				
				board.add(new Factory(name, num, price, owner, fs, level, group, rent1));
			}else if(type.equals("Restaurant")) {
				
				String name = file.next();
				int num = file.nextInt();
				int price = file.nextInt();
				int owner = file.nextInt();
				boolean fs = file.nextBoolean();
				int level = file.nextInt();
				String group = file.next();
				int rent1 = file.nextInt();
				
				board.add(new Restaurant(name, num, price, owner, fs, level, group, rent1));
			}else if(type.equals("Go")) {
				
				String name = file.next();
				int num = file.nextInt();
				
				board.add(new Go(name, num));
			}else if(type.equals("Jail")) {
				
				String name = file.next();
				int num = file.nextInt();
				
				board.add(new Jail(name, num));
			}else if(type.equals("GoToJail")) {
				
				String name = file.next();
				int num = file.nextInt();
				
				board.add(new GoToJail(name, num));
			}else if(type.equals("FreeSpace")) {
				
				String name = file.next();
				int num = file.nextInt();
				
				board.add(new FreeSpace(name, num));
			}else if(type.equals("Jeepers")) {
				
				String name = file.next();
				int num = file.nextInt();
				
				board.add(new Jeepers(name, num));
			}else if(type.equals("CardSpace")) {
				
				String name = file.next();
				int num = file.nextInt();
				boolean iz = file.nextBoolean();
				
				board.add(new CardSpace(name, num, iz));
			}
		}
		
//		for(int k = 0; k < board.size(); k++) {
//			
//			IProperty pro = board.get(k);
//			System.out.println(pro.getName());
//		}
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Board Complete!");
		System.out.println("");
	}
}
