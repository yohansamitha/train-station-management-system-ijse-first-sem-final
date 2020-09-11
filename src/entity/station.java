package entity;

public class station {
    private String station_ID;
    private String station_name;
    private int duration;

    public station(String station_ID, String station_name, int duration) {
        this.station_ID = station_ID;
        this.station_name = station_name;
        this.duration = duration;
    }

    public String getStation_ID() {
        return station_ID;
    }

    public void setStation_ID(String station_ID) {
        this.station_ID = station_ID;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
