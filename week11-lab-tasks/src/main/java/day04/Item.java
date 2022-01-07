package day04;

import java.time.LocalDate;

public abstract class Item {

    private final String name;
    private final int price;
    protected int expiryTime;
    private LocalDate boughtDate;

    protected Item(String name, int price) {
        if (Validator.isEmpty(name)) {
            throw new IllegalArgumentException("Item name can't be empty!");
        }

        if (price < 0) {
            throw new IllegalArgumentException("Price can't be negative!");
        }
        this.name = name;
        this.price = price;
        this.expiryTime = setExpiryTime();
    }

    protected Item(String name, int price, LocalDate boughtDate) {
        this(name,price);
        this.boughtDate = boughtDate;
    }

    public abstract int setExpiryTime();

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getExpiryTime() {
        return expiryTime;
    }

    public LocalDate getExpiryDate() {
        if (boughtDate == null) {
            return LocalDate.now().plusMonths(expiryTime);
        }
        else {
            return boughtDate.plusMonths(expiryTime);
        }
    }

    public LocalDate getBoughtDate() {
        return boughtDate;
    }

    public void setBoughtDate(LocalDate boughtDate) {
        this.boughtDate = boughtDate;
    }
}
