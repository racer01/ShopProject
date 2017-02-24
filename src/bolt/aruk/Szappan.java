package bolt.aruk;

import bolt.Aru;

public class Szappan extends Aru {
    public static final char AMOSOHATAS = 'A';
    public static final char BMOSOHATAS = 'B';
    private final char mosohatas;

    public Szappan(Long vonalkod, String gyarto, char mosohatas) {
        super(vonalkod, gyarto);
        this.mosohatas = mosohatas;
    }
}
