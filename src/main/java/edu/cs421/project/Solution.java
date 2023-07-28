package edu.cs421.project;

import java.util.Arrays;

public class Solution {

    static int [] timeToCross;
    static String [] toysToCross =  { "Buzz", "Woody", "Rex", "Hamm", "Snail" };

    public static void main(String[] args) {
        timeToCross = new int[]{ 5, 10 };
        System.out.println("Test 1: " + Arrays.toString(timeToCross));
        System.out.println("Total Time 1: " + totalTime(timeToCross, timeToCross.length));

        timeToCross = new int[]{ 1, 20, 21 };
        System.out.println("\nTest 2: " + Arrays.toString(timeToCross));
        System.out.println("Total Time 2: " + totalTime(timeToCross, timeToCross.length));

        timeToCross = new int[]{ 5, 10, 20, 25 };
        System.out.println("\nTest 3: " + Arrays.toString(timeToCross));
        System.out.println("Total Time 3: " + totalTime(timeToCross, timeToCross.length));

        timeToCross = new int[]{ 1, 20, 21, 22, 25 };
        System.out.println("\nTest 4: " + Arrays.toString(timeToCross));
        System.out.println("Total Time 4: " + totalTime(timeToCross, timeToCross.length));
    }

    public static int totalTime(int[] timeToCross , int n){
        //Either 2 people or 1 person.
        if (n < 3)
        {
            //as the elements are sorted.
            System.out.println("Crossing: " + toysToCross[0] + ":" + timeToCross[0] + " - " + toysToCross[n-1] + ":" + timeToCross[n-1]);
            return timeToCross[n - 1];
        }
        //3 people will be addition of all.
        else if (n == 3)
        {
            System.out.println("Crossing: " + toysToCross[0] + ":" + timeToCross[0] + " - " + toysToCross[1] + ":" + timeToCross[1]);
            System.out.println("Back: " + toysToCross[0] + ":" + timeToCross[0]);
            System.out.println("Crossing: " + toysToCross[0] + ":" + timeToCross[0] + " - " + toysToCross[2] + ":" + timeToCross[2]);
            return timeToCross[0] + timeToCross[1] + timeToCross[2];
        }
        // n >= 4
        else
        {
            String toysTakenCaseOne = "\nCrossing: " + toysToCross[0] + ":" + timeToCross[0] + " - " + toysToCross[1] + ":" + timeToCross[1] + " = Total: " + Math.max(timeToCross[0], timeToCross[1]) +
                    "\nBack: " + toysToCross[0] + ":" + timeToCross[0] + " = Total: " + timeToCross[0] +
                    "\nCrossing: " + toysToCross[n-1] + ":" + timeToCross[n-1] + " - " + toysToCross[n-2] + ":" + timeToCross[n-2] + " = Total: " + Math.max(timeToCross[n-1], timeToCross[n-2]) +
                    "\nBack: " + toysToCross[1] + ":" + timeToCross[1] + " = Total: " + timeToCross[1];
            int timeTakenCaseOne = timeToCross[1] + timeToCross[0] + timeToCross[n-1] + timeToCross[1];

            String toysTakenCaseTwo = "Crossing: " + toysToCross[0] + ":" + timeToCross[0] + " - " + toysToCross[n-1] + ":" + timeToCross[n-1] +
                    "\nBack: " + toysToCross[0] + ":" + timeToCross[0] +
                    "\nCrossing: " + toysToCross[0] + ":" + timeToCross[0] + " - " + toysToCross[n-2] + ":" + timeToCross[n-2] +
                    "\nBack: " + toysToCross[0] + ":" + timeToCross[0];
            int timeTakenCaseTwo  = timeToCross[n-1] + timeToCross[0] + timeToCross[n-2] + timeToCross[0];

            if (timeTakenCaseOne < timeTakenCaseTwo)
            {
                System.out.println(toysTakenCaseOne);
                return timeTakenCaseOne + totalTime(timeToCross, n - 2);
            }
            else if (timeTakenCaseTwo < timeTakenCaseOne)
            {
                System.out.println(toysTakenCaseTwo);
                return timeTakenCaseTwo + totalTime(timeToCross, n - 2);
            }
            System.out.println(toysTakenCaseTwo);
            return timeTakenCaseTwo + totalTime(timeToCross, n - 2);
        }
    }
}