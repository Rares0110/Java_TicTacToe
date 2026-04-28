import java.util.Scanner;


public class TicTacToeConsole {
    TicTacToeModel model = new TicTacToeModel();
    static Scanner scanner = new Scanner(System.in);

    private char[][] displayBoard = model.getBoard();
    private char currPlayer = model.getCurrentPlayer();
    private int userRow = 0;
    private int userCol = 0;

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
                if (model.placeMarker(userRow, userCol) == false) {
                    playTTT();
                }
                else {
                    if (model.checkForWin() == true) {
                        System.out.println("GAME OVER, WINNER IS " + currPlayer);
                        System.exit(0);
                    }
                    else {
                        if (model.isBoardFull() == true) {
                            System.out.println("GAME OVER, BOARD IS FULL");
                            showDisplayBoard();
                            System.exit(0);
                        }
                        else {
                            showDisplayBoard();
                            model.switchPlayer();
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
        catch (NumberFormatException e) {
            System.out.println("Input can only be a whole number");
            scanner.nextLine();
            playTTT();
        }
    }
    public static void main(String[] args) {
        TicTacToeConsole play = new TicTacToeConsole();
        System.out.println();
        System.out.println("WELCOME TO TIC TAC TOE!");
        play.showDisplayBoard();
        System.out.println("Player: " + play.currPlayer + " goes first");
        play.playTTT();
    }
}