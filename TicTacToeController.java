import javax.swing.*;  
import java.awt.event.*;
import java.awt.Color;


public class TicTacToeController {
    private TicTacToeModel model;
    private TicTacToeView view;
    private JButton[][] buttons;

    public TicTacToeController() {
        this.view = new TicTacToeView();
        this.model = new TicTacToeModel();
        this.buttons = view.getButtons();
        hookUpListeners();
    }

    private void hookUpListeners() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                final int r = row;
                final int c = col;
                buttons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (model.placeMarker(r, c)) {
                            if (model.checkForWin() == true) {
                                buttons[r][c].setText(String.valueOf(model.getCurrentPlayer()));
                                view.setStatus("PLAYER " + model.getCurrentPlayer() + " WINS");
                                disableButtons();
                            }
                            else if (model.isBoardFull() == true) {
                                view.setStatus("GAME OVER - BOARD IS FULL");
                                disableButtons();
                            } 
                            else {
                            buttons[r][c].setText(String.valueOf(model.getCurrentPlayer()));
                            buttons[r][c].setForeground(Color.WHITE);
                            model.switchPlayer();
                            view.setStatus("PLAYER " + model.getCurrentPlayer() + "'s TURN");
                            }
                        }
                    }
                });
            }
        }
    }

    private void disableButtons() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToeController();
    }
}