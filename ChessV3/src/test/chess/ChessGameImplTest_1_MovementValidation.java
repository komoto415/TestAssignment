package test.chess;

import chess.ChessGame;
import chess.ChessGameImpl_Skeleton;
import chess.GridPosition;
import chess.Player;
import chess.piece.*;
import org.junit.Test;
import test.Points;
import test.piece.PieceTest_7_BlackPawn;

import java.util.Random;

import static chess.GridPosition.*;
import static org.junit.Assert.*;
import static utils.PythonMethods.print;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public class ChessGameImplTest_1_MovementValidation extends PieceTest_7_BlackPawn {
    public final boolean DO_PRINT = false;
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
            BLACK_ROOK, BLACK_KNIGHT, BLACK_BISHOP, BLACK_QUEEN, BLACK_KING, BLACK_BISHOP, BLACK_KNIGHT, BLACK_ROOK,
            };
    public final Piece[] startingRow7 = new Piece[] {
            BLACK_PAWN, BLACK_PAWN, BLACK_PAWN, BLACK_PAWN, BLACK_PAWN, BLACK_PAWN, BLACK_PAWN, BLACK_PAWN,
            };
    public final Piece[] startingRow2 = new Piece[] {
            WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN, WHITE_PAWN,
            };
    public final Piece[] startingRow1 = new Piece[] {
            WHITE_ROOK, WHITE_KNIGHT, WHITE_BISHOP, WHITE_QUEEN, WHITE_KING, WHITE_BISHOP, WHITE_KNIGHT, WHITE_ROOK,
            };

    protected ChessGame getChessGame() {
        return new ChessGameImpl_Skeleton();
    }

    protected GridPosition getGPFromFileRank(int file, int rank) {
        StringBuilder sb = new StringBuilder();
        char fl = intToColTranslation[file];
        String gridPositionAsString = sb.append(fl).append(rank).toString();
        return GridPosition.translate(gridPositionAsString);
    }

    @Points(value = 0)
    @Test
    public void toStringOrNotToString() {
        TEST_GOAL_MESSAGE = "Pretty toString()";
        ChessGame game = getChessGame();
        print(game);
    }

    @Points(value = 5)
    @Test
    public void getPiecesOfANewBoard() {
        TEST_GOAL_MESSAGE = "Get all pieces of a freshly instantiated board";

        ChessGame game = getChessGame();
        for (int rank = ROW_COUNT; rank > 0; rank--) {
            for (int file = 0; file < COL_COUNT; file++) {
                GridPosition gp = getGPFromFileRank(file, rank);
                Piece p = game.getPiece(gp);
                switch (rank) {
                    case 8:
                        assertEquals(startingRow8[file], p);
                        break;

                    case 7:
                        assertEquals(startingRow7[file], p);
                        break;

                    case 2:
                        assertEquals(startingRow2[file], p);
                        break;

                    case 1:
                        assertEquals(startingRow1[file], p);
                        break;

                    default:
                        assertNull(p);
                }
            }
        }
    }

    @Points(value = 5)
    @Test
    public void piecesThatCantMoveOnFirstMove() {
        TEST_GOAL_MESSAGE = "Checking that White pieces are the only ones can move one turn one and that the only " +
                            "ones that can move are the pawns or knights";

        final int[] necessaryRanks = new int[] {1, 2, 7, 8};

        ChessGame game = getChessGame();
        for (int i = necessaryRanks.length - 1; i >= 0; i--) {
            for (int file = 0; file < COL_COUNT; file++) {
                int rank = necessaryRanks[i];
                GridPosition gp = getGPFromFileRank(file, rank);
                boolean validMove = game.canMove(gp);
                if (game.getPiece(gp).equals(WHITE_PAWN) || game.getPiece(gp).equals(WHITE_KNIGHT)) {
                    assertTrue(validMove);
                } else {
                    assertFalse(validMove);
                }
            }
        }
    }

    @Points(value = 5)
    @Test
    public void test_movePiece_playerMoveAlternation() {
        TEST_GOAL_MESSAGE = "Piece movement alternates between players and ALWAYS starts with White";

        ChessGame game = getChessGame();
        if (DO_PRINT) {
            print(game);
        }

        assertFalse(game.isValidMove(BLACK_PAWN, B5));
        assertTrue(game.isValidMove(WHITE_PAWN, A4));
        game.movePiece(WHITE_PAWN, A4);
        if (DO_PRINT) {
            print(game);
        }

        assertFalse(game.isValidMove(WHITE_PAWN, A5));
        assertTrue(game.isValidMove(BLACK_PAWN, B5));
        game.movePiece(BLACK_PAWN, B5);
        if (DO_PRINT) {
            print(game);
        }

        assertFalse(game.isValidMove(BLACK_ROOK, F6));
        assertTrue(game.isValidMove(WHITE_PAWN, B5));
        game.movePiece(WHITE_PAWN, B5);
        if (DO_PRINT) {
            print(game);
        }
    }

    @Points(value = 5)
    @Test
    public void test_4() {
        TEST_GOAL_MESSAGE = "";

        ChessGame game = getChessGame();

        game.movePiece(WHITE_PAWN, D4);
        game.movePiece(BLACK_KNIGHT, C6);

        game.movePiece(WHITE_PAWN, E3);
        game.movePiece(BLACK_PAWN, G5);

        game.movePiece(WHITE_BISHOP, C4);
    }

    @Points(value = 5)
    @Test(expected = AssertionError.class)
    public void ambiguousMoveJustGridPositionAttemptedFailure() {
        TEST_GOAL_MESSAGE = "Moving declaring only GridPosition, attempted move is ambiguous so not piece can be " +
                            "moved. Ambiguity caused by two pieces being able to be moved that the endpoint";

        ChessGame game = getChessGame();

        game.movePiece(A4);
        game.movePiece(A5);

        game.movePiece(H4);
        game.movePiece(H5);

        assertTrue(game.isAmbiguousMove(H3));
        game.movePiece(H3);
    }

    @Points(value = 5)
    @Test
    public void ambiguousMoveJustGridPositionResolution() {
        TEST_GOAL_MESSAGE = "Moving declaring only GridPosition, ambiguous move resolved only needing to declare the " +
                            "piece type.";

        ChessGame game = getChessGame();

        game.movePiece(A4);
        game.movePiece(A5);

        game.movePiece(H4);
        game.movePiece(H5);

        game.movePiece(WHITE_ROOK, H3);
    }

    @Points(value = 5)
    @Test(expected = AssertionError.class)
    public void ambiguousMovePieceGridPositionAttemptedFailure() {
        TEST_GOAL_MESSAGE = "Moving declaring Piece and GridPosition, attempted move is ambiguous so not piece can be" +
                            " moved. Ambiguity caused by two pieces of the same type being able to be moved that the " +
                            "endpoint";

        ChessGame game = getChessGame();

        game.movePiece(A4);
        game.movePiece(A5);

        game.movePiece(H4);
        game.movePiece(H5);

        game.movePiece(WHITE_ROOK, H3);
        game.movePiece(G5);

        assertTrue(game.isAmbiguousMove(A3));
        assertTrue(game.isAmbiguousMove(WHITE_ROOK, A3));

        game.movePiece(WHITE_ROOK, A3);
    }

    @Points(value = 5)
    @Test
    public void ambiguousMovePieceGridPositionResolution() {
        TEST_GOAL_MESSAGE = "Moving declaring Piece GridPosition, ambiguous move resolved by declaring both the piece" +
                            " type and the file that the desired piece is on";

        ChessGame game = getChessGame();

        game.movePiece(A4);
        game.movePiece(A5);

        game.movePiece(H4);
        game.movePiece(H5);

        game.movePiece(WHITE_ROOK, H3);
        game.movePiece(G5);

        // Potential Valid Moves
        assertTrue(game.isValidMove(WHITE_ROOK, 'A', A3));
        assertTrue(game.isValidMove(WHITE_ROOK, 'H', A3));
        assertTrue(game.isValidMove(WHITE_KNIGHT, A3));
        if (DO_PRINT) {
            print(game);
        }

        int D3 = new Random().nextInt(3) + 1;
        if (D3 == 0) {
            game.movePiece(WHITE_ROOK, 'A', A3);
        } else if (D3 == 2) {
            game.movePiece(WHITE_ROOK, 'H', A3);
        } else {
            game.movePiece(WHITE_KNIGHT, A3);
        }
        if (DO_PRINT) {
            print(game);
        }
    }

    @Points(value = 5)
    @Test
    public void test_7() {
        TEST_GOAL_MESSAGE = "";

        ChessGame game = getChessGame();

    }

    @Points(value = 5)
    @Test
    public void test_8() {
        TEST_GOAL_MESSAGE = "";

        ChessGame game = getChessGame();

    }

    @Points(value = 5)
    @Test
    public void test_9() {
        TEST_GOAL_MESSAGE = "";

        ChessGame game = getChessGame();

    }

    @Points(value = 5)
    @Test
    public void test_10() {
        TEST_GOAL_MESSAGE = "";

        ChessGame game = getChessGame();

    }
}