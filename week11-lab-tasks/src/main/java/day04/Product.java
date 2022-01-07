package day04;

import java.time.LocalDate;

public class Product extends Item{
    private static final int NORMAL_EXPIRY_TIME = 3;
    private static final int EXTRA_EXPIRY_TIME = 36;

    public Product(String name, int price) {
        super(name, price);
    }

    public Product(String name, int price, LocalDate boughtDate) {
        super(name, price, boughtDate);
    }

    @Override
    public int setExpiryTime() {
        return NORMAL_EXPIRY_TIME;
    }

    public void setExtraWarranty() {
        expiryTime = EXTRA_EXPIRY_TIME;
    }
}
