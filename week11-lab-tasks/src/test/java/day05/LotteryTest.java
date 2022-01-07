package day05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

    @Test
    void startLottery() {
        Lottery lottery = new Lottery(5,90);
        List<Integer> numbers = lottery.startLottery();
        assertEquals(5, numbers.size());
    }
}