import model.*;
import service.OrderService;
import service.RestaurantService;
import payment.CashPayment;
import payment.CreditCardPayment;
import payment.PaymentMethod;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Online Yemek Sipariş Sistemi'nin ana giriş noktasıdır (Main Class).
 * <p>
 * Bu sınıf, Konsol Arayüzü (CLI) üzerinden kullanıcı ile etkileşime geçer.
 * Menüleri listeleme, sipariş oluşturma ve ödeme işlemlerini yöneten
 * ana döngüyü barındırır.
 * </p>
 *
 * @author Gökhan Demirci
 * @version 3.0
 */

public class Main {

    private static RestaurantService restaurantService = new RestaurantService();
    private static OrderService orderService = new OrderService();
    private static Scanner scanner = new Scanner(System.in);

    private static Customer currentUser;

    public static void main(String[] args) {
        System.out.println("--- SİSTEM BAŞLATILIYOR (Versiyon 3.0 - Final) ---\n");

        // 1. Verileri Yükle
        initializeData();

        // 2. Kullanıcı Girişi
        currentUser = new Customer("Gökhan", "Demirci", "gokhan@mail.com", "555-1234");
        System.out.println("Hoşgeldiniz, " + currentUser.getName() + "!");

        // 3. Menü Döngüsü
        boolean running = true;
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Buffer temizleme

            switch (choice) {
                case 1:
                    listRestaurants();
                    break;
                case 2:
                    createOrderFlow();
                    break;
                case 3:
                    viewOrdersAndPay();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor... İyi günler!");
                    running = false;
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    // --- YARDIMCI METOTLAR ---

    private static void printMenu() {
        System.out.println("\n=== ANA MENÜ ===");
        System.out.println("1. Restoranları Listele");
        System.out.println("2. Sipariş Ver");
        System.out.println("3. Ödeme Yap");
        System.out.println("0. Çıkış");
        System.out.print("Seçiminiz: ");
    }

    private static void listRestaurants() {
        System.out.println("\n--- RESTORAN LİSTESİ ---");
        ArrayList<Restaurant> list = restaurantService.getRestaurants();

        if (list.isEmpty()) {
            System.out.println("Sistemde kayıtlı restoran yok.");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            Restaurant r = list.get(i);
            System.out.println((i + 1) + ". " + r.getName() + " (Puan: " + r.getRating() + ")");

            for (MenuItem item : r.getMenu()) {
                System.out.println("   - " + item.getName() + ": " + item.getPrice() + " TL");
            }
        }
    }

    private static void createOrderFlow() {
        System.out.println("\n--- SİPARİŞ OLUŞTURMA ---");
        ArrayList<Restaurant> list = restaurantService.getRestaurants();

        System.out.print("Restoran Seç (Numara): ");
        int resIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (resIndex < 0 || resIndex >= list.size()) {
            System.out.println("Hatalı seçim!");
            return;
        }
        Restaurant selectedRestaurant = list.get(resIndex);

        Order newOrder = orderService.createOrder(currentUser, selectedRestaurant);

        boolean adding = true;
        while (adding) {
            System.out.println("\n" + selectedRestaurant.getName() + " Menüsü:");
            ArrayList<MenuItem> menu = selectedRestaurant.getMenu();
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menu.get(i).getName() + " - " + menu.get(i).getPrice() + " TL");
            }
            System.out.println("0. Tamamla");

            System.out.print("Ürün Ekle: ");
            int itemIndex = scanner.nextInt() - 1;
            scanner.nextLine();

            if (itemIndex == -1) {
                adding = false;
            } else if (itemIndex >= 0 && itemIndex < menu.size()) {
                newOrder.addItem(menu.get(itemIndex));
                System.out.println("Eklendi.");
            }
        }
    }

