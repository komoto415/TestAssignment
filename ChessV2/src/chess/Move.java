package chess;

import chess.piece.Piece;
import chess.utils.ChessGameUtils_Ng;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public class Move {
    private final Piece piece;
    private final GridPosition current;
    private final GridPosition end;

    public Move(Piece piece, GridPosition current, GridPosition end) {
        assert current != end;

        this.piece = piece;
        this.current = current;
        this.end = end;
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
        int[] curYX = ChessGameUtils_Ng.convertGridPositionTo2DYXArray(current);
        int[] endYX = ChessGameUtils_Ng.convertGridPositionTo2DYXArray(end);

        int curY = curYX[ChessGameUtils_Ng.Y_INDEX];
        int curX = curYX[ChessGameUtils_Ng.X_INDEX];
        int endY = endYX[ChessGameUtils_Ng.Y_INDEX];
        int endX = endYX[ChessGameUtils_Ng.Y_INDEX];

        return new int[] {endY - curY, endX - curX,};
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
