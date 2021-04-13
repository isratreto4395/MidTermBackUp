package mathproblems;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class UnitTestingMath {
    public static void main(String[] args) {
        //Apply Unit testing into each classes and methods in this package.

    }

    @Test
    public void factorialRecursionTesting() {
        int expectedFactorialRecursion = 120;
        int actualFactorialRecursion = Factorial.factorialRecursion(5);
        Assert.assertEquals("Test Failed", expectedFactorialRecursion, actualFactorialRecursion);
    }

    @Test
    public void factorialIterationTesting() {
        int expectedFactorialIteration = 120;
        int actualFactorialIteration = Factorial.factorialIteration(5);
        Assert.assertEquals("Test Failed", expectedFactorialIteration, actualFactorialIteration);
    }

    @Test
    public void fibonacciTestingOneAsInput() {
        int expectedFibonacciOutputOne = 1;
        int actualFibonacciOutputOne = Fibonacci.fibonacciSequence(1);
        Assert.assertEquals("Test Fail", expectedFibonacciOutputOne, actualFibonacciOutputOne);
    }

    //Negative testing
    @Test
    public void fibonacciTestingTwoAsInput() {

        int expectedFibonacciOutputTwo = 3;
        int actualFibonacciOutputTwo = Fibonacci.fibonacciSequence(2);
        Assert.assertEquals("Test should Fail", expectedFibonacciOutputTwo, actualFibonacciOutputTwo);
    }

    @Test
    public void fibonacciTestingThreeAsInput() {
        int expectedFibonacciOutputThree = 3;
        int actualFibonacciOutputThree = Fibonacci.fibonacciSequence(3);
        Assert.assertEquals("Test Fail", expectedFibonacciOutputThree, actualFibonacciOutputThree);
    }

    @Test
    public void lowestDifferencetesting() {
        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19};
        int expectedLowestDifference = 1;
        int actualLowestDifference = FindLowestDifference.lowestDifference(array1, array2);
        Assert.assertEquals("Wrong lowest Difference", expectedLowestDifference, actualLowestDifference);
    }

    @Test(timeout = 34)
    public void missingNumTesting() {
        int[] array = new int[]{10, 2, 1, 4, 5, 3, 7, 8, 6};
        int expectedMissingNum = 9;
        int actualMissingNum = FindMissingNumber.missingNum(array);
        Assert.assertEquals("Worng missing number", expectedMissingNum, actualMissingNum);

    }

    @Test
    public void lowestNumberTesting() {
        int array[] = new int[]{211, 110, 99, 34, 67, 89, 67, 456, 321, 456, 78, 90, 45, 32, 56, 78, 90, 54, 32, 123, 67, 5, 679, 54, 32, 65};
        int expectedLowestNum = 5;
        int actualLowestNum = LowestNumber.lowestNumber(array);
        Assert.assertEquals("Wrong lowest Value printed", expectedLowestNum, actualLowestNum);
    }

    @Test
    public void pyramidTesting() {
        String expectedPyramidPattern = "    *\n   **\n   ***\n";
        //Assert.assertEquals("Pyramid is not formed properly",expectedPyramidPattern,MakePyramid.pyramid(5));

    }

    @Test
    public void mergeandRemoveDuplicatesInTwoArrTesting() {
        int[] arrayA = {1, 3, 4};
        int[] arrayB = {4, 5, 6, 7, 8};
        int[] expectedMergeAndRemoveDuplicates = {1, 3, 4, 5, 6, 7, 8};
        int[] actualMergeAndRemoveDuplicates = MergeTwoArraysAndRemoveDuplicatesProgram.mergeAndRemoveDuplicatesInTwoArrays(arrayA, arrayB);
        Assert.assertEquals("It is not merged correctly, duplicates remain", expectedMergeAndRemoveDuplicates, actualMergeAndRemoveDuplicates);
    }

    @Test
    public void patternTesting() {
        ArrayList<Integer> expectedPattern = new ArrayList<>(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
        ArrayList<Integer> actualPattern = Pattern.readPattern(10);
        Assert.assertEquals("Testing failed", expectedPattern, actualPattern);

    }

    @Test
    public void primeNumberTesting() {
        boolean expectedPrimeNum = true;
        boolean actualPrimeNum = PrimeNumber.isItPrime(31);
        Assert.assertEquals("not prime", expectedPrimeNum, actualPrimeNum);

    }


}
