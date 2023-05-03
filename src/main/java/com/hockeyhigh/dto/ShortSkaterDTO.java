package com.hockeyhigh.dto;

import com.hockeyhigh.model.enums.Position;

public class ShortSkaterDTO {
    private String photo_url;
    private String player_name;
    private String team_logo;
    private Position position;
    private int goals;
    private int assists;

    public ShortSkaterDTO(ShortSkaterDTOBuilder shortSkaterDTOBuilder) {
        this.photo_url = shortSkaterDTOBuilder.getPhoto_url();
        this.player_name = shortSkaterDTOBuilder.getPlayer_name();
        this.team_logo = shortSkaterDTOBuilder.getTeam_logo();
        this.goals = shortSkaterDTOBuilder.getGoals();
        this.assists = shortSkaterDTOBuilder.getAssists();
        this.position = shortSkaterDTOBuilder.getPosition();
    }

    public String getPhoto_url() { return photo_url; }

    public String getPlayer_name() { return player_name; }

    public int getGoals() { return goals; }

    public String getTeam_logo() { return team_logo; }

    public int getAssists() { return assists; }

    public Position getPosition() { return position; }
}
