package chess.piece;

import chess.*;
import chess.utils.ChessGameUtils_Ng;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public class Rook extends Piece {
    private static final Label ROOK_LABEL = Label.ROOK;
    private static final int ROOK_POINT_VALUE = 5;

    public Rook(Player player) {
        super(ROOK_LABEL, player, ROOK_POINT_VALUE);
    }

    @Override
    public Move_Skeleton[] getMoveListFromCurrentPosition(GridPosition current) {
        throw new RuntimeException("NOW IMPLEMENTED YET");
    }

    @Override
    public int[][] getEndpointListFromCurrentPosition(GridPosition current) {
        int[][] endPoints = new int[ChessGame.ROW_COUNT][ChessGame.COLUMN_COUNT];
        int[] curYX = ChessGameUtils_Ng.convertGridPositionTo2DYXArray(current);
        int y = curYX[ChessGameUtils_Ng.Y_INDEX], x = curYX[ChessGameUtils_Ng.X_INDEX];

        for (int row = 0; row < ChessGame.ROW_COUNT; row++) {
            if (row != y) {
                endPoints[row][x] = 1;
            }
        }

        for (int col = 0; col < ChessGame.COLUMN_COUNT; col++) {
            if (col != x) {
                endPoints[y][col] = 1;
            }
        }

        endPoints[y][x] = 0;

        return endPoints;
    }
}
