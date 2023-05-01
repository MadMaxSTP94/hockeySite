package com.hockeyhigh.model.statistics;

import com.hockeyhigh.model.builders.statsBuilder.TeamStatsBuilder;
import com.hockeyhigh.model.enums.Season;
import com.hockeyhigh.model.player.Player;

import java.util.HashSet;

public class TeamStats {
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
    private Season season;
    private long team_id;
    private long game_id;
    private HashSet<Player> playerSet;

    public TeamStats() {
        playerSet = new HashSet<>();
    }

    public TeamStats(TeamStatsBuilder teamStatsBuilder) {
        this();
        this.id = teamStatsBuilder.getId();
        this.team_id = teamStatsBuilder.getTeam_id();
        this.game_id = teamStatsBuilder.getGame_id();
        this.wins = teamStatsBuilder.getWins();
        this.ties = teamStatsBuilder.getTies();
        this.loses = teamStatsBuilder.getLoses();
        this.ot_wins = teamStatsBuilder.getOt_wins();
        this.goals_for = teamStatsBuilder.getGoals_for();
        this.goals_against = teamStatsBuilder.getGoals_against();
        this.pp_attempts = teamStatsBuilder.getPp_attempts();
        this.pp_goals = teamStatsBuilder.getPp_goals();
        this.pk_attempts = teamStatsBuilder.getPk_attempts();
        this.pk_goals = teamStatsBuilder.getPk_goals();
        this.season = teamStatsBuilder.getSeason();

    }

    public long getId() { return id; }

    public long getGame_id() { return game_id; }

    public long getTeam_id() { return team_id; }

    public int getGames_played() { return wins + ties + loses; }

    public int getTotal_points() { return 2 * wins + ot_wins + ties; }

    public float getPoints_per_game() { return 1.0f * getTotal_points() / getGames_played(); }

    public int getGoals_difference() { return goals_for - goals_against; }

    public float getPP() { return 100.0f * pp_goals / pp_attempts; }

    public float getPK() { return 100.0f * pk_goals / pk_attempts; }

    public Season getSeason() { return season; }

    public int getWins() { return wins; }

    public void setWins(int wins) { this.wins = wins; }

    public int getTies() { return ties; }

    public void setTies(int ties) { this.ties = ties; }

    public int getLoses() { return loses; }

    public void setLoses(int loses) { this.loses = loses; }

    public int getOt_wins() { return ot_wins; }

    public void setOt_wins(int ot_wins) { this.ot_wins = ot_wins; }

    public int getGoals_for() { return goals_for; }

    public void setGoals_for(int goals_for) { this.goals_for = goals_for; }

    public int getGoals_against() { return goals_against; }

    public void setGoals_against(int goals_against) { this.goals_against = goals_against; }

    public int getPp_attempts() { return pp_attempts; }

    public void setPp_attempts(int pp_attempts) { this.pp_attempts = pp_attempts; }

    public int getPp_goals() { return pp_goals; }

    public void setPp_goals(int pp_goals) { this.pp_goals = pp_goals; }

    public int getPk_attempts() { return pk_attempts; }

    public void setPk_attempts(int pk_attempts) { this.pk_attempts = pk_attempts; }

    public int getPk_goals() { return pk_goals; }

    public void setPk_goals(int pk_goals) { this.pk_goals = pk_goals; }

    public void addPlayer(Player player) { if(player != null) playerSet.add(player); }

    public void removePlayer(Player player) {
        playerSet.remove(player);
    }

    public Player getPlayer(long player_id) {
        return playerSet.stream().filter(player -> player.getId() == player_id).findFirst().get();
    }
}
