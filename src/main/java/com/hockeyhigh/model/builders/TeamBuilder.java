package com.hockeyhigh.model.builders;
import com.hockeyhigh.model.team.Team;

import java.sql.ResultSet;

public class TeamBuilder {
    private long id;
    private String name;
    private String logo_url;
    private String info_url;

    public TeamBuilder(){}

    public TeamBuilder(ResultSet rs) {
        if(rs != null) {
            try {
                long id = rs.getInt("id");
                String name = rs.getString("name");
                String logo_url = rs.getString("logo_url");
                String info_url = rs.getString("info_url");
                this.setId(id).setName(name).setLogoUrl(logo_url).setInfoUrl(info_url);
            } catch (Exception ex) {
                System.out.println("RS exception from constructor");
            }
        }
    }

    public long getId() { return id; }

    public String getName() { return name; }

    public String getLogo_url() { return logo_url; }

    public String getInfo_url() { return info_url; }

    public TeamBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public TeamBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TeamBuilder setLogoUrl(String logo_url) {
        this.logo_url = logo_url;
        return this;
    }

    public TeamBuilder setInfoUrl(String info_url) {
        this.info_url = info_url;
        return this;
    }

    public Team build() { return new Team(this);}
}
