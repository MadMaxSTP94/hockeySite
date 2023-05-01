package com.hockeyhigh.model.media;

import java.sql.ResultSet;

public class Article {
    private long id;
    private String body;
    private long media_id;

    public Article() {}

    public Article(long id, String body, long media_id) {
        this.id = id;
        this.media_id = media_id;
        this.body = body;
    }

    public Article(ResultSet rs) {
        try{
            this.id = rs.getInt("id");
            this.body = rs.getString("body");
            this.media_id = rs.getInt("media_id");
        }
        catch(Exception ex) {

        }
    }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public long getMedia_id() { return media_id; }

    public void setMedia_id(long media_id) { this.media_id = media_id; }

    public String toString() { return body + "; " + media_id; }
}
