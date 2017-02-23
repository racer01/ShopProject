package bolt;

import java.util.Calendar;
import java.util.Date;

public class Tej {
    public static final int LITER = 1000;
    public static final int FELLITER = 500;
    public static final int POHAR = 200;
    public static final double ZSIROS = 3.5;
    public static final double FELZSIROS = 2.8;
    protected Long vonalkod;
    protected int urtartalom;
    protected String gyarto;
    protected Date szavatossagiIdo;
    protected double zsirtartalom;

    public Tej(long vonalkod,
               int urtartalom,
               String gyarto,
               Date szavatossagiIdo,
               double zsirtartalom) {
        this.vonalkod = vonalkod;
        this.urtartalom = urtartalom;
        this.gyarto = gyarto;
        this.szavatossagiIdo = szavatossagiIdo;
        this.zsirtartalom = zsirtartalom;
    }

    public Long getVonalkod() {
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

    @Override
    public String toString() {
        String zsir = "";
        if (zsirtartalom == ZSIROS) {
            zsir = String.format("%s ", "zsíros");
        } else if (zsirtartalom == FELZSIROS) {
            zsir = String.format("%s ", "félzsíros");
        }
        return String.format("%s %s tej (%f%%) %fl", gyarto, zsir, zsirtartalom, (float) urtartalom / 1000);
    }
}
