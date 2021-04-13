package mathproblems;


public class Factorial {

    public static void main(String[] args) {
        /*
         * Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120.
         * Write a java program to find Factorial of a given number using Recursion as well as Iteration.
         *
         */

        factorialRecursion(5);
        factorialIteration(5);
    }

    //Factorial of a Number Using Recursion
    public static int factorialRecursion(int num) {
        if (num == 0) {
            return 1;
        } else {
            return ((num) * factorialRecursion(num - 1));
        }
    }

    //Factorial of a Number Using Iteration
    public static int factorialIteration(int num) {
        int factorialNum = 1;
        for (int i = 1; i <= num; i++) {
            factorialNum *= i;

        }
        System.out.println(factorialNum);
        return factorialNum;
    }
}
