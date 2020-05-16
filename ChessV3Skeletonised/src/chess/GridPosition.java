package chess;

import java.util.HashMap;
import java.util.Map;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public enum GridPosition {
    A1("A1"), A2("A2"), A3("A3"), A4("A4"), A5("A5"), A6("A6"), A7("A7"), A8("A8"),
    B1("B1"), B2("B2"), B3("B3"), B4("B4"), B5("B5"), B6("B6"), B7("B7"), B8("B8"),
    C1("C1"), C2("C2"), C3("C3"), C4("C4"), C5("C5"), C6("C6"), C7("C7"), C8("C8"),
    D1("D1"), D2("D2"), D3("D3"), D4("D4"), D5("D5"), D6("D6"), D7("D7"), D8("D8"),
    E1("E1"), E2("E2"), E3("E3"), E4("E4"), E5("E5"), E6("E6"), E7("E7"), E8("E8"),
    F1("F1"), F2("F2"), F3("F3"), F4("F4"), F5("F5"), F6("F6"), F7("F7"), F8("F8"),
    G1("G1"), G2("G2"), G3("G3"), G4("G4"), G5("G5"), G6("G6"), G7("G7"), G8("G8"),
    H1("H1"), H2("H2"), H3("H3"), H4("H4"), H5("H5"), H6("H6"), H7("H7"), H8("H8");

    private static final int FILE_INDEX = 0;
    private static final int RANK_INDEX = 1;

    static Map<String, GridPosition> translate;
    static {
        translate = new HashMap<>();
        translate.put("A1", A1);
        translate.put("A2", A2);
        translate.put("A3", A3);
        translate.put("A4", A4);
        translate.put("A5", A5);
        translate.put("A6", A6);
        translate.put("A7", A7);
        translate.put("A8", A8);
        translate.put("B1", B1);
        translate.put("B2", B2);
        translate.put("B3", B3);
        translate.put("B4", B4);
        translate.put("B5", B5);
        translate.put("B6", B6);
        translate.put("B7", B7);
        translate.put("B8", B8);
        translate.put("C1", C1);
        translate.put("C2", C2);
        translate.put("C3", C3);
        translate.put("C4", C4);
        translate.put("C5", C5);
        translate.put("C6", C6);
        translate.put("C7", C7);
        translate.put("C8", C8);
        translate.put("D1", D1);
        translate.put("D2", D2);
        translate.put("D3", D3);
        translate.put("D4", D4);
        translate.put("D5", D5);
        translate.put("D6", D6);
        translate.put("D7", D7);
        translate.put("D8", D8);
        translate.put("E1", E1);
        translate.put("E2", E2);
        translate.put("E3", E3);
        translate.put("E4", E4);
        translate.put("E5", E5);
        translate.put("E6", E6);
        translate.put("E7", E7);
        translate.put("E8", E8);
        translate.put("F1", F1);
        translate.put("F2", F2);
        translate.put("F3", F3);
        translate.put("F4", F4);
        translate.put("F5", F5);
        translate.put("F6", F6);
        translate.put("F7", F7);
        translate.put("F8", F8);
        translate.put("G1", G1);
        translate.put("G2", G2);
        translate.put("G3", G3);
        translate.put("G4", G4);
        translate.put("G5", G5);
        translate.put("G6", G6);
        translate.put("G7", G7);
        translate.put("G8", G8);
        translate.put("H1", H1);
        translate.put("H2", H2);
        translate.put("H3", H3);
        translate.put("H4", H4);
        translate.put("H5", H5);
        translate.put("H6", H6);
        translate.put("H7", H7);
        translate.put("H8", H8);
    }
    private final String position;

    GridPosition(final String position) {
        this.position = position;
    }

    public static GridPosition translate(String str) {
        return translate.get(str.toUpperCase());
    }

    public String toString() {
        return position;
    }

    public char getFile() {
        return position.charAt(FILE_INDEX);
    }

    public char getRank() {
        return position.charAt(RANK_INDEX);
    }
}
