import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class HashMapExample {
	public static void main(String[] args) {
		//Create a HashMap with String as key and LinkedList as value
		//The key will be the state code (ie. WI, MN, IL, IA...)
		//The list in the value will store city names.
		//Make linked list for WI
		LinkedList<String> wisconsinCities = new LinkedList<String>();
		wisconsinCities.add("Menomonie");
		wisconsinCities.add("Eau Claire");
		HashMap<String, LinkedList<String>> citiesByState;
		citiesByState = new HashMap<String, LinkedList<String>>();
		//add wisconsinCities as value for key WI
		citiesByState.put("WI", wisconsinCities);
		//add Hudson to WI
		//need to get list with key "WI" to add Hudson to Linked List
		citiesByState.get("WI").add("Hudson");
		//add IL with an empty list to HashMap
		citiesByState.put("IL", new LinkedList<String>());
		//add DeKalb list for IL in HashMap
		citiesByState.get("IL").add("DeKalb");
		//add Chicago list for IL in HashMap
		citiesByState.get("IL").add("Chicago");
		
		//add another state with empty LinkedList to HashMap
		citiesByState.put("CA", new LinkedList<String>());
		
		//add two cities for this state
		citiesByState.get("CA").add("Huntington Beach");
		citiesByState.get("CA").add("San Diego");
		
		printCitiesByState(citiesByState);
	}

	public static void printCitiesByState(HashMap<String, LinkedList<String>> map) {
		//Iterate through keys and print out list of cities for each key
		String s = "State and cities:\n";
		//loop through keys
		for (String key : map.keySet()) {
			s += "State: " + key + ":" ;
			//Get list of cities and iterate through list for this key
			LinkedList<String> cities = map.get(key);
			Iterator<String> iterator = cities.iterator();
			while(iterator.hasNext()) {
				String city = iterator.next();
				s += " ->" + city;
			}
			s += "\n";
		}
		System.out.println(s);
	}
}