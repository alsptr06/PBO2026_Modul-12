public class OvoPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("[OVO] Membayar Rp" + amount + " via API OVO");
    }

    @Override
    public void refund(double amount) {
        System.out.println("[OVO] Mengembalikan Rp" + amount + " ke saldo OVO");
    }
}
