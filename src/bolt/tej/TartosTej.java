package bolt.tej;

import bolt.Tej;

import java.util.Date;

public class TartosTej extends Tej {
    public TartosTej(long vonalkod, int urtartalom, String gyarto, Date szavatossagiIdo, double zsirtartalom) {
        super(vonalkod, urtartalom, gyarto, szavatossagiIdo, zsirtartalom);
    }

    @Override
    public String toString() {
        return String.format("%s %s, tartós tej (%f%%) %fl",
                gyarto,
                getZsir(),
                zsirtartalom,
                (float) urtartalom / 1000);
    }
}
