package bv.sci.TicTacToe;
import java.lang.Character;

/**
 * This class describes the principal unit of a TicTacToe board: a cell
 * Each cell will contain a char value, set by the player
 * The default allocated value will be ' ', when the board will be created
 *
 * @author Bogdan Butuza
 */
public class Cell {
    private char value;

    /**
     * The constructor of a cell
     * @param value a char value, that will be converted to uppercase
     */
    public Cell(char value) {
        this.value = Character.toUpperCase(value);
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
            this.value = value;
    }
}