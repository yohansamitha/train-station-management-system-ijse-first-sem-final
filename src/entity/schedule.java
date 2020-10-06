package entity;

import java.sql.Date;
import java.sql.Time;

public class schedule {
    private String schedule_ID;
    private String engine_number;
    private String primary_driver_ID;
    private String assistant_driver_ID;
    private String route_ID;
    private String date;
    private String time;

    public schedule(String schedule_ID, String engine_number, String primary_driver_ID, String assistant_driver_ID, String route_ID, String date, String time) {
        this.schedule_ID = schedule_ID;
        this.engine_number = engine_number;
        this.primary_driver_ID = primary_driver_ID;
        this.assistant_driver_ID = assistant_driver_ID;
        this.route_ID = route_ID;
        this.date = date;
        this.time = time;
    }

    public String getSchedule_ID() {
        return schedule_ID;
    }

    public void setSchedule_ID(String schedule_ID) {
        this.schedule_ID = schedule_ID;
    }

    public String getEngine_number() {
        return engine_number;
    }

    public void setEngine_number(String engine_number) {
        this.engine_number = engine_number;
    }

    public String getPrimary_driver_ID() {
        return primary_driver_ID;
    }

    public void setPrimary_driver_ID(String primary_driver_ID) {
        this.primary_driver_ID = primary_driver_ID;
    }

    public String getAssistant_driver_ID() {
        return assistant_driver_ID;
    }

    public void setAssistant_driver_ID(String assistant_driver_ID) {
        this.assistant_driver_ID = assistant_driver_ID;
    }

    public String getRoute_ID() {
        return route_ID;
    }

    public void setRoute_ID(String route_ID) {
        this.route_ID = route_ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
