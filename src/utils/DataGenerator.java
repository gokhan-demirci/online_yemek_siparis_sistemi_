package utils;

import model.MenuItem;
import model.Restaurant;
import service.RestaurantService;

/**
 * Test verilerini oluşturmak için kullanılan yardımcı sınıf.
 * Main sınıfını temiz tutmak için verileri burada üretiyoruz.
 */
public class DataGenerator {

    // Sahte restoran ve menü verilerini üretip servise yükler
    public void initializeData(RestaurantService restaurantService) {

        // 1. Restoran: Lezzet Durağı
        Restaurant r1 = new Restaurant("Lezzet Durağı", 4.5);
        r1.addMenuItem(new MenuItem("İskender", 320.0, "Bol Tereyağlı"));
        r1.addMenuItem(new MenuItem("Adana Kebap", 240.0, "Acılı"));
        r1.addMenuItem(new MenuItem("Ayran", 30.0, "Yayık"));

        // 2. Restoran: Pizza Limanı
        Restaurant r2 = new Restaurant("Pizza Limanı", 4.3);
        r2.addMenuItem(new MenuItem("Karışık Pizza", 260.0, "Büyük Boy"));
        r2.addMenuItem(new MenuItem("Margarita", 200.0, "İnce Hamur"));
        r2.addMenuItem(new MenuItem("Cola", 40.0, "Zero"));

        // 3. Restoran: Burger Evi (Yeni)
        Restaurant r3 = new Restaurant("Burger Evi", 4.7);
        r3.addMenuItem(new MenuItem("Cheeseburger", 180.0, "150gr Et"));
        r3.addMenuItem(new MenuItem("Patates", 60.0, "Baharatlı"));

        // Hepsini servise kaydediyoruz
        restaurantService.addRestaurant(r1);
        restaurantService.addRestaurant(r2);
        restaurantService.addRestaurant(r3);

        System.out.println("--- Test Verileri Yüklendi (Data Generator) ---");
    }
}