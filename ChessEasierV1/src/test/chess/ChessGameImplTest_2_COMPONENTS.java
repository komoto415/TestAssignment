package test.chess;

import chess.*;
import chess.piece.*;
import org.junit.Test;
import test.Points;

import static utils.PythonMethods.*;
import static chess.GridPosition.*;
import static org.junit.Assert.*;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public class ChessGameImplTest_2_COMPONENTS extends ChessGameImplTest_1_ENVIRONMENT {
    public final int ROW_COUNT = ChessGame.ROW_COUNT;
    public final int COL_COUNT = ChessGame.COLUMN_COUNT;
    public final Piece
            BLACK_PAWN = new Pawn(Player.BLACK), BLACK_ROOK = new Rook(Player.BLACK),
            BLACK_KNIGHT = new Knight(Player.BLACK), BLACK_BISHOP = new Bishop(Player.BLACK),
            BLACK_KING = new King(Player.BLACK), BLACK_QUEEN = new Queen(Player.BLACK),
            WHITE_PAWN = new Pawn(Player.WHITE), WHITE_ROOK = new Rook(Player.WHITE),
            WHITE_KNIGHT = new Knight(Player.WHITE), WHITE_BISHOP = new Bishop(Player.WHITE),
            WHITE_KING = new King(Player.WHITE), WHITE_QUEEN = new Queen(Player.WHITE);

    public final char[] intToColTranslation = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',};
    public final Piece[] startingRow8 = new Piece[] {
            BLACK_ROOK, BLACK_KNIGHT, BLACK_BISHOP, BLACK_KING, BLACK_QUEEN, BLACK_BISHOP, BLACK_KNIGHT, BLACK_ROOK,
            };
    public final Piece[] startingRow7 = new Piece[] {
            BLACK_PAWN, BLACK_PAWN, BLACK_PAWN, BLACK_PAWN, BLACK_PAWN, BLACK_PAWN, BLACK_PAWN, BLACK_PAWN,
            };
    public final Piece[] startingRow2 = new Piece[] {
            WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN,
            };
    public final Piece[] startingRow1 = new Piece[] {
            WHITE_ROOK, WHITE_KNIGHT, WHITE_BISHOP, WHITE_KING, WHITE_QUEEN, WHITE_BISHOP, WHITE_KNIGHT, WHITE_ROOK,
            };

    protected ChessGame getChessGame() {
        return new ChessGameImpl_Ng();
    }

    @Points(value = 0)
    @Test
    public void test_toString() {
        TEST_GOAL_MESSAGE = "Pretty toString()";
        ChessGame game = getChessGame();
        print(game);
    }

    @Points(value = 5)
    @Test
    public void test_getPiece_justInstantiation() {
        TEST_GOAL_MESSAGE = "Get all pieces of a freshly instantiated board";

        ChessGame game = getChessGame();
        for (int rank = ROW_COUNT; rank > 0; rank--) {
            for (int col = 0; col < COL_COUNT; col++) {
                StringBuilder sb = new StringBuilder();
                char file = intToColTranslation[col];
                String gridPositionAsString = sb.append(file).append(rank).toString();
                GridPosition gp = GridPosition.translate(gridPositionAsString);
                switch (rank) {
                    case 8:
                        assertEquals(startingRow8[col], game.getPiece(gp));
                        break;

                    case 7:
                        assertEquals(startingRow7[col], game.getPiece(gp));
                        break;

                    case 2:
                        assertEquals(startingRow2[col], game.getPiece(gp));
                        break;

                    case 1:
                        assertEquals(startingRow1[col], game.getPiece(gp));
                        break;

                    default:
                        assertNull(game.getPiece(gp));
                }
            }
        }
    }

    @Test
    public void test_PawnA3() {
        TEST_GOAL_MESSAGE = "Pawn single space move and check if the board has been correctly updated";

        ChessGame game = getChessGame();
        game.movePiece(A2, A3);
        assertEquals(WHITE_PAWN, game.getPiece(A3));
        assertNull(game.getPiece(A2));
    }

    @Test
    public void test_PawnA4() {
        TEST_GOAL_MESSAGE = "Pawn two space move off of rank 2";

        ChessGame game = getChessGame();
        game.movePiece(A2, A4);
        assertEquals(WHITE_PAWN, game.getPiece(A4));
        assertNull(game.getPiece(A2));
    }

    @Test(expected = AssertionError.class)
    public void test_PawnA5() {
        TEST_GOAL_MESSAGE = "Pawn two space move not off of rank 2 should fail";

        ChessGame game = getChessGame();
        game.movePiece(A2, A3);
        game.movePiece(A7, A6);
        game.movePiece(A3, A5);
    }
}