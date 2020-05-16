package test.piece;

import chess.GridPosition;
import chess.Player;
import chess.piece.Piece;
import org.junit.Test;
import test.Points;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static chess.GridPosition.A2;
import static chess.GridPosition.B1;
import static org.junit.Assert.assertArrayEquals;

/**
 @author Jeffrey Ng
 @created 2020-05-13 */
public class PieceTest_1_King extends PieceTest_0_Environment {
    protected Piece getPieceFromTestName(String testName) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        String classNameAux = testName.substring(0, testName.length() - 2);
        char title = classNameAux.toUpperCase().charAt(0);
        String restOfTheClassName = classNameAux.substring(1);
        StringBuilder sb = new StringBuilder();
        String className = sb.append(title).append(restOfTheClassName).toString();
        Class<?> clazz = Class.forName(String.format("chess.piece.%s", className));
        Constructor<?> constructor = clazz.getConstructor(Player.class);
        return (Piece) constructor.newInstance(Player.WHITE);
    }

    protected Piece getPieceFromTestName_(String testName) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        String classNameAux = testName.substring(0, testName.length() - 4);
        char title = classNameAux.toUpperCase().charAt(0);
        String restOfTheClassName = classNameAux.substring(1);
        StringBuilder sb = new StringBuilder();
        String className = sb.append(title).append(restOfTheClassName).toString();
        Class<?> clazz = Class.forName(String.format("chess.piece.%s", className));
        Constructor<?> constructor = clazz.getConstructor(Player.class);
        return (Piece) constructor.newInstance(Player.WHITE);
    }

    protected GridPosition extractGridPositionFromTestName(String testName) {
        return GridPosition.translate(testName.substring(testName.length() - 2));
    }

    protected GridPosition extractGridPositionFromTestName_(String testName) {
        return GridPosition.translate(testName.substring(testName.length() - 4, testName.length() - 2));
    }

    // 6 tests => 30 points

    @Points(value = 5)
    @Test
    public void kingA8() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        TEST_GOAL_MESSAGE = "Checking if lower bound out of range indexing is handled with a valid return value";

        String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        GridPosition gp = extractGridPositionFromTestName(testName);
        Piece p = getPieceFromTestName(testName);

        int[][] actual = p.getEndpointListFromCurrentPosition(gp);
        int[][] expected = new int[][] {
                new int[] {0, 1, 0, 0, 0, 0, 0, 0,},
                new int[] {1, 1, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
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
    public void kingA1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
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
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                new int[] {1, 1, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 1, 0, 0, 0, 0, 0, 0,},
                };

        assertArrayEquals(expected, actual);
    }

    @Points(value = 5)
    @Test
    public void kingC3() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
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
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                new int[] {0, 1, 1, 1, 0, 0, 0, 0,},
                new int[] {0, 1, 0, 1, 0, 0, 0, 0,},
                new int[] {0, 1, 1, 1, 0, 0, 0, 0,},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0,},
                };

        assertArrayEquals(expected, actual);
    }

    @Points(value = 5)
    @Test
    public void kingA3A2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        TEST_GOAL_MESSAGE = "1 step down the file by a King";

        String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        GridPosition endGP = extractGridPositionFromTestName(testName);
        GridPosition curGP = extractGridPositionFromTestName_(testName);
        Piece p = getPieceFromTestName_(testName);

        GridPosition[] actual = p.path(curGP, endGP);
        GridPosition[] expected = new GridPosition[] {A2,};

        assertArrayEquals(expected, actual);
    }

    @Points(value = 5)
    @Test
    public void kingA1B1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        TEST_GOAL_MESSAGE = "1 step right along the row by a King";

        String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        GridPosition endGP = extractGridPositionFromTestName(testName);
        GridPosition curGP = extractGridPositionFromTestName_(testName);
        Piece p = getPieceFromTestName_(testName);

        GridPosition[] actual = p.path(curGP, endGP);
        GridPosition[] expected = new GridPosition[] {B1,};

        assertArrayEquals(expected, actual);
    }

    @Points(value = 5)
    @Test(expected = AssertionError.class)
    public void kingA1A3() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {
        TEST_GOAL_MESSAGE = "Illegal 2 steps attempted to be made by a King";

        String testName = Thread.currentThread().getStackTrace()[1].getMethodName();
        GridPosition endGP = extractGridPositionFromTestName(testName);
        GridPosition curGP = extractGridPositionFromTestName_(testName);
        Piece p = getPieceFromTestName_(testName);

        GridPosition[] actual = p.path(curGP, endGP);
    }
}
