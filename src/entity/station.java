package entity;

public class station {
    private String station_ID;
    private String route_ID;
    private String station_name;
    private int distance;
    private String duration;

    public station(String station_ID, String route_ID, String station_name, int distance, String duration) {
        this.station_ID = station_ID;
        this.route_ID = route_ID;
        this.station_name = station_name;
        this.distance = distance;
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRoute_ID() {
        return route_ID;
    }

    public void setRoute_ID(String route_ID) {
        this.route_ID = route_ID;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
