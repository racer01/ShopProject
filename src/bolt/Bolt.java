package bolt;

import java.util.Hashtable;

public class Bolt {
    private String nev;
    private String cim;
    private String tulajdonos;
    // I used <Long, BoltBejegyzes>
    // because the solution written in #general (<Class<? extends Elelmiszer>, BoltBejegyzes>)
    // don't make sense because you can't store multiple types of Tej that way (ie. litre and cup)
    private Hashtable<Long, BoltBejegyzes> elelmiszerpult;

    public Bolt(String nev, String cim, String tulajdonos, Hashtable elelmiszerpult) {
        this.nev = nev;
        this.cim = cim;
        this.tulajdonos = tulajdonos;
        this.elelmiszerpult = elelmiszerpult;
    }

    public Bolt(String nev, String cim, String tulajdonos) {
        this.nev = nev;
        this.cim = cim;
        this.tulajdonos = tulajdonos;
        this.elelmiszerpult = new Hashtable<Long, BoltBejegyzes>();
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

    private boolean vanMegAdottAru(Class c) {
        for (BoltBejegyzes boltBejegyzes : elelmiszerpult.values()) {
            if (c.isInstance(boltBejegyzes.e)) {
                return true;
            }
        }
        return false;
    }

    public boolean vanMegTej() {
        return vanMegAdottAru(Tej.class);
    }

    public boolean vanMegSajt() {
        return false;
    }

    public void feltoltElelmiszerrel(Long vonalkod, long mennyiseg) throws NemLetezoAruKivetel {
        if (elelmiszerpult.containsKey(vonalkod)) {
            elelmiszerpult.get(vonalkod).adMennyiseg(mennyiseg);
        } else {
            throw new NemLetezoAruKivetel("Nem létezik ilyen teltölthető áru.");
        }
    }

    public void feltoltUjElelmiszerrel(Elelmiszer e, long mennyiseg, long ar) {
        elelmiszerpult.put(e.getVonalkod(), new BoltBejegyzes(e, mennyiseg, ar));
    }

    public void torolElelmiszert(Long vonalkod) throws NemLetezoAruKivetel {
        if (elelmiszerpult.containsKey(vonalkod)) {
            elelmiszerpult.remove(vonalkod);
        } else {
            throw new NemLetezoAruKivetel("Nem létezik ilyen törölhető áru.");
        }
    }

    public void vasarolElelmiszert(Long vonalkod, long mennyiseg) throws NemLetezoAruKivetel, TulSokLevonasKivetel {
        if (elelmiszerpult.containsKey(vonalkod)) {
            elelmiszerpult.get(vonalkod).levonMennyiseg(mennyiseg);
        } else {
            throw new NemLetezoAruKivetel("Nem létezik ilyen megvásárolható áru.");
        }
    }

    class BoltBejegyzes {
        private Elelmiszer e;
        private long mennyiseg;
        private long ar;

        public BoltBejegyzes(Elelmiszer e, long mennyiseg, long ar) {
            this.e = e;
            this.mennyiseg = mennyiseg;
            this.ar = ar;
        }

        public Elelmiszer getElelmiszer() {
            return e;
        }

        public void setElelmiszer(Elelmiszer e) {
            this.e = e;
        }

        public long getMennyiseg() {
            return mennyiseg;
        }

        public void setMennyiseg(long mennyiseg) {
            this.mennyiseg = mennyiseg;
        }

        public void adMennyiseg(long mennyiseg) {
            this.mennyiseg += mennyiseg;
        }

        public void levonMennyiseg(long mennyiseg) throws TulSokLevonasKivetel {
            if (this.mennyiseg >= mennyiseg) {
                this.mennyiseg -= mennyiseg;
            }
            else {
                throw new TulSokLevonasKivetel("A kívánt áruból nem elérhető a kívánt mennyiség.");
            }
        }

        public long getAr() {
            return ar;
        }

        public void setAr(long ar) {
            this.ar = ar;
        }
    }
}
