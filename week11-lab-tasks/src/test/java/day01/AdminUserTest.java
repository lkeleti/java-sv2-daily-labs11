package day01;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdminUserTest {

    @Test
    void testGetUserEmail() {
        AdminUser adminUser = new AdminUser("adminuser@gmail.com", "Password1234");
        assertEquals("adminuser@gmail.com", adminUser.getUserEmail());
    }

    @Test
    void testGetPassword() {
        AdminUser adminUser = new AdminUser("adminuser@gmail.com", "Password1234");
        assertEquals("************", adminUser.getPassword());
        assertEquals("Password1234".length(), adminUser.getPassword().length());
    }
}