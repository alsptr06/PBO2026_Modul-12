class OrderService {
    private final Payable paymentMethod;
    private final EmailNotifier notifier;

    public OrderService(Payable paymentMethod, EmailNotifier notifier) {
        this.paymentMethod = paymentMethod;
        this.notifier = notifier;
    }

    public void processPayment(double amount) {
        paymentMethod.pay(amount);
        notifier.sendEmail("Pembayaran Rp" + amount + " berhasil");
    }

    public void processRefund(double amount) {
        if (paymentMethod instanceof Refundable refundable) {
            refundable.refund(amount);
            notifier.sendEmail("Refund Rp" + amount + " diproses");
        } else {
            throw new UnsupportedOperationException("Voucher tidak dapat di-refund!");
        }
    }
}