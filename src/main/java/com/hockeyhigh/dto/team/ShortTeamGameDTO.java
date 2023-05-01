package com.hockeyhigh.dto.team;

public class ShortTeamGameDTO {
    private String team_logo_url;
    private String team_name;
    private int goals;

    public ShortTeamGameDTO(String team_name, String team_logo_url, int goals) {
        this.team_name = team_name;
        this.team_logo_url = team_logo_url;
        this.goals = goals;
    }

    public String getTeam_logo_url() {
        return team_logo_url;
    }

    public String getTeam_name() {
        return team_name;
    }

    public int getGoals() {
        return goals;
    }
}
