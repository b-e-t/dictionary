import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class: Assignment4
 * Purpose: Create a dictionary, provide a menu to Reset the tree, enter a word, load a file, search for a word, show how many words are in the dictionary
 * Author: Brian Thompson
 * Date: March 25, 2016
 * Data: 	in: Scanner - get menu choice and load a file through Scanner
 * 			key: Scanner - iterate through file
 * 			file: String - store file name
 * 			word: String - store word
 * 			dictionary: Dictionary - TreeMap to store words
 * Methods: main
 */

public class Assign4 {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		int choice = 0;
		String file;
		String word;
		Dictionary dictionary = new Dictionary();
		
		try{
			do{
				System.out.println("1. Reset tree to empty");
				System.out.println("2. Enter a word to add to the dictionary");
				System.out.println("3. Enter a file to add to the dictionary");
				System.out.println("4. Enter a word to search for in the dictionary");
				System.out.println("5. Display number of nodes in the dictionary");
				System.out.println("0. Exit");
	
				choice = in.nextInt();
				in.nextLine();
				//MENU
				switch(choice){
				case 1://RESET TREE TO EMPTY
					System.out.println("\nThe tree is empty.\n");
					dictionary.clearDictionary();
					break;
				case 2://READ A STRING FROM KEYBOARD AND ADD TO DICTIONARY
					System.out.print("Enter a word to process: ");
					word = in.nextLine();
					dictionary.addToDictionary(word.toLowerCase().replaceAll("\\W", "").trim());
					break;
				case 3://READ FROM FILE AND ADD TO DICTIONARY
					System.out.print("Enter a file to process: ");
					file = in.nextLine();
					try(Scanner key = new Scanner(new File(file))){
						while(key.hasNext()){
							word = key.next();
							dictionary.addToDictionary(word.toLowerCase().replaceAll("\\W", "").trim());
						}
					}catch(FileNotFoundException e){
						System.out.println("That file doesn't exist!");
					}
					break;
				case 4://SEARCH FOR A WORD AND DISPLAY OCCURENCES
					System.out.print("Enter a word to search for: ");
					word = in.nextLine();
					dictionary.searchDictionary(word.toLowerCase().replaceAll("\\W", "").trim());
					break;
				case 5://DISPLAY NUMBER OF NODES IN DICTIONARY
					dictionary.displayNodes();
					break;
				case 0://EXIT
					System.out.println("\n\nYou have chosen to exit.");
					System.out.println("********EXITING*********");
					break;
				}//end MENU
			}while(choice!=0);
		}catch(InputMismatchException e){
			System.out.println("You have entered an inappropriate choice, as punishment the program is terminating.");
		}
	}//end main
}//end class Assign4
