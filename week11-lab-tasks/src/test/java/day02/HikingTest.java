package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HikingTest {

    @Test
    void testGetPlusElevation() {
        Hiking hiking = new Hiking();
        hiking.addGpsData(new GPS(1.1,1.1,10.0));
        hiking.addGpsData(new GPS(1.1,1.1,20.0));
        hiking.addGpsData(new GPS(1.1,1.1,15.0));
        hiking.addGpsData(new GPS(1.1,1.1,18.0));

        assertEquals(13.0,hiking.getPlusElevation(hiking.getHeights()));
    }

    @Test
    void testZeroElevation() {
        Hiking hiking = new Hiking();
        hiking.addGpsData(new GPS(1.1,1.1,20.0));
        hiking.addGpsData(new GPS(1.1,1.1,18.0));
        hiking.addGpsData(new GPS(1.1,1.1,17.0));
        hiking.addGpsData(new GPS(1.1,1.1,15.0));

        assertEquals(0,hiking.getPlusElevation(hiking.getHeights()));
    }
}