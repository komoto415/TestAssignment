package chess.piece;

import chess.GridPosition;
import chess.Label;
import chess.Move;
import chess.Player;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public class Pawn extends Piece {
    private static final Label PAWN_LABEL = Label.PAWN;
    private static final int PAWN_POINT_VALUE = 1;

    public Pawn(Player player) {
        super(PAWN_LABEL, player, PAWN_POINT_VALUE);
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
