package bv.sci.TicTacToeTests;

import bv.sci.TicTacToe.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class BoardTest {

    Board test = new Board();

    @Test
    void checkMoveTrue() {
        test.assignValue('X',1,1);
        test.assignValue('O',1,2);
        Assertions.assertTrue(test.checkMove(0,2));
    }

    @Test
    void checkMoveFalse() {
        test.assignValue('X',2,2);
        Assertions.assertFalse(test.checkMove(2,2));
    }

    @Test
    void checkWinnerRowsTrue() {
        test.assignValue('X',0,0);
        test.assignValue('X',0,1);
        test.assignValue('X',0,2);
        Assertions.assertTrue(test.checkRows('X'));
    }

    @Test
    void checkWinnerRowsFalse() {
        test.assignValue('X',1,0);
        test.assignValue('O',1,1);
        test.assignValue('X',1,2);
        Assertions.assertFalse(test.checkRows('X'));
    }

    @Test
    void checkWinnerColumnsTrue() {
        test.assignValue('O',0,1);
        test.assignValue('O',1,1);
        test.assignValue('O',2,1);
        Assertions.assertTrue(test.checkColumns('O'));
    }

    @Test
    void checkWinnerColumnsFalse() {
        test.assignValue('X',0,0);
        test.assignValue('X',1,0);
        test.assignValue('O',2,0);
        Assertions.assertFalse(test.checkColumns('X'));
    }

    @Test
    void checkWinnerMainDiagonalTrue() {
        test.assignValue('O',0,0);
        test.assignValue('O',1,1);
        test.assignValue('O',2,2);
        Assertions.assertTrue(test.checkMainDiagonal('O'));
    }

    @Test
    void checkWinnerMainDiagonalFalse() {
        test.assignValue('X',0,0);
        test.assignValue('X',1,1);
        test.assignValue(' ',2,2);
        Assertions.assertFalse(test.checkMainDiagonal('X'));
    }

    @Test
    void checkWinnerSecondaryDiagonalTrue() {
        test.assignValue('X',0,2);
        test.assignValue('X',1,1);
        test.assignValue('X',2,0);
        Assertions.assertTrue(test.checkSecondaryDiagonal('X'));
    }

    @Test
    void checkWinnerSecondaryDiagonalFalse() {
        test.assignValue('O',0,2);
        test.assignValue('O',1,1);
        test.assignValue('X',2,0);
        Assertions.assertFalse(test.checkSecondaryDiagonal('O'));
    }

    @Test
    void messageInvalidPositionEquals() {
        int givenPosition1 = 1;
        int givenPosition2 = 2;
        test.assignValue('X',givenPosition1,givenPosition2);
        String message = "This move at (" + (givenPosition1+1) + "," + (givenPosition2+1) + ") is not valid." +
                " Try again...";
        Assertions.assertEquals(test.getPositionMessage(givenPosition1,givenPosition2),message);
    }

    @Test
    void messageInvalidPositionNull() {
        int givenPosition1 = 0;
        int givenPosition2 = 2;
        test.assignValue('X',1,2);
        test.assignValue(' ',givenPosition1,givenPosition2);
        Assertions.assertNull(test.getPositionMessage(givenPosition1,givenPosition2));
    }

    @Test
    void messageInvalidPositionNotNull() {
        int givenPosition1 = 0;
        int givenPosition2 = 2;
        test.assignValue('X',1,2);
        test.assignValue('O', givenPosition1, givenPosition2);
        Assertions.assertNotNull(test.getPositionMessage(givenPosition1,givenPosition2));
    }

    Player player = new Player('O');
    private final String ERROR_MSG = "Player 'X' won!";
    private final String CORRECT_MSG = "Player 'O' won!";

    @Test
    void messageWinnerEquals() {
        test.assignValue('O',1,2);
        test.assignValue('O',1,1);
        test.assignValue('O',1,0);
        Assertions.assertEquals(test.getWinnerMessage(player),CORRECT_MSG);
    }

    @Test
    void messageWinnerNotEquals() {
        test.assignValue('O',1,2);
        test.assignValue('O',1,1);
        test.assignValue('O',1,0);
        Assertions.assertNotEquals(test.getWinnerMessage(player),ERROR_MSG);
    }

    @Test
    void messageWinnerNull() {
        test.assignValue('O',1,2);
        test.assignValue('X',1,1);
        test.assignValue('X',1,0);
        Assertions.assertNotEquals(test.getWinnerMessage(player),ERROR_MSG);
    }

    @Test
    void isAvailableTrue() {
        test.assignValue(' ', 2,2);
        Assertions.assertTrue(test.isAvailable());
    }

    @Test
    void isAvailableFalse() {
        test.assignValue('X', 0,0);
        test.assignValue('X', 0,1);
        test.assignValue('O', 0,2);
        test.assignValue('O', 1,0);
        test.assignValue('O', 1,1);
        test.assignValue('X', 1,2);
        test.assignValue('X', 2,0);
        test.assignValue('X', 2,1);
        test.assignValue('O', 2,2);
        Assertions.assertFalse(test.isAvailable());
    }
}