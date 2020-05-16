package test.piece;

import org.junit.Test;
import test.Points;

/**
 @author Jeffrey Ng
 @created 2020-05-13 */
public class PieceTest_0_Environment {
    protected String TEST_GOAL_MESSAGE;

    // Total (Piece) 30, 30, 30, 35, 35, 45, 45 = 250

    @Points(value = 0)
    @Test(expected = AssertionError.class)
    public void assertionsEnabledTest() {
        TEST_GOAL_MESSAGE = "Check whether assertions are enabled";
        assert false;
        throw new RuntimeException("ENABLE ASSERTIONS IN RUN CONFIGURATION!");
    }
}
