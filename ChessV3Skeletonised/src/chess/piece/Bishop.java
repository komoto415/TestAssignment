package chess.piece;

import chess.GridPosition;
import chess.Label;
import chess.Move;
import chess.Player;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public class Bishop extends Piece {
    private static final Label BISHOP_LABEL = Label.BISHOP;
    private static final int BISHOP_POINT_VALUE = 3;

    public Bishop(Player player) {
        super(BISHOP_LABEL, player, BISHOP_POINT_VALUE);
    }

    @Override
    public Move[] getMoveListFromCurrentPosition(GridPosition current) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public int[][] getEndpointListFromCurrentPosition(GridPosition current) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public GridPosition[] getPath(GridPosition current, GridPosition end) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public boolean pathIsPossible(GridPosition current, GridPosition end) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }
}
