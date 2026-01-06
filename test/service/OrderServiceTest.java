package service;

import model.Customer;
import model.MenuItem;
import model.Order;
import model.Restaurant;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @Test
    public void testCreateOrderAndCalculateTotal() {

        OrderService orderService = new OrderService();

        Customer customer = new Customer("Ali", "Yılmaz", "ali@mail.com", "123456");

        Restaurant restaurant = new Restaurant("Lezzet Dünyası", 4.8);

        MenuItem burger = new MenuItem("Burger", 150.0, "Bol cheddarlı");
        MenuItem kola = new MenuItem("Kola", 30.0, "Soğuk kutu içecek");

        restaurant.getMenu().add(burger);
        restaurant.getMenu().add(kola);

        Order order = orderService.createOrder(customer, restaurant);

        order.addItem(burger);
        order.addItem(kola);

        assertNotNull(order, "Sipariş nesnesi null olmamalı!");
        assertEquals(180.0, order.getTotalPrice(), "Toplam tutar yanlış hesaplandı!");

        System.out.println("Test Başarılı: Sipariş tutarı 180.0 TL.");
    }
}