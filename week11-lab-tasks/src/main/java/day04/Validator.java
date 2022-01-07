package day04;

public class Validator {

    public static boolean isEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }

    public static boolean isEmptyItem(Item item) {
        return item == null;
    }
}
