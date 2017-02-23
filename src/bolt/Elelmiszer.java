package bolt;

import java.util.Calendar;
import java.util.Date;

public abstract class Elelmiszer {
    protected Long vonalkod;
    protected String gyarto;
    protected Date szavatossagiIdo;

    public Elelmiszer(Long vonalkod, String gyarto, Date szavatossagiIdo) {
        this.vonalkod = vonalkod;
        this.gyarto = gyarto;
        this.szavatossagiIdo = szavatossagiIdo;
    }

    public Long getVonalkod() {
        return vonalkod;
    }

    public boolean joMeg() {
        return Calendar.getInstance().getTime().compareTo(szavatossagiIdo) < 0;
    }

    public String getGyarto() {
        return gyarto;
    }

    public Date getSzavatossagiIdo() {
        return szavatossagiIdo;
    }

    @Override
    public abstract String toString();
}
