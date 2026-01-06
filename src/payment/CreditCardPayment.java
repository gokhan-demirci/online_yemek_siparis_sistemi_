package payment;

import model.Order;
import model.OrderStatus;

/**
 * Kredi Kartı ile online ödeme işlemlerini yöneten sınıf.
 * <p>
 * {@link PaymentMethod} arayüzünü uygular. Banka ile iletişim kurularak
 * ödemenin sanal pos üzerinden çekilmesini simüle eder.
 * </p>
 *
 * @author Gökhan Demirci
 */

public class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private String cardHolder;

    public CreditCardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(Order order) {
        System.out.println("Banka ile iletişim kuruluyor...");
        System.out.println(order.getTotalPrice() + " TL tutarındaki ödeme " + cardNumber + " nolu karttan çekildi.");

        // Online ödemede sipariş mutfağa (Hazırlanıyor) düşer
        order.setStatus(OrderStatus.PREPARING);
    }
}