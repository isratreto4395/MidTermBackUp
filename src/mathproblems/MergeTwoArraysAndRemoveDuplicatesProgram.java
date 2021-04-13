package mathproblems;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MergeTwoArraysAndRemoveDuplicatesProgram {

    // Merge Two Arrays Into Single Sorted Array Without Duplicates
    // given  arrayA={1,3,4}
    // given  arrayB={4,5,6,7,8}
    // output {1,3,4,5,6,7,8}


    public static void main(String[] args) {
        int[] arrayA = {1,3,4};
        int[] arrayB ={4,5,6,7,8};
        mergeAndRemoveDuplicatesInTwoArrays(arrayA, arrayB);
    }

    public static int[] mergeAndRemoveDuplicatesInTwoArrays(int[] array1, int[] array2) {
        int num1 = array1.length;
        int num2 = array2.length;
        int[] mergeArray = new int[num1 + num2];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < num1 && j < num2) {
            if (array1[i] < array2[j]) {
                mergeArray[k] = array1[i];
                i++;
                k++;
            } else {
                mergeArray[k] = array2[j];
                j++;
                k++;
            }
        }
        while (i < num1) {
            mergeArray[k] = array1[i];
            k++;
            i++;
        }
        while (j < num2) {
            mergeArray[k] = array2[j];
            k++;
            j++;
        }
        Set<Integer> noduplicates = new HashSet<>();
        for(int x = 0; x<mergeArray.length; x++){
            noduplicates.add(mergeArray[x]);
        }
        Iterator<Integer> iterate = noduplicates.iterator();
        int[] mergeArrayNoDuplicates = new int[noduplicates.size()];
        int y = 0;
        while(iterate.hasNext()){
            mergeArrayNoDuplicates[y] = iterate.next();
            y++;
        }
        Arrays.sort(mergeArrayNoDuplicates);
        System.out.println("The merged Array : "+ Arrays.toString(mergeArrayNoDuplicates));
       return mergeArrayNoDuplicates;
    }
        }





