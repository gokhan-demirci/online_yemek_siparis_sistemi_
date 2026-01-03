package model;

public class MenuItem {
    private String name;        // Yemeğin adı
    private double price;       // Fiyatı
    private String description; // Açıklaması

    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getter Metotları
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return name + " - " + price + " TL (" + description + ")";
    }
}