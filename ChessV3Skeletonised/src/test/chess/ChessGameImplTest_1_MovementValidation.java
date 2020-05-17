package test.chess;

import chess.ChessGame;
import chess.ChessGameImpl_Skeleton;
import chess.GridPosition;
import chess.Player;
import chess.piece.*;
import org.junit.Test;
import test.Points;
import test.piece.PieceTest_7_BlackPawn;
import utils.PythonCollections;


import static chess.GridPosition.*;
import static org.junit.Assert.*;
import static utils.PythonMethods.*;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public class ChessGameImplTest_1_MovementValidation extends PieceTest_7_BlackPawn {
    //    protected String TEST_GOAL_MESSAGE;
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

    // 90 totals points

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

    @Points(value = 10)
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
                boolean movable = game.canMove(gp);
                if (game.getPiece(gp).equals(WHITE_PAWN) || game.getPiece(gp).equals(WHITE_KNIGHT)) {
                    assertTrue(movable);
                } else {
                    assertFalse(movable);
                }
            }
        }
    }

    @Points(value = 5)
    @Test
    public void nullPreconditionCatcher() {
        TEST_GOAL_MESSAGE = "Piece movement alternates between players and ALWAYS starts with White";

        final int EXPECTED_FAIL_CASES = 6;
        int failureCase = 0;
        ChessGame game = getChessGame();
        try {
            game.getPiece(null);
            assert false;
        } catch (AssertionError ae) {
            failureCase += 1;
        }

        try {
            game.movePiece(null);
            assert false;
        } catch (AssertionError ae) {
            failureCase += 1;
        }

        try {
            game.movePiece(null, A3);
            assert false;
        } catch (AssertionError ae) {
            failureCase += 1;
        } try {
            game.movePiece(WHITE_PAWN, null);
            assert false;
        } catch (AssertionError ae) {
            failureCase += 1;
        }

        try {
            game.movePiece(null, 'A', A3);
            assert false;
        } catch (AssertionError ae) {
            failureCase += 1;
        } try {
            game.movePiece(WHITE_PAWN, 'A', null);
            assert false;
        } catch (AssertionError ae) {
            failureCase += 1;
        }

        assertEquals(EXPECTED_FAIL_CASES, failureCase);
    }

    @Points(value = 5)
    @Test
    public void playerMoveAlternation() {
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

    public final GridPosition[] noAmbiguousMovesGPs = new GridPosition[] {
            A4, G5, F4, E6, F3, B4, B3, F8,
            };
    public final Piece[] noAmbiguousPieces = new Piece[] {
            WHITE_PAWN, BLACK_PAWN, WHITE_PAWN, BLACK_PAWN, WHITE_KNIGHT, BLACK_BISHOP, WHITE_PAWN, BLACK_KING,
            };
    public final char[] noAmbiguousFiles = new char[] {
            'A', 'G', 'F', 'E', 'G', 'F', 'B', 'E',
            };

    @Points(value = 5)
    @Test
    public void runSequenceOnlyGP() {
        TEST_GOAL_MESSAGE = "Running a sequence of moves with no ambiguity passing in only GridPositions";

        ChessGame game = getChessGame();

        for (GridPosition gp : noAmbiguousMovesGPs) {
            assertFalse(game.isAmbiguousMove(gp));
            assertFalse(game.isValidMove(gp));
            game.movePiece(gp);
        }
    }

    @Points(value = 5)
    @Test
    public void runSequencePieceGP() {
        TEST_GOAL_MESSAGE = "Running a sequence of moves with no ambiguity passing in only Pieces and GridPositions";

        ChessGame game = getChessGame();

        for (Object[] tup : PythonCollections.zip(noAmbiguousPieces, noAmbiguousMovesGPs)) {
            Piece p = (Piece) tup[0];
            GridPosition gp = (GridPosition) tup[1];
            assertFalse(game.isAmbiguousMove(p, gp));
            game.movePiece(p, gp);
        }
    }

    @Points(value = 5)
    @Test
    public void runSequencePieceFileGP() {
        TEST_GOAL_MESSAGE = "Running a sequence of moves with no ambiguity passing in Pieces, files and GridPositions";

        ChessGame game = getChessGame();

        for (int turn = 0; turn < noAmbiguousFiles.length; turn++) {
            GridPosition gp = noAmbiguousMovesGPs[turn];
            Piece p = noAmbiguousPieces[turn];
            char file = noAmbiguousFiles[turn];
            game.movePiece(p, file, gp);
        }
    }

    @Points(value = 5)
    @Test(expected = AssertionError.class)
    public void ambiguousMoveJustGridPositionAttemptedFailure() {
        TEST_GOAL_MESSAGE = "Ambiguity caused by two pieces being able to be moved to the endpoint";

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
        TEST_GOAL_MESSAGE = "Ambiguity resolved by passing in the piece type";

        ChessGame game = getChessGame();

        game.movePiece(A4);
        game.movePiece(A5);

        game.movePiece(H4);
        game.movePiece(H5);

        assertFalse(game.isAmbiguousMove(WHITE_ROOK, H3));
        game.movePiece(WHITE_ROOK, H3);
    }

    @Points(value = 5)
    @Test(expected = AssertionError.class)
    public void ambiguousMovePieceGridPositionAttemptedFailure() {
        TEST_GOAL_MESSAGE = "Ambiguity caused by two pieces of the same type being able to be moved to the endpoint";

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
        TEST_GOAL_MESSAGE = "Ambiguity resolved by passing in the piece type and the file of the desired piece or " +
                            "another valid piece of differing type that can move to that endpoint";

        // Viable solution 1
        ChessGame game = getChessGame();

        game.movePiece(A4);
        game.movePiece(A5);

        game.movePiece(H4);
        game.movePiece(H5);

        game.movePiece(WHITE_ROOK, H3);
        game.movePiece(G5);

        assertTrue(game.isValidMove(WHITE_ROOK, 'A', A3));
        game.movePiece(WHITE_ROOK, 'A', A3);

        // Viable solution 2
        game = getChessGame();

        game.movePiece(A4);
        game.movePiece(A5);

        game.movePiece(H4);
        game.movePiece(H5);

        game.movePiece(WHITE_ROOK, H3);
        game.movePiece(G5);

        assertTrue(game.isValidMove(WHITE_ROOK, 'H', A3));
        game.movePiece(WHITE_ROOK, 'H', A3);

        // Viable solution 3
        game = getChessGame();

        game.movePiece(A4);
        game.movePiece(A5);

        game.movePiece(H4);
        game.movePiece(H5);

        game.movePiece(WHITE_ROOK, H3);
        game.movePiece(G5);

        assertTrue(game.isValidMove(WHITE_KNIGHT, A3));
        game.movePiece(WHITE_KNIGHT, A3);
    }

    @Points(value = 5)
    @Test
    public void isInvalidDueToNotApartOfValidMoveSet() {
        TEST_GOAL_MESSAGE = "Illegal move based on the pairing of Piece and GridPosition";

        ChessGame game = getChessGame();

        assertFalse(game.isValidMove(WHITE_PAWN, B3));
    }

    @Points(value = 5)
    @Test
    public void isInvalidDueToSamePlayerOccupiedSpace() {
        TEST_GOAL_MESSAGE = "Illegal move of trying to move to a space already occupied by a piece of the same player";

        ChessGame game = getChessGame();

        game.movePiece(WHITE_PAWN, A3);
        game.movePiece(BLACK_PAWN, A6);
        assertFalse(game.isValidMove(WHITE_ROOK, A3));
        assertFalse(game.isValidMove(WHITE_KNIGHT, A3));
    }

    @Points(value = 5)
    @Test
    public void isInvalidDueToBlock() {
        TEST_GOAL_MESSAGE = "Illegal move by being blocked to the endpoint";

        ChessGame game = getChessGame();

        game.movePiece(E4);
        game.movePiece(E5);
        game.movePiece(G4);
        game.movePiece(H5);

        assertFalse(game.isValidMove(WHITE_QUEEN, H5));
    }

    @Points(value = 5)
    @Test
    public void getPieceAtGridPositionBeforeAndAfterCapture() {
        TEST_GOAL_MESSAGE = "Checking that the piece at the GridPosition is updated from captured to captor after " +
                            "capture";

        ChessGame game = getChessGame();

        game.movePiece(E4);
        game.movePiece(E5);
        game.movePiece(G3);

        game.movePiece(H5);
        assertEquals(BLACK_PAWN, game.getPiece(H5));

        game.movePiece(H5);
        assertEquals(WHITE_QUEEN, game.getPiece(H5));

    }

    @Points(value = 5)
    @Test
    public void pieceDoesNotMakeSenseWithFileAndGP() {
        TEST_GOAL_MESSAGE = "Piece provided doesn't make sense despite potentially valid pairing of file and endpoint";

        ChessGame game = getChessGame();

        game.movePiece(A4);
        game.movePiece(A5);

        game.movePiece(H4);
        game.movePiece(H5);

        game.movePiece(WHITE_ROOK, H3);
        game.movePiece(G5);

        assertFalse(game.isValidMove(WHITE_KNIGHT, 'A', A3));
    }

    @Points(value = 5)
    @Test
    public void fileDoesNotMakeSenseWithPieceAndGP() {
        TEST_GOAL_MESSAGE = "File provided doesn't make sense despite potentially valid pairing of piece and endpoint";

        ChessGame game = getChessGame();

        game.movePiece(A4);
        game.movePiece(A5);

        game.movePiece(H4);
        game.movePiece(H5);

        game.movePiece(WHITE_ROOK, H3);
        game.movePiece(G5);

        assertFalse(game.isValidMove(WHITE_ROOK, 'D', A3));
    }
}