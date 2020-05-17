package chess.piece;

import chess.*;
import chess.piece.utils.PieceUtils_Ng;
import chess.utils.ChessGameUtils_Ng;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public class Knight extends Piece {
    private static final Label KNIGHT_LABEL = Label.KNIGHT;
    private static final int KNIGHT_POINT_VALUE = 3;
    private static final int KNIGHT_STEP_ONE_INDEX = 0;
    private static final int KNIGHT_STEP_TWO_INDEX = KNIGHT_STEP_ONE_INDEX + 1;
    private static final int KNIGHT_STEP_THR_INDEX = KNIGHT_STEP_TWO_INDEX + 1;
    private static final int KNIGHT_STEP_ONE_SIZE = 2;
    private static final int KNIGHT_STEP_TWO_SIZE = 1;
    private static final int KNIGHT_ALWAYS_TAKES_3_STEPS = 3;

    public Knight(Player player) {
        super(KNIGHT_LABEL, player, KNIGHT_POINT_VALUE);
    }

    @Override
    public Move[] getMoveListFromCurrentPosition(GridPosition current) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    /* Notes
            x,y    x,y
            0,0 => 2,1
                   1,2

            1,0 => 3,1
                   2,2
                   0,2

            0,1 => 2,0
                   2,2
                   1,3


            1,1 => 3,0
                   3,2
                   2,3
                   0,3

            4,4 => 5,2 = 7
                   6,3 = 9
                   6,5 = 11
                   5,6 = 11
                   3,6 = 9
                   2,5 = 7
                   2,3 = 5
                   3,2 = 5


    */
    @Override
    public int[][] getEndpointListFromCurrentPosition(GridPosition current) {
        int[][] endPoints = new int[ChessGame.ROW_COUNT][ChessGame.COLUMN_COUNT];
        int[] curYX = ChessGameUtils_Ng.convertGridPositionTo2DYXArray(current);
        int y = curYX[ChessGameUtils_Ng.Y_INDEX], x = curYX[ChessGameUtils_Ng.X_INDEX];

        int lowY = Math.max(y - KNIGHT_STEP_ONE_SIZE, PieceUtils_Ng.OFF_BOARD_DEFAULT_LOWER_BOUND);
        int highY = Math.min(y + KNIGHT_STEP_ONE_SIZE, PieceUtils_Ng.OFF_BOARD_DEFAULT_UPPER_BOUND);
        int lowX = Math.max(x - KNIGHT_STEP_ONE_SIZE, PieceUtils_Ng.OFF_BOARD_DEFAULT_LOWER_BOUND);
        int highX = Math.min(x + KNIGHT_STEP_ONE_SIZE, PieceUtils_Ng.OFF_BOARD_DEFAULT_UPPER_BOUND);

        for (int row = lowY; row <= highY; row++) {
            for (int col = lowX; col <= highX; col++) {
                if (!PieceUtils_Ng.isCurrent(y, x, row, col)) {
                    boolean NE = (y - KNIGHT_STEP_ONE_SIZE == row && x + KNIGHT_STEP_TWO_SIZE == col) ||
                                 (y - KNIGHT_STEP_TWO_SIZE == row && x + KNIGHT_STEP_ONE_SIZE == col);
                    boolean SE = (y + KNIGHT_STEP_ONE_SIZE == row && x + KNIGHT_STEP_TWO_SIZE == col) ||
                                 (y + KNIGHT_STEP_TWO_SIZE == row && x + KNIGHT_STEP_ONE_SIZE == col);
                    boolean SW = (y + KNIGHT_STEP_ONE_SIZE == row && x - KNIGHT_STEP_TWO_SIZE == col) ||
                                 (y + KNIGHT_STEP_TWO_SIZE == row && x - KNIGHT_STEP_ONE_SIZE == col);
                    boolean NW = (y - KNIGHT_STEP_ONE_SIZE == row && x - KNIGHT_STEP_TWO_SIZE == col) ||
                                 (y - KNIGHT_STEP_TWO_SIZE == row && x - KNIGHT_STEP_ONE_SIZE == col);
                    if (NE || SE || SW || NW) {
                        endPoints[row][col] = 1;
                    }
                }
            }
        }

        return endPoints;
    }

    @Override
    public GridPosition[] getPath(GridPosition current, GridPosition end) {
        assert pathIsPossible(current, end);

        int[] curYX = ChessGameUtils_Ng.convertGridPositionTo2DYXArray(current);
        int[] endYX = ChessGameUtils_Ng.convertGridPositionTo2DYXArray(end);

        int curY = curYX[ChessGameUtils_Ng.Y_INDEX], curX = curYX[ChessGameUtils_Ng.X_INDEX];
        int endY = endYX[ChessGameUtils_Ng.Y_INDEX], endX = endYX[ChessGameUtils_Ng.X_INDEX];

        boolean N = endY + KNIGHT_STEP_ONE_SIZE == curY && endX + KNIGHT_STEP_TWO_SIZE == curX ||
                    endY + KNIGHT_STEP_ONE_SIZE == curY && endX - KNIGHT_STEP_TWO_SIZE == curX;

        boolean E = endY + KNIGHT_STEP_TWO_SIZE == curY && endX - KNIGHT_STEP_ONE_SIZE == curX ||
                    endY - KNIGHT_STEP_TWO_SIZE == curY && endX - KNIGHT_STEP_ONE_SIZE == curX;

        boolean S = endY - KNIGHT_STEP_ONE_SIZE == curY && endX - KNIGHT_STEP_TWO_SIZE == curX ||
                    endY - KNIGHT_STEP_ONE_SIZE == curY && endX + KNIGHT_STEP_TWO_SIZE == curX;

        boolean W = endY - KNIGHT_STEP_TWO_SIZE == curY && endX + KNIGHT_STEP_ONE_SIZE == curX ||
                    endY + KNIGHT_STEP_TWO_SIZE == curY && endX + KNIGHT_STEP_ONE_SIZE == curX;

        GridPosition[] path = new GridPosition[KNIGHT_ALWAYS_TAKES_3_STEPS];

        GridPosition step1 = current, step2 = end;
        if (N) {
            step1 = ChessGameUtils_Ng.convertYXToGridPosition(curY - 1, curX);
            step2 = ChessGameUtils_Ng.convertYXToGridPosition(curY - 2, curX);
        } else if (E) {
            step1 = ChessGameUtils_Ng.convertYXToGridPosition(curY, curX + 1);
            step2 = ChessGameUtils_Ng.convertYXToGridPosition(curY, curX + 2);
        } else if (S) {
            step1 = ChessGameUtils_Ng.convertYXToGridPosition(curY + 1, curX);
            step2 = ChessGameUtils_Ng.convertYXToGridPosition(curY + 2, curX);
        } else if (W) {
            step1 = ChessGameUtils_Ng.convertYXToGridPosition(curY, curX - 1);
            step2 = ChessGameUtils_Ng.convertYXToGridPosition(curY, curX - 2);
        }

        path[KNIGHT_STEP_ONE_INDEX] = step1;
        path[KNIGHT_STEP_TWO_INDEX] = step2;
        path[KNIGHT_STEP_THR_INDEX] = end;

        return path;
    }

    @Override
    public boolean pathIsPossible(GridPosition current, GridPosition end) {
        return PieceUtils_Ng.pathIsPossible(this, current, end);
    }
}
