package ro.sci.bv.InputData;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * This program asks the user to enter the current time
 * The user must enter two numbers - one for hours and one for minutes
 * The program will validate the entry data and will output it if it's correct
 *
 * @author Bogdan Butuza
 * Modify date: 02/03/2019
 */
public class InputData {

    /**
     * Method checkDate verifies if both values are valid ones
     * Hour must be between 0 and 23 and minutes should be between 0 and 59, in order to be considered a valid time
     * @param hour a short variable, representing the given hour
     * @param minutes minutes a short variable, representing the given minutes
     * @return true, if the entered values are considered valid
     *         false, otherwise
     */
    public boolean checkDate(int hour, int minutes) {
        boolean ok = false;
        if  ((hour>=0 && hour<=23) && (minutes>=0 && minutes<=59)) {
            ok = true;
        }
        return ok;
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
        System.out.println("What time is it?");
        /* Prompts the user to insert 2 values - hour and minutes */
        System.out.print("Enter hour: ");
        int h = scan.nextShort();
        System.out.print("Enter minutes: ");
        int min = scan.nextShort();

        InputData input = new InputData();

        if (input.checkDate(h, min)) {
            System.out.println("The time is " + input.formatDate(h,min)+ " now.");
        }else{
            System.out.println("Incorrect time.");
        }
        scan.close();
    }

}
