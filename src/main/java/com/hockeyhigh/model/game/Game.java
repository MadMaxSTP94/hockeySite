package com.hockeyhigh.model.game;

import com.hockeyhigh.model.builders.GameBuilder;
import com.hockeyhigh.model.enums.Season;
import com.hockeyhigh.model.enums.Status;

public class Game {
    private long id;
    private String date;
    private String time;
    private int attendance;
    private Status status;
    private Season season;

    public Game() {}
    public Game(GameBuilder gameBuilder) {
        this.id = gameBuilder.getId();
        this.date = gameBuilder.getDate();
        this.time = gameBuilder.getTime();
        this.attendance = gameBuilder.getAttendance();
        this.status = gameBuilder.getStatus();
        this.season = gameBuilder.getSeason();
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    public int getAttendance() { return attendance; }

    public void setAttendance(int attendance) { this.attendance = attendance; }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

    public Season getSeason() { return season; }

    public void setSeason(Season season) { this.season = season; }

    public String toString() {
        return id + "," + date + "," + time + "," + attendance + "," + status + "," + season;
    }
}
