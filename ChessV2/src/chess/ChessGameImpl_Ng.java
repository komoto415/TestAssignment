package chess;

import chess.piece.*;
import chess.utils.ChessGameUtils_Ng;

import java.util.ArrayList;
import java.util.List;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public class ChessGameImpl_Ng implements ChessGame {
    public static final int BLACK_ROYAL_FAMILY_INDEX = 0;
    public static final int BLACK_PAWN_ROW_INDEX = 1;
    public static final int WHITE_PAWN_ROW_INDEX = 6;
    public static final int WHITE_ROYAL_FAMILY_INDEX = 7;
    private static final String INNER_CELL_BUFFER = " ";
    private static final String LABEL_EDGE_BUFFER = " ";
    private static final String EMPTY_GRID_POSITION = "   ";
    private static final String VERTICAL_WALL = "|";
    private static final String ROW_SEPARATOR = "   ----- ----- ----- ----- ----- ----- ----- -----";
    private static final String COL_DESC = "     A     B     C     D     E     F     G     H";
    private static final int DELTA_Y_INDEX = 0;
    private static final int DELTA_X_INDEX = 1;
    private static final Piece EMPTY_SPACE = null;
    private Piece[][] board;
    private List<Move> moveHistory;

    public ChessGameImpl_Ng() {
        board = new Piece[ROW_COUNT][COLUMN_COUNT];
        board[BLACK_ROYAL_FAMILY_INDEX] = new Piece[] {
                new Rook(Player.BLACK), new Knight(Player.BLACK), new Bishop(Player.BLACK), new King(Player.BLACK),
                new Queen(Player.BLACK), new Bishop(Player.BLACK), new Knight(Player.BLACK), new Rook(Player.BLACK),
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
                new Rook(Player.WHITE), new Knight(Player.WHITE), new Bishop(Player.WHITE), new King(Player.WHITE),
                new Queen(Player.WHITE), new Bishop(Player.WHITE), new Knight(Player.WHITE), new Rook(Player.WHITE),
                };

        moveHistory = new ArrayList<>();
    }

    @Override
    public Piece getPiece(GridPosition position) {
        char file = position.getFile();
        char rank = position.getRank();

        int y = ChessGameUtils_Ng.convertRankToYIndex(rank);
        int x = ChessGameUtils_Ng.convertFileToXIndex(file);
        return board[y][x];
    }

    private GridPosition getCurrentGridPositionOfPiece(Piece piece, char file, GridPosition end) {
        char endFile = end.getFile();
        int endFileY = ChessGameUtils_Ng.convertFileToXIndex(endFile);
        int itr = 0;
        int[][] yxPotentials = new int[8][2];
        for (int row = 0; row < ChessGame.ROW_COUNT; row++) {
            for (int col = 0; col < ChessGame.COLUMN_COUNT; col++) {
                if (board[row][col].equals(piece)) {
                    yxPotentials[itr] = new int[] {row, col};
                    itr += 1;
                }
            }
        }

        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public void movePiece(Piece piece, GridPosition end) {
//        assert isAmbiguousMove(piece, end);
        char file = end.getFile();
        movePiece(piece, file, end);
    }

    @Override
    public void movePiece(Piece piece, char file, GridPosition end) {
//        assert isValidMove(piece, file, end);
        GridPosition current = getCurrentGridPositionOfPiece(piece, file, end);

        Move mv = new Move(piece, current, end);

        int[] curYX = ChessGameUtils_Ng.convertGridPositionTo2DYXArray(current);
        int curY = curYX[ChessGameUtils_Ng.Y_INDEX], curX = curYX[ChessGameUtils_Ng.X_INDEX];

        int[] update = mv.getYXDelta();
        int dY = update[DELTA_Y_INDEX], dX = update[DELTA_X_INDEX];

        board[curY][curX] = EMPTY_SPACE;
        board[curY + dY][curX + dX] = piece;
        moveHistory.add(mv);
    }

    @Override
    public boolean isAmbiguousMove(Piece piece, GridPosition end) {
        boolean ambiguous = false;

        int endFile = ChessGameUtils_Ng.convertFileToXIndex(end.getFile());
        int endRank = ChessGameUtils_Ng.convertRankToYIndex(end.getRank());

        int itr = 0;
        int[][] yxPotentials = new int[8][2];
        for (int row = 0; row < ChessGame.ROW_COUNT; row++) {
            for (int col = 0; col < ChessGame.COLUMN_COUNT; col++) {
                if (board[row][col].equals(piece)) {
                    yxPotentials[itr] = new int[] {row, col};
                    itr += 1;
                }
            }
        }

        int potentialPieces = itr;
        int[][] boardMapping = new int[ChessGame.ROW_COUNT][ChessGame.COLUMN_COUNT];
        int endPointTotals = 0;

        if (piece instanceof Pawn) {
            for (int p = 0; p < potentialPieces; p++) {
                GridPosition gp = ChessGameUtils_Ng.convert2DYXArrayToGridPosition(yxPotentials[p]);
                int[][] endPoints = piece.getEndpointListFromCurrentPosition(gp);
                int endPointCur = endPoints[endRank][endFile];
                endPointTotals += endPointCur;
            }

            if (endPointTotals == 2) {
                ambiguous = true;
            }

        }

//        return ambiguous;
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
