import java.util.List;

public class KrsPrinter {

        public void printPDF(String namaMahasiswa, List<MataKuliah> daftarMataKuliah) {
        System.out.println("===KOP SURAT UNIVERSITAS===");
        System.out.println("Nama Mahasiswa: " + namaMahasiswa);

        
        StringBuilder sb = new StringBuilder();
        int totalSKS = 0;
        for (MataKuliah mk : daftarMataKuliah) {
            sb.append(mk.getNamaMatkul()).append(" (").append(mk.getSKS()).append(" SKS), ");
            totalSKS += mk.getSKS();
        }

        System.out.println("Daftar Mata Kuliah: " + sb.toString());
        System.out.println("Total SKS: " + totalSKS);
        System.out.println("=================================");
        System.out.println("KRS PDF berhasil dibuat untuk " + namaMahasiswa);
    }
}