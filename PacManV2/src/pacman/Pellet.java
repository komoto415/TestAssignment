package pacman;

public enum Pellet {
    DOT('*', 1), CHERRY('C', 4);

    private final char ch;
    private final int point;

    Pellet(final char ch, int point) {
        this.ch = ch;
        this.point = point;
    }

    public static Pellet translate(char ch) {
        Pellet p;
        switch (Character.toLowerCase(ch)) {
            case '*':
                p = DOT;
                break;
            case 'c':
                p = CHERRY;
                break;
            default:
                p = null;
        }
        return p;
    }

    public char getCharSymbol() {
        return ch;
    }

    public int getPointValue() {
        return point;
    }

}
