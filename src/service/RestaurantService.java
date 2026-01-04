package service;

import model.Restaurant;
import java.util.ArrayList;

/**
 * Restoranları sisteme ekler ve listeler.
 */
public class RestaurantService {
    private ArrayList<Restaurant> restaurants; // Tüm restoranların listesi

    public RestaurantService() {
        this.restaurants = new ArrayList<>();
    }

    // Sisteme yeni bir restoran ekler
    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
        System.out.println(restaurant.getName() + " sisteme başarıyla eklendi.");
    }

    // Kayıtlı restoranları getirir
    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }
}