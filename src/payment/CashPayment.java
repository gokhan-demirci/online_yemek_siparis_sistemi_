package payment;

public class CashPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Kapıda ödeme seçildi.");
        System.out.println(amount + " TL nakit olarak tahsil edildi.");
    }
}