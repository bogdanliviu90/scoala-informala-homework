package bv.sci.TicTacToe;
import java.lang.Character;

/**
 * Class Player holds the methods for each player
 * This class will be instantiated for both 'X' and 'O' players
 *
 * @author Bogdan Butuza
 */
public class Player {
    private String name;
    private char symbol;

    /**
     * Constructor will automatically create aa title for each player, depending on the symbol a player is holding
     * @param symbol a char parameter, that will be assigned to the player
     */
    public Player(char symbol) {
        setSymbol(symbol);
        this.name = "Player " + "'" + this.symbol + "'";
    }

    public String getName() {
        return name;
    }

    /**
     * This method brings a symbol to uppercase, then assigns it only if it is 'X' or 'O'
     * In case the first player will input any other character than 'X' or 'O', it will receive the 'X' symbol
     * @param symbol the character value to be assigned
     */
    public void setSymbol(char symbol) {
        symbol = Character.toUpperCase(symbol);
        if (symbol == 'X' || symbol == 'O') {
            this.symbol = symbol;
        }else{
            System.out.println("Invalid symbol. Assuming 'X'.");
            this.symbol = 'X';
        }
    }

    public char getSymbol() {
        return symbol;
    }
}