package com.hockeyhigh.model.statistics;

import com.hockeyhigh.model.builders.statsBuilder.PlayerStatsBuilder;
import com.hockeyhigh.model.enums.Season;
import com.hockeyhigh.model.team.Team;
import com.hockeyhigh.util.DataUtil;
import com.hockeyhigh.util.StringUtil;

public class PlayerStats {
    protected long id;
    protected long player_id;
    protected long game_id;
    protected String total_ice_time;
    protected Season season;
    protected Team team;

    public PlayerStats(PlayerStatsBuilder playerStatsBuilder) {
        this.id = playerStatsBuilder.getId();
        this.player_id = playerStatsBuilder.getPlayer_id();
        this.game_id = playerStatsBuilder.getGame_id();
        this.total_ice_time = playerStatsBuilder.getTotal_ice_time();
        this.season = playerStatsBuilder.getSeason();
        this.team = playerStatsBuilder.getTeam();
    }

    public void setGame_id(long game_id) { this.game_id = game_id; }

    public void setTotal_ice_time(String total_ice_time) {
        this.total_ice_time = DataUtil.addTime(this.total_ice_time,total_ice_time);
    }

   /* public void setSeason(Season season) {
        this.season = season;
    }

    public void setTeam(Team team) { this.team = team; }

    public long getPlayer_id() {
        return player_id;
    }*/

    public long getGameId() { return game_id; }

    public String getTotal_ice_time() { return total_ice_time; }

    public Season getSeason() { return season; }

    public long getId() { return id; }

    public long getPlayer_id() { return player_id; }

    public Team getTeam() { return team; }

    public String toString() {
        return  player_id + "," + game_id + "," +
                StringUtil.convertToDb(total_ice_time) + "," + StringUtil.convertToDb(season.toString()) +
                "," + team.getId();
    }
}
