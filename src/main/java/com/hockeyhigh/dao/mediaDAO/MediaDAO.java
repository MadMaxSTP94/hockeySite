package com.hockeyhigh.dao.mediaDAO;

import com.hockeyhigh.dao.DAO;
import com.hockeyhigh.model.entity.media.Media;
import com.hockeyhigh.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MediaDAO implements DAO<Media> {
    private static MediaDAO instance;

    private static final String ALL_MEDIA = "select * from media;";
    private static final String GET_MEDIA = "select * from media where id =? ;";
    private static final String DELETE_MEDIA = "delete from media where id =?;";
    private static final String INSERT_MEDIA = "insert into media(url,header,type,poster_url) values(?,?,?,?);";
    private static final String UPDATE_MEDIA = "update media set url = ?,header = ?, type = ?,poster_url = ? where id = ?";

    private MediaDAO() {}

    @Override
    public Media get(long id) {
        Media media = null;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_MEDIA);
            statement.setInt(1,(int)id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()) media = new Media(rs);
            //if(media != null) System.out.println(media + "From get method");
        }
        catch(Exception ex) {
            System.out.println("No value present! From mediaDAO get()");
        }
        return media;
    }

    @Override
    public List<Media> getAll() {
        List<Media> medias = null;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(ALL_MEDIA);
            medias = new ArrayList<>();

            while(rs.next()) {
                Media media = new Media(rs);
                medias.add(media);
            }
        }
        catch(Exception ex) {
            System.out.println("Didn't connect to database! From mediaDao getAll()");
        }
        return medias;
    }

    @Override
    public void save(Media media) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_MEDIA);
            this.SetValuesToStatement(statement, media);
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From mediaDAO save()");
        }
    }

    @Override
    public void update(Media media) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_MEDIA);
            int parameterIndex = this.SetValuesToStatement(statement, media);
            statement.setInt(parameterIndex++,(int)media.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From articleDAO update()");
        }
    }

    @Override
    public void delete(Media media) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_MEDIA);
            statement.setInt(1,(int)media.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From mediaDAO delete()");
        }
    }

    public static MediaDAO getInstance() {
        if(instance == null) {
            instance = new MediaDAO();
        }
        return instance;
    }

    private int SetValuesToStatement(PreparedStatement statement, Media media) {
        int parameterIndex = 1;
        try{
            statement.setString(parameterIndex++,media.getUrl());
            statement.setString(parameterIndex++,media.getHeader());
            statement.setString(parameterIndex++,media.getType().toString());
            statement.setString(parameterIndex++,media.getPoster_url());
        }
        catch (Exception ex) {
            System.out.println("Failed to set values for statement");
        }
        return parameterIndex;

    }
}
