package chess;

import chess.piece.Piece;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public class Move_Skeleton {
    private final Piece piece;
    private final GridPosition current;
    private final GridPosition end;

    public Move_Skeleton(Piece piece, GridPosition current, GridPosition end) {
        assert current != end;
        assert piece.pathIsPossible(current, end);

        this.piece = piece;
        this.current = current;
        this.end = end;
    }

    public GridPosition[] getPath() {
        return piece.path(current, end);
    }

    /*
        Precondition(s):
                None

        Postcondition(s):
            rv.forEach(i -> i.forEach(k))   =>  i[0] == signedDeltaY && i[1] == signedDeltaX
                                            =>  -14 <= sum(i, k) <= 14
                                            =>  -7 <= (i && k) <= 7
                                            =>  (i == 0 => j != 0) || (j == 0 => i != 0)
    */
    public int[] getYXDelta() {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    public Piece getPiece() {
        return piece;
    }

    public GridPosition getCurrent() {
        return current;
    }

    public GridPosition getEnd() {
        return end;
    }

}
