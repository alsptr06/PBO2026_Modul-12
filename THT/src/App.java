import java.util.ArrayList;
import java.util.List;
import KRS.*;
import MATKUL.*;
import UKT.*;

public class App {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   SISTEM AKADEMIK KAMPUS (SIAKAD)     ");
        System.out.println("========================================\n");

        // 1. Daftar Mata Kuliah
        System.out.println("--- [1] DAFTAR MATA KULIAH ---");

        MataKuliah pbo = new MataKuliah() {
            public String getNamaMatkul() {
                return "Pemrograman Berorientasi Objek";
            }

            public int getSKS() {
                return 3;
            }
        };

        MataKuliah basisData = new MataKuliah() {
            public String getNamaMatkul() {
                return "Basis Data";
            }

            public int getSKS() {
                return 3;
            }
        };

        MatkulPraktikum prakPBO = new MatkulPraktikum("Praktikum PBO", 1);
        MatkulPraktikum prakBasisData = new MatkulPraktikum("Praktikum Basis Data", 1);

        System.out.println("Mata Kuliah Teori:");
        System.out.println("  - " + pbo.getNamaMatkul() + " (" + pbo.getSKS() + " SKS)");
        System.out.println("  - " + basisData.getNamaMatkul() + " (" + basisData.getSKS() + " SKS)");

        System.out.println("\nMata Kuliah Praktikum:");
        System.out.println("  - " + prakPBO.getNamaMatkul() + " (" + prakPBO.getSKS() + " SKS)");
        prakPBO.alokasiAsistenLab();
        prakPBO.cekPeralatanPraktikum();

        System.out.println("  - " + prakBasisData.getNamaMatkul() + " (" + prakBasisData.getSKS() + " SKS)");
        prakBasisData.alokasiAsistenLab();
        prakBasisData.cekPeralatanPraktikum();

        // 2. Validasi Prasyarat
        System.out.println("\n--- [2] VALIDASI PRASYARAT MATA KULIAH ---");

        ValidatorMatKul validator = new ValidatorMatKul();
        String[] matkulDiuji = { "PBO", "Basis Data", "Algoritma", "Kecerdasan Buatan" };
        String mahasiswaId = "MHS2024001";

        for (String kode : matkulDiuji) {
            boolean hasil = validator.validasiPrasyarat(mahasiswaId, kode);
            System.out.println("  Hasil: " + (hasil ? "LULUS VALIDASI" : "GAGAL VALIDASI"));
            System.out.println();
        }

        // 3. Cetak KRS
        System.out.println("\n--- [3] CETAK KRS MAHASISWA ---");

        List<MataKuliah> daftarKRS = new ArrayList<>();
        daftarKRS.add(pbo);
        daftarKRS.add(basisData);
        daftarKRS.add(prakPBO);
        daftarKRS.add(prakBasisData);

        KrsPrinter printer = new KrsPrinter();
        printer.printPDF("Budi Santoso (NIM: MHS2024001)", daftarKRS);

        // 4. Perhitungan UKT
        System.out.println("\n--- [4] PERHITUNGAN UKT ---");

        DataUKT dataRegular = new DataUKT("Teknik Informatika", "Semester 3", "tidak berprestasi");
        DataUKT dataRegularPrestasi = new DataUKT("Teknik Informatika", "Semester 5", "berprestasi");
        DataUKT dataKaryawan = new DataUKT("Manajemen", "Semester 2", "tidak berprestasi");
        DataUKT dataInternasional = new DataUKT("Kedokteran", "Semester 1", "tidak berprestasi");
        DataUKT dataBidikMisi = new DataUKT("Teknik Sipil", "Semester 4", "berprestasi");

        CalculateUKT calculator = new CalculateUKT();

        // a) Regular
        System.out.println("\n[4a] Mahasiswa Regular:");
        calculator.setStrategy(new Regular());
        System.out.println("  UKT: Rp " + String.format("%,.0f", calculator.calculate(dataRegular)));

        // b) Regular + Prestasi
        System.out.println("\n[4b] Mahasiswa Regular (Berprestasi):");
        calculator.setStrategy(new Regular());
        System.out.println("  UKT: Rp " + String.format("%,.0f", calculator.calculate(dataRegularPrestasi)));

        // c) Karyawan
        System.out.println("\n[4c] Mahasiswa Karyawan:");
        calculator.setStrategy(new Karyawan());
        System.out.println("  UKT: Rp " + String.format("%,.0f", calculator.calculate(dataKaryawan)));

        // d) Internasional
        System.out.println("\n[4d] Mahasiswa Internasional:");
        calculator.setStrategy(new Internasional());
        System.out.println("  UKT: Rp " + String.format("%,.0f", calculator.calculate(dataInternasional)));

        // e) Bidik Misi
        System.out.println("\n[4e] Mahasiswa Bidik Misi:");
        calculator.setStrategy(new BidikMisi());
        System.out.println("  UKT: Rp " + String.format("%,.0f", calculator.calculate(dataBidikMisi)));

        // 5. Error Handling
        System.out.println("\n--- [5] ERROR HANDLING ---");
        System.out.println("Mencoba hitung UKT tanpa strategy...");
        CalculateUKT calculatorKosong = new CalculateUKT();
        try {
            calculatorKosong.calculate(dataRegular);
        } catch (IllegalStateException e) {
            System.out.println("  [ERROR] " + e.getMessage());
        }

        // Ringkasan
        System.out.println("\n========================================");
        System.out.println("          RINGKASAN SISTEM             ");
        System.out.println("========================================");
        System.out.println("Total SKS: 8");
        System.out.println("Regular: Rp 50.000.000");
        System.out.println("Regular + Prestasi: Rp 30.000.000");
        System.out.println("Karyawan: Rp 80.000.000");
        System.out.println("Internasional: Rp 150.000.000");
        System.out.println("Bidik Misi: Rp 0 (GRATIS)");
        System.out.println("\nSistem berjalan dengan baik!");
        System.out.println("========================================");
    }
}