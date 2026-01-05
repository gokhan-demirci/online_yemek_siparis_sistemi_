package service;

import model.Order;
import model.Customer;
import model.Restaurant;
import java.util.ArrayList;

/**
 * Sipariş işlemlerini yöneten servis sınıfı.
 * Yeni sipariş oluşturur ve mevcut siparişleri listeler.
 */
public class OrderService {
    private ArrayList<Order> orders; // Tüm siparişlerin tutulduğu liste

    public OrderService() {
        this.orders = new ArrayList<>();
    }

    // Yeni bir sipariş oluşturur ve sisteme kaydeder
    public Order createOrder(Customer customer, Restaurant restaurant) {
        Order newOrder = new Order(customer, restaurant);
        orders.add(newOrder);
        System.out.println("Sipariş oluşturuldu: " + customer.getName() + " -> " + restaurant.getName());
        return newOrder;
    }

    // Tüm siparişleri getirir
    public ArrayList<Order> getOrders() {
        return orders;
    }
}