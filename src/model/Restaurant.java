package model;

import java.util.ArrayList;

/**
 * Sistemdeki bir restoranı temsil eden sınıf.
 * <p>
 * Bir restoranın adını, puanını ve sahip olduğu menü öğelerini (Yemek/İçecek)
 * tutar. Menüye ürün ekleme ve listeleme işlemlerini yönetir.
 * </p>
 * * @author Gökhan Demirci
 */

public class Restaurant {
    private String name;
    private double rating; // YENİ: Puan değişkeni eklendi
    private ArrayList<MenuItem> menu;

    // Constructor hem isim hem puan alıyor
    public Restaurant(String name, double rating) {
        this.name = name;
        this.rating = rating;
        this.menu = new ArrayList<>();
    }

    // Main.java'da kullanılan puanı getiren metod
    public double getRating() {
        return rating;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void listMenu() {
        System.out.println("--- " + name + " Menüsü ---");
        for (MenuItem item : menu) {
            System.out.println(item); // MenuItem'ın toString() metodu varsa güzel yazar
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }
}