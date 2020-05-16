package test.chess;

import chess.ChessGame;
import chess.ChessGameImpl_Skeleton;
import chess.GridPosition;
import chess.Player;
import chess.piece.*;
import org.junit.Test;
import test.Points;
import test.piece.PieceTest_7_BlackPawn;

import static chess.GridPosition.*;
import static org.junit.Assert.*;
import static utils.PythonMethods.print;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public class ChessGameImplTest_1_MovementValidation extends PieceTest_7_BlackPawn {
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
        TEST_GOAL_MESSAGE = "Checking that White pieces are the only ones can move one turn one and but the ones that" +
                            " are blocked can't";
        final GridPosition[][] moves = new GridPosition[][] {
                new GridPosition[] {
                        A4, C3, F4, D2, E5, A6, H3, D1,
                        },
                new GridPosition[] {
                        A3, B3, C4, D4, E4, F4, G3, H3,
                        },
                new GridPosition[] {
                        A6, B6, C6, D6, E6, F6, G6, H6,
                        },
                new GridPosition[] {
                        A5, C6, F5, D7, E4, A3, H6, D8,
                        },
                };
        final int[] necessaryRanks = new int[] {1, 2, 7, 8};

        ChessGame game = getChessGame();
        for (int i = necessaryRanks.length - 1; i >= 0; i--) {
            for (int file = 0; file < COL_COUNT; file++) {
                int rank = necessaryRanks[i];
                GridPosition gp = getGPFromFileRank(file, rank);
                Piece p = game.getPiece(gp);
                GridPosition moveTo = moves[i][file];
                boolean validMove = game.isValidMove(p, moveTo);
                if (i == 3 || i == 2) {
                    assertFalse(validMove);
                } else {
                    if (i == 1 || (file == 1 || file == 6)) {
                        assertTrue(validMove);
                    } else {
                        assertFalse(validMove);
                    }
                }
            }
        }
    }

    @Points(value = 5)
    @Test
    public void test_movePiece_playerMoveAlternation() {
        TEST_GOAL_MESSAGE = "Piece movement alternates between players and ALWAYS starts with White";

        ChessGame game = getChessGame();
        print(game);

        assertFalse(game.isValidMove(BLACK_PAWN, B5));
        assertTrue(game.isValidMove(WHITE_PAWN, A4));
        game.movePiece(WHITE_PAWN, A4);
        print(game);

        assertFalse(game.isValidMove(WHITE_PAWN, A5));
        assertTrue(game.isValidMove(BLACK_PAWN, B5));
        game.movePiece(BLACK_PAWN, B5);
        print(game);

        assertFalse(game.isValidMove(BLACK_ROOK, F6));
        assertTrue(game.isValidMove(WHITE_PAWN, B5));
        game.movePiece(WHITE_PAWN, B5);
        print(game);
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
    @Test
    public void test_5() {
        TEST_GOAL_MESSAGE = "";

        ChessGame game = getChessGame();

        game.movePiece(WHITE_PAWN, A4);
        game.movePiece(BLACK_PAWN, A6);

        game.movePiece(WHITE_PAWN, H4);
        game.movePiece(BLACK_PAWN, B6);

        game.movePiece(WHITE_ROOK, A3);
        game.movePiece(BLACK_PAWN, C6);

        game.movePiece(WHITE_ROOK, H3);
        game.movePiece(BLACK_PAWN, D6);

        assertTrue(game.isAmbiguousMove(WHITE_ROOK, E3));
    }

    @Points(value = 5)
    @Test
    public void test_6() {
        TEST_GOAL_MESSAGE = "";

        ChessGame game = getChessGame();

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