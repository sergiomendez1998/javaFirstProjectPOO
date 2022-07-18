package javapoo.utils;

import java.util.Random;
import java.util.Scanner;

public class Util {


    public static final Scanner SCANNER = new Scanner(System.in);
    public static Random random = new Random();
    public static int diceHighestNumber(int times, int max, int min){
         int result = 0;
         int tmp = 0;
         for(int i = 1; i <= times; i++){
              tmp = generateRandomNumber(min, max);
              if(tmp > result){
                result = tmp;
              }
         }
         return result;

   }
    public static int generateRandomNumber(int min, int max) {
        return random.nextInt(max - (min - 1)) + 1 + (min - 1);
    }
}

