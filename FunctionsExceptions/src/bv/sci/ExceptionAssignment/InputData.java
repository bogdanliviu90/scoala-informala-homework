package bv.sci.ExceptionAssignment;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program asks the user to enter the current time
 * The user must enter two numbers - one for hours and one for minutes
 * The program will validate the entry data and will output it if it's correct
 *
 * @author Bogdan Butuza
 * Modify date: 02/17/2019
 */
public class InputData {

    /**
     * Method checkDate verifies if both values are valid ones
     * Hour must be between 0 and 23 and minutes should be between 0 and 59, in order to be considered a valid time
     * @param hour a short variable, representing the given hour
     * @param minutes minutes a short variable, representing the given minutes
     * @return true, if the entered values are considered valid
     *         an argument exception, if hour is not a value between 0 and 23 or minutes are not between 0 and 59
     */
    public boolean checkDate(int hour, int minutes) {
        if  ((hour>=0 && hour<=23) && (minutes>=0 && minutes<=59)) {
            return true;
        }else{
            throw new IllegalArgumentException("Incorrect time!");
        }
    }

    /**
     * Method formatDate takes two variables - meaning the given time - and sets them in format "hh:mm"
     * @param hour a short variable, representing the given hour
     * @param minutes minutes a short variable, representing the given minutes
     * @return time in format hh:mm (hour:minutes), concatenated to a string
     */
    public String formatDate(int hour, int minutes) {
        /* Creating format pattern for two decimals */
        NumberFormat f = new DecimalFormat("00");
        /* Converting with 2 decimals to string */
        String hh = f.format(hour);
        String mm = f.format(minutes);
        return hh + ":" + mm;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int h, min;
        try {
            System.out.println("What time is it?");
            /* Prompts the user to insert 2 values - hour and minutes */
            System.out.print("Enter hour: ");
            h = scan.nextInt();
            System.out.print("Enter minutes: ");
            min = scan.nextInt();
            InputData input = new InputData();
            if (input.checkDate(h, min)) {
                System.out.println("The time is " + input.formatDate(h,min)+ " now.");
            }
        } catch (InputMismatchException e) {
            System.out.println("You must insert an integer value.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        scan.close();
    }

}