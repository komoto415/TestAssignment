package chess.piece;

import chess.*;
import chess.piece.utils.PieceUtils_Ng;
import chess.utils.ChessGameUtils_Ng;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public class Pawn extends Piece {
    private static final Label PAWN_LABEL = Label.PAWN;
    private static final int PAWN_POINT_VALUE = 1;
    private static final int PAWN_STEP_SIZE = 1;
    private static final int PAWN_SPECIAL_STEP_SIZE = 2;
    private static final int BLACK_PAWN_SPECIAL_RANK = 1;
    private static final int WHITE_PAWN_SPECIAL_RANK = 6;

    public Pawn(Player player) {
        super(PAWN_LABEL, player, PAWN_POINT_VALUE);
    }

    @Override
    public Move[] getMoveListFromCurrentPosition(GridPosition current) {
        throw new RuntimeException("NOW IMPLEMENTED YET");
    }

    @Override
    public int[][] getEndpointListFromCurrentPosition(GridPosition current) {
        int[][] endPoints = new int[ChessGame.ROW_COUNT][ChessGame.COLUMN_COUNT];
        int[] curYX = ChessGameUtils_Ng.convertGridPositionTo2DYXArray(current);
        int y = curYX[ChessGameUtils_Ng.Y_INDEX], x = curYX[ChessGameUtils_Ng.X_INDEX];
        Player player = this.getPlayer();

        int lowX = Math.max(x - PAWN_STEP_SIZE, PieceUtils_Ng.OFF_BOARD_DEFAULT_LOWER_BOUND);
        int highX = Math.min(x + PAWN_STEP_SIZE, PieceUtils_Ng.OFF_BOARD_DEFAULT_UPPER_BOUND);
        boolean blackMeetsLastRelativeIndex = y == ChessGameImpl_Ng.WHITE_ROYAL_FAMILY_INDEX;
        boolean whiteMeetsLastRelativeIndex = y == ChessGameImpl_Ng.BLACK_ROYAL_FAMILY_INDEX;
        if (player == Player.BLACK) {
            if (!blackMeetsLastRelativeIndex) {
                endPoints[y + 1][lowX] = 1;
                endPoints[y + 1][x] = 1;
                endPoints[y + 1][highX] = 1;
                if (y == BLACK_PAWN_SPECIAL_RANK) {
                    int highY = BLACK_PAWN_SPECIAL_RANK + PAWN_SPECIAL_STEP_SIZE;
                    endPoints[highY][x] = 1;
                }
            }
        } else {
            if (!whiteMeetsLastRelativeIndex) {
                endPoints[y - 1][lowX] = 1;
                endPoints[y - 1][x] = 1;
                endPoints[y - 1][highX] = 1;
                if (y == WHITE_PAWN_SPECIAL_RANK) {
                    int lowY = WHITE_PAWN_SPECIAL_RANK - PAWN_SPECIAL_STEP_SIZE;
                    endPoints[lowY][x] = 1;
                }
            }
        }

        return endPoints;
    }

    @Override
    public GridPosition[] path(GridPosition current, GridPosition end) {
        return new GridPosition[0];
    }

    @Override
    public boolean pathIsPossible(GridPosition current, GridPosition end) {
        return false;
    }
}
