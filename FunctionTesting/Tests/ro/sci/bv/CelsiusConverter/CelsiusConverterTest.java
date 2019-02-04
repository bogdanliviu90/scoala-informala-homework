package ro.sci.bv.CelsiusConverter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * This test checks if a Fahrenheit temperature is correctly transformed into Celsius degrees
 * It also tests if the right message is given to the user, based on inputted values.
 *
 * @author Bogdan Butuza
 */
class CelsiusConverterTest {

    CelsiusConverter c = new CelsiusConverter();

    /**
     * Testing conversion: 98.60 Fahrenheit degrees represent 37.00 Celsius degrees
     */
    @Test
    public void convertCelsiusEquals() {
        double expectedTemperature = c.convertCelsius(98.60);
        Assertions.assertEquals(expectedTemperature, 37.00);
    }

    /**
     * Testing conversion: -40 Fahrenheit degrees represent -40 Celsius degrees
     * Not a valid human body temperature, but testing conversion
     */
    @Test
    public void convertCelsiusEqualsBoth() {
        double expectedTemperature = c.convertCelsius(-40);
        Assertions.assertEquals(expectedTemperature,-40);
    }

    @Test
    public void convertCelsiusNotEquals() {
        double convert = c.convertCelsius(138.20);
        //Expected result is 59 degrees
        Assertions.assertNotEquals(convert, 80);
    }

    private final static String NORMAL_MESSAGE = "Your temperature is normal.";
    private final static String ILL_MESSAGE = "You are ill!";
    private final static String INVALID_MESSAGE = "The given temperature isn't for a human body.";

    /**
     * Testing if getMessage method returns the right message
     * 97.20 Fahrenheit Degrees is the minimum normal value for the human body temperature(36.20 Celsius degrees)
     * a NORMAL_MESSAGE should be returned
     */
    @Test
    public void getMessageEquals() {
        Assertions.assertEquals(c.getMessage(c.convertCelsius(97.20)), NORMAL_MESSAGE);
    }

    /**
     * Supposing getMessage method will not return the right message
     * 93.20 Fahrenheit degrees means 34 Celsius degrees, less than human body normal temperature,
     * returned message shouldn't be ILL_MESSAGE
     */
    @Test
    public void getFalseMessage() {
        Assertions.assertNotEquals(c.getMessage(c.convertCelsius(93.20)),ILL_MESSAGE);
    }

    /**
     * Testing if the right message is returned
     * 95 Fahrenheit degrees means 35 Celsius degrees, less than human body normal temperature,
     * INVALID_MESSAGE should be returned
     */
    @Test
    public void getTrueMessage() {
        Assertions.assertEquals(c.getMessage(c.convertCelsius(95.00)), INVALID_MESSAGE);
    }
}