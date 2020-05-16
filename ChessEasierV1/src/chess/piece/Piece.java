package chess.piece;

import chess.GridPosition;
import chess.Label;
import chess.Move_Skeleton;
import chess.Player;

import java.util.HashMap;
import java.util.Map;

import static chess.Label.*;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public abstract class Piece {
    private static final Map<Label, Integer> labelToPoint = new HashMap<>();
    static {
        labelToPoint.put(PAWN, 1);
        labelToPoint.put(ROOK, 5);
        labelToPoint.put(KNIGHT, 3);
        labelToPoint.put(BISHOP, 3);
        labelToPoint.put(QUEEN, 9);
        labelToPoint.put(KING, 0);
    }
    private final Player player;
    private final Label label;
    private final char labelShort;
    private final int pointValue;

    public Piece(final Label label, final Player player, final int pointValue) {
        assert labelToPoint.get(label) == pointValue;
        assert player != null;

        this.player = player;
        this.label = label;
        this.labelShort = label.getLabelShort();
        this.pointValue = pointValue;
    }

    /*
       Precondition(s):
                                    piece   !=  null
                                  current   !=  null
    */
    /*  Postcondition(s):
                                piece == PAWN   =>  2 <= rv.size <= 8 or
                                                    0 <= rv.size <= 4   depending if I want to diff between
                                                                        player colours. Other method does for
                                                                        now. Decisions decisions...
                                piece == ROOK   =>  0 <  rv.size <= 14
                              piece == KNIGHT   =>  0 <  rv.size <= 8
                              piece == BISHOP   =>  0 <  rv.size <= 13
                               piece == QUEEN   =>  0 <  rv.size <= 27(?) not 100% sure...
                                piece == KING   =>  0 <  rv.size <= 8
    */
    // TODO: WIP, DO NOT TRY AND IMPLEMENT THIS METHOD YET
    public abstract Move_Skeleton[] getMoveListFromCurrentPosition(GridPosition current);

    /*  Precondition(s):
                                  current   !=  null
    */
    /*  Postcondition(s):
                                rv.length   ==  8
                            rv.forEach(i)   =>  i.length == 8
            rv.forEach(i -> i.forEach(k))   =>  k == 0 || k == 1
                             rv[y][x] = 1   =>  y != currentTranslatedToYCoordinate &&
                                                x != currentTranslatedToXCoordinate
    */
    /*  Example Call:
                 piece == Rook-> path(A1)   =>  rv == [
                                                        [1,0,0,0,0,0,0,0,],
                                                        [1,0,0,0,0,0,0,0,],
                                                        [1,0,0,0,0,0,0,0,],
                                                        [1,0,0,0,0,0,0,0,],
                                                        [1,0,0,0,0,0,0,0,],
                                                        [1,0,0,0,0,0,0,0,],
                                                        [1,0,0,0,0,0,0,0,],
                                                        [0,1,1,1,1,1,1,1,],
                                                      ]
                piece == Rook -> path(A1)   =>  rv == [
                                                        [0,0,0,0,0,0,0,1,],
                                                        [0,0,0,0,0,0,1,0,],
                                                        [0,0,0,0,0,1,0,0,],
                                                        [0,0,0,0,1,0,0,0,],
                                                        [0,0,0,1,0,0,0,0,],
                                                        [0,0,1,0,0,0,0,0,],
                                                        [0,1,0,0,0,0,0,0,],
                                                        [0,0,0,0,0,0,0,0,],
                                                      ]
    */
    public abstract int[][] getEndpointListFromCurrentPosition(GridPosition current);

    /*  Precondition(s):
                                      end   !=  null
                                  current   !=  null
                            this.piece.pathIsPossible(current, end)
    */
    /*  Postcondition(s):
                                rv.length   <   8
                                    rv[i]   =>  i_th step from current to end ORDER MATTERS
    */
    /*  Example Call:
            piece == Rook -> path(A1, A3)   =>  rv == [A2]
            piece == Rook -> path(A1, A4)   =>  rv == [A2, A3]
            piece == Rook -> path(A1, D1)   =>  rv == [B1, C1, D1]
            piece == Rook -> path(A1, C3)   =>  nuclear broccoli
    */
    public abstract GridPosition[] path(GridPosition current, GridPosition end);

    public abstract boolean pathIsPossible(GridPosition current, GridPosition end);

    public String toString() {
        return String.format("%s %s", player, label);
    }

    public Player getPlayer() {
        return player;
    }

    public Label getLabel() {
        return label;
    }

    public char getLabelShort() {
        return labelShort;
    }

    public int getPointValue() {
        return pointValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Piece)) {
            return false;
        }
        Piece piece = (Piece) obj;
        return piece.label.equals(this.label) && piece.player.equals(this.player);
    }

    @Override
    public int hashCode() {
        int hashCode = 1999;
        final int mul = 4 * 15 * 12 * 23; // 😄

        hashCode = mul * hashCode + label.hashCode();
        hashCode = mul * hashCode + player.hashCode();

        return hashCode;
    }
}