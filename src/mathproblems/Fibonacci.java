package mathproblems;

public class Fibonacci {
    public static void main(String[] args) {
         /*
          Write 40 Fibonacci numbers with java.
          0,1,1,2,3,5,8,13
         */
        fibonacciSequence(40);
    }

    public static int fibonacciSequence(int inputNum) {
        int sum = 0;
        int prevNum = 0;
        int nextNum = 1;
        for (int i = 1; i <= inputNum; i++) {
            System.out.print(prevNum + " ");
            sum = prevNum + nextNum;
            prevNum = nextNum;
            nextNum = sum;
        }
        return sum;
    }
}
