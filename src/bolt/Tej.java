package bolt;

import java.util.Calendar;
import java.util.Date;

public class Tej {
    private long vonalkod;
    private static final int LITER = 1000;
    private static final int FELLITER = 500;
    private static final int POHAR = 200;
    private static final double ZSIROS = 3.5;
    private static final double FELZSIROS = 2.8;
    private int urtartalom;
    private String gyarto;
    private Date szavatossagiIdo;
    private double zsirtartalom;
    private long ar;

    public Tej(long vonalkod,
               int urtartalom,
               String gyarto,
               Date szavatossagiIdo,
               double zsirtartalom,
               long ar) {
        this.vonalkod = vonalkod;
        this.urtartalom = urtartalom;
        this.gyarto = gyarto;
        this.szavatossagiIdo = szavatossagiIdo;
        this.zsirtartalom = zsirtartalom;
        this.ar = ar;
    }

    public long getVonalkod() {
        return vonalkod;
    }

    public boolean joMeg() {
        return Calendar.getInstance().getTime().compareTo(szavatossagiIdo) < 0;
    }

    public int getUrtartalom() {
        return urtartalom;
    }

    public String getGyarto() {
        return gyarto;
    }

    public Date getSzavatossagiIdo() {
        return szavatossagiIdo;
    }

    public double getZsirtartalom() {
        return zsirtartalom;
    }

    public long getAr() {
        return ar;
    }

    @Override
    public String toString() {
        return String.format("%s %s", gyarto, zsirtartalom);
    }
}
