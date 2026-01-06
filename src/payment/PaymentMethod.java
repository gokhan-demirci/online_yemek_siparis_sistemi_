package payment;

import model.Order;

public interface PaymentMethod {
    void pay(Order order);
}