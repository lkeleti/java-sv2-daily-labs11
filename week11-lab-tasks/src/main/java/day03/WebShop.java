package day03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WebShop {

    private final List<Item> items;
    private final List<User> users;

    public WebShop(List<Item> items, List<User> users) {
        this.items = items;
        this.users = users;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public void sellItem(String userName, String itemName, LocalDate dateOfBuy) {
        if (Validator.isEmpty(userName)) {
            throw new IllegalArgumentException("Username can not be empty!");
        }

        if (Validator.isEmpty(itemName)) {
            throw new IllegalArgumentException("Item name can not be empty!");
        }

        getUser(userName).buyItem(getItem(itemName),dateOfBuy);
    }

    private User getUser(String userName) {
        for (User user: users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        throw new IllegalArgumentException("User does not exists!");
    }

    private Item getItem(String itemName) {
        for (Item item: items) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Item does not exists!");
    }
}
