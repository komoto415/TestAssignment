package chess;

/**
 @author Jeffrey Ng
 @created 2020-05-12 */
public enum Player {
    BLACK("Black"), WHITE("White");
    private final String player;

    Player(final String player) {
        this.player = player;
    }

    public static Player translate(String str) {
        return str.toLowerCase().equals("black") ? BLACK : WHITE;
    }

    public String toString() {
        return player;
    }
}
