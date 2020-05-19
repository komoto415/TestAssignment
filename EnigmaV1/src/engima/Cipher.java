package engima;

/**
 @author Jeffrey Ng
 @created 2020-05-19 */
public abstract class Cipher {
    char[][] wiring;

    public Cipher(char[][] wiring) {
        this.wiring = wiring;
    }

    public abstract char encode(char ch, boolean direction);

    private static final int KEY_INDEX = 0;
    private static final int SHIFT_INDEX = 1;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (char[] shift : wiring) {
            sb.append(shift[KEY_INDEX]).append(" : ").append(shift[SHIFT_INDEX]).append('\n');
        }
        return sb.toString().trim();
    }
}
