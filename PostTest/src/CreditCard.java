public class CreditCard implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("[CreditCard] Membayar Rp" + amount + " via API Bank");
    }

    @Override
    public void refund(double amount) {
        System.out.println("[CreditCard] Mengembalikan Rp" + amount + " ke rekening bank");
    }
}
