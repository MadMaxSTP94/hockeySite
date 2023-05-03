package com.hockeyhigh.dto;

import com.hockeyhigh.model.enums.Position;

public class ShortGoalieDTOBuilder {
    private String photo_url;
    private String player_name;
    private String team_logo;
    private Position position;
    private float GGA;
    private float SAVES;
    private int shutouts;

    public ShortGoalieDTOBuilder setPhotoUrl(String photo_url) {
        this.photo_url = photo_url;
        return this;
    }

    public ShortGoalieDTOBuilder setPlayerName(String player_name) {
        this.player_name = player_name;
        return this;
    }

    public ShortGoalieDTOBuilder setTeamLogo(String team_logo) {
        this.team_logo = team_logo;
        return this;
    }

    public ShortGoalieDTOBuilder setPosition(Position position) {
        this.position = position;
        return this;
    }

    public ShortGoalieDTOBuilder setGGA(float GGA) {
        this.GGA = GGA;
        return this;
    }

    public ShortGoalieDTOBuilder setSaves(float SAVES) {
        this.SAVES = SAVES;
        return this;
    }

    public ShortGoalieDTOBuilder setShutouts(int shutouts) {
        this.shutouts = shutouts;
        return this;
    }

    public String getPhoto_url() { return photo_url; }

    public String getPlayer_name() { return player_name; }

    public String getTeam_logo() { return team_logo; }

    public Position getPosition() { return position; }

    public float getGGA() { return GGA; }

    public float getSAVES() { return SAVES; }

    public int getShutouts() { return shutouts; }

    public ShortGoalieDTO build() {
        return new ShortGoalieDTO(this);
    }
}