package MATKUL;
public class MatkulPraktikum implements MataKuliah, Praktikum {
    private String namaMatkul;
    private int sks;
    public MatkulPraktikum(String namaMatkul, int sks) {
        this.namaMatkul = namaMatkul;
        this.sks = sks;
    }
   
    @Override
    public String getNamaMatkul() {
        return namaMatkul;
    }
   
    @Override
    public int getSKS() {
        return sks;
    }

    @Override
    public void alokasiAsistenLab() {
        System.out.println("Asisten lab untuk " + namaMatkul + " telah dialokasikan.");
    }

    @Override
    public void cekPeralatanPraktikum() {
        System.out.println("Peralatan praktikum untuk " + namaMatkul + " telah diperiksa.");
    }

}


