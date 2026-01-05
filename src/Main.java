import model.*;
import service.OrderService;
import service.RestaurantService;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- SİSTEM BAŞLATILIYOR ---\n");

        // 1. Servisleri Başlat (Yöneticileri İşe Al)
        RestaurantService restaurantService = new RestaurantService();
        OrderService orderService = new OrderService();

        // 2. Veri Hazırlığı (Restoran ve Menü)
        Restaurant rest1 = new Restaurant("Lezzet Durağı", 4.5);
        rest1.addMenuItem(new MenuItem("İskender", 300.0, "Tereyağlı"));
        rest1.addMenuItem(new MenuItem("Ayran", 30.0, "Köpüklü"));

        Restaurant rest2 = new Restaurant("Pizza Limanı", 4.2);
        rest2.addMenuItem(new MenuItem("Karışık Pizza", 250.0, "Büyük Boy"));

        // 3. Restoranları Sisteme Kaydet
        restaurantService.addRestaurant(rest1);
        restaurantService.addRestaurant(rest2);

        // 4. Müşteri Oluştur
        Customer customer = new Customer("Gökhan Demirci", "gokhan@mail.com", "555-1234", "Kadıköy");

        // 5. SİPARİŞ OLUŞTURMA (Servis Üzerinden)
        System.out.println("\n--- Sipariş Süreci ---");
        Order myOrder = orderService.createOrder(customer, rest1);

        // Menüden yemek seçip siparişe ekliyoruz
        myOrder.addItem(rest1.getMenu().get(0)); // İskender
        myOrder.addItem(rest1.getMenu().get(1)); // Ayran

        // 6. SONUÇLARI YAZDIR
        System.out.println("\n--- Fiş Özeti ---");
        System.out.println("Müşteri: " + myOrder.getCustomer().getName());
        System.out.println("Restoran: " + rest1.getName());
        System.out.println("Durum: " + myOrder.getStatus()); // Enum testi
        System.out.println("Toplam Tutar: " + myOrder.getTotalPrice() + " TL");
    }
}