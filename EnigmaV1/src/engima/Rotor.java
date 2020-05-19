package engima;

/**
 @author Jeffrey Ng
 @created 2020-05-19 */
public class Rotor extends Reflector {
    private int position;

    public Rotor(char[][] wiring, int position) {
        super(wiring);
        this.position = position;
    }

    @Override
    public char encipher(char ch, boolean direction) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

}
