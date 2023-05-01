package com.hockeyhigh.dao.entityDAO;

import com.hockeyhigh.dao.DAO;
import com.hockeyhigh.model.builders.TeamBuilder;
import com.hockeyhigh.model.team.Team;
import com.hockeyhigh.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO implements DAO<Team> {
    public static TeamDAO instance;
    private List<Team> teams;

    private static final String ALL_TEAM = "select * from team;";
    private static final String GET_TEAM = "select * from team where id =";
    private static final String DELETE_TEAM = "delete from team where id =";
    private static final String INSERT_TEAM = "insert into team(name,logo_url ,info_url) values(?,?,?);";
    private static final String UPDATE_TEAM = "update team set name = ?,logo_url = ?, info_url = ? where id = ?";

    private TeamDAO() { }

    @Override
    public Team get(long id) {
        Team team = null;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_TEAM + id + ";");
            if(rs.next()) team = new TeamBuilder(rs).build();
            //if(team != null) System.out.println(team + "From get method");
        }
        catch(Exception ex) {
            System.out.println("No value present! From teamDAO get()");
        }
        return team;
    }

    @Override
    public List<Team> getAll() {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(ALL_TEAM);
            teams = new ArrayList<>();

            while(rs.next()) {
                Team team = new TeamBuilder(rs).build();
                teams.add(team);
                System.out.println(team.toString());
            }
        }
        catch(Exception ex) {
            System.out.println("Didn't connect to database! From playerDao getAll()");
        }
        return teams;
    }

    @Override
    public void save(Team team) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_TEAM);
            this.SetValuesToStatement(statement, team);
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From teamDAO save()");
        }
        teams.add(team);
    }

    @Override
    public void update(Team team) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_TEAM);
            int parameterIndex = this.SetValuesToStatement(statement, team);
            statement.setInt(parameterIndex++,(int)team.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From teamDAO update()");
        }
    }

    @Override
    public void delete(Team team) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_TEAM + team.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From teamDAO delete()");
        }
        teams.remove(team);
    }

    public static TeamDAO getInstance() {
        if(instance == null)
            instance = new TeamDAO();
        return instance;
    }

    private int SetValuesToStatement(PreparedStatement statement, Team team) {
        int parameterIndex = 1;
        try{
            statement.setString(parameterIndex++,team.getName());
            statement.setString(parameterIndex++,team.getLogo_url());
            statement.setString(parameterIndex++,team.getInfo_url());
        }
        catch (Exception ex) {
            System.out.println("Failed to set values for statement");
        }
        return parameterIndex;

    }
}
