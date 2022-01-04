package day02;

public class GPS {
    private double longitude;
    private double latitude;
    private double height;

    public GPS(double longitude, double latitude, double height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getHeight() {
        return height;
    }
}
