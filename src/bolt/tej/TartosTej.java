package bolt.tej;

import bolt.Tej;

import java.util.Date;

public class TartosTej extends Tej {
    public TartosTej(long vonalkod, int urtartalom, String gyarto, Date szavatossagiIdo, double zsirtartalom) {
        super(vonalkod, urtartalom, gyarto, szavatossagiIdo, zsirtartalom);
    }

    @Override
    public String toString() {
        String zsir = "";
        if (zsirtartalom == ZSIROS) {
            zsir = "zsíros";
        } else if (zsirtartalom == FELZSIROS) {
            zsir = "félzsíros";
        }
        return String.format("%s %s, féltartós tej (%f%%) %fl", gyarto, zsir, zsirtartalom, (float) urtartalom / 1000);
    }
}
