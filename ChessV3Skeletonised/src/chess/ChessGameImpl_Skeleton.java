package chess;

import chess.piece.*;

import java.util.ArrayList;
import java.util.List;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public class ChessGameImpl_Skeleton implements ChessGame {
    private static final int BLACK_ROYAL_FAMILY_INDEX = 0;
    private static final int BLACK_PAWN_ROW_INDEX = 1;
    private static final int WHITE_PAWN_ROW_INDEX = 6;
    private static final int WHITE_ROYAL_FAMILY_INDEX = 7;
    private static final String INNER_CELL_BUFFER = " ";
    private static final String LABEL_EDGE_BUFFER = " ";
    private static final String EMPTY_GRID_POSITION = "   ";
    private static final String VERTICAL_WALL = "|";
    private static final String ROW_SEPARATOR = "   ----- ----- ----- ----- ----- ----- ----- -----";
    private static final String COL_DESC = "     A     B     C     D     E     F     G     H";
    private Piece[][] board;
    private List<Move> moveHistory;

    public ChessGameImpl_Skeleton() {
        board = new Piece[ROW_COUNT][COLUMN_COUNT];
        board[BLACK_ROYAL_FAMILY_INDEX] = new Piece[] {
                new Rook(Player.BLACK), new Knight(Player.BLACK), new Bishop(Player.BLACK), new Queen(Player.BLACK),
                new King(Player.BLACK), new Bishop(Player.BLACK), new Knight(Player.BLACK), new Rook(Player.BLACK),
                };
        board[BLACK_PAWN_ROW_INDEX] = new Piece[] {
                new Pawn(Player.BLACK), new Pawn(Player.BLACK), new Pawn(Player.BLACK), new Pawn(Player.BLACK),
                new Pawn(Player.BLACK), new Pawn(Player.BLACK), new Pawn(Player.BLACK), new Pawn(Player.BLACK),
                };
        board[WHITE_PAWN_ROW_INDEX] = new Piece[] {
                new Pawn(Player.WHITE), new Pawn(Player.WHITE), new Pawn(Player.WHITE), new Pawn(Player.WHITE),
                new Pawn(Player.WHITE), new Pawn(Player.WHITE), new Pawn(Player.WHITE), new Pawn(Player.WHITE),
                };
        board[WHITE_ROYAL_FAMILY_INDEX] = new Piece[] {
                new Rook(Player.WHITE), new Knight(Player.WHITE), new Bishop(Player.WHITE), new Queen(Player.WHITE),
                new King(Player.WHITE), new Bishop(Player.WHITE), new Knight(Player.WHITE), new Rook(Player.WHITE),
                };

        moveHistory = new ArrayList<>();
    }

    @Override
    public Piece getPiece(GridPosition position) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public void movePiece(GridPosition end) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public void movePiece(Piece piece, GridPosition end) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public void movePiece(Piece piece, char file, GridPosition end) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public boolean isAmbiguousMove(GridPosition end) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public boolean isAmbiguousMove(Piece piece, GridPosition end) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public boolean canMove(GridPosition gp) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public boolean isValidMove(GridPosition end) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public boolean isValidMove(Piece piece, GridPosition end) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public boolean isValidMove(Piece piece, char file, GridPosition end) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public boolean isCheckmated() {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public List<Move> getMoveHistory() {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int rowNo = 8;
        sb.append(COL_DESC).append('\n');
        for (Piece[] row : board) {
            sb.append(ROW_SEPARATOR).append('\n');
            sb.append(rowNo).append(LABEL_EDGE_BUFFER).append(VERTICAL_WALL);
            for (Piece p : row) {
                sb.append(INNER_CELL_BUFFER);
                if (p != null) {
                    sb.append(p.getPlayer() == Player.BLACK ? "B_" : "W_");
                    sb.append(p.getLabelShort());
                } else {
                    sb.append(EMPTY_GRID_POSITION);
                }
                sb.append(INNER_CELL_BUFFER).append(VERTICAL_WALL);
            }
            sb.append(LABEL_EDGE_BUFFER).append(rowNo).append('\n');
            rowNo -= 1;
        }
        sb.append(ROW_SEPARATOR).append('\n');
        sb.append(COL_DESC).append('\n');
        return sb.toString();
    }
}
