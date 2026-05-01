class TicTacToeModel {
    private char[][] board;
    private char currentPlayer;

    public TicTacToeModel() {
        board = new char[3][3];
        initialiseBoard();
        currentPlayer = 'X';

        //System.out.println("Constructor Ran");
    }

    public char[][] getBoard() {
        return board;
    }

    private void initialiseBoard() {
        //System.out.println("Creating Board");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = '-';
            }
        }
    }

    public void switchPlayer() {
        getCurrentPlayer();
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
            //System.out.println("Turn is now Player O");
        }
        else {
            currentPlayer = 'X';
            //System.out.println("Turn is now Player X");
        }
    }

    public void resetBoard() {
        initialiseBoard();
    }

    public char getCurrentPlayer() {
        //System.out.println("Get currentPlayer worked");
        return currentPlayer;
        }

    public char getMark(int row, int col) {
        return board[row][col];
    }
    
    public boolean placeMarker(int row, int col) {
        if (getMark(col, row) == '-') {
            board[col][row] = currentPlayer;
            //System.out.println("Placed marker successfully");
            return true;
        }
        else {
            System.out.println("That spot is already taken");
            return false;
        }
    }

    private boolean checkRows() {
        if (board[0][0] != '-' && board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
            return true;
        }
        else if (board[0][1] != '-' && board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
            return true;
        }
        else if (board[0][2] != '-' && board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean checkColumns() {
        if (board[0][0] != '-' && board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
            return true;
        }
        else if (board[1][0] != '-' && board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
            return true;
        }
        else if (board[2][0] != '-' && board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean checkDiagonals() {
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        else if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
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
        return true;
    }
}
