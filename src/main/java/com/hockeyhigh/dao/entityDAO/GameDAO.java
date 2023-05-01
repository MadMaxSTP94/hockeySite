package com.hockeyhigh.dao.entityDAO;

import com.hockeyhigh.dao.DAO;
import com.hockeyhigh.model.builders.GameBuilder;
import com.hockeyhigh.model.game.Game;
import com.hockeyhigh.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GameDAO implements DAO<Game> {
    private static GameDAO instance;
    private static final String ALL_GAME = "select * from game;";
    private static final String GET_GAME = "select * from game where id =? ;";
    private static final String DELETE_GAME = "delete from game where id =?;";
    private static final String INSERT_GAME = "insert into game(date,time,attendance,status,season) values(?,?,?,?,?);";
    private static final String UPDATE_GAME = "update game set date = ?,time = ?,attendance = ?,status = ?,season=? where id = ?";

    private GameDAO() {}

    public static GameDAO getInstance() {
        if(instance == null)
            instance = new GameDAO();
        return instance;
    }

    @Override
    public Game get(long id) {
        Game game = null;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_GAME);
            statement.setInt(1,(int)id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) game = new GameBuilder(rs).build();
        }
        catch(Exception ex) {
            System.out.println("No value present! From mediaDAO get()");
        }
        return game;
    }

    @Override
    public List<Game> getAll() {
        List<Game> games = null;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(ALL_GAME);
            games = new ArrayList<>();

            while(rs.next()) {
                Game game = new GameBuilder(rs).build();
                games.add(game);
            }
        }
        catch(Exception ex) {
            System.out.println("Didn't connect to database! From mediaDao getAll()");
        }
        return games;
    }

    @Override
    public void save(Game game) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_GAME);
            this.SetValuesToStatement(statement, game);
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From gameDAO save()");
        }
    }

    @Override
    public void update(Game game) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_GAME);
            int parameterIndex = this.SetValuesToStatement(statement, game);
            statement.setInt(parameterIndex++,(int)game.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From gameDAO update()");
        }
    }

    @Override
    public void delete(Game game) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_GAME);
            statement.setInt(1,(int)game.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From gameDAO delete()");
        }
    }

    private int SetValuesToStatement(PreparedStatement statement, Game game) {
        int parameterIndex = 1;
        try{
            statement.setString(parameterIndex++,game.getDate());
            statement.setString(parameterIndex++,game.getTime());
            statement.setInt(parameterIndex++,game.getAttendance());
            statement.setString(parameterIndex++,game.getStatus().toString());
            statement.setString(parameterIndex++,game.getSeason().toString());
        }
        catch (Exception ex) {
            System.out.println("Failed to set values for statement");
        }
        return parameterIndex;

    }
}
