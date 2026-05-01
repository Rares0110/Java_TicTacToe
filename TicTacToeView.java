import javax.swing.*;
import java.awt.*;


public class TicTacToeView {
    private JButton[][] button;
    private JLabel statusLabel;
    private JFrame page;

    public TicTacToeView() {
        page = new JFrame("TIC TAC TOE");
        button = new JButton[3][3];

        statusLabel = new JLabel("PLAYER X's TURN", SwingConstants.CENTER);
        statusLabel.setForeground(Color.WHITE);

        page.setLayout(new BorderLayout());
        page.add(statusLabel, BorderLayout.NORTH);

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3, 3));
        
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                button[row][col] = new JButton("[ - ]");
                button[row][col].setBackground(Color.DARK_GRAY);
                button[row][col].setForeground(Color.WHITE);
                button[row][col].setOpaque(true); // THESE 2 ARE FOR MAC ONLY TO SEE THE COLOUR IN THE BUTTONS
                button[row][col].setBorderPainted(false); // THEY CAN BE // OUT IF NOT ON MAC
                gridPanel.add(button[row][col]);
            }
        }
        
        page.getContentPane().setBackground(Color.DARK_GRAY);
        page.add(gridPanel, BorderLayout.CENTER);
        page.setSize(300, 300);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        page.setLocationRelativeTo(null);
        page.setVisible(true);
    }

    public JButton[][] getButtons() {
        return button;
    }

    public void setStatus(String text) {
        statusLabel.setText(text);
    }
}