package test;

import org.junit.Test;
import pacman.PacManNavigator;
import pacman.PacManNavigatorImpl_Skeleton;

import static org.junit.Assert.assertTrue;
import static pacman.Direction.*;

/**
 @author Jeffrey Ng
 @created 2020-05-13 */
public class PacManNavigatorImplTest_2_COMPONENTS extends PacManNavigatorImplTest_1_ENVIRONMENT {
    protected String buildMaze() {
        String row01 = "|===================|";
        String row02 = "|*******************|";
        String row03 = "|*|*|==|*|=|*|==|*|*|";
        String row04 = "|*|*|==|*|=|*|==|*|*|";
        String row05 = "|*******************|";
        String row06 = "|*|=|*|*|=O=|*|*|=|*|";
        String row07 = "|*|***|***|***|*****|";
        String row08 = "|*|===|=|*|*|=|===|*|";
        String row09 = "|*******|*|*|*******|";
        String row10 = "|*|====|**|**|====|*|";
        String row11 = "|*|******|=|******|*|";
        String row12 = "|***|==|*****|==|***|";
        String row13 = "|===================|";

        String[] aux = new String[] {
                row01, row02, row03, row04, row05,
                row06, row07, row08, row09, row10,
                row11, row12, row13,
                };

        StringBuilder sb = new StringBuilder();
        for (String row : aux) {
            sb.append(row).append('\n');
        }

        return sb.toString().trim();
    }

    protected PacManNavigator getPacMan(int maxTurns) {
        return new PacManNavigatorImpl_Skeleton(buildMaze(), maxTurns);
    }

    @Test
    public void test1() {
        final int maxTurns = 10;
        PacManNavigator navigator = getPacMan(maxTurns);
        System.out.println(navigator);

        assertTrue(true);

        navigator.move(E);
        navigator.move(E);
        navigator.move(E);
        navigator.move(S);
        navigator.move(S);
        navigator.move(W);
        navigator.move(W);

    }

}