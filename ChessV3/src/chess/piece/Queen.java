package chess.piece;

import chess.*;
import chess.piece.utils.PieceUtils_Ng;
import chess.utils.ChessGameUtils_Ng;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public class Queen extends Piece {
    private static final Label QUEEN_LABEL = Label.QUEEN;
    private static final int QUEEN_POINT_VALUE = 9;

    public Queen(Player player) {
        super(QUEEN_LABEL, player, QUEEN_POINT_VALUE);
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

        Piece rook = new Rook(Player.BLACK);
        Piece bishop = new Bishop(Player.WHITE);

        int[][] rookEndpoints = rook.getEndpointListFromCurrentPosition(current);
        int[][] bishopEndPoints = bishop.getEndpointListFromCurrentPosition(current);

        for (int row = 0; row < ChessGame.ROW_COUNT; row++) {
            for (int col = 0; col < ChessGame.COLUMN_COUNT; col++) {
                if (!PieceUtils_Ng.isCurrent(y, x, row, col)) {
                    endPoints[row][col] = rookEndpoints[row][col] + bishopEndPoints[row][col];
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

        int yDiff = endY - curY;
        int xDiff = endX - curX;

        boolean isVerticalOrHorizontal = xDiff == 0 || yDiff == 0;

        return isVerticalOrHorizontal ? new Rook(Player.BLACK).getPath(current, end) :
               new Bishop(Player.BLACK).getPath(current, end);
    }

    @Override
    public boolean pathIsPossible(GridPosition current, GridPosition end) {
        return PieceUtils_Ng.pathIsPossible(this, current, end);
    }
}
