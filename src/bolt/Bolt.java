package bolt;

import java.util.Hashtable;

public class Bolt {
    private String nev;
    private String cim;
    private String tulajdonos;
    // I used <Long, BoltBejegyzes>
    // because the solution written in #general (<Class<? extends Elelmiszer>, BoltBejegyzes>)
    // don't make sense because you can't store multiple types of Tej that way (ie. litre and cup)
    private Hashtable<Long, BoltBejegyzes> tejpult;

    public Bolt(String nev, String cim, String tulajdonos, Hashtable tejpult) {
        this.nev = nev;
        this.cim = cim;
        this.tulajdonos = tulajdonos;
        this.tejpult = tejpult;
    }

    public Bolt(String nev, String cim, String tulajdonos) {
        this.nev = nev;
        this.cim = cim;
        this.tulajdonos = tulajdonos;
        this.tejpult = new Hashtable<Long, BoltBejegyzes>();
    }

    public String getNev() {
        return nev;
    }

    public String getCim() {
        return cim;
    }

    public String getTulajdonos() {
        return tulajdonos;
    }

    public boolean vanMegTej() {
        return tejpult.size() != 0;
    }

    public Tej vasarolTej(long vonalkod) {
        if (tejpult.contains(vonalkod)) {
            BoltBejegyzes vasaroltBejegyzes = this.tejpult.get(vonalkod);
            if (vasaroltBejegyzes.mennyiseg > 1) {
                vasaroltBejegyzes.levonMennyiseg(1);
            } else {
                Tej vasaroltTej = vasaroltBejegyzes.getT();
                tejpult.remove(vonalkod);
                return vasaroltTej;
            }
        }
        return null;
    }

    public void feltoltTej(Tej m) {
        if (tejpult.contains(m.vonalkod)) {
            tejpult.get(m.vonalkod).adMennyiseg(1);
        } else {
            tejpult.put(m.vonalkod.longValue(), new BoltBejegyzes(m, 1, 100));
        }
    }

    class BoltBejegyzes {
        private Tej t;
        private int mennyiseg;
        private int ar;

        public BoltBejegyzes(Tej t, int mennyiseg, int ar) {
            this.t = t;
            this.mennyiseg = mennyiseg;
            this.ar = ar;
        }

        public Tej getT() {
            return t;
        }

        public void setT(Tej t) {
            this.t = t;
        }

        public int getMennyiseg() {
            return mennyiseg;
        }

        public void setMennyiseg(int mennyiseg) {
            this.mennyiseg = mennyiseg;
        }

        public void adMennyiseg(int mennyiseg) {
            this.mennyiseg += mennyiseg;
        }

        public void levonMennyiseg(int mennyiseg) {
            this.mennyiseg -= mennyiseg;
        }

        public int getAr() {
            return ar;
        }

        public void setAr(int ar) {
            this.ar = ar;
        }
    }
}
