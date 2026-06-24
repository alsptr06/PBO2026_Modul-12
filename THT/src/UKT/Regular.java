package UKT;
public class Regular implements UktCalculateStrategy {
    private static final double UKT_DASAR = 50000000;
    private static final double DISKON_BERPRESTASI = 20000000;
    private static final String STATUS_BERPRESTASI = "berprestasi";

    @Override
    public double calculateUkt(DataUKT data) {
        double uktDasar = UKT_DASAR;

        
        if (data.getPrestasi().equalsIgnoreCase(STATUS_BERPRESTASI)) {
            uktDasar -= DISKON_BERPRESTASI;
        }

        return uktDasar;
    }
}
