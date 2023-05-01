package com.hockeyhigh.dao.mediaDAO;

import com.hockeyhigh.dao.DAO;
import com.hockeyhigh.model.entity.media.Article;
import com.hockeyhigh.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO implements DAO<Article> {
    private static ArticleDAO instance;

    private static final String ALL_ARTICLE = "select * from article;";
    private static final String GET_ARTICLE = "select * from article where id =";
    private static final String DELETE_ARTICLE = "delete from article where id =";
    private static final String INSERT_ARTICLE = "insert into article(body, media_id) values(?,?);";
    private static final String UPDATE_ARTICLE = "update article set body = ?, media_id = ? where id = ?";

    private ArticleDAO() {}

    @Override
    public Article get(long id) {
        Article article = null;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ARTICLE + id + ";");
            if(rs.next()) article = new Article(rs);
            if(article != null) System.out.println(article + "From get method");
        }
        catch(Exception ex) {
            System.out.println("No value present! From articleDAO get()");
        }
        return article;
    }

    @Override
    public List<Article> getAll() {
        List<Article> articles = null;
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(ALL_ARTICLE);
            articles = new ArrayList<>();

            while(rs.next()) {
                Article article = new Article(rs);
                articles.add(article);
                System.out.println(article.toString());
            }
        }
        catch(Exception ex) {
            System.out.println("Didn't connect to database! From articleDao getAll()");
        }
        return articles;
    }

    @Override
    public void save(Article article) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_ARTICLE);
            this.SetValuesToStatement(statement, article);
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From teamDAO save()");
        }
    }

    @Override
    public void update(Article article) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_ARTICLE);
            int parameterIndex = this.SetValuesToStatement(statement, article);
            statement.setInt(parameterIndex++,(int)article.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From articleDAO update()");
        }
    }

    @Override
    public void delete(Article article) {
        try{
            Connection connection = DBUtil.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_ARTICLE + article.getId());
            statement.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println("No value present! From articleDAO delete()");
        }
    }

    public static ArticleDAO getInstance() {
        if(instance == null)
            instance = new ArticleDAO();
        return instance;
    }

    private int SetValuesToStatement(PreparedStatement statement, Article article) {
        int parameterIndex = 1;
        try{
            statement.setString(parameterIndex++,article.getBody());
            statement.setInt(parameterIndex++,(int)article.getMedia_id());
        }
        catch (Exception ex) {
            System.out.println("Failed to set values for statement");
        }
        return parameterIndex;

    }
}
