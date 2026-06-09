public class TiketPemesanan {
    private String namaPenumpang;
    private String nik;
    private Kereta kereta;
    private int jumlahTiket;

    public TiketPemesanan(String namaPenumpang, String nik, Kereta kereta, int jumlahTiket) {
        this.namaPenumpang = namaPenumpang;
        this.nik = nik;
        this.kereta = kereta;
        this.jumlahTiket = jumlahTiket;
    }

    public String getNamaPenumpang() {
        return namaPenumpang;
    }

    public String getNik() {
        return nik;
    }

    public Kereta getKereta() {
        return kereta;
    }

    public int getJumlahTiket() {
        return jumlahTiket;
    }
}