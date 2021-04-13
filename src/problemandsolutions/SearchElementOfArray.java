package problemandsolutions;

public class SearchElementOfArray {
    // By using the sequential search algorithm,
    // write a Java program to search for an element of an integer array of 10 elements.


    public static void main(String[] args) {
        int[] element1 = {12, 16, 65, 78, 95, 34, 13, 2, 4, 8};
        SearchElementOfArray.searchElement(element1, 95);
    }

    public static int searchElement(int[] element, int search) {
        for (int i = 0; i < element.length; i++) {
            if (element[i] == search) {
                System.out.println("Found " + search + " at index " + i);
                return i;
            }
        }
        System.out.println(search + " is not in this array.");
        return -1;
    }

}

