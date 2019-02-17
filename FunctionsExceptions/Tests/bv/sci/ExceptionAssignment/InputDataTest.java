package bv.sci.ExceptionAssignment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * InputDataTest tests if two given values - hours and minutes - represent valid time coordinates and it also
 * checks if the date is casted in the desired format: hh:mm
 *
 * @author Bogdan Butuza
 */
class InputDataTest {

    InputData input = new InputData();

    /**
     * Testing if time coordinates - hours and minutes - are valid
     * Hour must be between 0-23 and minutes between 0-59
     */
    @Test
    public void checkDateEquals() {
        boolean expected = input.checkDate(23,45);
        Assertions.assertTrue(expected);
    }

    /**
     * Testing if the inputted value for hours will throw an IllegalArgumentException
     */
    @Test
    public void hoursThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {input.checkDate(24,30);});
    }

    /**
     * Testing if the inputted value for minutes will throw an IllegalArgumentException
     */
    @Test
    public void minutesThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {input.checkDate(20,65);});
    }

    // Declaring some times format, in order to check now the formatDate method
    private static final String format1 = "23:05";
    private static final String format2 = "05:30";
    private static final String format3 = "07:5"; // We don't want this format
    private static final String format4 = "2:01"; // We don't want this format neither

    /**
     * for values 23 and 5: method formatDate must return "23:05" - format1
     */
    @Test
    public void formatDateEqualsFormat1() {
        Assertions.assertEquals(input.formatDate(23,5), format1);
    }

    /**
     * for values 5 and 30: method formatDate must return "05:30" - format2
     */
    @Test
    public void formatDateEqualsFormat2() {
        Assertions.assertEquals(input.formatDate(5,30), format2);
    }

    /**
     * for values 7 and 5: method formatDate must not return "07:5" - format3
     * "07:05" is the expected value
     */
    @Test
    public void formatDateNotEqualsFormat3() {
        Assertions.assertNotEquals(input.formatDate(7,5), format3);
    }

    /**
     * for values 2 and 1: method formatDate must not return "2:01" - format4
     * "02:01" is the expected return
     */
    @Test
    public void formatDateNotEqualsFormat4() {
        Assertions.assertNotEquals(input.formatDate(2,1), format4);
    }
}