public class TiketService {
    private KeretaRepository keretaRepository;
    private PenumpangValidator penumpangValidator;

    public TiketService(KeretaRepository keretaRepository, PenumpangValidator penumpangValidator) {
        this.keretaRepository = keretaRepository;
        this.penumpangValidator = penumpangValidator;
    }

    public TiketPemesanan pesanTiket(String kodeKereta, String nik, String namaPenumpang, int jumlahTiket) {
        penumpangValidator.validasiNIK(nik);

        Kereta kereta = keretaRepository.cariKereta(kodeKereta);
        if (kereta == null) {
            throw new RuteTidakDitemukanException("Kode kereta tidak ditemukan");
        }

        if (jumlahTiket > kereta.getSisaKursi()) {
            throw new TiketHabisException("Tiket tidak cukup",
                    kereta.getNamaKereta(), kereta.getSisaKursi());
        }

        kereta.kurangiKursi(jumlahTiket);
        return new TiketPemesanan(namaPenumpang, nik, kereta, jumlahTiket);
    }
}