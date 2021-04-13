package problemandsolutions;

import java.util.Scanner;

public class ArithmeticOperator {
    //Write Java program to allow the user to input two integer values and then the program prints the results of adding,
    // subtracting, multiplying, and dividing among the two values.


    public static void main(String[] args) {

        ArithmeticOperator arithmetic = new ArithmeticOperator();
        arithmetic.userInputArithmeticOp();
    }

    public void userInputArithmeticOp() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input only whole numbers starting from 1");
        System.out.print("Input the first Number: ");
        int num1 = input.nextInt();
        System.out.print("Input the second Number: ");
        int num2 = input.nextInt();

        try {
            System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
            System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
            System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
            System.out.println(num1 + " / " + num2 + " = " + (float)num1 / num2);
        } catch (ArithmeticException exception) {
            System.out.println("Please input numbers from 1 to n");
        }
        input.close();
    }

}



