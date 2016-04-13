import java.util.TreeMap;

/**
 * Class: Assignment4
 * Purpose: Create a dictionary, provide a menu to Reset the tree, enter a word, load a file, search for a word, show how many words are in the dictionary
 * Author: Brian Thompson
 * Date: March 25, 2016
 * Data: 	dictionary: TreeMap - Tree to store/search words passed into this class
 * 			Integer: instances - variable to store result if word exists
 * 			
 * Methods: clearDictionary(void) - clears all nodes in dictionary
 * 			addToDictionary(String) - adds String to TreeMap
 * 			searchDictionary(String) - searches TreeMap for instance of String
 * 			displayNodes(void) - displays number of nodes in TreeMap
 */

public class Dictionary {
	private TreeMap<String, Integer> dictionary = new TreeMap<String, Integer>();
	private Integer instances;
	
	public void clearDictionary(){
		dictionary.clear();
	}//end clearDictionary
	
	public void addToDictionary(String word){
		if(word.isEmpty()==false){
			instances = dictionary.get(word);
			if(dictionary.size()<1||instances==null){
				dictionary.put(word, 1);
			}
			else{
				dictionary.put(word, instances+1);
			}
		}
	}//end addToDictionary
	
	public void searchDictionary(String word){
		instances=dictionary.get(word);
		if(instances==null)
			instances=0;
		System.out.println(word+" occurs "+instances+" times");
	}//end searchDictionary
	
	public void displayNodes(){
		System.out.println("There are "+dictionary.size()+" nodes");
	}//end displayNodes
	
}//end class Dictionary
