package datastructure;

import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class UseArrayList {

    public static void main(String[] args) {
        /*
         * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
         * Use For Each loop and while loop with Iterator to retrieve data.
         * Store all the sorted data into one of the databases.
         *
         */
        //UseArrayList.arrayListExample();
        //UseArrayList.storeDatatoSQL();
        UseArrayList.readMyData();

    }

    public static ArrayList<String> arrayListExample() {

        ArrayList<String> bills = new ArrayList<>();
        bills.add("Hospital Bill");
        bills.add("Electricity Bill");
        bills.add("Water Bill");
        bills.add("Phone Bill");
        bills.add("Internet Bill");
        bills.add("Credit Card Bills");
        //adding by index, and element
        bills.add(6, "Rent");
        bills.add(7, "Loans");

        System.out.println("Printing the Array: " + bills);

        //retrieving all the elements using for each loop
        for (String bill : bills) {
            System.out.println("Retrieving all the elements from the ArrayList: " + bill);
        }
        //removing an element at index
        bills.remove(6);
        System.out.println("After removing an element: " + bills);

        //size of the Arraylist
        System.out.println("Size of the ArrayList: " + bills.size());

        System.out.println("Peek Element: " + bills.get(0));

        //replace an element at a index
        bills.set(6, "Mortgage");
        System.out.println(bills);

        //Using Iterator to retrieve data
        Iterator<String> iterate = bills.iterator();
        while (iterate.hasNext()) {
            System.out.println("Iterating to retrieve data: " + iterate.next());
        }

        //Finding a specific element from the array
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i).equals("Mortgage")) {
                System.out.println("found the specific element: " + bills.get(i));
            }

            System.out.println();

            try {
                for (int m = 0; m < bills.size(); i++) {
                    if (bills.get(i).equals("Electricity Bill")) {
                        System.out.println("Another element: " + bills.get(i));
                    }
                }

            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index Out Of Bounds Exception");

            }
        }
        return bills;
    }

    public static void storeDatatoSQL() {
        Collections.sort(arrayListExample());
        List<String>list = arrayListExample();
        ConnectToSqlDB.insertDataFromArrayListToSqlTable(list, "bills", "bills_type");
    }

    //Read the data from the database
        public static void readMyData() {
            try {
                List<String> data =ConnectToSqlDB.readDataBase("bills", "bills_type");
//                for (String num : data) {
//                    System.out.println(num);
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }






