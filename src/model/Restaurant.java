package model;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private double rating;
    private ArrayList<MenuItem> menu; // Yemek listesi

    public Restaurant(String name, double rating) {
        this.name = name;
        this.rating = rating;
        this.menu = new ArrayList<>();
    }

    // Menüye yemek ekleme
    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    // Menüyü listeleme
    public void listMenu() {
        System.out.println("--- " + name + " Menüsü ---");
        for (MenuItem item : menu) {
            System.out.println(item);
        }
    }

    public String getName() { return name; }
    public ArrayList<MenuItem> getMenu() { return menu; }
}