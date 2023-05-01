package com.hockeyhigh.dto.team;

import com.hockeyhigh.dto.HighlightTeamStatsBuilder;

public class HighlightTeamStatsDTO {
    private String team_logo_url;
    private String team_name;
    private int games_played;
    private int wins;
    private int ties;
    private int loses;
    private int ot_wins;
    private int points;

    public HighlightTeamStatsDTO(HighlightTeamStatsBuilder highlightTeamStatsBuilder) {
        this.team_logo_url = highlightTeamStatsBuilder.getTeam_logo_url();
        this.team_name = highlightTeamStatsBuilder.getTeam_name();
        this.games_played = highlightTeamStatsBuilder.getGames_played();
        this.wins = highlightTeamStatsBuilder.getWins();
        this.ties = highlightTeamStatsBuilder.getTies();
        this.loses = highlightTeamStatsBuilder.getLoses();
        this.ot_wins = highlightTeamStatsBuilder.getOt_wins();
        this.points = highlightTeamStatsBuilder.getPoints();
    }

    public String getTeam_logo_url() { return team_logo_url; }

    public String getTeam_name() { return team_name; }

    public int getGames_played() { return games_played; }

    public int getWins() { return wins; }

    public int getTies() { return ties; }

    public int getLoses() { return loses; }

    public int getOt_wins() { return ot_wins; }

    public int getPoints() { return points; }
}
