package bv.sci.ExceptionAssignment;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program asks the user to type 3 numbers, in order to find the biggest of them
 * Then the program will print it to the user
 *
 * @author Bogdan Butuza
 * Modify date: 02/17/2019
 */
public class CalculateMax {

    /**
     * Function getMax() finds the maximum between two numbers
     * @param number1 an integer variable, representing the first number
     * @param number2 an integer variable, representing the second number
     * @return the biggest of the two values.
     */
    public int getMax(int number1, int number2) {
        if (number1 > number2) {
            return number1;
        }
        return number2;
    }

    public static void main(String[] args) {
        CalculateMax maximum = new CalculateMax();
        int max = 0;
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Insert the first number: ");
            int number1 = input.nextInt();
            System.out.println("Insert the second number: ");
            int number2 = input.nextInt();
            System.out.println("Insert the third number: ");
            int number3 = input.nextInt();
            max = maximum.getMax(maximum.getMax(number1, number2), number3);
            System.out.println("The maximum number is: " + max);
        }catch (InputMismatchException e) {
            System.out.println("Value must be an integer.");
        }
    }
}