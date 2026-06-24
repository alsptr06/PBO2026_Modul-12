package UKT;
public class Internasional implements UktCalculateStrategy {
    
    private static final double UKT_INTERNASIONAL = 150000000;

    @Override
    public double calculateUkt(DataUKT data) {
        return UKT_INTERNASIONAL;
    }
}
