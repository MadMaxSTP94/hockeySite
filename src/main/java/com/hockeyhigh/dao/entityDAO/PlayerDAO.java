package com.hockeyhigh.dao.entityDAO;

import com.hockeyhigh.dao.DAO;
import com.hockeyhigh.model.builders.PlayerBuilder;
import com.hockeyhigh.model.player.Player;
import com.hockeyhigh.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO implements DAO<Player> {
    public static PlayerDAO playerDAO;
    private List<Player> players;

    private static final String ALL_PLAYER = "select * from player;";
    private static final String GET_PLAYER = "select * from player where id =";
    private static final String DELETE_PLAYER = "delete from player where id =";
    private static final String INSERT_PLAYER = "insert into player" +
                                                "(name ,place_of_birth ,photo_url,nationality," +
                                                "date_of_birth, shoots , position, age, height, weight)" +
                                                " values(?,?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_PLAYER = "update player set name = ?," +
                                                "place_of_birth = ?," +
                                                "photo_url = ?," +
                                                "nationality = ?," +
                                                "date_of_birth = ?," +
                                                "shoots = ?," +
                                                "position = ?," +
                                                "age = ?," +
                                                "height = ?," +
                                                "weight = ? where id = ?";

    private PlayerDAO() {}

    @Override
    public Player get(long id) {
        Player player = null;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_PLAYER + id + ";");
            if(rs.next()) player = new PlayerBuilder(rs).build();
            if(player != null) System.out.println(player + "From get method");
        }
        catch(Exception ex) {
            System.out.println("No value present! From playerDAO get()");
        }
        return player;
    }

    @Override
    public List<Player> getAll() {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(ALL_PLAYER);
            players = new ArrayList<>();

            while(rs.next()) {
                Player player = new PlayerBuilder(rs).build();
                players.add(player);
                System.out.println(player.toString());
            }
        }
        catch(Exception ex) {
            System.out.println("Didn't connect to database! From PlayerDao");
        }
        return players;
    }

    @Override
    public void save(Player player) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_PLAYER);
            this.SetValuesToStatement(statement, player);
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From playerDAO get()");
        }
        players.add(player);
    }

    @Override
    public void update(Player player) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_PLAYER);
            int parameterIndex = this.SetValuesToStatement(statement, player);
            statement.setInt(parameterIndex++,(int)player.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From playerDAO get()");
        }
    }

    @Override
    public void delete(Player player) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_PLAYER + player.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From playerDAO get()");
        }
        players.remove(player);
    }

    public static PlayerDAO getInstance() {
        if(playerDAO == null)
            playerDAO = new PlayerDAO();
        return playerDAO;
    }

    private int SetValuesToStatement(PreparedStatement statement, Player player) {
        int parameterIndex = 1;
        try{
            statement.setString(parameterIndex++,player.getName());
            statement.setString(parameterIndex++,player.getPlace_of_birth());
            statement.setString(parameterIndex++,player.getPhoto_url());
            statement.setString(parameterIndex++,player.getNationality().toString());
            statement.setString(parameterIndex++,player.getDate_of_birth());
            statement.setString(parameterIndex++,player.getShoots().toString());
            statement.setString(parameterIndex++,player.getPosition().toString());
            statement.setInt(parameterIndex++,player.getAge());
            statement.setInt(parameterIndex++,player.getHeight());
            statement.setInt(parameterIndex++,player.getWeight());
        }
        catch (Exception ex) {
            System.out.println("Failed to set values for statement");
        }
        return parameterIndex;

    }
}
