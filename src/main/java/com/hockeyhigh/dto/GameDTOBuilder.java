package com.hockeyhigh.dto;

import com.hockeyhigh.dto.team.HighlightTeamStatsDTO;
import com.hockeyhigh.dto.team.ShortTeamGameDTO;
import com.hockeyhigh.model.enums.Status;

public class GameDTOBuilder {
    private String date;
    private String time;
    private int attendance;
    private Status status;
    private ShortTeamGameDTO home;
    private ShortTeamGameDTO guest;

    public GameDTOBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public GameDTOBuilder setTime(String time) {
        this.time = time;
        return this;
    }

    public GameDTOBuilder setAttendance(int attendance) {
        this.attendance = attendance;
        return this;
    }

    public GameDTOBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public GameDTOBuilder setHome(ShortTeamGameDTO home) {
        this.home = home;
        return this;
    }

    public GameDTOBuilder setGuest(ShortTeamGameDTO guest) {
        this.guest = guest;
        return this;
    }

    public String getDate() { return date; }

    public String getTime() { return time; }

    public int getAttendance() { return attendance; }

    public Status getStatus() { return status; }

    public ShortTeamGameDTO getHome() { return home; }

    public ShortTeamGameDTO getGuest() { return guest; }

    public GameDTO build() {
        return new GameDTO(this);
    }
}
