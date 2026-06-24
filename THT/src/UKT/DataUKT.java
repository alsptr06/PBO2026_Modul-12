package UKT;
public class DataUKT {
    private String jurusan;
    private String tingkat;
    private String prestasi;

    public DataUKT(String jurusan, String tingkat, String prestasi) {
        this.jurusan = jurusan;
        this.tingkat = tingkat;
        this.prestasi = prestasi;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getTingkat() {
        return tingkat;
    }

    public String getPrestasi() {
        return prestasi;
    }
}
