package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	
	
	
	public static void main(String[] args) {
		Map<String, Double> nh = new HashMap<>();
		nh.put("Maya", 70.0);
		nh.put("Nia", 59.5);
		nh.put("Ines", 66.0);
		System.out.println("Name: ");
		Scanner in = new Scanner(System.in);
		String name = in.next();
		while (name.equals("quit") != true) {
			
			if (nh.get(name)== null) {
				System.out.println("No information for given name. Please enter new name or enter 'quit' to quit.");
				System.out.println("Name: ");
				name = in.next();
			}
			else {
				System.out.println("Height: " + nh.get(name));
				System.out.println("Name: ");
				name = in.next();
				
			}
		}
		System.out.println("end.");
		
		

	}
}
