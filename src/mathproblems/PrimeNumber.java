package mathproblems;

import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {


    public static void main(String[] args) {
        /*
         * Find list of Prime numbers from number 2 to 1 million.
         * Try the best solution as possible.Which will take less CPU life cycle.
         * Out put number of Prime numbers on the given range.
         *
         *
         * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
         *
         */

//        System.out.println(isItPrime(1000000));
//        System.out.println(isItPrime(2));
        findPrimeNum(2, 100);

    }

    public static boolean isItPrime(long num) {
        if (num <= 1) {
            return false;
        }
        for (long i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        System.out.println();
        return true;
    }

    //ArrayList<Long>
    public static void findPrimeNum(long start, long end) {

        List<Long> primeNumber = new ArrayList<>();
        long prime = 0;
        for (long n = start; n < end; n++) {
            if (n == 2) {
                System.out.println(n);
                prime++;
                primeNumber.add(n);
            } else {
                if (isItPrime(n)) {
                    prime++;
                    System.out.println(n);
                    primeNumber.add(n);
                }
            }

        }
        System.out.println(primeNumber);

        //Storing and retrieving from the database
        List<String> primelists = new ArrayList<>(primeNumber.size());
        for (Long ln : primeNumber) {
            primelists.add(String.valueOf(ln));
        }

        ConnectToSqlDB.insertDataFromArrayListToSqlTable(primelists, "prime_numbers", "PrimeValue");

    }

}



