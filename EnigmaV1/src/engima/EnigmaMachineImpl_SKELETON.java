package engima;

/**
 @author Jeffrey Ng
 @created 2020-05-19 */
public class EnigmaMachineImpl_SKELETON implements EnigmaMachine {
    private final Rotor rotor1;
    private final Rotor rotor2;
    private final Rotor rotor3;
    private final Reflector reflector;
    private final PlugBoard plugBoard;

    public EnigmaMachineImpl_SKELETON(Rotor rotor1, Rotor rotor2, Rotor rotor3, Reflector reflector,
            PlugBoard plugBoard) {
        this.rotor1 = rotor1;
        this.rotor2 = rotor2;
        this.rotor3 = rotor3;
        this.reflector = reflector;
        this.plugBoard = plugBoard;
    }

    @Override
    public String encode(String str) {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    @Override
    public void moveRotors() {
        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }
}
