package com.hockeyhigh.model.entity.builders.statsBuilder;

import com.hockeyhigh.model.entity.statistics.SkaterStats;

import java.sql.ResultSet;

public class SkaterStatsBuilder extends PlayerStatsBuilder{
    private long id;
    private long player_stats_id;
    private int goals;
    private int assists;
    private int penalty_minutes;
    private int plus_minus;
    private int short_handed_goals;
    private int power_play_goals;
    private int game_winning_goals;
    private int shots_made;
    private int face_offs_count;
    private int face_offs_wins;

    public SkaterStatsBuilder() {}

    public SkaterStatsBuilder(ResultSet rs) {
        try{
            this.id = rs.getInt("id");
            this.player_stats_id = rs.getInt("player_stats_id");
            this.goals = rs.getInt("goals");
            this.assists = rs.getInt("assists");
            this.penalty_minutes = rs.getInt("penalty_minutes");
            this.plus_minus = rs.getInt("plus_minus");
            this.short_handed_goals = rs.getInt("short_handed_goals");
            this.power_play_goals = rs.getInt("power_play_goals");
            this.game_winning_goals = rs.getInt("game_winning_goals");
            this.shots_made = rs.getInt("shots_made");
            this.face_offs_count = rs.getInt("face_offs_count");
            this.face_offs_wins = rs.getInt("face_offs_wins");
        }
        catch (Exception ex) {
            System.out.println("Error in skaterStatsBuilder");
        }
    }

    public SkaterStatsBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public SkaterStatsBuilder setPlayerStatsId(long player_stats_id) {
        this.player_stats_id = player_stats_id;
        return this;
    }

    public SkaterStatsBuilder setGoals(int goals) {
        this.goals=goals;
        return this;
    }

    public SkaterStatsBuilder setAssists(int assists) {
        this.assists = assists;
        return this;
    }

    public SkaterStatsBuilder setPenaltyMinutes(int penalty_minutes) {
        this.penalty_minutes=penalty_minutes;
        return this;
    }

    public SkaterStatsBuilder setPlusMinus(int plus_minus) {
        this.plus_minus = plus_minus;
        return this;
    }

    public SkaterStatsBuilder setShortHandedGoals(int short_handed_goals) {
        this.short_handed_goals = short_handed_goals;
        return this;
    }

    public SkaterStatsBuilder setPowerPlayGoals(int power_play_goals) {
        this.power_play_goals = power_play_goals;
        return this;
    }

    public SkaterStatsBuilder setGameWinningGoals(int game_winning_goals) {
        this.game_winning_goals = game_winning_goals;
        return this;
    }

    public SkaterStatsBuilder setShotsMade(int shots_made) {
        this.shots_made = shots_made;
        return this;
    }

    public SkaterStatsBuilder setFaceOffCount(int face_offs_count) {
        this.face_offs_count = face_offs_count;
        return this;
    }

    public SkaterStatsBuilder setFaceOffWins(int face_offs_wins) {
        this.face_offs_wins  = face_offs_wins;
        return this;
    }

    public int getGoals() { return goals; }

    public int getAssists() { return assists; }

    public int getPenalty_minutes() { return penalty_minutes; }

    public int getPlus_minus() { return plus_minus; }

    public int getShort_handed_goals() { return short_handed_goals; }

    public int getPower_play_goals() { return power_play_goals; }

    public int getGame_winning_goals() { return game_winning_goals; }

    public int getShots_made() { return shots_made; }

    public int getFace_offs_count() { return face_offs_count; }

    public int getFace_offs_wins() { return face_offs_wins; }

    public long getId() { return id; }

    public long getPlayer_stats_id() { return player_stats_id; }

    public SkaterStats build() {
        return new SkaterStats(this);
    }
}
