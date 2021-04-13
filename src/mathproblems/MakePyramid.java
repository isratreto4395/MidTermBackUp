package mathproblems;

public class MakePyramid {
    public static void main(String[] args) {

        /*   Implement a large Pyramid of stars in the screen with java.

         *
         * *
         * * *
         * * * *
         * * * * *
         * * * * * *

         */

        pyramid(6);

    }

    public static void pyramid(int input) {

        // outer loop tp handle number of rows
        for (int i = 1; i <= input; i++) {
            //inner loop to handle number spaces
            for (int j = input; j >= i; j--) {
                System.out.print(" ");
            }
            //inner loop to handle number of columns
            for (int k = 1; k <= i; k++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}

