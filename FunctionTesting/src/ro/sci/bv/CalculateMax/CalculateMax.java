package ro.sci.bv.CalculateMax;
import java.util.Scanner;

/**
 * This program asks the user to type 3 numbers, in order to find the biggest of them
 * Then the program will print it to the user
 *
 * @author Bogdan Butuza
 * Modify date: 02/03/2019
 */
public class CalculateMax {
    /**
     * Function getMax() finds the maximum between two numbers
     * @param a an integer variable, representing the first number
     * @param b an integer variable, representing the second number
     * @return the biggest of the two values.
     */
    public int getMax(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        /* Reading 3 numbers from the keyboard */
        Scanner keyboard = new Scanner(System.in);
        System.out.print("The first number is: ");
        int x = keyboard.nextInt();
        System.out.print("The second number is: ");
        int y = keyboard.nextInt();
        System.out.print("The third number is: ");
        int z = keyboard.nextInt();
        CalculateMax max = new CalculateMax();
        /* Prints the maximum between these three numbers */
        System.out.println("The maximum number is: " + max.getMax(max.getMax(x,y),z));
        keyboard.close();
    }
}
