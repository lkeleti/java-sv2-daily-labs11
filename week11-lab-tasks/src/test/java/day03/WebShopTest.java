package day03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WebShopTest {
    WebShop webShop = null;

    @BeforeEach
    void setUp() {
        webShop = new WebShop(List.of(
                new Product("Pendrive",3000),
                new Product("SSD",10000),
                new Service("Install Windows",8000)
                ),
                List.of(
                        new User("JohnDoe",50000),
                        new User("JackDoe",3000),
                        new User ("JaneDoe",1000)
                ));
    }

    @Test
    void normalSellProductTest() {
        webShop.sellItem("JackDoe","Pendrive", LocalDate.of(2021,12,13));
        assertEquals(0, webShop.getUsers().get(1).getCash());
        assertEquals(LocalDate.of(2022,3,13), webShop.getUsers().get(1).getItems().get(0).getExpiryDate());
    }

    @Test
    void extraWarrantySellProductTest() {
        webShop.sellItem("JohnDoe","Install Windows", LocalDate.of(2021,12,13));
        assertEquals(42000, webShop.getUsers().get(0).getCash());
        assertEquals(LocalDate.of(2022,12,13), webShop.getUsers().get(0).getItems().get(0).getExpiryDate());
    }

    @Test
    void normalSellServiceTest() {
        webShop.sellItem("JohnDoe","Pendrive", LocalDate.of(2021,12,13));
        assertEquals(46700, webShop.getUsers().get(0).getCash());
        assertEquals(LocalDate.of(2024,12,13), webShop.getUsers().get(0).getItems().get(0).getExpiryDate());
    }

    @Test
    void lowMoneySellTest() {
        Exception actualException = assertThrows(IllegalStateException.class, () ->
                webShop.sellItem("JaneDoe","SSD", LocalDate.of(2021,12,13))
        );

        assertEquals("Don't have enough money!", actualException.getMessage());
    }

    @Test
    void emptyUsernameSellTest() {
        Exception actualException = assertThrows(IllegalArgumentException.class, () ->
                webShop.sellItem("","SSD", LocalDate.of(2021,12,13))
        );

        assertEquals("Username can not be empty!", actualException.getMessage());
    }

    @Test
    void emptyItemSellTest() {
        Exception actualException = assertThrows(IllegalArgumentException.class, () ->
                webShop.sellItem("JohnDoe","", LocalDate.of(2021,12,13))
        );

        assertEquals("Item name can not be empty!", actualException.getMessage());
    }

    @Test
    void unknownUserSellTest() {
        Exception actualException = assertThrows(IllegalArgumentException.class, () ->
                webShop.sellItem("Anonymous","SSD", LocalDate.of(2021,12,13))
        );

        assertEquals("User does not exists!", actualException.getMessage());
    }

    @Test
    void unknownItemSellTest() {
        Exception actualException = assertThrows(IllegalArgumentException.class, () ->
                webShop.sellItem("JohnDoe","Bread", LocalDate.of(2021,12,13))
        );

        assertEquals("Item does not exists!", actualException.getMessage());
    }

    @Test
    void warrantyCheckBeforeSellProductTest() {
        assertEquals(LocalDate.now().plusMonths(3), webShop.getItems().get(0).getExpiryDate());
    }

    @Test
    void warrantyCheckBeforeSellServiceTest() {
        assertEquals(LocalDate.now().plusMonths(12), webShop.getItems().get(2).getExpiryDate());
    }
}