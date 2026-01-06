import model.*;
import service.OrderService;
import service.RestaurantService;
import utils.DataGenerator;
import payment.*; // Ödeme sınıflarını dahil ettik

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- SİSTEM BAŞLATILIYOR (Versiyon 3.0 - Ödeme Entegrasyonu) ---\n");

        // 1. Servisleri Başlat
        RestaurantService restaurantService = new RestaurantService();
        OrderService orderService = new OrderService();
        DataGenerator dataGenerator = new DataGenerator();

        // 2. Verileri Yükle
        dataGenerator.initializeData(restaurantService);

        // 3. Restoran Seç (Lezzet Durağı)
        Restaurant selectedRestaurant = restaurantService.getRestaurants().get(0);

        // 4. Müşteri Oluştur
        Customer customer = new Customer("Gökhan Demirci", "gokhan@mail.com", "555-1234", "Kadıköy");

        // 5. Sipariş Oluştur
        System.out.println("\n--- Sipariş Oluşturuluyor ---");
        Order newOrder = orderService.createOrder(customer, selectedRestaurant);
        newOrder.addItem(selectedRestaurant.getMenu().get(0)); // İskender
        newOrder.addItem(selectedRestaurant.getMenu().get(2)); // Ayran

        // 6. Toplam Tutarı Göster
        System.out.println("\n--- Ödeme Ekranı ---");
        System.out.println("Ödenecek Tutar: " + newOrder.getTotalPrice() + " TL");

        // 7. ÖDEME İŞLEMİ
        PaymentMethod paymentMethod = new CreditCardPayment("1234-5678-9012-3456", "Gökhan Demirci");

        // Ödemeyi gerçekleştir
        paymentMethod.pay(newOrder.getTotalPrice());

        // 8. Sipariş Durumunu Güncelle
        newOrder.setStatus(OrderStatus.PREPARING);
        System.out.println("\nSipariş Durumu: " + newOrder.getStatus());
    }
}