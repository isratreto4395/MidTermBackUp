package problemandsolutions;

import java.util.Random;

public class RandomNumberGenerate {
    //Write Java program to generate a random number between 1 to 8.

    public static void main(String[] args) {

        randomNum();
    }

    public static void randomNum() {
        int[] prodId = new int[10];
        Random random = new Random(1);//start point
        for (int i = 0; i < prodId.length; i++) {
            prodId[i] = random.nextInt(8);//end point
            System.out.println(prodId[i]);
        }

    }
}

