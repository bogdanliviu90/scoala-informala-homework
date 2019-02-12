package bv.sci.TicTacToe;

/**
 * This class prepare and holds the board of the game
 * It creates a new board and holds methods which can assign a vaalue to a certain position, it checks if a move is
 * available, or it can search for a winner.
 *
 * @author Bogdan Butuza
 */
public class Board {
    private Cell[][] cells;

    /**
     * Constructor initializes a new empty board with ' ' values
     */
    public Board() {
        Cell[][] board = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new Cell(' ');
            }
        }
        this.cells = board;
    }

    public Cell[][] getCells() {
        return cells;
    }

    /**
     * This method assigns a value to the desired position, defined by three coordinates
     * @param symbol a char value, representing the player's choice ('X' or 'O')
     * @param position1 an integer value, representing the row coordinate
     * @param position2 an integer value, representing the column coordinate
     */
    public void assignValue(char symbol, int position1, int position2) {
        cells[position1][position2].setValue(symbol);
    }

    /**
     * Method checkMove simply checks if a desired position(given by these two coordinates) is available
     * This helps the previous assignValue method, in order to find a valid position
     * @param position1 an integer value, representing the row coordinate
     * @param position2 an integer value, representing the column coordinate
     * @return true, if the desired position is empty and it can host other value than ' '
     *         false, if it is not available or simply invalid
     */
    public boolean checkMove(int position1, int position2) {
        if (position1 >= cells.length || position2 >= cells.length) {
            return false;
        }
        if (cells[position1][position2].getValue() != ' ') {
            return false;
        }
        return true;
    }

    /**
     * This method checks if a player wins the game
     * Its condition is a matter of certain methods that check if the win is on the lines, on the rows, or on the both
     * diagonals
     * @param symbol a char value, which represents the player's choice ('X' or 'O')
     * @return true, if a win is found
     *         false, otherwise
     */
    public boolean checkWinner(char symbol) {
        if (checkRows(symbol) || checkColumns(symbol) || checkMainDiagonal(symbol) ||
                checkSecondaryDiagonal(symbol)) {
            return true;
        }
        return false;
    }

    /**
     * This method checks if three characters of the same type are alligned on the same row
     * @param symbol a character value, as the symbol to be searched for
     * @return true, if the characters are found
     *         false, otherwise
     */
    public boolean checkRows(char symbol) {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i][0].getValue() == symbol && cells[i][1].getValue() == symbol & cells[i][2].getValue() == symbol) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks if we have three symbols of the same type on a column
     * @param symbol a character value, as the symbol to be searched for
     * @return true, if the symbols are encountered
     *         false, otherwise
     */
    public boolean checkColumns(char symbol) {
        for (int j = 0; j < cells.length; j++) {
            if (cells[0][j].getValue() == symbol && cells[1][j].getValue() == symbol && cells[2][j].getValue() == symbol) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks if we have three characters of the same type on the main diagonal
     * @param symbol a character value, for the symbol to be searched for
     * @return true, if the three symbols are found
     *         false, otherwise
     */
    public boolean checkMainDiagonal(char symbol) {
        if (cells[0][0].getValue() == symbol && cells[1][1].getValue() == symbol && cells[2][2].getValue() == symbol) {
            return true;
        }
        return false;
    }

    /**
     * This method checks if we have three characters of the same type on the secondary diagonal
     * @param symbol a character value, for the symbol to be searched for
     * @return true, if the three characters are found
     *         false, otherwise
     */
    public boolean checkSecondaryDiagonal(char symbol) {
        if (cells[0][2].getValue() == symbol && cells[1][1].getValue() == symbol && cells[2][0].getValue() == symbol) {
            return true;
        }
        return false;
    }

    /**
     * This method uses the checkMove method, to find if a position is valid and available
     * Based on this check, the actual method will get a message, which will inform the user - in case the position is
     * not available
     * @param position1 an integer value, meaning the row coordinate
     * @param position2 an integer value, meaning the column coordinate
     * @return a message indicating that the given position is not available, in case it is not
     *         a null message if the position is available
     */
    public String getPositionMessage(int position1, int position2) {
        if (checkMove(position1, position2)) {
            return null;
        }
        return "This move at (" + (position1 + 1) + "," + (position2 + 1) + ") is not valid." +
                " Try again...";
    }

    /**
     * This method uses the checkWinner method, in order to get a winning message
     * @param player a Player object, which represents one of the current players
     * @return a message of type "Player '(player's symbol)' has won"
     *         a null message, if nobody won at the moment
     */
    public String getWinnerMessage(Player player) {
        if (checkWinner(player.getSymbol())) {
            return player.getName() + " won!";
        }

        return null;
    }

    /**
     * Method isAvailable checks if the board has at least one free position, in order to make at least one move
     * It iterates to find at least one ' ' value
     * @return true, if at least a single ' ' value is found
     *         false, otherwise
     */
    public boolean isAvailable() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                if (cells[i][j].getValue() == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

}