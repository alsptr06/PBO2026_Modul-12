public class App {
    public static void main(String[] args) throws Exception {
        OrderService order1 = new OrderService(new CreditCard(), new EmailSystem());
        order1.processPayment(500000);
        order1.processRefund(100000);

        OrderService order2 = new OrderService(new GiftVoucher(), new EmailSystem());
        order2.processPayment(100000);
        try {
            order2.processRefund(50000);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
