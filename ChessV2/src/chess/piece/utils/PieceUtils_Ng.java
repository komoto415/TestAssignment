package chess.piece.utils;

/**
 @author Jeffrey Ng
 @created 2020-05-13 */
public class PieceUtils_Ng {
    public static final int OFF_BOARD_DEFAULT_LOWER_BOUND = 0;

    public static boolean isCurrent(int curY, int curX, int row, int col) {
        return row == curY && col == curX;
    }
}
