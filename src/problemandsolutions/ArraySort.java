package problemandsolutions;

public class ArraySort {
    // By using the bubble sort algorithm, write a Java program to sort an integer array of 10 elements in ascending.

    public static void main(String[] args) {
        ArraySort.bubbleSort(array());
    }


    public static int[] array() {
        int[] sortNums = new int[6];
        sortNums[0] = 10;
        sortNums[1] = 23;
        sortNums[2] = 3;
        sortNums[3] = 9;
        sortNums[4] = 34;
        sortNums[5] = 1;

        System.out.print("Before bubble sort: ");

        for (int i = 0; i < sortNums.length; i++) {
            System.out.print(sortNums[i] + " ");
        }
        return sortNums;
    }


    public static void bubbleSort(int[] array1) {
        int temp = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 1; j < (array1.length - i); j++) {
                if (array1[j - 1] > array1[j]) {
                    temp = array1[j - 1];
                    array1[j - 1] = array1[j];
                    array1[j] = temp;
                }
            }
        }
        System.out.print("\n"+"After bubble sort: ");
        for (int k = 0; k < array1.length; k++) {

            System.out.print(array1[k] + " ");
        }
    }
}