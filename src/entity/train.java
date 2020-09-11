package entity;

public class train {
    private String engine_number;
    private String engine_type;
    private int fuel_capacity;
    private String station_ID;

    public train(String engine_number, String engine_type, int fuel_capacity, String station_ID) {
        this.engine_number = engine_number;
        this.engine_type = engine_type;
        this.fuel_capacity = fuel_capacity;
        this.station_ID = station_ID;
    }

    public String getEngine_number() {
        return engine_number;
    }

    public void setEngine_number(String engine_number) {
        this.engine_number = engine_number;
    }

    public String getEngine_type() {
        return engine_type;
    }

    public void setEngine_type(String engine_type) {
        this.engine_type = engine_type;
    }

    public int getFuel_capacity() {
        return fuel_capacity;
    }

    public void setFuel_capacity(int fuel_capacity) {
        this.fuel_capacity = fuel_capacity;
    }

    public String getStation_ID() {
        return station_ID;
    }

    public void setStation_ID(String station_ID) {
        this.station_ID = station_ID;
    }
}
