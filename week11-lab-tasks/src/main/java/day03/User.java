package day03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

    private final String userName;
    private final List<Item> items = new ArrayList<>();
    private int cash;

    public User(String userName, int cash) {
        if (Validator.isEmpty(userName)) {
            throw new IllegalArgumentException("Username can't be empty!");
        }

        if (cash < 0) {
            throw new IllegalArgumentException("Cash can't be negative!");
        }
        this.userName = userName;
        this.cash = cash;
    }

    public String getUserName() {
        return userName;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public int getCash() {
        return cash;
    }

    public void buyItem(Item item, LocalDate dateOfBuy) {
        if (Validator.isEmptyItem(item)) {
            throw new NullPointerException("Item can't be null!");
        }
        if (!checkCash(item.getPrice())) {
            throw new IllegalStateException("Don't have enough money!");
        }
        if (item instanceof Product) {
            Product boughtItem = new Product(item.getName(), item.getPrice(), dateOfBuy);
            if (checkExtraWarranty(item.getPrice())) {
                cash -= (item.getPrice() * 0.1);
                boughtItem.setExtraWarranty();
            }
            items.add(boughtItem);
        } else {
            items.add(new Service(item.getName(), item.getPrice(), dateOfBuy));
        }
        cash -= item.getPrice();
    }

    private boolean checkCash(int price) {
        return price <= cash;
    }

    private boolean checkExtraWarranty(int price) {
        return (price * 3) <= cash;
    }
}
