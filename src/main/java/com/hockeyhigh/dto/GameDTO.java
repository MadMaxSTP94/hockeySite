package com.hockeyhigh.dto;

import com.hockeyhigh.dto.team.HighlightTeamStatsDTO;
import com.hockeyhigh.dto.team.ShortTeamGameDTO;
import com.hockeyhigh.model.enums.Status;

public class GameDTO {
    private String date;
    private String time;
    private int attendance;
    private Status status;
    private ShortTeamGameDTO home;
    private ShortTeamGameDTO guest;

    public GameDTO(GameDTOBuilder gameDTOBuilder) {
        this.date = gameDTOBuilder.getDate();
        this.time = gameDTOBuilder.getTime();
        this.attendance = gameDTOBuilder.getAttendance();
        this.status = gameDTOBuilder.getStatus();
        this.home = gameDTOBuilder.getHome();
        this.guest = gameDTOBuilder.getGuest();
    }

    public String getDate() { return date; }

    public String getTime() { return time; }

    public int getAttendance() { return attendance; }

    public Status getStatus() { return status; }

    public ShortTeamGameDTO getHome() { return home; }

    public ShortTeamGameDTO getGuest() { return guest; }
}
