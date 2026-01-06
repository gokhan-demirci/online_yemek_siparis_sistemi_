import model.*;
import service.OrderService;
import service.RestaurantService;
import utils.DataGenerator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- SİSTEM BAŞLATILIYOR (Versiyon 2.0) ---\n");

        // 1. Servisleri ve Veri Üreticiyi Başlat
        RestaurantService restaurantService = new RestaurantService();
        OrderService orderService = new OrderService();
        DataGenerator dataGenerator = new DataGenerator();

        // 2. Hazır Verileri Yükle
        // Tek satırla bütün restoranlar ve menüler yükleniyor.
        dataGenerator.initializeData(restaurantService);

        // 3. Kullanılacak Restoranı Seç
        ArrayList<Restaurant> restaurantList = restaurantService.getRestaurants();
        Restaurant selectedRestaurant = restaurantList.get(0); // Lezzet Durağı'nı seçtik

        // 4. Müşteri Oluştur
        Customer customer = new Customer("Gökhan Demirci", "gokhan@mail.com", "555-1234", "Kadıköy");

        // 5. Sipariş Oluştur
        System.out.println("\n--- Sipariş Oluşturuluyor ---");
        Order newOrder = orderService.createOrder(customer, selectedRestaurant);

        // Menüden örnek yemekler eklendi
        newOrder.addItem(selectedRestaurant.getMenu().get(0)); // İskender
        newOrder.addItem(selectedRestaurant.getMenu().get(2)); // Ayran

        // 6. Sonuç Yazdır
        System.out.println("\n--- Fiş Detayı ---");
        System.out.println("Restoran: " + selectedRestaurant.getName());
        System.out.println("Müşteri: " + newOrder.getCustomer().getName());
        System.out.println("Toplam Tutar: " + newOrder.getTotalPrice() + " TL");
        System.out.println("Sipariş Durumu: " + newOrder.getStatus());
    }
}