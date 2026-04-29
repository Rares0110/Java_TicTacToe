import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TicTacToeTest {

    @Test
    void testAll() {
        testRowWins();
        testColWins();
        testDiagWins();
        System.out.println("Everything has passed");
    }
    
    private void testRowWins() {
        TicTacToeModel model = new TicTacToeModel();
        model.placeMarker(0, 0);
        model.placeMarker(1, 0);
        model.placeMarker(2, 0);

        assertTrue(model.checkForWin());
        System.out.println("Test Rows Was Successful");
    }

    private void testColWins() {
        TicTacToeModel model = new TicTacToeModel();
        model.placeMarker(0, 0);
        model.placeMarker(0, 1);
        model.placeMarker(0, 2);

        assertTrue(model.checkForWin());
        System.out.println("Test Columns Was Successful");
    }

    private void testDiagWins() {
        TicTacToeModel model = new TicTacToeModel();
        model.placeMarker(0, 0);
        model.placeMarker(1, 1);
        model.placeMarker(2, 2);

        assertTrue(model.checkForWin());
        System.out.println("Test Diagonals Was Successful");
    }
    public static void main(String[] args) {
        TicTacToeTest test = new TicTacToeTest();
        test.testAll();
    }
} 