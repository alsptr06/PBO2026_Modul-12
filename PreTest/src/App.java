public class App {
    public static void main(String[] args) throws Exception {
        LibraryManager b = new LibraryManager("Java Basics", "Alice", 2020);
        b.info(); 
        System.out.println(b.pinjam()); 
        b.info(); 
        b.kembalikan(12, 7); 
        b.info();
    }
}
