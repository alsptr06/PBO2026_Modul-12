class SmsSystem implements SmsNotifier {
    @Override
    public void sendSMS(String message) {
        System.out.println("[SMS] Mengirim: " + message);
    }
}
