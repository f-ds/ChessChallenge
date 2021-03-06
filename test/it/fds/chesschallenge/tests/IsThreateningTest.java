package it.fds.chesschallenge.tests;

import it.fds.chesschallenge.model.chessboard.ChessBoard;
import it.fds.chesschallenge.model.chessboard.MatrixChessBoard;
import it.fds.chesschallenge.model.chessman.Bishop;
import it.fds.chesschallenge.model.chessman.Chessman;
import it.fds.chesschallenge.model.chessman.King;
import it.fds.chesschallenge.model.chessman.Knight;
import it.fds.chesschallenge.model.chessman.Queen;
import it.fds.chesschallenge.model.chessman.Rook;
import it.fds.chesschallenge.model.configuration.Configuration;
import it.fds.chesschallenge.model.configuration.HashedConfiguration;

import org.junit.Test;
/**
 * This test suite validates the implementation provided by all of the {@link Chessman} specialized classes of the {@link Chessman}{@link #IsThreateningTest()} method.
 * 
 * @author DamianoG
 * 
 */
public class IsThreateningTest extends BaseChessChallengeTest {

    public static int numRow = 7;

    public static int numCol = 7;

    @Test
    public void testKnight() {
        Chessman cp = new Knight(1);
        
        //Test against a 5x5 matrix
        int matrixSize = 5;
        Integer[][] positions = buildPositionsArray(matrixSize, matrixSize);
        
        cp.setPos(0, 0);
        assertEquals(2, testIsThreatening(positions, cp, matrixSize, matrixSize));
        
        cp.setPos(1, 1);
        assertEquals(4, testIsThreatening(positions, cp, matrixSize, matrixSize));
        
        cp.setPos(3, 3);
        assertEquals(4, testIsThreatening(positions, cp, matrixSize, matrixSize));
        
        cp.setPos(2, 2);
        assertEquals(8, testIsThreatening(positions, cp, matrixSize, matrixSize));
        
        cp.setPos(4, 4);
        assertEquals(2, testIsThreatening(positions, cp, matrixSize, matrixSize));
        
        cp.setPos(0, 3);
        assertEquals(3, testIsThreatening(positions, cp, matrixSize, matrixSize));

        //Test against a 8x8 matrix
        matrixSize = 8;
        cp.setPos(3, 3);
        positions = buildPositionsArray(matrixSize, matrixSize);
        assertEquals(8, testIsThreatening(positions, cp, matrixSize, matrixSize));
        
        //Test against a 3x3 matrix
        matrixSize = 3;
        cp.setPos(1, 1);
        positions = buildPositionsArray(matrixSize, matrixSize);
        assertEquals(0, testIsThreatening(positions, cp, matrixSize, matrixSize));
        
        //Test against a 5x3 matrix
        int matrixSizeX = 5;
        int matrixSizeY = 3;
        cp.setPos(1, 1);
        positions = buildPositionsArray(matrixSizeX, matrixSizeY);
        assertEquals(2, testIsThreatening(positions, cp, matrixSizeX, matrixSizeY));
        
        cp.setPos(2, 2);
        positions = buildPositionsArray(matrixSizeX, matrixSizeY);
        assertEquals(4, testIsThreatening(positions, cp, matrixSizeX, matrixSizeY));
        
        cp.setPos(2, 1);
        positions = buildPositionsArray(matrixSizeX, matrixSizeY);
        assertEquals(4, testIsThreatening(positions, cp, matrixSizeX, matrixSizeY));
        
        cp.setPos(3, 2);
        positions = buildPositionsArray(matrixSizeX, matrixSizeY);
        assertEquals(3, testIsThreatening(positions, cp, matrixSizeX, matrixSizeY));
    }
    
    @Test
    public void testBishop() {
        Chessman cp = new Bishop(1);
        
        //Test against a 5x5 matrix
        int matrixSize = 5;
        Integer[][] positions = buildPositionsArray(matrixSize, matrixSize);
        
        cp.setPos(0, 0);
        assertEquals(4, testIsThreatening(positions, cp, matrixSize, matrixSize));

        //Test against a 8x8 matrix
        matrixSize = 8;
        cp.setPos(3, 3);
        positions = buildPositionsArray(matrixSize, matrixSize);
        assertEquals(13, testIsThreatening(positions, cp, matrixSize, matrixSize));
        
        //Test against a 3x3 matrix
        matrixSize = 3;
        cp.setPos(1, 1);
        positions = buildPositionsArray(matrixSize, matrixSize);
        assertEquals(4, testIsThreatening(positions, cp, matrixSize, matrixSize));
        
        //Test against a 5x3 matrix
        int matrixSizeX = 5;
        int matrixSizeY = 3;
        
        cp.setPos(1, 1);
        positions = buildPositionsArray(matrixSizeX, matrixSizeY);
        assertEquals(4, testIsThreatening(positions, cp, matrixSizeX, matrixSizeY));
    }
    
