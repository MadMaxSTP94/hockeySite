package com.hockeyhigh.model.media;

import com.hockeyhigh.model.enums.MediaType;

import java.sql.ResultSet;

public class Media {
    private long id;
    private String url;
    private String header;
    private MediaType type;
    private String poster_url;

    public Media(){}
    public Media(long id, String url, String header, MediaType type, String poster_url) {
        this.id = id;
        this.url = url;
        this.header = header;
        this.type = type;
        this.poster_url = poster_url;
    }
    public Media(ResultSet rs) {
        try{
            this.id = rs.getInt("id");
            this.url = rs.getString("url");
            this.header = rs.getString("header");
            this.type = MediaType.valueOf(rs.getString("type"));
            this.poster_url = rs.getString("poster_url");
        }
        catch(Exception ex) {
            System.out.println("Exception in rs media constructor");
        }
    }

    public long getId() { return id; }

    public String getUrl() { return url; }

    public String getHeader() { return header; }

    public MediaType getType() { return type; }

    public String getPoster_url() { return poster_url; }

    public void setId(long id) { this.id = id; }

    public void setUrl(String url) { this.url = url; }

    public void setHeader(String header) { this.header = header; }

    public void setType(MediaType type) { this.type = type; }

    public void setPoster_url(String poster_url) { this.poster_url = poster_url; }
}
