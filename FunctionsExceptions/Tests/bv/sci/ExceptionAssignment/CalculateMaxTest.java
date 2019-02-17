package bv.sci.ExceptionAssignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * CalculateMaxTest checks if the method getMax returns the maximum number between some values
 *
 * @author Bogdan Butuza
 */
class CalculateMaxTest {

    CalculateMax max = new CalculateMax();

    /**
     * Testing if the expected result is reached
     */
    @Test
    public void getMaxEquals() {
        int expected = max.getMax(24,94);
        Assertions.assertEquals(expected, 94);
    }

    /**
     * Testing if between 2 similar values, it returns one of them
     */
    @Test
    public void getMaxSameNumbers() {
        Assertions.assertEquals(max.getMax(9,9),9);
    }

    /**
     * Testing if the maximum between three values is reached
     */
    @Test
    public void getMaxThreeNumbersEquals() {
        Assertions.assertEquals(max.getMax(max.getMax(-64,82),20),82);
    }

    /**
     * Supposing the expected result is not reached
     */
    @Test
    public void getMaxNotEquals() {
        int actual = max.getMax(105,230); // 230
        Assertions.assertNotEquals(max.getMax(max.getMax(94,-10),105),actual);
    }
}