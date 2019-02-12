package bv.sci.TicTacToe;

import java.util.Scanner;

/**
 * TicTacToe is the main class of the game
 * It mainly assures the functionality of the program and it controls the interaction between the program and the users
 * It uses the Board, Player and Cell classes, in order to set the game
 *
 * @author Bogdan Butuza
 */
public class TicTacToe {

    /**
     * This method prints the available options to the user, in order to get the input
     */
    private static void showMenu() {
        System.out.println("Tic-Tac-Toe Game:" + "\n" + "Select an option: ");
        System.out.println("1. Start new game");
        System.out.println("2. Exit");
    }

    /**
     * The method showBoard ensures that the board is displayed to the user
     * @param board a Board object, representing the current game board
     */
    private static void showBoard(Board board) {
        for (int i = 0; i < board.getCells().length; i++) {
            int j = 0;
            do {
                System.out.print(board.getCells()[i][j].getValue() + " | ");
                j++;
            } while (j < board.getCells().length - 1);
            System.out.println(board.getCells()[i][j].getValue());
            if (i != board.getCells().length - 1) {
                System.out.println("-----------");
            }
        }
    }

    /**
     * This method will ask the player to make a move
     * After the messaage is printed, it's input will be asked
     * @param player a Player object, representing the asked player
     */
    private static void askForMove(Player player) {
        System.out.println(player.getName() + ", enter your move (row[1-3] column[1-3]: ");
    }

    /**
     * This checkForMessage method validates a message, in order to print it to the console
     * This method will avoid the printing of a null message
     * @param message a String value, as the message to be verified
     *                !this parameter will receive the reesult of methods getWinnerMessage and getPositionMessage,
     *                so a not null message will be available when there is an incoming win or an invalid position
     */
    public static void checkForMessage(String message) {
        if (message != null) {
            System.out.println(message);
        }
    }

    /**
     * This method is meant to asset the right steps for each player of the game (one by one, for each Player 'X' and
     * Player 'O')
     * @param player a Player object, meaning the current player for which the sets will be applied
     * @param board a Board object, representing the current game board
     */
    public static void playGame(Player player, Board board) {
        int position1;
        int position2;

        do {
            // Asking the player to choose a position and reading the two coordinates: row and column
            askForMove(player);
            Scanner input = new Scanner(System.in);
            position1 = input.nextInt() - 1;
            position2 = input.nextInt() - 1;
            // Checking if the position is available; repeating until inputted values are valid coordinates
            checkForMessage(board.getPositionMessage(position1, position2));
        } while (!board.checkMove(position1, position2));

        // Assigning the value and checking if the player has won the game
        board.assignValue(player.getSymbol(), position1, position2);
        checkForMessage(board.getWinnerMessage(player));
    }

    public static void main(String[] args) {
        // Showing the game menu and inputting user's option
        showMenu();
        System.out.print("Your option is: ");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        do {
            if (option == 1) {
                // Asking the first player for a choice; if the input is not valid, it will receive an X-in Player class
                System.out.println("X or O ?:");
                char symbol1 = Character.toUpperCase(input.next().charAt(0));
                Player player1 = new Player(symbol1);
                char symbol2 = (player1.getSymbol() == 'X') ? 'O' : 'X';
                Player player2 = new Player(symbol2);
                Board game = new Board();
                // Setting the current game status
                boolean isPlaying;

                do {
                    // First player's turn
                    showBoard(game);
                    playGame(player1, game);
                    // Checking the game status
                    isPlaying = !game.checkWinner(player1.getSymbol()) && game.isAvailable();
                    // Checking if there is any available position
                    if (!game.isAvailable()) {
                        System.out.println("Game over!");
                    }

                    // Second player's turn - doing the same like for the first player
                    if (isPlaying) {
                        showBoard(game);
                        playGame(player2, game);
                        isPlaying = !game.checkWinner(player2.getSymbol()) && game.isAvailable();
                    }
                } while (isPlaying);
            } else {
                System.out.println("Your option is not available!");
            }
            // Entering the game menu again, if the users desire a new game
            showMenu();
            System.out.println("Your option is: ");
            option = input.nextInt();
        } while (option != 2);
    }

}