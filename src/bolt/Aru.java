package bolt;

public abstract class Aru {
    protected Long vonalkod;
    protected String gyarto;

    public Aru(Long vonalkod, String gyarto) {
        this.vonalkod = vonalkod;
        this.gyarto = gyarto;
    }

    public Long getVonalkod() {
        return vonalkod;
    }

    public String getGyarto() {
        return gyarto;
    }

    @Override
    public abstract String toString();
}
