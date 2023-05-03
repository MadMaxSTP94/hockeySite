package com.hockeyhigh.model.statistics;

import com.hockeyhigh.model.builders.statsBuilder.PlayerStatsBuilder;
import com.hockeyhigh.model.builders.statsBuilder.SkaterStatsBuilder;

public class SkaterStats extends PlayerStats {
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

    public SkaterStats(PlayerStatsBuilder playerStatsBuilder) {
        super(playerStatsBuilder);
    }

    public SkaterStats(SkaterStatsBuilder skaterPlayerBuilder) {
        this((PlayerStatsBuilder) skaterPlayerBuilder);
        this.id = skaterPlayerBuilder.getId();
        this.player_stats_id = skaterPlayerBuilder.getPlayer_stats_id();
        this.goals = skaterPlayerBuilder.getGoals();
        this.assists = skaterPlayerBuilder.getAssists();
        this.penalty_minutes = skaterPlayerBuilder.getPenalty_minutes();
        this.plus_minus = skaterPlayerBuilder.getPlus_minus();
        this.short_handed_goals = skaterPlayerBuilder.getShort_handed_goals();
        this.power_play_goals = skaterPlayerBuilder.getPower_play_goals();
        this.game_winning_goals = skaterPlayerBuilder.getGame_winning_goals();
        this.shots_made = skaterPlayerBuilder.getShots_made();
        this.face_offs_count = skaterPlayerBuilder.getFace_offs_count();
        this.face_offs_wins = skaterPlayerBuilder.getFace_offs_wins();

    }

    public long getId() { return id; }

    public long getPlayer_stats_id() { return player_stats_id; }

    public float getIceTimePerGame() {
        return 1.0f*Integer.getInteger(total_ice_time.toString())/ getGameId();
    }

    public int getTotalPoints() {
        return goals + assists;
    }

    public float getFOWinsPercentage() {
        return 100.0f*face_offs_wins/face_offs_count;
    }

    public float getShotsEffectivity() {
        return 100.0f*goals/shots_made;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getPenalty_minutes() {
        return penalty_minutes;
    }

    public void setPenalty_minutes(int penalty_minutes) {
        this.penalty_minutes = penalty_minutes;
    }

    public int getPlus_minus() {
        return plus_minus;
    }

    public void setPlus_minus(int plus_minus) {
        this.plus_minus = plus_minus;
    }

    public int getShort_handed_goals() {
        return short_handed_goals;
    }

    public void setShort_handed_goals(int short_handed_goals) {
        this.short_handed_goals = short_handed_goals;
    }

    public int getPower_play_goals() {
        return power_play_goals;
    }

    public void setPower_play_goals(int power_play_goals) {
        this.power_play_goals = power_play_goals;
    }

    public int getGame_winning_goals() {
        return game_winning_goals;
    }

    public void setGame_winning_goals(int game_winning_goals) {
        this.game_winning_goals = game_winning_goals;
    }

    public int getShots_made() {
        return shots_made;
    }

    public void setShots_made(int shots_made) {
        this.shots_made = shots_made;
    }

    public int getFace_offs_count() {
        return face_offs_count;
    }

    public void setFace_offs_count(int face_offs_count) {
        this.face_offs_count = face_offs_count;
    }

    public int getFace_offs_wins() {
        return face_offs_wins;
    }

    public void setFace_offs_wins(int face_offs_wins) {
        this.face_offs_wins = face_offs_wins;
    }

    public void setPlayer_stats_id(long player_stats_id) {
        this.player_stats_id = player_stats_id;
    }

    public String toString() {
        return  player_stats_id + "," + goals + "," + assists + "," +
                penalty_minutes + "," + plus_minus + "," + short_handed_goals + "," +
                power_play_goals + "," + game_winning_goals + "," + shots_made + "," +
                face_offs_count + "," + face_offs_wins;
    }
}
