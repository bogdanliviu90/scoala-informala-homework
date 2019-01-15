/**
 * This program asks the user to enter the current time
 * The user must enter two numbers - one for hours and one for minutes
 * The program will validate the entry data and will output it if it's correct
 *
 * @author Bogdan Butuza
 */
package ro.sci.bv.InputDataValidation;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
public class InputDataValidation {

    /**
     * Method checkData verifies if both values are valid ones
     * If correct, it puts hour and minutes in the right format and prints it to the user
     * @param hour a short variable, representing the given hour
     * @param minutes a short variable, representing the given minutes
     */
    private static void checkData(short hour, short minutes) {
        if  ((hour>=0 && hour<=23) && (minutes>=0 && minutes<=59)) {
            /* Creating format pattern for two decimals */
            NumberFormat f = new DecimalFormat("00");
            /* Converting with 2 decimals to string */
            String hh = f.format(hour);
            String mm = f.format(minutes);
            System.out.println("The time is " + hh + ":" + mm + " now.");
        }else{
            /* The inserted values are not valid */
            System.out.println("Incorrect time!");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What time is it?");
        /* Prompts the user to insert 2 values - hour and minutes */
        System.out.print("Enter hour: ");
        short h = input.nextShort();
        System.out.print("Enter minutes: ");
        short min = input.nextShort();
        checkData(h, min);
        input.close();
    }

}
