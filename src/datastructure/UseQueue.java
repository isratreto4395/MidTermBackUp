package datastructure;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {

    public static void main(String[] args) {
        /*
         * Demonstrate how to use Queue that includes add,peek,remove,pool elements.
         * Use For Each loop and while loop with Iterator to retrieve data.
         *
         */
		UseQueue.queue();

    }

    public static void queue() {
        Queue<String> coffeeOrders = new LinkedList<>();
        coffeeOrders.add("Cappuccino");
        coffeeOrders.add("Caffe macchiato");
        coffeeOrders.add("Caffe mocha");
        coffeeOrders.add("Latte");
        coffeeOrders.add("Double Espresso");

        for (String orde : coffeeOrders) {
            System.out.println("List of orders: " + orde);
        }

        System.out.println("*****Removing an element*****");
        coffeeOrders.remove("Latte");
        for (String ord : coffeeOrders) {
            System.out.println("After removing a order: " + ord);
        }

        System.out.println("****Peek****");
        System.out.println(coffeeOrders.peek());

        System.out.println("****Poll****");
        System.out.println(coffeeOrders.poll());

        System.out.println("***retrieve elements using for each loop***");
        for (String orders : coffeeOrders) {
            System.out.println(orders);
        }

        System.out.println("***retrieve elements using iteration***");
        Iterator<String> iterator = coffeeOrders.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

}
