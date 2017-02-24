package bolt.aruk;

import bolt.Aru;

import java.util.Calendar;
import java.util.Date;

public abstract class Elelmiszer extends Aru {
    protected Date szavatossagiIdo;

    public Elelmiszer(Long vonalkod, String gyarto, Date szavatossagiIdo) {
        super(vonalkod, gyarto);
        this.szavatossagiIdo = szavatossagiIdo;
    }

    public boolean joMeg() {
        return Calendar.getInstance().getTime().compareTo(szavatossagiIdo) < 0;
    }

    public Date getSzavatossagiIdo() {
        return szavatossagiIdo;
    }
}
