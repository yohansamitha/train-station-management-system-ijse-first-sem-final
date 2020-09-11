package entity;

import java.sql.Time;

public class route {
    private String route_ID ;
    private String route_rank;
    private String start;
    private String destination;
    private Time estimated_time;

    public route(String route_ID, String route_rank, String start, String destination, Time estimated_time) {
        this.route_ID = route_ID;
        this.route_rank = route_rank;
        this.start = start;
        this.destination = destination;
        this.estimated_time = estimated_time;
    }

    public String getRoute_ID() {
        return route_ID;
    }

    public void setRoute_ID(String route_ID) {
        this.route_ID = route_ID;
    }

    public String getRoute_rank() {
        return route_rank;
    }

    public void setRoute_rank(String route_rank) {
        this.route_rank = route_rank;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Time getEstimated_time() {
        return estimated_time;
    }

    public void setEstimated_time(Time estimated_time) {
        this.estimated_time = estimated_time;
    }
}
