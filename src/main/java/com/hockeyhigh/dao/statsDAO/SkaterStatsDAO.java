package com.hockeyhigh.dao.statsDAO;

import com.hockeyhigh.dao.DAO;
import com.hockeyhigh.model.entity.builders.statsBuilder.SkaterStatsBuilder;
import com.hockeyhigh.model.entity.statistics.SkaterStats;
import com.hockeyhigh.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkaterStatsDAO implements DAO<SkaterStats> {
    private static SkaterStatsDAO instance;

    private static final String ALL_SKATER_STATS = "select * from skater_stats;";
    private static final String GET_SKATER_STATS = "select * from skater_stats where id =? ;";
    private static final String DELETE_SKATER_STATS = "delete from skater_stats where id =?;";
    private static final String INSERT_SKATER_STATS = "insert into skater_stats(player_stats_id,goals,assists,penalty_minutes," +
                                                      "plus_minus,short_handed_goals,power_play_goals,game_winning_goals,shots_made," +
                                                      "face_offs_count,face_offs_wins) values(?,?,?,?,?,?,?,?,?,?,?);";

    private static final String UPDATE_SKATER_STATS= "update skater_stats set player_stats_id = ?,goals=?, assists = ?,penalty_minutes=?," +
                                                     "plus_minus = ?,short_handed_goals= ?,power_play_goals= ?,game_winning_goals= ?," +
                                                     "shots_made = ?,face_offs_count=?,face_offs_wins=? where id = ?";

    private SkaterStatsDAO() {}

    @Override
    public SkaterStats get(long id) {
        SkaterStats skaterStats = null;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_SKATER_STATS);
            statement.setInt(1,(int)id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) skaterStats = new SkaterStatsBuilder(rs).build();
        }
        catch(Exception ex) {
            System.out.println("No value present! From skaterStatsDAO get()");
        }
        return skaterStats;
    }

    @Override
    public List<SkaterStats> getAll() {
        List<SkaterStats> skaterStatsList = null;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(ALL_SKATER_STATS);
            skaterStatsList = new ArrayList<>();

            while(rs.next()) {
                SkaterStats playerStats = new SkaterStatsBuilder(rs).build();
                skaterStatsList.add(playerStats);
            }
        }
        catch(Exception ex) {
            System.out.println("Didn't connect to database! From skaterStatsDao getAll()");
        }
        return skaterStatsList;
    }

    @Override
    public void save(SkaterStats skaterStats) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_SKATER_STATS);
            this.SetValuesToStatement(statement, skaterStats);
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From skaterStatsDAO save()");
        }
    }

    @Override
    public void update(SkaterStats skaterStats) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_SKATER_STATS);
            int parameterIndex = this.SetValuesToStatement(statement, skaterStats);
            statement.setInt(parameterIndex++,(int)skaterStats.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From skaterStatsDAO update()");
        }
    }

    @Override
    public void delete(SkaterStats skaterStats) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_SKATER_STATS);
            statement.setInt(1,(int)skaterStats.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From skaterStatsDAO delete()");
        }
    }

    public static SkaterStatsDAO getInstance() {
        if(instance == null) {
            instance = new SkaterStatsDAO();
        }
        return instance;
    }

    private int SetValuesToStatement(PreparedStatement statement, SkaterStats skaterStats) {
        int parameterIndex = 1;
        try{ ;
            statement.setInt(parameterIndex++,(int)skaterStats.getPlayer_stats_id());
            statement.setInt(parameterIndex++,skaterStats.getGoals());
            statement.setInt(parameterIndex++,skaterStats.getAssists());
            statement.setInt(parameterIndex++,skaterStats.getPenalty_minutes());
            statement.setInt(parameterIndex++,skaterStats.getPlus_minus());
            statement.setInt(parameterIndex++,skaterStats.getShort_handed_goals());
            statement.setInt(parameterIndex++,skaterStats.getPower_play_goals());
            statement.setInt(parameterIndex++,skaterStats.getGame_winning_goals());
            statement.setInt(parameterIndex++,skaterStats.getShots_made());
            statement.setInt(parameterIndex++,skaterStats.getFace_offs_count());
            statement.setInt(parameterIndex++,skaterStats.getFace_offs_wins());
        }
        catch (Exception ex) {
            System.out.println("Failed to set values for statement");
        }
        return parameterIndex;

    }

}
