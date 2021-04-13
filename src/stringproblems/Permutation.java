package stringproblems;


public class Permutation {

    public static void main(String[] args) {

        /*
         * Permutation of String "ABC" is "ABC" "BAC" "BCA" "ACB" "CAB" "CBA".
         * Write Java program to compute all Permutation of a String
         *
         */
        stringPermutation("", "ABC");
    }

    public static String stringPermutation(String permutation, String word) {
        String wrd = null;
        int wrdLength = word.length();
        if (wrdLength == 0) {
            System.out.println(permutation);
        } else {
            for (int i = 0; i < wrdLength; i++) {
                char perm = word.charAt(i);
                wrd = word.substring(0, i) + word.substring(i + 1, wrdLength);
                stringPermutation(permutation + perm, wrd);
            }
        }
    return wrd;
    }
}
