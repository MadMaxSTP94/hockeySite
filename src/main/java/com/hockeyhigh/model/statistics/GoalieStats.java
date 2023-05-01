package com.hockeyhigh.model.statistics;

import com.hockeyhigh.model.builders.statsBuilder.GoalieStatsBuilder;
import com.hockeyhigh.model.builders.statsBuilder.PlayerStatsBuilder;
import com.hockeyhigh.util.DataUtil;

public class GoalieStats extends PlayerStats{
    private long id;
    private long player_stats_id;
    private int wins;
    private int loses;
    private int shutouts;
    private int ties;
    private int saves_count;
    private int goals_against;
    private int shots_faced;

    public GoalieStats(PlayerStatsBuilder playerBuilder) {
        super(playerBuilder);
    }

    public GoalieStats(GoalieStatsBuilder goaliePlayerBuilder) {
        this((PlayerStatsBuilder) goaliePlayerBuilder);
        this.id = goaliePlayerBuilder.getId();
        this.player_stats_id = goaliePlayerBuilder.getPlayer_stats_id();
        this.wins = goaliePlayerBuilder.getWins();
        this.loses = goaliePlayerBuilder.getLoses();
        this.shutouts = goaliePlayerBuilder.getShutouts();
        this.ties = goaliePlayerBuilder.getTies();
        this.saves_count = goaliePlayerBuilder.getSaves_count();
        this.goals_against = goaliePlayerBuilder.getGoals_against();
        this.shots_faced = goaliePlayerBuilder.getShots_faced();

    }

    public float getGoals_against_average() {
        return 60.0f * goals_against / Integer.parseInt(DataUtil.getMinutes(total_ice_time)) ;
    }

    public float getSaves_percentage() { return 100.0f * saves_count / shots_faced; }

    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }

    public int getShutouts() {
        return shutouts;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public void setShutouts(int shutouts) {
        this.shutouts = shutouts;
    }

    public int getTies() { return ties; }

    public void setTies(int ties) { this.ties = ties; }

    public int getSaves_count() { return saves_count; }

    public void setSaves_count(int saves_count) { this.saves_count = saves_count; }

    public int getGoals_against() { return goals_against; }

    public void setGoals_against(int goals_against) { this.goals_against = goals_against; }

    public int getShots_faced() { return shots_faced; }

    public void setShots_faced(int shots_faced) { this.shots_faced = shots_faced; }

    @Override
    public long getId() { return id; }

    public long getPlayer_stats_id() { return player_stats_id; }

    public String toString() {
        return  player_stats_id + "," + wins + "," + loses + "," +
                shutouts + "," + ties + "," + saves_count + "," +
                goals_against + "," + shots_faced;
    }
}
