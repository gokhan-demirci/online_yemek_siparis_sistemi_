package payment;

import model.Order;
import model.OrderStatus;

/**
 * Nakit ödeme işlemlerini yöneten sınıf.
 * <p>
 * {@link PaymentMethod} arayüzünü uygular. Bu strateji seçildiğinde,
 * ödemenin teslimat sırasında fiziksel olarak yapıldığı varsayılır.
 * </p>
 *
 * @author Gökhan Demirci
 */

public class CashPayment implements PaymentMethod {

    @Override
    public void pay(Order order) {
        System.out.println("Kapıda ödeme seçildi.");
        System.out.println(order.getTotalPrice() + " TL nakit olarak tahsil edildi.");

        // Nakit ödemede sipariş anında teslim edilmiş sayılır
        order.setStatus(OrderStatus.DELIVERED);
    }
}