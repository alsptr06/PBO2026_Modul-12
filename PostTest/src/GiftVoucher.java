class GiftVoucher implements Payable {
    @Override
    public void pay(double amount) {
        System.out.println("[GiftVoucher] Membayar Rp" + amount + " menggunakan voucher");
    }
}