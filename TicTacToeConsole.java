import java.util.Scanner;
import java.util.InputMismatchException;


public class TicTacToeConsole {
    static Scanner scanner = new Scanner(System.in);
    private TicTacToeModel modelBoard;
    private char[][] displayBoard;
    private char currPlayer;
    private int userRow = 0;
    private int userCol = 0;

    public TicTacToeConsole() {
        modelBoard = new TicTacToeModel();
        displayBoard = modelBoard.getBoard();
        currPlayer = modelBoard.getCurrentPlayer();
    }

    private void showDisplayBoard() {
        System.out.println("   0  1  2");
        for (int row = 0; row < 3; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < 3; col++) {
                System.out.print("[" + displayBoard[row][col] + "]");
            }
            System.out.println();
        }
    }

    private void playTTT() {
        try {
            System.out.println("Enter Row (0, 1 or 2): ");
            userRow = scanner.nextInt();

            System.out.println("Enter Column (0, 1 or 2): ");
            userCol = scanner.nextInt();
            
            if (userRow >= 0 && userRow <= 2 && userCol >= 0 && userCol <= 2) {
                if (modelBoard.placeMarker(userRow, userCol) == false) {
                    playTTT();
                }
                else {
                    if (modelBoard.checkForWin() == true) {
                        System.out.println();
                        System.out.println("GAME OVER, WINNER IS " + currPlayer);
                        showDisplayBoard();
                        System.out.println();
                        System.exit(0);
                    }
                    else {
                        if (modelBoard.isBoardFull() == true) {
                            System.out.println();
                            System.out.println("GAME OVER, BOARD IS FULL");
                            showDisplayBoard();
                            System.out.println();
                            System.exit(0);
                        }
                        else {
                            showDisplayBoard();
                            modelBoard.switchPlayer();
                            System.out.println("Turn is now Player " + modelBoard.getCurrentPlayer());
                            playTTT();
                        }
                    }
                }
            }
            else {
                System.out.println("Row and Column must be between 0 - 2");
                playTTT();
            }
        } 
        catch (InputMismatchException e) {
            System.out.println("Input can only be a whole number");
            scanner.nextLine();
            playTTT();
        }
    }
    public static void main(String[] args) {
        TicTacToeConsole cons = new TicTacToeConsole();
        System.out.println();
        System.out.println("WELCOME TO TIC TAC TOE!");
        System.out.println();
        System.out.println("    Board:   ");
        cons.showDisplayBoard();
        System.out.println("Player: " + cons.currPlayer + " goes first");
        cons.playTTT();
    }
}