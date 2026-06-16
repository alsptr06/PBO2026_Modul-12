public class Karyawan implements UktCalculateStrategy{
    
    private static final double UKT_KARYAWAN = 80000000;

    @Override
    public double calculateUkt(DataUKT data) {
        return UKT_KARYAWAN;
    }
}
