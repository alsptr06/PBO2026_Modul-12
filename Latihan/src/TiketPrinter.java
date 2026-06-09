public class TiketPrinter {

    public void printJadwal(KeretaRepository repository) {
        System.out.println("--- JADWAL KERETA ---");
        for (Kereta k : repository.getDaftarKereta()) {
            System.out.println(k.getKodeKereta() + " | " + k.getNamaKereta() + " | " + k.getRutePerjalanan()
                    + " | Sisa: " + k.getSisaKursi());
        }
        System.out.println();
    }

    public void printTiket(TiketPemesanan tiket) {
        System.out.println("=== PEMESANAN BERHASIL ===");
        System.out.println("Nama: " + tiket.getNamaPenumpang());
        System.out.println("NIK: " + tiket.getNik());
        System.out.println("Kereta: " + tiket.getKereta().getNamaKereta());
        System.out.println("Rute: " + tiket.getKereta().getRutePerjalanan());
        System.out.println("Jumlah Tiket: " + tiket.getJumlahTiket());
        System.out.println("==========================");
    }
}