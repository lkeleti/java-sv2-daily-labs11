package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;
    Item productExpensive;
    Item productCheap;
    Item productMedium;
    Item service;

    @BeforeEach
    void init() {
        user = new User("test",3000);
        productExpensive = new Product("SSD",15000);
        productMedium = new Product("Pendrive",2500);
        productCheap = new Product("DVD",200);
        service = new Service("Repair",1000);
    }
    @Test
    void getUserNameTest() {
        assertEquals("test", user.getUserName());
    }

    @Test
    void getItemsTest() {
        assertEquals(0, user.getItems().size());
    }

    @Test
    void getCashTest() {
        assertEquals(3000, user.getCash());
    }

    @Test
    void buyCheapProductTest() {
        user.buyItem(productCheap, LocalDate.of(2022,1,6));
        assertEquals(1,user.getItems().size());
        assertEquals(2780, user.getCash());
        assertEquals(LocalDate.of(2025,1,6),user.getItems().get(0).getExpiryDate());
    }

    @Test
    void buyServiceTest() {
        user.buyItem(service, LocalDate.of(2022,1,6));
        assertEquals(1,user.getItems().size());
        assertEquals(2000, user.getCash());
        assertEquals(LocalDate.of(2023,1,6),user.getItems().get(0).getExpiryDate());
    }
    @Test
    void buyExpensiveProductTest() {
        Exception e = assertThrows(IllegalStateException.class,()->
                user.buyItem(productExpensive,LocalDate.now()
                )
        );
        assertEquals("Don't have enough money!", e.getMessage());
    }
    @Test
    void buyMediumProductTest() {
        user.buyItem(productMedium, LocalDate.of(2022,1,6));
        assertEquals(1,user.getItems().size());
        assertEquals(500, user.getCash());
        assertEquals(LocalDate.of(2022,4,6),user.getItems().get(0).getExpiryDate());
    }
    @Test
    void buyNullItemTest() {
        Exception e = assertThrows(NullPointerException.class,()->
                user.buyItem(null,LocalDate.now()
                )
        );
        assertEquals("Item can't be null!", e.getMessage());
    }
}