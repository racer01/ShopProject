package bolt.aruk;

import java.util.Date;

public abstract class Tej extends Elelmiszer {
    public static final int LITER = 1000;
    public static final int FELLITER = 500;
    public static final int POHAR = 200;
    public static final double ZSIROS = 3.5;
    public static final double FELZSIROS = 2.8;
    protected int urtartalom;
    protected double zsirtartalom;

    public Tej(long vonalkod,
               int urtartalom,
               String gyarto,
               Date szavatossagiIdo,
               double zsirtartalom) {
        super(vonalkod, gyarto, szavatossagiIdo);
        this.urtartalom = urtartalom;
        this.zsirtartalom = zsirtartalom;
    }

    public int getUrtartalom() {
        return urtartalom;
    }

    public double getZsirtartalom() {
        return zsirtartalom;
    }

    protected String getZsir() {
        if (zsirtartalom == ZSIROS) {
            return "zsíros";
        } else if (zsirtartalom == FELZSIROS) {
            return "félzsíros";
        }
        return "";
    }
}
