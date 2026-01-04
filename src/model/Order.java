package model;

import java.util.ArrayList;

/**
 * Sipariş işlemlerini yöneten sınıf.
 * Müşteri, restoran, yemekler ve sipariş durumunu içerir.
 */
public class Order {
    private Customer customer;
    private Restaurant restaurant;
    private ArrayList<MenuItem> items;
    private double totalPrice;
    private OrderStatus status; // YENİ: Siparişin durumu (Enum)

    public Order(Customer customer, Restaurant restaurant) {
        this.customer = customer;
        this.restaurant = restaurant;
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
        this.status = OrderStatus.RECEIVED; // Varsayılan durum: ALINDI
    }

    public void addItem(MenuItem item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    // Durumu değiştirmek için metod (Örn: Hazırlanıyor -> Yolda)
    public void setStatus(OrderStatus status) {
        this.status = status;
        System.out.println("Sipariş durumu güncellendi: " + status);
    }

    // Getter Metotları
    public OrderStatus getStatus() { return status; }
    public double getTotalPrice() { return totalPrice; }
    public Customer getCustomer() { return customer; }
}