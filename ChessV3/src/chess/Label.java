package chess;

import java.util.HashMap;
import java.util.Map;

/**
 @author Jeffrey Ng
 @created 2020-05-13 */
public enum Label {
    PAWN("Pawn", 'P'), ROOK("Rook", 'R'), KNIGHT("Knight", 'N'),
    BISHOP("Bishop", 'B'), QUEEN("Queen", 'Q'), KING("King", 'K');

    static Map<String, Label> translate;
    static {
        translate = new HashMap<>();
        translate.put("PAWN", PAWN);
        translate.put("ROOK", ROOK);
        translate.put("KNIGHT", KNIGHT);
        translate.put("BISHOP", BISHOP);
        translate.put("QUEEN", QUEEN);
        translate.put("KING", KING);
    }
    private final String label;
    private final char labelShort;

    Label(final String label, final char labelShort) {
        this.label = label;
        this.labelShort = labelShort;
    }

    public static Label translate(String str) {
        return translate.get(str.toUpperCase());
    }

    public String toString() {
        return label;
    }

    public char getLabelShort() {
        return labelShort;
    }
}
