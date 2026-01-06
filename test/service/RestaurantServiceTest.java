package service;

import model.Restaurant;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class RestaurantServiceTest {

    @Test
    public void testAddRestaurant() {
        // 1. Servisi oluştur
        RestaurantService service = new RestaurantService();

        // 2. Bir restoran oluştur ve ekle
        Restaurant restaurant = new Restaurant("Test Kebapçısı", 4.0);
        service.addRestaurant(restaurant);

        // 3. Sonucu kontrol et
        List<Restaurant> list = service.getRestaurants();

        // Liste boş olmamalı
        assertNotNull(list);

        // Listenin boyutu 1 olmalı
        assertEquals(1, list.size());

        // Eklenen restoranın adı doğru mu?
        assertEquals("Test Kebapçısı", list.get(0).getName());
    }
}