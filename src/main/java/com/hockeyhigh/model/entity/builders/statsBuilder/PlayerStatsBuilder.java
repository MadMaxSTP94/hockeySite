package com.hockeyhigh.model.entity.builders.statsBuilder;

import com.hockeyhigh.dao.entityDAO.TeamDAO;
import com.hockeyhigh.model.entity.enums.Season;
import com.hockeyhigh.model.entity.statistics.PlayerStats;
import com.hockeyhigh.model.entity.team.Team;

import java.sql.ResultSet;

public class PlayerStatsBuilder {
    protected long player_id;
    protected long id;
    protected int game_id;
    protected String total_ice_time;
    protected Season season;
    protected Team team;


    public PlayerStatsBuilder() {}
    public PlayerStatsBuilder(ResultSet rs) {
        try{
            this.id = rs.getInt("id");
            this.game_id = rs.getInt("game_id");
            this.player_id = rs.getInt("player_id");
            this.total_ice_time = rs.getString("total_ice_time");
            this.season = Season.valueOf(rs.getString("season"));
            this.team = TeamDAO.getInstance().get(rs.getInt("team_id"));
        }
        catch(Exception ex) {
            System.out.println("Exception in playerstatsbuilder constructor");
        }

    }

    public PlayerStatsBuilder setPlayerId(long player_id) {
        this.player_id = player_id;
        return this;
    }

    public PlayerStatsBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public PlayerStatsBuilder setGameId(int game_id) {
        this.game_id = game_id;
        return this;
    }

    public PlayerStatsBuilder setTotalIceTime(String total_ice_time) {
        this.total_ice_time = total_ice_time;
        return this;
    }

    public PlayerStatsBuilder setSeason(Season season) {
        this.season = season;
        return this;
    }

    public PlayerStatsBuilder setTeam(Team team) {
        this.team = team;
        return this;
    }

    public long getPlayer_id() {
        return player_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public String getTotal_ice_time() {
        return total_ice_time;
    }

    public Season getSeason() {
        return season;
    }

    public Team getTeam() { return team; }

    public long getId() { return id; }

    public PlayerStats build() {
        return new PlayerStats(this);
    }
}
