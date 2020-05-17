package chess;

import chess.piece.Piece;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public class Move {
    private final Piece piece;
    private final GridPosition current;
    private final GridPosition end;

    public Move(Piece piece, GridPosition current, GridPosition end) {
        assert current != end;
        assert piece.pathIsPossible(current, end);

        this.piece = piece;
        this.current = current;
        this.end = end;
    }

    /*  Precondition(s):
                                            None
     */
    /*  Postcondition(s):
                                            A

     */
    public GridPosition[] getPath() {
        return piece.getPath(current, end);
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
