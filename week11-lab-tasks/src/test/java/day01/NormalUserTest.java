package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalUserTest {

    @Test
    void getUserEmail() {
        NormalUser normalUser = new NormalUser("normalUser@gmail.com", "NormalPassword");
        assertEquals("normalUser@gmail.com", normalUser.getUserEmail());
    }

    @Test
    void getPassword() {
        NormalUser normalUser = new NormalUser("normalUser@gmail.com", "NormalPassword");
        assertEquals("NormalPassword", normalUser.getPassword());
    }
}