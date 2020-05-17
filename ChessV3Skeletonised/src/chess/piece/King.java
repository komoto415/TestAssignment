package chess.piece;

import chess.GridPosition;
import chess.Label;
import chess.Move;
import chess.Player;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public class King extends Piece {
    private static final Label KING_LABEL = Label.KING;
    private static final int KING_POINT_VALUE = 0;

    public King(Player player) {
        super(KING_LABEL, player, KING_POINT_VALUE);
    }

    @Override
    public Move[] getMoveListFromCurrentPosition(GridPosition current) {
        throw new RuntimeException("NOW IMPLEMENTED YET");
    }

    @Override
    public int[][] getEndpointListFromCurrentPosition(GridPosition current) {
        throw new RuntimeException("NOW IMPLEMENTED YET");
    }

    @Override
    public GridPosition[] getPath(GridPosition current, GridPosition end) {
        throw new RuntimeException("NOW IMPLEMENTED YET");
    }

    @Override
    public boolean pathIsPossible(GridPosition current, GridPosition end) {
        throw new RuntimeException("NOW IMPLEMENTED YET");
    }
}
