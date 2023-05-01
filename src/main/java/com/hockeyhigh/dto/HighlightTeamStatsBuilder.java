package com.hockeyhigh.dto;

import com.hockeyhigh.dto.team.HighlightTeamStatsDTO;

public class HighlightTeamStatsBuilder {
    private String team_logo_url;
    private String team_name;
    private int games_played;
    private int wins;
    private int ties;
    private int loses;
    private int ot_wins;
    private int points;

    public HighlightTeamStatsBuilder setTeamLogoUrl(String team_logo_url) {
        this.team_logo_url = team_logo_url;
        return this;
    }

    public HighlightTeamStatsBuilder setTeamName(String team_name) {
        this.team_name = team_name;
        return this;
    }

    public HighlightTeamStatsBuilder setGamesPlayed(int games_played) {
        this.games_played = games_played;
        return this;
    }

    public HighlightTeamStatsBuilder setWins(int wins) {
        this.wins = wins;
        return this;
    }

    public HighlightTeamStatsBuilder setTies(int ties) {
        this.ties = ties;
        return this;
    }

    public HighlightTeamStatsBuilder setLoses(int loses) {
        this.loses = loses;
        return this;
    }

    public HighlightTeamStatsBuilder setOTwins(int ot_wins) {
        this.ot_wins = ot_wins;
        return this;
    }

    public HighlightTeamStatsBuilder setPoints(int points) {
        this.points = points;
        return this;
    }

    public String getTeam_logo_url() { return team_logo_url; }

    public String getTeam_name() { return team_name; }

    public int getGames_played() { return games_played; }

    public int getWins() { return wins; }

    public int getTies() { return ties; }

    public int getLoses() { return loses; }

    public int getOt_wins() { return ot_wins; }

    public int getPoints() { return points; }

    public HighlightTeamStatsDTO build() {
        return new HighlightTeamStatsDTO(this);
    }
}
