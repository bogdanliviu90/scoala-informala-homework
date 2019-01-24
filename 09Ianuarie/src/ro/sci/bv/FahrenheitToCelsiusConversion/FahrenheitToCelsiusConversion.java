/**
 * This program prompts the user to insert a temperature in Fahrenheit degrees
 * Then it realizes a conversion to Celsius degrees and outputs a message, based on the inputted value
 *
 * @author Bogdan Butuza
 */
package ro.sci.bv.FahrenheitToCelsiusConversion;
import java.text.DecimalFormat;
import java.util.Scanner;
public class FahrenheitToCelsiusConversion {

    /*To display the double variable with only one decimal */
    private static DecimalFormat oneDecimal = new DecimalFormat(".#");

    /**
     * This method converts a temperature from Fahrenheit degrees to Celsius degrees
     * If the measured temperature in Celsius is higher than 37 degrees, the method warns the users that
     * they are ill
     * If the inputted temperature is right, an message with its conversion to Fahrenheit will be printed to
     * the console
     * @param temperature a double value, representing the temperature to be converted
     */
    private static void toCelsius(double temperature) {
        double celsius = (temperature - 32) * 5/9;
        System.out.println("Your body temperature in Celsius degrees is " + oneDecimal.format(celsius));
        if (celsius > 37) {
            System.out.println("You are ill!");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please insert your body temperature in Fahrenheit degrees: ");
        double x = input.nextDouble();
        toCelsius(x);
        input.close();
    }

}
