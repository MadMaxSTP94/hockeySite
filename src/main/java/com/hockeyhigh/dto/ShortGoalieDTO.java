package com.hockeyhigh.dto;

import com.hockeyhigh.model.enums.Position;

public class ShortGoalieDTO {
    private String photo_url;
    private String player_name;
    private String team_logo;
    private Position position;
    private float GGA;
    private float SAVES;
    private int shutouts;

    public ShortGoalieDTO(ShortGoalieDTOBuilder shortGoalieDTOBuilder) {
        this.photo_url = shortGoalieDTOBuilder.getPhoto_url();
        this.player_name = shortGoalieDTOBuilder.getPlayer_name();
        this.team_logo = shortGoalieDTOBuilder.getTeam_logo();
        this.position = shortGoalieDTOBuilder.getPosition();
        this.GGA = shortGoalieDTOBuilder.getGGA();
        this.SAVES = shortGoalieDTOBuilder.getSAVES();
        this.shutouts = shortGoalieDTOBuilder.getShutouts();
    }

    public String getPhoto_url() { return photo_url; }

    public String getPlayer_name() { return player_name; }

    public String getTeam_logo() { return team_logo; }

    public Position getPosition() { return position; }

    public float getGGA() { return GGA; }

    public float getSAVES() { return SAVES; }

    public int getShutouts() { return shutouts; }

}
