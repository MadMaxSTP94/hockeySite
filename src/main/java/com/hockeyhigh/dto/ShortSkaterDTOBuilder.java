package com.hockeyhigh.dto;

public class ShortSkaterDTOBuilder {
    private String photo_url;
    private String player_name;
    private String team_logo;
    private int goals;
    private int assists;

    public ShortSkaterDTOBuilder setPhotoUrl(String photo_url) {
        this.photo_url = photo_url;
        return this;
    }

    public ShortSkaterDTOBuilder setPlayerName(String player_name) {
        this.player_name = player_name;
        return this;
    }

    public ShortSkaterDTOBuilder setTeamLogo(String team_logo) {
        this.team_logo = team_logo;
        return this;
    }

    public ShortSkaterDTOBuilder setGoals(int goals) {
        this.goals = goals;
        return this;
    }

    public ShortSkaterDTOBuilder setAssists(int assists) {
        this.assists = assists;
        return this;
    }

    public String getPhoto_url() { return photo_url; }

    public String getPlayer_name() { return player_name; }

    public String getTeam_logo() { return team_logo; }

    public int getGoals() { return goals; }

    public int getAssists() { return assists; }

    public ShortSkaterDTO build() {
        return new ShortSkaterDTO(this);
    }
}
