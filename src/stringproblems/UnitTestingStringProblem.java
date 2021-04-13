package stringproblems;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UnitTestingStringProblem {
    public static void main(String[] args) {
        //Apply Unit Test into all the methods in this package.

    }

    @Test
    public void anagramTesting() {
        boolean actualAnagramResult = Anagram.wordLength("CAT", "ACT");
        Assert.assertTrue("Test Fail", actualAnagramResult);

    }

    @Test
    public void largestWordTesting() {
        String largestWord = "biological";
        Map<Integer, String> expectedResult = new HashMap<>();
        expectedResult.put(10, "biological");
        Map<Integer, String> actualResult = DetermineLargestWord.findTheLargestWord(largestWord);
        Assert.assertNotEquals("Word did not match", expectedResult, actualResult);
    }

    @Test
    public void duplicateWordAveragelengthTesting() {
        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
        String expectedWordAndOccurance = "Java";
        Set<String> actaulWordAndOccurance = DuplicateWord.duplicateWords(st);
        Assert.assertNotEquals("Word and its occurance is not correct",expectedWordAndOccurance,actaulWordAndOccurance);

    }

    @Test
    public void palindromeTesting() {
        String expectedResult = "It is a palindrome";
        //String actualResult = Palindrome.palindromes("level");
        Assert.assertEquals("It is not a palindrome", expectedResult, Palindrome.palindromes("level"));
    }

    @Test
    public void permutationTesting() {
        String expectedPermutation = " ABC \n" +"ACB \n"+"BAC \n"+"BCA \n"+"CAB \n"+"CBA \n"+"CBA";
        String actualPermutation = Permutation.stringPermutation("","ABC");
        Assert.assertEquals("All the permutation of the word is not dispalyed",expectedPermutation,actualPermutation);

    }


}
