package mathproblems;

public class FindMissingNumber {

    public static void main(String[] args) {
        /*
         * If n = 10, then array will have 9 elements in the range from 1 to 10.
         * For example {10, 2, 1, 4, 5, 3, 7, 8, 6}. One number will be missing in array (9 in this case).
         * Write java code to find the missing number from the array. Write static helper method to find it.
         */
        int[] array = new int[]{10, 2, 1, 4, 5, 3, 7, 8, 6};

        missingNum(array);
    }

    public static int missingNum(int[] arr) {
        int sum1 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
        }
        int sum2 = 0;
        for (int j = 1; j <= arr.length + 1; j++) {
            sum2 += j;
        }
        int total = sum2 - sum1;
        System.out.println("The missing number in the array is " + total);
        return total;
    }
}
