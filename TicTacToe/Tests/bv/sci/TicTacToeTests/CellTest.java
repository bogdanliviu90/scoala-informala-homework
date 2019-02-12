package bv.sci.TicTacToeTests;

import bv.sci.TicTacToe.Cell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CellTest {

    Cell cell = new Cell('X');

    @Test
    void getValueEquals() {
        Assertions.assertEquals(cell.getValue(), 'X');
    }

    @Test
    void setAValue() {
        cell.setValue('O');
        Assertions.assertEquals(cell.getValue(),'O');
    }
}