    private static void viewOrdersAndPay() {
        System.out.println("\n--- ÖDEME EKRANI ---");
        ArrayList<Order> orders = orderService.getOrders();

        if (orders.isEmpty()) {
            System.out.println("Ödenecek sipariş yok.");
            return;
        }

        for (int i = 0; i < orders.size(); i++) {
            System.out.println((i + 1) + ". Tutar: " + orders.get(i).getTotalPrice() + " TL - Durum: " + orders.get(i).getStatus());
        }

        System.out.print("Ödemek istediğiniz sipariş (Numara): ");
        int orderIndex = scanner.nextInt() - 1;

        if (orderIndex >= 0 && orderIndex < orders.size()) {
            Order selectedOrder = orders.get(orderIndex);

            System.out.println("1. Kredi Kartı");
            System.out.println("2. Nakit");
            int payChoice = scanner.nextInt();

            PaymentMethod paymentMethod;

            if (payChoice == 1) {
                paymentMethod = new CreditCardPayment("1111-2222-3333-4444", currentUser.getName());
            } else {
                paymentMethod = new CashPayment();
            }

            paymentMethod.pay(selectedOrder);
        }
    }

    // Sisteme zenginleştirilmiş test verileri ekleyen metot
    private static void initializeData() {

        Restaurant r1 = new Restaurant("Anadolu Sofrası", 4.8);
        // Çorbalar
        r1.addMenuItem(new MenuItem("Mercimek Çorbası", 70.0, "Süzme, tereyağlı sos ile"));
        r1.addMenuItem(new MenuItem("Yayla Çorbası", 70.0, "Naneli soslu"));
        // Ana Yemekler & Pideler
        r1.addMenuItem(new MenuItem("Adana Kebap", 240.0, "Közlenmiş domates ve biber ile"));
        r1.addMenuItem(new MenuItem("Kuşbaşılı Pide", 220.0, "Odun ateşinde, bol malzemeli"));
        r1.addMenuItem(new MenuItem("Kaşarlı Pide", 190.0, "Özel Trabzon peynirli"));
        r1.addMenuItem(new MenuItem("Lahmacun", 80.0, "Taş fırından, çıtır"));
        // Tatlı
        r1.addMenuItem(new MenuItem("Fıstıklı Baklava", 180.0, "Günlük, 3 dilim"));
        // İçecek
        r1.addMenuItem(new MenuItem("Yayık Ayran", 30.0, "Bol köpüklü, bakır bardakta"));


        Restaurant r2 = new Restaurant("Fast Food Diyarı", 4.5);
        r2.addMenuItem(new MenuItem("Cheeseburger Menü", 260.0, "180gr köfte, patates ve içecek"));
        r2.addMenuItem(new MenuItem("Pizza Margherita", 210.0, "İtalyan hamuru, mozzarella, fesleğen"));
        r2.addMenuItem(new MenuItem("Barbekü Tavuk Pizza", 240.0, "Özel soslu"));
        r2.addMenuItem(new MenuItem("Soğan Halkası", 60.0, "8 adet, çıtır"));
        r2.addMenuItem(new MenuItem("Sufle", 120.0, "Akışkan çikolatalı, sıcak"));
        r2.addMenuItem(new MenuItem("Ice Tea Şeftali", 40.0, "Büyük boy"));


        Restaurant r3 = new Restaurant("Sultan Sofrası1", 4.9);
        // Sebze & Salata
        r3.addMenuItem(new MenuItem("Zeytinyağlı Enginar", 160.0, "Dereotlu, bezelyeli"));
        r3.addMenuItem(new MenuItem("Sezar Salata", 190.0, "Izgara tavuklu, krutonlu"));
        r3.addMenuItem(new MenuItem("Mevsim Salatası", 110.0, "Taze yeşillikler, nar ekşili"));
        r3.addMenuItem(new MenuItem("Izgara Sebze Tabağı", 180.0, "Kabak, patlıcan, biber, mantar"));
        r3.addMenuItem(new MenuItem("Kabak Çorbası", 80.0, "Kremalı, kıtır ekmekli"));
        // İçecek
        r3.addMenuItem(new MenuItem("Taze Sıkılmış Portakal Suyu", 70.0, "Katkısız"));
        r3.addMenuItem(new MenuItem("Detoks Suyu", 50.0, "Salatalık, nane, limon"));


        // Restoranları servise kaydet
        restaurantService.addRestaurant(r1);
        restaurantService.addRestaurant(r2);
        restaurantService.addRestaurant(r3);

        System.out.println("✅ Menüler başarıyla yüklendi: Pide, Çorba, Sebze seçenekleri eklendi.");
    }

}