package com.hockeyhigh.model.builders;

import com.hockeyhigh.model.enums.Season;
import com.hockeyhigh.model.enums.Status;
import com.hockeyhigh.model.game.Game;

import java.sql.ResultSet;

public class GameBuilder {
    private long id;
    private String date;
    private String time;
    private int attendance;
    private Status status;
    private Season season;

    public GameBuilder() {}
    public GameBuilder(ResultSet rs) {
        try{
            this.id = rs.getInt("id");
            this.date = rs.getString("date");
            this.time = rs.getString("time");
            this.attendance = rs.getInt("attendance");
            this.status = Status.valueOf(rs.getString("status"));
            this.season = Season.valueOf(rs.getString("season"));
        }
        catch(Exception ex) {
            System.out.println("Exception in GameBuilder constructor");
        }

    }

    public GameBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public GameBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public GameBuilder setTime(String time) {
        this.time = time;
        return this;
    }

    public GameBuilder setAttendance(int attendance) {
        this.attendance = attendance;
        return this;
    }

    public GameBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public GameBuilder setSeason(Season season) {
        this.season = season;
        return this;
    }

    public long getId() { return id; }

    public String getDate() { return date; }

    public String getTime() { return time; }

    public int getAttendance() { return attendance; }

    public Status getStatus() { return status; }

    public Season getSeason() { return season; }

    public Game build() { return new Game(this); }
}
