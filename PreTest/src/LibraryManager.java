public class LibraryManager {
    private final String judul;
    private final String penulis;
    private final int tahunTerbit;
    private boolean tersedia = true;

    public LibraryManager(String judul, String penulis, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    public boolean cocok(String judul) {
        return this.judul.equalsIgnoreCase(judul);
    }

    public boolean pinjam() {
        if (!tersedia)
            return false;
        tersedia = false;
        return true;
    }

    public void kembalikan(int hariPinjam, int batasHari) {
        tersedia = true;
        if (hariPinjam > batasHari) {
            int denda = (hariPinjam - batasHari) * 1000;
            System.out.println("Terlambat! Denda: Rp" + denda);
        }
    }
    
    public void info() {
        System.out.println(judul + " | " + penulis + " | " + tahunTerbit + " | " + (tersedia ? "Tersedia" : "Dipinjam"));
    }

}