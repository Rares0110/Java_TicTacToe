import java.util.Scanner;


class TicTacToeModel {
    private char[][] board;
    private char turn;
    static Scanner scanner = new Scanner(System.in);

    public TicTacToeModel() {
        board = new char[3][3];
        initialiseBoard();
        turn = 'X';

        //System.out.println("Constructor Ran");
    }

    private void initialiseBoard() {
        //System.out.println("Creating Board");

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    public void showDisplayBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void switchPlayer() {
        getCurrentPlayer();
        if (turn == 'X') {
            turn = 'O';
            System.out.println("Turn is now Player O");
        }
        else {
            turn = 'X';
            System.out.println("Turn is now Player X");
        }
    }

    public void resetBoard() {
        board = new char[3][3];
    }

    public char getCurrentPlayer() {
        //System.out.println("Get currentPlayer worked");
        return turn;
        }

    public int[] getMark() {
        try {
            System.out.println("Enter Row (0, 1 or 2): ");
            int row = scanner.nextInt();

            System.out.println("Enter Column (0, 1 or 2): ");
            int col = scanner.nextInt();
            
            if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
                return new int[] {row, col};
            }
            else {
                System.out.println("Row and Column must be between 0 - 2");
                return getMark();
            }
        } 
        catch (NumberFormatException e) {
            System.out.println("Input can only be a whole number");
            scanner.nextLine();
            return getMark();
        }
    }
    
    public boolean placeMarker() {
        getCurrentPlayer();
        int[] cords = getMark();
        int row = cords[1];
        int col = cords[0];

        if (board[row][col] == '-') {
            board[row][col] = turn;
            //System.out.println("Placed marker successfully");
            if (checkForWin() == true) {
                System.out.println("Player: " + getCurrentPlayer() + " Wins!");
                return true;
            }
            else {
                showDisplayBoard();
                switchPlayer();
                placeMarker();
                return true;
            }
        }
        else {
            System.out.println("That spot is already taken");
            placeMarker();
            return false;
        }
    }

    private boolean checkRows() {
        if (board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
            return true;
        }
        else if (board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
            return true;
        }
        else if (board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean checkColumns() {
        if (board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
            return true;
        }
        else if (board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
            return true;
        }
        else if (board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean checkDiagonals() {
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        else if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkForWin() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }
    
    public boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '-') {
                    return false;
                }
            }
        }
        if (checkForWin() == true) {
            System.out.println("Player: " + getCurrentPlayer() + "Wins!");
            resetBoard();
            return true;
        }
        else {
            System.out.println("Nobody has won");
            resetBoard();
            return true;
        }
    }


    public static void main(String[] args) {
        TicTacToeModel model = new TicTacToeModel();
        System.out.println("WELCOME TO TIC TAC TOE!");

        model.showDisplayBoard();
        System.out.println("Player: " + model.getCurrentPlayer() + " goes first");
        model.placeMarker();
    }
}

