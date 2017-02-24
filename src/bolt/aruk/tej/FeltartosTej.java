package bolt.aruk.tej;

import bolt.Tej;

import java.util.Date;

public class FeltartosTej extends Tej {
    public FeltartosTej(long vonalkod, int urtartalom, String gyarto, Date szavatossagiIdo, double zsirtartalom) {
        super(vonalkod, urtartalom, gyarto, szavatossagiIdo, zsirtartalom);
    }

    @Override
    public String toString() {
        return String.format("%s %s, féltartós tej (%f%%) %fl",
                gyarto,
                getZsir(),
                zsirtartalom,
                (float) urtartalom / 1000);
    }
}
