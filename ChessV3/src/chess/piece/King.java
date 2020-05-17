package chess.piece;

import chess.*;
import chess.piece.utils.PieceUtils_Ng;
import chess.utils.ChessGameUtils_Ng;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public class King extends Piece {
    private static final Label KING_LABEL = Label.KING;
    private static final int KING_POINT_VALUE = 0;
    private static final int KING_STEP_SIZE = 1;

    public King(Player player) {
        super(KING_LABEL, player, KING_POINT_VALUE);
    }

    @Override
    public Move[] getMoveListFromCurrentPosition(GridPosition current) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public int[][] getEndpointListFromCurrentPosition(GridPosition current) {
        int[][] endPoints = new int[ChessGame.ROW_COUNT][ChessGame.COLUMN_COUNT];
        int[] curYX = ChessGameUtils_Ng.convertGridPositionTo2DYXArray(current);
        int y = curYX[ChessGameUtils_Ng.Y_INDEX], x = curYX[ChessGameUtils_Ng.X_INDEX];

        int lowY = Math.max(y - KING_STEP_SIZE, PieceUtils_Ng.OFF_BOARD_DEFAULT_LOWER_BOUND);
        int highY = Math.min(y + KING_STEP_SIZE, PieceUtils_Ng.OFF_BOARD_DEFAULT_UPPER_BOUND);
        int lowX = Math.max(x - KING_STEP_SIZE, PieceUtils_Ng.OFF_BOARD_DEFAULT_LOWER_BOUND);
        int highX = Math.min(x + KING_STEP_SIZE, PieceUtils_Ng.OFF_BOARD_DEFAULT_UPPER_BOUND);

        for (int row = lowY; row <= highY; row++) {
            for (int col = lowX; col <= highX; col++) {
                if (!PieceUtils_Ng.isCurrent(y, x, row, col)) {
                    endPoints[row][col] = 1;
                }
            }
        }

        return endPoints;
    }

    @Override
    public GridPosition[] getPath(GridPosition current, GridPosition end) {
        assert pathIsPossible(current, end);
        return new GridPosition[] {end};
    }

    @Override
    public boolean pathIsPossible(GridPosition current, GridPosition end) {
        return PieceUtils_Ng.pathIsPossible(this, current, end);
    }
}
