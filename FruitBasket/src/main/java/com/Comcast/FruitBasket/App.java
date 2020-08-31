package com.Comcast.FruitBasket;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Fruit Basket App Console application (CLI) that allows a user to process a
 * CSV-file and produce a summary report from it.
 * 
 * @Author RoseNakiberu
 */

public class App {

	// Global variables
	static List<String[]> allLines = new ArrayList<String[]>(); // fruits are initially stored here as string[] from csv
	static List<Fruit> basket = new ArrayList<>(); // contains the basket that has all the fruits

	// Program starts here
	public static void main(String[] args) {
		System.out.println("Fruit Basket App!");
		int x = 0;
		// call mainMenu() and perpetually go back there until user uses quit option
		while (x != 1) {
			mainMenu();
		}

		// in the unlikely scenario user is able to break free of infinite loop,
		// terminate application
		System.out.println("Thanks for using the Fruit Basket App!");
		System.exit(2);
	}

	private static void mainMenu() {

		System.out.println("\n|==========\033[34mFRUIT BASKET APP!\033[0m==========|");
		System.out.println("|==============\033[34mMAIN MENU\033[0m==============|");
		System.out.println("|        \033[36mWould You like to do?\033[0m        |");
		System.out.println("|1: \033[36mLoad CSV file\033[0m                     |");
		System.out.println("|2: \033[36mLook in Basket\033[0m                    |");
		System.out.println("|3: \033[36mGenerate Report\033[0m                   |");
		System.out.println("|4: \033[36mExit\033[0m                              |");
		System.out.println("|-------------------------------------|");
		System.out.println("|\033[36mType an Option Number or '\033[0mq\033[36m' to quit\033[0m |");
		System.out.println("|=====================================|");
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int option = 0;// initializing it so that it enters the while loop for the 1st time
		while (option != 10) { // keeps the program waiting here for user input
			switch (s) {
			case "1":
				loadCSV(scan);
				return;
			case "2":
				System.out.println("Looking in Basket. . .");
				if (basket.isEmpty() == true) {
					System.out.println("Basket is empty!\nMight I suggest you load in a CSV?");
				} else {
					basket.forEach(item -> {
						System.out.println(item);
					});
				}
				return;
			case "3":
				genReport();
				return;
			case "4":
				System.out.println("Okay! Exiting!");
				System.out.println("Thanks for using the Fruit Basket App!");
				scan.close();
				System.exit(0);
				return;
			case "q":
				System.out.println("Okay! Quitting!");
				System.out.println("Thanks for using the Fruit Basket App!");
				scan.close();
				System.exit(0);
				return;
			default:
				System.out.println("Invalid Selection!\nMake another Selection!");
				mainMenu();
				return;
			}
		}
	}

	// method to create a report
	private static void genReport() {

//		Total count of all fruits in the CVS-file
		System.out.println("Total number of fruit: \n" + basket.size() + "\n");
//		Total count of distinct fruit types in the basket
		System.out.println("Total types of fruit: \n" + uniqueFruit() + "\n");
//		The fruit type and age of the oldest fruit in the basket in days
		System.out.println("Oldest fruit & age: ");
		oldFruit();
//		Count of all fruits grouped by fruit types in descending order
		System.out.println("\nThe number of each type of fruit in descending order: ");
		typeFruit();
//		Count of all fruits grouped by fruit type and all characteristics in descending order
		System.out.println("\nThe various characteristics (count, color, shape, etc.) of each fruit by type: ");
		charFruit();
	}

	private static void charFruit() {
		ArrayList<String> fruitList = new ArrayList<String>(); // to store all the names of the fruit

		// iterate through basket putting the name of each fruit in a List
		for (int i = 0; i < basket.size(); i++) {
			Fruit fruit = basket.get(i);
			fruitList.add(fruit.getFruit() + ": " + fruit.getChar1() + ", " + fruit.getChar2());
		}

		// get Frequencies
		countFrequencies2(fruitList);
	}

	private static void typeFruit() {
		ArrayList<String> fruitList = new ArrayList<String>(); // to store all the names of the oldest fruit

		// iterate through basket putting the name of each fruit in a List
		for (int i = 0; i < basket.size(); i++) {
			Fruit fruit = basket.get(i);
			fruitList.add(fruit.getFruit());
		}

		// get Frequencies
		countFrequencies(fruitList);
	}

	public static void countFrequencies(ArrayList<String> list) {
		// hashMap to store the frequency of element
		Map<String, Integer> hm = new HashMap<String, Integer>();
		// for every fruit in the basket get the current count and if its null add 1
		// otherwise add 1 to the current count
		for (String i : list) {
			Integer j = hm.get(i);
			hm.put(i, (j == null) ? 1 : j + 1);
		}

		// displaying the occurrence of elements in the arraylist
		for (Map.Entry<String, Integer> val : hm.entrySet()) {
			System.out.println(val.getKey() + ": " + val.getValue());
		}
	}

