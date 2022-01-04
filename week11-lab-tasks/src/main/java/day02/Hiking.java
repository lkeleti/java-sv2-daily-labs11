package day02;

import java.util.ArrayList;
import java.util.List;

public class Hiking {
    private List<GPS> gpsDatas = new ArrayList<>();

    public void addGpsData(GPS gpsData) {
        gpsDatas.add(gpsData);
    }

    public List<GPS> getGpsDatas() {
        return new ArrayList<>(gpsDatas);
    }

    public List<Double> getHeights() {
        List<Double> heights = new ArrayList<>();
        for (GPS gpsData: gpsDatas) {
            heights.add(gpsData.getHeight());
        }
        return heights;
    }

    public double getPlusElevation(List<Double> heights) {
        double rising = 0.0;
        for (int i = 0; i < heights.size()-1; i++) {
            if (heights.get(i+1) > heights.get(i)) {
                rising += (heights.get(i+1) - heights.get(i));
            }
        }
        return rising;
    }
}
