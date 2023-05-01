package com.hockeyhigh.dao.statsDAO;

import com.hockeyhigh.dao.DAO;
import com.hockeyhigh.model.entity.builders.statsBuilder.GoalieStatsBuilder;
import com.hockeyhigh.model.entity.statistics.GoalieStats;
import com.hockeyhigh.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GoalieStatsDAO implements DAO<GoalieStats> {
    private static GoalieStatsDAO instance;

    private static final String ALL_GOALIE_STATS = "select * from goalie_stats;";
    private static final String GET_GOALIE_STATS = "select * from goalie_stats where id =? ;";
    private static final String DELETE_GOALIE_STATS = "delete from goalie_stats where id =?;";
    private static final String INSERT_GOALIE_STATS = "insert into goalie_stats(player_stats_id,wins,loses,shutouts,ties," +
                                                      "saves_count,goals_against,shots_faced) values(?,?,?,?,?,?,?,?);";
    private static final String UPDATE_GOALIE_STATS= "update goalie_stats set player_stats_id = ?,wins = ?, loses = ?, shutouts=?," +
                                                     "ties = ?, saves_count = ?,goals_against= ?,shots_faced= ? where id = ?";

    private GoalieStatsDAO() {}

    @Override
    public GoalieStats get(long id) {
        GoalieStats goalieStats = null;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_GOALIE_STATS);
            statement.setInt(1,(int)id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) goalieStats = new GoalieStatsBuilder(rs).build();
        }
        catch(Exception ex) {
            System.out.println("No value present! From playerStatsDAO get()");
        }
        return goalieStats;
    }

    @Override
    public List<GoalieStats> getAll() {
        List<GoalieStats> playerStatsList = null;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(ALL_GOALIE_STATS);
            playerStatsList = new ArrayList<>();

            while(rs.next()) {
                GoalieStats playerStats = new GoalieStatsBuilder(rs).build();
                playerStatsList.add(playerStats);
            }
        }
        catch(Exception ex) {
            System.out.println("Didn't connect to database! From goalieStatsDao getAll()");
        }
        return playerStatsList;
    }

    @Override
    public void save(GoalieStats goalieStats) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_GOALIE_STATS);
            this.SetValuesToStatement(statement, goalieStats);
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From teamDAO save()");
        }
    }

    @Override
    public void update(GoalieStats goalieStats) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_GOALIE_STATS);
            int parameterIndex = this.SetValuesToStatement(statement, goalieStats);
            statement.setInt(parameterIndex++,(int)goalieStats.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From goalieStatsDAO update()");
        }
    }

    @Override
    public void delete(GoalieStats goalieStats) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_GOALIE_STATS);
            statement.setInt(1,(int)goalieStats.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From goalieStatsDAO delete()");
        }
    }

    public static GoalieStatsDAO getInstance() {
        if(instance == null) {
            instance = new GoalieStatsDAO();
        }
        return instance;
    }

    private int SetValuesToStatement(PreparedStatement statement, GoalieStats goalieStats) {
        int parameterIndex = 1;
        try{
            statement.setInt(parameterIndex++,(int)goalieStats.getPlayer_stats_id());
            statement.setInt(parameterIndex++,goalieStats.getWins());
            statement.setInt(parameterIndex++,goalieStats.getLoses());
            statement.setInt(parameterIndex++,goalieStats.getShutouts());
            statement.setInt(parameterIndex++,goalieStats.getTies());
            statement.setInt(parameterIndex++,goalieStats.getSaves_count());
            statement.setInt(parameterIndex++,goalieStats.getGoals_against());
            statement.setInt(parameterIndex++,goalieStats.getShots_faced());
        }
        catch (Exception ex) {
            System.out.println("Failed to set values for statement");
        }
        return parameterIndex;

    }
}
