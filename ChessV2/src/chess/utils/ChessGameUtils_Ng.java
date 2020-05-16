package chess.utils;

import chess.GridPosition;
import chess.piece.*;

import java.util.HashMap;
import java.util.Map;

import static chess.Player.BLACK;
import static chess.Player.WHITE;

/**
 @author Jeffrey Ng
 @created 2020-05-13 */
public class ChessGameUtils_Ng {
    public static final int Y_INDEX = 0;
    public static final int X_INDEX = 1;
    static Map<Character, Integer> fileToCol;
    static Map<Character, Integer> rankToRow;
    static Map<Integer, Character> colToFile;
    static Map<Integer, Character> rowToRank;
    static Map<Piece, Integer> maxAmountOfAParticularPiece;
    static {
        fileToCol = new HashMap<>();
        fileToCol.put('A', 0);
        fileToCol.put('B', 1);
        fileToCol.put('C', 2);
        fileToCol.put('D', 3);
        fileToCol.put('E', 4);
        fileToCol.put('F', 5);
        fileToCol.put('G', 6);
        fileToCol.put('H', 7);
    }

    static {
        colToFile = new HashMap<>();
        colToFile.put(0, 'A');
        colToFile.put(1, 'B');
        colToFile.put(2, 'C');
        colToFile.put(3, 'D');
        colToFile.put(4, 'E');
        colToFile.put(5, 'F');
        colToFile.put(6, 'G');
        colToFile.put(7, 'H');
    }

    static {
        rankToRow = new HashMap<>();
        rankToRow.put('8', 0);
        rankToRow.put('7', 1);
        rankToRow.put('6', 2);
        rankToRow.put('5', 3);
        rankToRow.put('4', 4);
        rankToRow.put('3', 5);
        rankToRow.put('2', 6);
        rankToRow.put('1', 7);
    }

    static {
        rowToRank = new HashMap<>();
        rowToRank.put(0, '8');
        rowToRank.put(1, '7');
        rowToRank.put(2, '6');
        rowToRank.put(3, '5');
        rowToRank.put(4, '4');
        rowToRank.put(5, '3');
        rowToRank.put(6, '2');
        rowToRank.put(7, '1');
    }

    static {
        maxAmountOfAParticularPiece = new HashMap<>();
        maxAmountOfAParticularPiece.put(new Pawn(BLACK), 8);
        maxAmountOfAParticularPiece.put(new Pawn(WHITE), 8);
        maxAmountOfAParticularPiece.put(new Rook(BLACK), 2);
        maxAmountOfAParticularPiece.put(new Rook(WHITE), 2);
        maxAmountOfAParticularPiece.put(new Knight(BLACK), 2);
        maxAmountOfAParticularPiece.put(new Knight(WHITE), 2);
        maxAmountOfAParticularPiece.put(new Bishop(BLACK), 2);
        maxAmountOfAParticularPiece.put(new Bishop(WHITE), 2);
        maxAmountOfAParticularPiece.put(new King(BLACK), 1);
        maxAmountOfAParticularPiece.put(new King(WHITE), 1);
        maxAmountOfAParticularPiece.put(new Queen(BLACK), 1);
        maxAmountOfAParticularPiece.put(new Queen(WHITE), 1);
    }

    public static int convertFileToXIndex(char file) {
        return fileToCol.get(file);
    }

    public static int convertRankToYIndex(char rank) {
        return rankToRow.get(rank);
    }

    public static char convertYIndexToRank(int y) {
        return rowToRank.get(y);
    }

    public static char convertXIndexToFile(int x) {
        return colToFile.get(x);
    }

    public static int[] convertGridPositionTo2DYXArray(GridPosition gp) {
        char file = gp.getFile();
        char rank = gp.getRank();

        return new int[] {convertRankToYIndex(rank), convertFileToXIndex(file)};
    }

    public static GridPosition convert2DYXArrayToGridPosition(int[] yx) {
        StringBuilder sb = new StringBuilder();
        char file = convertXIndexToFile(yx[X_INDEX]);
        char rank = convertYIndexToRank(yx[Y_INDEX]);

        return GridPosition.translate(sb.append(file).append(rank).toString());
    }

    public static int getMaxNumberOfPotentialPiece(Piece p) {
        return maxAmountOfAParticularPiece.get(p);
    }
}