    @Test
    public void testQueen() {
        Chessman cp = new Queen(1);
        
        //Test against a 5x5 matrix
        int matrixSize = 5;
        Integer[][] positions = buildPositionsArray(matrixSize, matrixSize);
        
        cp.setPos(0, 0);
        assertEquals(12, testIsThreatening(positions, cp, matrixSize, matrixSize));

        //Test against a 8x8 matrix
        matrixSize = 8;
        cp.setPos(3, 3);
        positions = buildPositionsArray(matrixSize, matrixSize);
        assertEquals(27, testIsThreatening(positions, cp, matrixSize, matrixSize));
        
        cp.setPos(4, 4);
        positions = buildPositionsArray(matrixSize, matrixSize);
        assertEquals(27, testIsThreatening(positions, cp, matrixSize, matrixSize));
        
        //Test against a 3x3 matrix
        matrixSize = 3;
        cp.setPos(1, 1);
        positions = buildPositionsArray(matrixSize, matrixSize);
        assertEquals(8, testIsThreatening(positions, cp, matrixSize, matrixSize));
        
        //Test against a 5x3 matrix
        int matrixSizeX = 5;
        int matrixSizeY = 3;
        
        cp.setPos(1, 1);
        positions = buildPositionsArray(matrixSizeX, matrixSizeY);
        assertEquals(10, testIsThreatening(positions, cp, matrixSizeX, matrixSizeY));
    }
    
    @Test
    public void testKing() {
        King cp = new King(1);
        
        //Test against a 5x5 matrix
        int matrixSize = 5;
        Integer[][] positions = buildPositionsArray(matrixSize, matrixSize);
        
        cp.setPos(0, 0);
        assertEquals(3, testIsThreatening(positions, cp, matrixSize, matrixSize));

        //Test against a 8x8 matrix
        matrixSize = 8;
        cp.setPos(3, 3);
        positions = buildPositionsArray(matrixSize, matrixSize);
        assertEquals(8, testIsThreatening(positions, cp, matrixSize, matrixSize));
        
        //Test against a 3x3 matrix
        matrixSize = 3;
        cp.setPos(1, 1);
        positions = buildPositionsArray(matrixSize, matrixSize);
        assertEquals(8, testIsThreatening(positions, cp, matrixSize, matrixSize));
        
        //Test against a 5x3 matrix
        int matrixSizeX = 5;
        int matrixSizeY = 3;
        
        cp.setPos(1, 1);
        positions = buildPositionsArray(matrixSizeX, matrixSizeY);
        assertEquals(8, testIsThreatening(positions, cp, matrixSizeX, matrixSizeY));
    }
    
    @Test
    public void testRook() {
        Rook cp = new Rook(1);
        
        //Test against a 5x5 matrix
        int matrixSize = 5;
        Integer[][] positions = buildPositionsArray(matrixSize, matrixSize);
        
        cp.setPos(0, 0);
        assertEquals(8, testIsThreatening(positions, cp, matrixSize, matrixSize));

        //Test against a 8x8 matrix
        matrixSize = 8;
        cp.setPos(3, 3);
        positions = buildPositionsArray(matrixSize, matrixSize);
        assertEquals(14, testIsThreatening(positions, cp, matrixSize, matrixSize));
        
        //Test against a 3x3 matrix
        matrixSize = 3;
        cp.setPos(1, 1);
        positions = buildPositionsArray(matrixSize, matrixSize);
        assertEquals(4, testIsThreatening(positions, cp, matrixSize, matrixSize));
        
        //Test against a 5x3 matrix
        int matrixSizeX = 5;
        int matrixSizeY = 3;
        
        cp.setPos(1, 1);
        positions = buildPositionsArray(matrixSizeX, matrixSizeY);
        assertEquals(6, testIsThreatening(positions, cp, matrixSizeX, matrixSizeY));
    }
    
    private int testIsThreatening(Integer positionsToCheck[][], Chessman cp, int positionMatrixX, int positionMatrixY) {
        if (positionsToCheck == null || positionsToCheck.length <= 0
                || positionsToCheck[0].length != 2) {
            throw new IllegalArgumentException("wrong parameters...");
        }
        int counter = 0;
        for (Integer[] b : positionsToCheck) {
            ChessBoard board = new MatrixChessBoard(positionMatrixX, positionMatrixY);
            Configuration config = new HashedConfiguration<>();
            config.add(new King(1, b[0], b[1]));
            board.initChessboard(config);
            if (cp.isThreatening(board))
                counter++;
        }
        return counter;

    }
}
