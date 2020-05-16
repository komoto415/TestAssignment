package test.piece;

import chess.GridPosition;
import chess.piece.Piece;
import org.junit.Test;
import test.Points;

import java.lang.reflect.InvocationTargetException;

import static chess.GridPosition.*;
import static org.junit.Assert.assertArrayEquals;

/**
 @author Jeffrey Ng
 @created 2020-05-13 */
public class PieceTest_3_Knight extends PieceTest_2_Rook {

    // 6 tests => 30 points

    @Points(value = 5)
    @Test
    public void knightA8() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        TEST_GOAL_MESSAGE = "Checking if lower bound out of range indexing is handled with a valid return value";

        String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        GridPosition gp = extractGridPositionFromTestName(testName);
        Piece p = getPieceFromTestName(testName);

        int[][] actual = p.getEndpointListFromCurrentPosition(gp);
        int[][] expected = new int[][] {
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 0, 1, 0, 0, 0, 0, 0,},
                new int[] {0, 1, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                };

        assertArrayEquals(expected, actual);
    }

    @Points(value = 5)
    @Test
    public void knightA1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        TEST_GOAL_MESSAGE = "Checking if upper bound out of range indexing is handled with a valid return value";

        String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        GridPosition gp = extractGridPositionFromTestName(testName);
        Piece p = getPieceFromTestName(testName);

        int[][] actual = p.getEndpointListFromCurrentPosition(gp);
        int[][] expected = new int[][] {
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 1, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 0, 1, 0, 0, 0, 0, 0,},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                };

        assertArrayEquals(expected, actual);
    }

    @Points(value = 5)
    @Test
    public void knightC3() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        TEST_GOAL_MESSAGE = "Simple return value where there is no immediate surrounding obstruction";

        String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        GridPosition gp = extractGridPositionFromTestName(testName);
        Piece p = getPieceFromTestName(testName);

        int[][] actual = p.getEndpointListFromCurrentPosition(gp);
        int[][] expected = new int[][] {
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 1, 0, 1, 0, 0, 0, 0,},
                new int[] {1, 0, 0, 0, 1, 0, 0, 0,},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                new int[] {1, 0, 0, 0, 1, 0, 0, 0,},
                new int[] {0, 1, 0, 1, 0, 0, 0, 0,},
                };

        assertArrayEquals(expected, actual);
    }

    @Points(value = 5)
    @Test
    public void knightA1B3() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        TEST_GOAL_MESSAGE = "2 steps up the file and 1 step right along the row by a Knight";

        String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        GridPosition endGP = extractGridPositionFromTestName(testName);
        GridPosition curGP = extractGridPositionFromTestName_(testName);
        Piece p = getPieceFromTestName_(testName);

        GridPosition[] actual = p.path(curGP, endGP);
        GridPosition[] expected = new GridPosition[] {A2, A3, B3,};

        assertArrayEquals(expected, actual);
    }

    @Points(value = 5)
    @Test
    public void knightC2A1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        TEST_GOAL_MESSAGE = "2 steps left along the row and 1 step down the file by a Knight";

        String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        GridPosition endGP = extractGridPositionFromTestName(testName);
        GridPosition curGP = extractGridPositionFromTestName_(testName);
        Piece p = getPieceFromTestName_(testName);

        GridPosition[] actual = p.path(curGP, endGP);
        GridPosition[] expected = new GridPosition[] {B2, A2, A1,};

        assertArrayEquals(expected, actual);
    }

    @Points(value = 5)
    @Test(expected = AssertionError.class)
    public void knightA1H1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        TEST_GOAL_MESSAGE = "Illegal flat horizontal step attempted to be made by a Knight";

        String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        GridPosition endGP = extractGridPositionFromTestName(testName);
        GridPosition curGP = extractGridPositionFromTestName_(testName);
        Piece p = getPieceFromTestName_(testName);

        GridPosition[] actual = p.path(curGP, endGP);
    }
}
