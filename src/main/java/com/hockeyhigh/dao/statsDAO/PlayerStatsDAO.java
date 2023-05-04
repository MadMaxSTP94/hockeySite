package com.hockeyhigh.dao.statsDAO;

import com.hockeyhigh.dao.DAO;
import com.hockeyhigh.model.builders.statsBuilder.PlayerStatsBuilder;
import com.hockeyhigh.model.statistics.PlayerStats;
import com.hockeyhigh.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayerStatsDAO implements DAO<PlayerStats> {
    private static PlayerStatsDAO instance;

    private static final String ALL_PLAYER_STATS = "select * from player_stats;";
    private static final String GET_PLAYER_STATS = "select * from player_stats where player_id =? ;";
    private static final String DELETE_PLAYER_STATS = "delete from player_stats where player_id =?;";
    private static final String INSERT_PLAYER_STATS = "insert into player_stats(player_id,game_id,total_ice_time,season,team_id) values(?,?,?,?,?);";
    private static final String UPDATE_PLAYER_STATS = "update player_stats set player_id = ?,game_id = ?, total_ice_time = ?,season = ?, team_id =? where id = ?";
    private static final String GET_TEAM_ID = "select team_id from player_stats where player_id =?;";

    private PlayerStatsDAO() { }

    public long getTeamId(long player_id) {
        long team_id = -100;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_TEAM_ID);
            statement.setInt(1,(int)player_id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) team_id = rs.getInt("team_id");
        }
        catch(Exception ex) {
            System.out.println("No value present! From playerStatsDAO get()");
        }
        return team_id;
    }

    @Override
    public PlayerStats get(long id) {
        PlayerStats playerStats = null;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_PLAYER_STATS);
            statement.setInt(1,(int)id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) playerStats = new PlayerStatsBuilder(rs).build();
        }
        catch(Exception ex) {
            System.out.println("No value present! From playerStatsDAO get()");
        }
        return playerStats;
    }

    @Override
    public List<PlayerStats> getAll() {
        List<PlayerStats> playerStatsList = null;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(ALL_PLAYER_STATS);
            playerStatsList = new ArrayList<>();

            while(rs.next()) {
                PlayerStats playerStats = new PlayerStatsBuilder(rs).build();
                playerStatsList.add(playerStats);
            }
        }
        catch(Exception ex) {
            System.out.println("Didn't connect to database! From playerStatsDao getAll()");
        }
        return playerStatsList;
    }

    @Override
    public void save(PlayerStats stats) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_PLAYER_STATS);
            this.SetValuesToStatement(statement, stats);
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From teamDAO save()");
        }
    }

    @Override
    public void update(PlayerStats stats) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_PLAYER_STATS);
            int parameterIndex = this.SetValuesToStatement(statement, stats);
            statement.setInt(parameterIndex++,(int)stats.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From articleDAO update()");
        }
    }

    @Override
    public void delete(PlayerStats stats) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_PLAYER_STATS);
            statement.setInt(1,(int)stats.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From playerDAO delete()");
        }
    }

    public static PlayerStatsDAO getInstance() {
        if(instance == null) {
            instance = new PlayerStatsDAO();
        }
        return instance;
    }

    private int SetValuesToStatement(PreparedStatement statement, PlayerStats playerStats) {
        int parameterIndex = 1;
        try{
            statement.setInt(parameterIndex++,(int)playerStats.getPlayer_id());
            statement.setInt(parameterIndex++,(int)playerStats.getGameId());
            statement.setString(parameterIndex++,playerStats.getTotal_ice_time());
            statement.setString(parameterIndex++,playerStats.getSeason().toString());
            statement.setInt(parameterIndex++,(int)playerStats.getTeam().getId());
        }
        catch (Exception ex) {
            System.out.println("Failed to set values for statement");
        }
        return parameterIndex;

    }

}
