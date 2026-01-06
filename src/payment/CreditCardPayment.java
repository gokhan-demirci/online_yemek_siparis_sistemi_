package payment;

public class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(double amount) {
        // Gerçek hayatta burada banka servisine bağlanılır.
        System.out.println("Banka ile iletişim kuruluyor...");
        System.out.println(amount + " TL tutarındaki ödeme " + cardNumber + " nolu karttan çekildi.");
    }
}