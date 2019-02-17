package bv.sci.ExceptionAssignment;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program prompts the user to insert a temperature in Fahrenheit degrees
 * Then it realizes a conversion to Celsius degrees and outputs a message, based on the inputted value
 *
 * @author Bogdan Butuza
 * Modify date 02/17/2019
 */
public class CelsiusConverter {
    /**
     * This method converts a temperature from Fahrenheit degrees to Celsius degrees
     * @param temperature a double value, representing the temperature to be converted
     * @return the converted temperature in Celsius degrees, a double value
     */
    public double convertCelsius(double temperature) {
        return ((temperature - 32) * 5/9);
    }

    /**
     * This method is used to output a message to the user, regarding the given temperature
     * @param temperature receives the converted temperature, as a double value
     * @return a message by every case: normal temperature, illness or an invalid temperature for the human body
     */
    public String getMessage(double temperature) {
        if ((temperature >= 36.20) && (temperature <= 45)) {
            //Normal temperature values for humans are between 36.20 and 37.20
            if (temperature >= 37.30) {
                return "You are ill!";
            }
            return "Your temperature is normal.";
        }else{
            throw new IllegalArgumentException("The given temperature isn't for a human body.");
        }
    }

    private static DecimalFormat oneDecimal = new DecimalFormat(".#");

    public static void main(String[] args) {
        CelsiusConverter c = new CelsiusConverter();
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Please insert your body temperature in Fahrenheit degrees: ");
            double myTemperature = input.nextDouble();
            System.out.println("Your temperature in Celsius degrees is: " +
                    oneDecimal.format(c.convertCelsius(myTemperature)));
            System.out.println(c.getMessage(c.convertCelsius(myTemperature)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("The entered value must be a number.");
        }
        input.close();
    }
}