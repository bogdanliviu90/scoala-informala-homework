package bv.sci.TicTacToeTests;

import bv.sci.TicTacToe.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class PlayerTest {
    private static final String PLAYER_X = "Player 'X'";
    private static final String PLAYER_O = "Player 'O'";

    // Testing first case : should return symbol 'X', not 'x'
    Player case1 = new Player('x');

    @Test
    void getSymbolCase1Equals() {
        Assertions.assertEquals(case1.getSymbol(), 'X');
    }

    @Test
    void getSymbolCase1IsNot() {
        Assertions.assertNotEquals(case1.getSymbol(),'x');
    }

    @Test
    void getNameCase1Equals() {
        Assertions.assertEquals(case1.getName(),PLAYER_X);
    }

    @Test
    void getNameCase1IsNot() {
        Assertions.assertNotEquals(case1.getName(),"Player 'x'");
    }

    // Testing second case  : should return symbol 'O', not 'o'
    Player case2 = new Player('o');

    @Test
    void getSymbolCase2Equals() {
        Assertions.assertEquals(case2.getSymbol(), 'O');
    }
    @Test
    void getSymbolCase2IsNot() {
        Assertions.assertNotEquals(case2.getSymbol(),'o');
    }

    @Test
    void getNameCase2Equals() {
        Assertions.assertEquals(case2.getName(),PLAYER_O);
    }

    @Test
    void getNameCase2IsNot() {
        Assertions.assertNotEquals(case2.getName(), PLAYER_X);
    }

    // Testing third case : if the symbol is not 'X' or 'O', function getSymbol() should return 'X'
    Player case3 = new Player('A');

    @Test
    void getSymbolCase3Equals() {
        Assertions.assertEquals(case3.getSymbol(), 'X');
    }

    @Test
    void getSymbolCase3IsNot() {
        Assertions.assertNotEquals(case3.getSymbol(),'A');
    }

    @Test
    void getNameCase3Equals() {
        Assertions.assertEquals(case3.getName(),PLAYER_X);
    }

    @Test
    void getNameCase3IsNot() {
        Assertions.assertNotEquals(case3.getName(), "Player 'A'");
    }

    // Testing fourth case : if the symbol is not 'X' or 'O', function getSymbol() should return 'X'
    Player case4 = new Player('4');

    @Test
    void getSymbolCase4Equals() {
        Assertions.assertEquals(case4.getSymbol(),'X');
    }

    @Test
    void getSymbolCase4IsNot() {
        Assertions.assertNotEquals(case3.getSymbol(),'4');
    }

    @Test
    void getNameCase4Equals() {
        Assertions.assertEquals(case4.getName(),PLAYER_X);
    }

    @Test
    void getNameCase4IsNot() {
        Assertions.assertNotEquals(case4.getName(), "Player '4'");
    }

}