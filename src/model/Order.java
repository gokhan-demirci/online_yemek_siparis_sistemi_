package model;

import java.util.ArrayList;

/**
 * Sipariş işlemlerini yöneten sınıf.
 * Müşteri, restoran ve seçilen yemekleri birleştirir.
 */
public class Order {
    private Customer customer;       // Siparişi veren müşteri
    private Restaurant restaurant;   // Sipariş verilen restoran
    private ArrayList<MenuItem> items; // Sipariş edilen yemekler
    private double totalPrice;       // Toplam tutar

    public Order(Customer customer, Restaurant restaurant) {
        this.customer = customer;
        this.restaurant = restaurant;
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    // Siparişe yemek ekler ve tutarı günceller
    public void addItem(MenuItem item) {
        items.add(item);
        totalPrice += item.getPrice(); // Fiyatı toplama ekle
        System.out.println(item.getName() + " siparişe eklendi.");
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }
}