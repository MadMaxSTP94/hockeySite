package com.hockeyhigh.dao.statsDAO;

import com.hockeyhigh.dao.DAO;
import com.hockeyhigh.model.builders.statsBuilder.TeamStatsBuilder;
import com.hockeyhigh.model.enums.Season;
import com.hockeyhigh.model.statistics.TeamStats;
import com.hockeyhigh.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeamStatsDAO implements DAO<TeamStats> {
    private static TeamStatsDAO instance;
    private static final String ALL_TEAM_STATS = "select * from team_stats;";
    private static final String GET_TEAM_STATS = "select * from team_stats where team_id =? ;";
    private static final String DELETE_TEAM_STATS = "delete from team_stats where id =?;";
    private static final String INSERT_TEAM_STATS = "insert into team_stats(team_id,game_id,wins,ties,loses,ot_wins,goals_for,goals_against," +
                                                    "pp_attempts,pp_goals,pk_attempts,pk_goals,season) values(?,?,?,?,?,?,?,?,?,?,?,?,?);";

    private static final String UPDATE_TEAM_STATS= "update team_stats set team_id = ?,game_id=?,wins = ?,ties=?," +
                                                   "loses= ?,ot_wins= ?,goals_for= ?,goals_against= ?,pp_attempts=?," +
                                                   "pp_goals=?,pk_attempts=?,pk_goals=?,season=? where id = ?";

    private static final String GET_TEAM_SEASON_STATS = "select * from team_stats where team_id=? and season=?;";
    private static final String GET_GAME_ID = "select game_id from team_stats where team_id=? order by game_id;";

    private TeamStatsDAO() {}

    public long getLastGameId(long team_id) {
        long game_id = -100;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_GAME_ID);
            statement.setInt(1,(int)team_id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) game_id = rs.getInt("game_id");
        }
        catch(Exception ex) {
            System.out.println("No value present! From teamStatsDAO get()");
        }
        return game_id;
    }
    @Override
    public TeamStats get(long id) {
        TeamStats teamStats = null;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_TEAM_STATS);
            statement.setInt(1,(int)id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) teamStats = new TeamStatsBuilder(rs).build();
        }
        catch(Exception ex) {
            System.out.println("No value present! From teamStatsDAO get()");
        }
        return teamStats;
    }

    @Override
    public List<TeamStats> getAll() {
        List<TeamStats> teamStatsList = null;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(ALL_TEAM_STATS);
            teamStatsList = new ArrayList<>();

            while(rs.next()) {
                TeamStats teamStats = new TeamStatsBuilder(rs).build();
                teamStatsList.add(teamStats);
            }
        }
        catch(Exception ex) {
            System.out.println("Didn't connect to database! From teamStatsDao getAll()");
        }
        return teamStatsList;
    }

    @Override
    public void save(TeamStats teamStats) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_TEAM_STATS);
            this.SetValuesToStatement(statement, teamStats);
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From skaterStatsDAO save()");
        }
    }

    @Override
    public void update(TeamStats teamStats) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_TEAM_STATS);
            int parameterIndex = this.SetValuesToStatement(statement, teamStats);
            statement.setInt(parameterIndex++,(int)teamStats.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From teamStatsDAO update()");
        }
    }

    @Override
    public void delete(TeamStats teamStats) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_TEAM_STATS);
            statement.setInt(1,(int)teamStats.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From teamStatsDAO delete()");
        }
    }

    public List<TeamStats> getSeasonStats(long id, Season season) {
        List<TeamStats> teamStats = new ArrayList<>();
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_TEAM_SEASON_STATS);
            preparedStatement.setInt(1,(int)id);
            preparedStatement.setString(2,season.toString());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                TeamStats teamStat = new TeamStatsBuilder(rs).build();
                teamStats.add(teamStat);
            }
        }
        catch(Exception ex) {
            System.out.println("Exception in getSeasonStats()");
        }
        return teamStats;
    }

    public static TeamStatsDAO getInstance() {
        if(instance == null) instance = new TeamStatsDAO();
        return instance;
    }

    private int SetValuesToStatement(PreparedStatement statement, TeamStats teamStats) {
        int parameterIndex = 1;
        try{
            statement.setInt(parameterIndex++,(int)teamStats.getTeam_id());
            statement.setInt(parameterIndex++,(int)teamStats.getGame_id());
            statement.setInt(parameterIndex++,teamStats.getWins());
            statement.setInt(parameterIndex++,teamStats.getTies());
            statement.setInt(parameterIndex++,teamStats.getLoses());
            statement.setInt(parameterIndex++,teamStats.getOt_wins());
            statement.setInt(parameterIndex++,teamStats.getGoals_for());
            statement.setInt(parameterIndex++,teamStats.getGoals_against());
            statement.setInt(parameterIndex++,teamStats.getPp_attempts());
            statement.setInt(parameterIndex++,teamStats.getPp_goals());
            statement.setInt(parameterIndex++,teamStats.getPk_attempts());
            statement.setInt(parameterIndex++,teamStats.getPk_goals());
            statement.setString(parameterIndex++,teamStats.getSeason().toString());

        }
        catch (Exception ex) {
            System.out.println("Failed to set values for statement");
        }
        return parameterIndex;

    }
}