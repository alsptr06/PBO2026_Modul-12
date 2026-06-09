import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        KeretaRepository keretaRepository = new KeretaRepository();
        PenumpangValidator penumpangValidator = new PenumpangValidator();
        TiketService tiketService = new TiketService(keretaRepository, penumpangValidator);
        TiketPrinter tiketPrinter = new TiketPrinter();

        boolean running = true;

        while (running) {
            System.out.println("=== JAVA EXPRESS ===");
            System.out.println("1. Lihat Jadwal");
            System.out.println("2. Pesan Tiket");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        tiketPrinter.printJadwal(keretaRepository);
                        break;

                    case 2:
                        System.out.print("Kode Kereta: ");
                        String kode = scanner.nextLine();
                        System.out.print("NIK: ");
                        String nik = scanner.nextLine();
                        System.out.print("Nama Penumpang: ");
                        String nama = scanner.nextLine();
                        System.out.print("Jumlah Tiket: ");
                        int jumlah = scanner.nextInt();
                        scanner.nextLine();

                        TiketPemesanan tiket = tiketService.pesanTiket(kode, nik, nama, jumlah);
                        tiketPrinter.printTiket(tiket);
                        break;

                    case 3:
                        running = false;
                        break;

                    default:
                        System.out.println("Menu tidak tersedia");
                }

            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka");
                scanner.nextLine();
            } catch (DataPenumpangTidakValidException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (RuteTidakDitemukanException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (TiketHabisException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Kereta: " + e.getNamaKereta());
                System.out.println("Sisa Kursi: " + e.getSisaKursi());
            }
        }

        System.out.println("Terima kasih telah menggunakan JAVA EXPRESS");
        scanner.close();
    }
}