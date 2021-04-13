package datastructure;

import databases.ConnectToSqlDB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DataReader {
	public static void main(String[] args) {
		String textFile = System.getProperty("user.dir") + "/src/data/self-driving-car";
		FileReader fileRead = null;
		BufferedReader buffRead = null;
		String line;
		ConnectToSqlDB connect = new ConnectToSqlDB();
		//Created stack and linked list
		Stack<String> stack = new Stack<>();
		LinkedList<String> linkedList = new LinkedList<>();
		int count = 1;

		try {
			fileRead = new FileReader(textFile);
			buffRead = new BufferedReader(fileRead);
			while ((line = buffRead.readLine()) != null) {
				System.out.println(line);

				//System.out.println("***Store each line in Database***");
				connect.insertDataFromStringToSqlTable(line, "selfdriving_car", "Text");

				//System.out.println("***Read the lines from the database***");
				ConnectToSqlDB.readDataBase("selfdriving_car", "Text");

				//Storing each word in my text in LinkedList and Stack
				String[] stringOfWords = line.split(" ");
				for (int i = 0; i < stringOfWords.length; i++) {
					stack.push(stringOfWords[i]);
					linkedList.add(stringOfWords[i]);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}


		System.out.println("******LinkedList: nodes****");

		Iterator<String> ite = linkedList.iterator();
		while (ite.hasNext()) {
			System.out.print("Node " + count++ + " : ");
			System.out.println(ite.next());
		}
		//store words in database
		connect.insertDataFromArrayListToSqlTable(linkedList, "self_driving_car_linkedlist", "line");

		System.out.println("LinkedList FIFO: ");
		while (!linkedList.isEmpty()) {
			System.out.println(linkedList.remove() + " ");
		}

		System.out.println("****Popping/Pushing/peaking/Searching elements in Stack*****");

		System.out.println("Stack LIFO: ");
		System.out.println("****Popping/Pushing/peaking/Searching elements in Stack*****");
		System.out.println("Pop: " + stack.pop());
		System.out.println("After pop: " + stack);
		System.out.println("Peek: " + stack.peek());
		System.out.println("After peek: " + stack);
		System.out.println("Push: " + stack.push("PNT-Midterm"));
		System.out.println("After push: " + stack);
		System.out.println("Search: " + stack.search("PNT-Midterm"));
		System.out.println("Search: " + stack.search("in"));

		for (String file : stack) {
			System.out.println("Stack for each: "+file);
		}

		Iterator<String> sta = stack.iterator();
		while (sta.hasNext()) {
			System.out.println("Iterating stack: "+sta.next());

		}

		//Store each word in stack in the database
		connect.insertDataFromArrayListToSqlTable(stack, "self_driving_car_stack", "line");



		//reading from database

		try {
			ConnectToSqlDB.readDataBase("self_driving_car_stack", "line");
			ConnectToSqlDB.readDataBase("self_driving_car_linkedlist", "line");
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}




