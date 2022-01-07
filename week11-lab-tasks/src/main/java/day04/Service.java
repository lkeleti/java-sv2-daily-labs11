package day04;

import java.time.LocalDate;

public class Service extends Item{
    private static final int NORMAL_EXPIRY_TIME = 12;

    public Service(String name, int price) {
        super(name, price);
    }

    public Service(String name, int price, LocalDate boughtDate) {
        super(name, price, boughtDate);
    }

    @Override
    public int setExpiryTime() {
        return NORMAL_EXPIRY_TIME;
    }
}
