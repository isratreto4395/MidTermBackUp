package datastructure;

import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseMap {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 */

		UseMap.hashMapAndLinkedList();
	}
	//use of map
	public static void useOfMap() {

		Map<String, Double> shoppingList = new HashMap<>();
		shoppingList.put("Chip", 4.50);
		shoppingList.put("cookies", 3.75);
		shoppingList.put("Cereal", 4.50);
		shoppingList.put("Chocolate", 1.75);

		System.out.println(shoppingList);
		for (Map.Entry list : shoppingList.entrySet()) {
			System.out.println(list.getKey() + " : " + list.getValue());
		}

		shoppingList.put("Spinach", 2.34);
		shoppingList.remove("Spinach");
		shoppingList.containsKey("Chip");
		shoppingList.containsValue(4.50);

	}
		//use of HashMap and Linked List

	public static void hashMapAndLinkedList(){
		//first list
		List<String> typesOfCookies = new ArrayList<>();
		typesOfCookies.add("Chocolate Chip");
		typesOfCookies.add("Macaroon");
		typesOfCookies.add("Fortune cookie");
		typesOfCookies.add("Oatmeal cookie");

		ConnectToSqlDB.insertDataFromArrayListToSqlTable(typesOfCookies,"types_of_cookies","cookies");

		//Read the data from the database
		try {
			ConnectToSqlDB.readDataBase("types_of_cookies","cookies");
		} catch (Exception e) {
			e.printStackTrace();
		}

		//second list
		List<String> typesOfChip = new ArrayList<>();
		typesOfChip.add("Doritos");
		typesOfChip.add("Lays Barbeque");
		typesOfChip.add("Onion Rings");
		typesOfChip.add("Pran Potato Cracker");

		ConnectToSqlDB.insertDataFromArrayListToSqlTable(typesOfChip,"types_of_chips","chips");

		//Read the data
		try {
			ConnectToSqlDB.readDataBase("types_of_chips","chips");
		} catch (Exception e) {
			e.printStackTrace();
		}

		//Use of map and List together
		Map<String,List<String>> types = new HashMap<>();
		typesOfChip.addAll(typesOfCookies);
		types.put("Snacks_types",typesOfChip);
		//types.put("Afternoon_Snacks",typesOfCookies);

		for(Map.Entry<String, List<String>> listEntry : types.entrySet()){
			System.out.println(
					listEntry.getKey()+" : "+listEntry.getValue());

			ConnectToSqlDB.insertDataFromArrayListToSqlTable(listEntry.getValue(), "Snacks",listEntry.getKey());
		}

		}

	}



