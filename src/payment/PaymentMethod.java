package payment;

/**
 * Tüm ödeme yöntemlerinin uyması gereken kural seti (Interface).
 * Polymorphism yapısını burada kuruyoruz.
 */
public interface PaymentMethod {
    void pay(double amount);
}