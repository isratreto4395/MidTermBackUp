package stringproblems;

import java.util.HashMap;
import java.util.Map;

public class DetermineLargestWord {
    public static void main(String[] args) {
        /*
         Implement to Find the length and longest word in the given sentence below.
         Should return "10 biological".
         */
        String s = "Human brain is a biological learning machine";
        DetermineLargestWord.findTheLargestWord(s);
        //implement

    }

    public static Map<Integer, String> findTheLargestWord(String wordGiven) {
        Map<Integer,String> map = new HashMap<Integer, String>();
        String st = "";
        //implement

        String[] arrayOfWords = wordGiven.split(" ");
        for(String word : arrayOfWords){
            map.put(word.length(),word);
        }
        int largestWrdLength = 0;
        String largestWord = "";
        for (Map.Entry<Integer, String> wordlength : map.entrySet()) {
            largestWrdLength = wordlength.getKey();
            largestWord = wordlength.getValue();
        }
        //System.out.println(largestWord + " is the longest word with " + largestWrdLength + " characters.");
        System.out.println(largestWrdLength+ " "+largestWord);
        return map;
    }
}