	public static void countFrequencies2(ArrayList<String> list) {
		// hashMap to store the frequency of element
		Map<String, Integer> hm = new HashMap<String, Integer>();
		// for every fruit in the basket get the current count and if its null add 1
		// otherwise add 1 to the current count
		for (String i : list) {
			Integer j = hm.get(i);
			hm.put(i, (j == null) ? 1 : j + 1);
		}

		// displaying the occurrence of elements in the arraylist
		for (Map.Entry<String, Integer> val : hm.entrySet()) {
			System.out.println(val.getValue() + " " + val.getKey());
		}
	}

	private static void oldFruit() {
		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
		List<String> oldFruitList = new ArrayList<String>(); // to store all the names of the oldest fruit
		int x = 0; // to store oldest age

		// iterate through basket putting the name and age of each fruit in a TreeMap
		for (int i = 0; i < basket.size(); i++) {
			Fruit fruit = basket.get(i);
			tmap.put(fruit.getAge(), fruit.getFruit());
		}

		// find the fruit with the oldest age
		Map.Entry<Integer, String> maxEntry = null;
		for (Map.Entry<Integer, String> entry : tmap.entrySet()) {
			if (maxEntry == null || entry.getKey().compareTo(maxEntry.getKey()) > 0) {
				maxEntry = entry;
			}
		}

		// get oldest age
		x = maxEntry.getKey();
		// look through basket picking out every food with this oldest age
		for (int i = 0; i < basket.size(); i++) {
			Fruit fruit = basket.get(i);
			if (fruit.getAge() == x) {
				oldFruitList.add(fruit.getFruit());
			}
		}

		// display all oldest fruits
		for (String temp : oldFruitList) {
			System.out.println(temp + ": " + x);
		}
		return;
	}

//returns the unique count of fruit in basket
	private static int uniqueFruit() {
		String s;
		int x = 0;
		HashSet<String> unifru = new HashSet<String>();

		for (int i = 0; i < basket.size(); i++) {
			Fruit fruit = basket.get(i);
			s = fruit.getFruit();
			unifru.add(s);
		}

		// get the number of unique fruit
		x = unifru.size();
		// pass number back to method caller
		return x;
	}

	// method to read/display csv
	private static void readCSV() {
		
		try { //try+catch checks csv file structure is in required format
			System.out.println("Reading CSV...one moment\n");
		
		// check to see if a csv was loaded
		if (allLines.size() == 0) {
			System.out.println("No CSV loaded!\n");
		}
				
		// display contents of file
		for (int i = 0; i < allLines.size(); i++) {

			String[] temp = allLines.get(i);

			for (int j = 0; j < temp.length; j++) {
				System.out.println(temp[j]);
			}

			if (i == 0) { // to skip over the labels
			} else {
				Fruit fruit = new Fruit(temp[0], Integer.parseInt(temp[1]), temp[2], temp[3]);
				basket.add(fruit);
			}
			System.out.println();
		}
		} catch (NumberFormatException e) { //checks age of fruit is an integer
			System.out.println("EXIT CODE 11.");
			System.out.println("File contains invalid data, and does not match the required CSV structure");
			System.exit(11);
		} catch (ArrayIndexOutOfBoundsException e1) { //check csv for additional data not formatted elsewhere in file
			System.out.println("EXIT CODE 12.");
			System.out.println("File has extraneous data, and does not match the required CSV structure");
			System.exit(12);
		} catch (Exception e2) { //all other exceptions
			System.out.println("EXIT CODE 13.");
			System.out.println("File structure does not match the CSV structure");
			System.exit(13);
		}
	}

	// method to load csv
	private static void loadCSV(Scanner scan) {
		basket.clear(); //ensure basket is empty
		allLines.clear(); //ensure previous csv read is wiped from runtime memory
		
		System.out.println("Enter the Path to CSV:");
		String row;
		try {
			// get path
			Scanner scan1 = new Scanner(System.in);
			String path = scan1.nextLine();

			// read CSV file
			System.out.println("Loading CSV...one moment");
			BufferedReader csvReader = new BufferedReader(new FileReader(path));
			// while loop if there is another line to read, add to the list
			while ((row = csvReader.readLine()) != null) {
				allLines.add(row.split(","));
			}
			csvReader.close();
			
			// requirement check CSV format
			readCSV();
			
			System.out.println("Loaded successfully!");
		} catch (IOException e) { // if there is no file to read, catch the IOException
			System.out.println("EXIT CODE 10.");
			System.out.println("Invalid location/File does not exist.");
			// e.printStackTrace(); //no need to print the stack trace
			System.exit(10);
		}
	}
}