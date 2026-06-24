package KRS;
import java.util.Arrays;
import java.util.List;

public class ValidatorMatKul {

    
    private static final List<String> MATA_KULIAH_TANPA_PRASYARAT = Arrays.asList(
            "PBO", "Basis Data", "Algoritma");

    public boolean validasiPrasyarat(String mahasiswaId, String kodeMatkul) {
        System.out.println("Memeriksa prasyarat untuk " + kodeMatkul + "...");

       
        if (MATA_KULIAH_TANPA_PRASYARAT.contains(kodeMatkul)) {
            System.out.println( kodeMatkul + " tidak memiliki prasyarat");
            return true;
        }

        
        System.out.println(" Prasyarat " + kodeMatkul + " terpenuhi untuk mahasiswa " + mahasiswaId);
        return true;
    }
}