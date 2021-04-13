package problemandsolutions;

import java.util.Scanner;

public class GradeSheet {
    // Write a Java program that determines a student’s grade.
    //The program will read three types of scores(quiz, mid-term, and final scores) and determine the grade based on
    // the following rules:
    //- if the average score >=90% =>grade=A
    //- if the average score >= 70% and <90% => grade=B
    //- if the average score>=50% and <70% =>grade=C
    //- if the average score<50% =>grade=F
    //
    //See the example output below:
    //
    //Quiz score: 80
    //
    //Mid-term score: 68
    //
    //Final score: 90
    //
    //Your grade is B.


    public static void main(String[] args) {
        GradeSheet.gradeMark();
    }

    public static void gradeMark() {
        Scanner input = new Scanner(System.in);
        System.out.print("Quiz Score: ");
        double score = input.nextDouble();
        System.out.print("Mid-term Score: ");
        double midterm = input.nextDouble();
        System.out.print("Final Score: ");
        double finalScore = input.nextDouble();
        double averageScore = ((score + midterm + finalScore) / 3);

        if (averageScore >= 90) {
            System.out.println("Your grade is A");
        } else if (averageScore < 90 && averageScore >= 70) {
            System.out.println("Your grade is B");
        } else if (averageScore < 70 && averageScore >= 50) {
            System.out.println("Your grade is C");
        } else if (score < 50) {
            System.out.println("Your grade is F");
        }
        input.close();

    }

}
