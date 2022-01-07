package day05;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Lottery {
    private int numberOfNumbers;
    private int maxLimit;

    public Lottery(int numberOfNumbers, int maxLimit) {
        if (numberOfNumbers > maxLimit) {
            throw new IllegalArgumentException("Illegal arguments!");
        }
        this.numberOfNumbers = numberOfNumbers;
        this.maxLimit = maxLimit;
    }

    public int getNumberOfNumbers() {
        return numberOfNumbers;
    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public List<Integer> startLottery() {
        HashSet<Integer> numbers = new HashSet<>();
        while(numbers.size() < numberOfNumbers) {
            numbers.add(new Random().nextInt(1, maxLimit +1));
        }
        return numbers.stream().toList();
    };
}
