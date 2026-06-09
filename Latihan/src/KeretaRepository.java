import java.util.ArrayList;
import java.util.List;


public class KeretaRepository {
    private List<Kereta> daftarKereta;

    public KeretaRepository() {
        daftarKereta = new ArrayList<>();
        daftarKereta.add(new Kereta("K01", "Argo Bromo", "JKT - SBY", 50));
        daftarKereta.add(new Kereta("K02", "Parahyangan", "JKT - BDG", 15));
    }

    public List<Kereta> getDaftarKereta() {
        return daftarKereta;
    }

    public Kereta cariKereta(String kodeKereta) {
        for (Kereta k : daftarKereta) {
            if (k.getKodeKereta().equalsIgnoreCase(kodeKereta)) {
                return k;
            }
        }
        return null;
    }
}