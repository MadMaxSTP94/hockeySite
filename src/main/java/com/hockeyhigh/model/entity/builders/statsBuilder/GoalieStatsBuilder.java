package com.hockeyhigh.model.entity.builders.statsBuilder;

import com.hockeyhigh.model.entity.statistics.GoalieStats;

import java.sql.ResultSet;

public class GoalieStatsBuilder extends PlayerStatsBuilder{
    private long id;
    private long player_stats_id;
    private int wins;
    private int loses;
    private int shutouts;
    private int ties;
    private int saves_count;
    private int goals_against;
    private int shots_faced;

    public GoalieStatsBuilder() {}
    public GoalieStatsBuilder(ResultSet rs) {
        try{
            this.id = rs.getInt("id");
            this.player_stats_id = rs.getInt("player_stats_id");
            this.wins = rs.getInt("wins");
            this.loses = rs.getInt("loses");
            this.ties = rs.getInt("ties");
            this.shutouts = rs.getInt("shutouts");
            this.saves_count = rs.getInt("saves_count");
            this.goals_against = rs.getInt("goals_against");
            this.shots_faced = rs.getInt("shots_faced");
        }
        catch(Exception ex) {
            System.out.println("Trouble in goalieStatsBuilder constructor");
        }
    }

    public GoalieStatsBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public GoalieStatsBuilder setPlayerStatsId(long player_stats_id) {
        this.player_stats_id = player_stats_id;
        return this;
    }

    public GoalieStatsBuilder setWins(int wins) {
        this.wins = wins;
        return this;
    }

    public GoalieStatsBuilder setLoses(int loses) {
        this.loses = loses;
        return this;
    }

    public GoalieStatsBuilder setShutouts(int shutouts) {
        this.shutouts = shutouts;
        return this;
    }

    public GoalieStatsBuilder setTies(int ties) {
        this.ties = ties;
        return this;
    }

    public GoalieStatsBuilder setSaves_count(int saves_count) {
        this.saves_count = saves_count;
        return this;
    }

    public GoalieStatsBuilder setGoals_against(int goals_against) {
        this.goals_against = goals_against;
        return this;
    }

    public GoalieStatsBuilder setShots_faced(int shots_faced) {
        this.shots_faced = shots_faced;
        return this;
    }

    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }

    public int getShutouts() {
        return shutouts;
    }

    public int getTies() { return ties; }

    public int getSaves_count() { return saves_count; }

    public int getGoals_against() { return goals_against; }

    public int getShots_faced() { return shots_faced; }

    @Override
    public long getId() { return id; }

    public long getPlayer_stats_id() { return player_stats_id; }

    @Override
    public GoalieStats build() {
        return new GoalieStats(this);
    }

}
