import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TicTacToeTest {
    
    @Test
    public void testRow1Win() {
        TicTacToeModel model = new TicTacToeModel();
        model.placeMarker(0, 0);
        model.placeMarker(0, 1);
        model.placeMarker(0, 2);

        assertTrue(model.checkForWin());
        System.out.println("Test Row 1 Was Successful");
    }

    @Test
    public void testRow2Win() {
        TicTacToeModel model = new TicTacToeModel();
        model.placeMarker(1, 0);
        model.placeMarker(1, 1);
        model.placeMarker(1, 2);

        assertTrue(model.checkForWin());
        System.out.println("Test Row 2 Was Successful");
    }

    @Test
    public void testRow3Win() {
        TicTacToeModel model = new TicTacToeModel();
        model.placeMarker(2, 0);
        model.placeMarker(2, 1);
        model.placeMarker(2, 2);

        assertTrue(model.checkForWin());
        System.out.println("Test Row 3 Was Successful");
    }

    @Test
    public void testCol1Win() {
        TicTacToeModel model = new TicTacToeModel();
        model.placeMarker(0, 0);
        model.placeMarker(1, 0);
        model.placeMarker(2, 0);

        assertTrue(model.checkForWin());
        System.out.println("Test Column 1 Was Successful");
    }

    @Test
    public void testCol2Win() {
        TicTacToeModel model = new TicTacToeModel();
        model.placeMarker(0, 1);
        model.placeMarker(1, 1);
        model.placeMarker(2, 1);

        assertTrue(model.checkForWin());
        System.out.println("Test Column 2 Was Successful");
    }

    @Test
    public void testCol3Win() {
        TicTacToeModel model = new TicTacToeModel();
        model.placeMarker(0, 2);
        model.placeMarker(1, 2);
        model.placeMarker(2, 2);

        assertTrue(model.checkForWin());
        System.out.println("Test Column 3 Was Successful");
    }

    @Test
    public void testDiag1Win() {
        TicTacToeModel model = new TicTacToeModel();
        model.placeMarker(0, 0);
        model.placeMarker(1, 1);
        model.placeMarker(2, 2);

        assertTrue(model.checkForWin());
        System.out.println("Test Diagonal 1 Was Successful");
    }

    @Test
    public void testDiag2Win() {
        TicTacToeModel model = new TicTacToeModel();
        model.placeMarker(2, 0);
        model.placeMarker(1, 1);
        model.placeMarker(0, 2);

        assertTrue(model.checkForWin());
        System.out.println("Test Diagonal 2 Was Successful");
    }
}