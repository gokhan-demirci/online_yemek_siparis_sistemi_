import model.MenuItem;
import model.Restaurant;
import model.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Online Yemek Sipariş Sistemi Başlatılıyor ---\n");

        // 1. Örnek Kullanıcı Oluşturma (User Testi)
        User user1 = new User("Gökhan Demirci", "gokhan@mail.com", "555-1234");
        System.out.println(user1); // Kullanıcıyı ekrana yazdırır

        // 2. Yemekleri Oluşturma (MenuItem Testi)
        MenuItem item1 = new MenuItem("Adana Kebap", 240.0, "Bol Acılı");
        MenuItem item2 = new MenuItem("Lahmacun", 50.0, "Taş Fırın");
        MenuItem item3 = new MenuItem("Ayran", 20.0, "Köpüklü");

        // 3. Restoran Oluşturma ve Menüye Ekleme (Restaurant Testi)
        Restaurant restaurant = new Restaurant("Lezzet Dünyası", 4.8);
        restaurant.addMenuItem(item1);
        restaurant.addMenuItem(item2);
        restaurant.addMenuItem(item3);

        // 4. Menüyü Listeleme
        System.out.println("\n--- Restoran Bilgileri ---");
        restaurant.listMenu();
    }
}