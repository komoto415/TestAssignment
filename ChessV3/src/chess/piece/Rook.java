package chess.piece;

import chess.*;
import chess.piece.utils.PieceUtils_Ng;
import chess.utils.ChessGameUtils_Ng;

import static utils.PythonMethods.print;

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
    public Move[] getMoveListFromCurrentPosition(GridPosition current) {
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

    @Override
    public GridPosition[] path(GridPosition current, GridPosition end) {
        assert pathIsPossible(current, end);

        int[] curYX = ChessGameUtils_Ng.convertGridPositionTo2DYXArray(current);
        int[] endYX = ChessGameUtils_Ng.convertGridPositionTo2DYXArray(end);

        int curY = curYX[ChessGameUtils_Ng.Y_INDEX], curX = curYX[ChessGameUtils_Ng.X_INDEX];
        int endY = endYX[ChessGameUtils_Ng.Y_INDEX], endX = endYX[ChessGameUtils_Ng.X_INDEX];

        int yDiff = endY - curY;
        int xDiff = endX - curX;

        boolean up = curY > endY;
        boolean down = curY < endY;
        boolean left = curX > endX;
        boolean right = curX < endX;

        int diff = left || right ? xDiff : yDiff;
        diff = Math.abs(diff);

        GridPosition[] path = new GridPosition[diff];
        int pathIndex = 0;

        for (int i = 1; i <= diff; i++) {
            int row = curY, col = curX;
            if (up) {
                row -= i;
            } else if (down) {
                row += i;
            } else if (left) {
                col -= i;
            } else if (right) {
                col += 1;
            }
            print(row, col);
            GridPosition gp = ChessGameUtils_Ng.convertYXToGridPosition(row, col);
            path[pathIndex] = gp;
            pathIndex += 1;
        }

        return path;
    }

    @Override
    public boolean pathIsPossible(GridPosition current, GridPosition end) {
        return PieceUtils_Ng.pathIsPossible(this, current, end);
    }
}
