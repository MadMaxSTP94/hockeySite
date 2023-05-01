package com.hockeyhigh.model.builders.statsBuilder;

import com.hockeyhigh.model.enums.Season;
import com.hockeyhigh.model.statistics.TeamStats;

import java.sql.ResultSet;

public class TeamStatsBuilder {
    private long id;
    private int wins;
    private int ties;
    private int loses;
    private int ot_wins;
    private int goals_for;
    private int goals_against;
    private int pp_attempts;
    private int pp_goals;
    private int pk_attempts;
    private int pk_goals;
    private long team_id;
    private long game_id;
    private Season season;

    public TeamStatsBuilder() {}

    public TeamStatsBuilder(ResultSet rs) {
        try{
            this.id = rs.getInt("id");
            this.team_id = rs.getInt("team_id");
            this.game_id = rs.getInt("game_id");
            this.wins = rs.getInt("wins");
            this.ties = rs.getInt("ties");
            this.loses = rs.getInt("loses");
            this.ot_wins = rs.getInt("ot_wins");
            this.goals_for = rs.getInt("goals_for");
            this.goals_against = rs.getInt("goals_against");
            this.pp_attempts = rs.getInt("pp_attempts");
            this.pp_goals = rs.getInt("pp_goals");
            this.pk_attempts = rs.getInt("pk_attempts");
            this.pk_goals = rs.getInt("pk_goals");
            this.season = Season.valueOf(rs.getString("season"));
        }
        catch (Exception ex) {
            System.err.println("Exception in teamStatsBuilderConstructor rs");
        }
    }

    public TeamStatsBuilder setGameId(long game_id) {
        this.game_id = game_id;
        return this;
    }

    public TeamStatsBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public TeamStatsBuilder setTeamId(long team_id) {
        this.team_id = team_id;
        return this;
    }

    public TeamStatsBuilder setWins(int wins) {
        this.wins = wins;
        return this;
    }

    public TeamStatsBuilder setTies(int ties) {
        this.ties = ties;
        return this;
    }

    public TeamStatsBuilder setLoses(int loses) {
        this.loses = loses;
        return this;
    }

    public TeamStatsBuilder setOTWins(int ot_wins) {
        this.ot_wins = ot_wins;
        return this;
    }

    public TeamStatsBuilder setGoalsFor(int goals_for) {
        this.goals_for = goals_for;
        return this;
    }

    public TeamStatsBuilder setGoalsAgainst(int goals_against) {
        this.goals_against = goals_against;
        return this;
    }

    public TeamStatsBuilder setPPAttempts(int pp_attempts) {
        this.pp_attempts = pp_attempts;
        return this;
    }

    public TeamStatsBuilder setPPGoals(int pp_goals) {
        this.pp_goals = pp_goals;
        return this;
    }

    public TeamStatsBuilder setPKAttempts(int pk_attempts) {
        this.pk_attempts = pk_attempts;
        return this;
    }

    public TeamStatsBuilder setPKGoals(int pk_goals) {
        this.pk_goals = pk_goals;
        return this;
    }

    public TeamStatsBuilder setSeason(Season season) {
        this.season = season;
        return this;
    }

    public long get() { return id; }

    public int getWins() { return wins; }

    public int getTies() { return ties; }

    public int getLoses() { return loses; }

    public int getOt_wins() { return ot_wins; }

    public int getGoals_for() { return goals_for; }

    public int getGoals_against() { return goals_against; }

    public int getPp_attempts() { return pp_attempts; }

    public int getPp_goals() { return pp_goals; }

    public int getPk_attempts() { return pk_attempts; }

    public int getPk_goals() { return pk_goals; }

    public Season getSeason() { return season; }

    public long getId() { return id; }

    public long getTeam_id() { return team_id; }

    public long getGame_id() { return game_id; }

    public TeamStats build() { return new TeamStats(this); }
}
