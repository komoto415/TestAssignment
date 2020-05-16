package chess.piece.utils;

import chess.GridPosition;
import chess.piece.Piece;
import chess.utils.ChessGameUtils_Ng;

/**
 @author Jeffrey Ng
 @created 2020-05-13 */
public class PieceUtils_Ng {
    public static final int OFF_BOARD_DEFAULT_LOWER_BOUND = 0;
    public static final int OFF_BOARD_DEFAULT_UPPER_BOUND = 7;

    public static boolean isCurrent(int curY, int curX, int row, int col) {
        return row == curY && col == curX;
    }

    public static boolean pathIsPossible(Piece p, GridPosition current, GridPosition end) {
        assert current != end;
        int[][] endPoints = p.getEndpointListFromCurrentPosition(current);
        int[] yx = ChessGameUtils_Ng.convertGridPositionTo2DYXArray(end);
        return endPoints[yx[ChessGameUtils_Ng.Y_INDEX]][yx[ChessGameUtils_Ng.X_INDEX]] == 1;
    }
}
