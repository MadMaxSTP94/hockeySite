package com.hockeyhigh.model.entity.team;

import com.hockeyhigh.model.entity.builders.TeamBuilder;
import com.hockeyhigh.model.entity.enums.Season;
import com.hockeyhigh.model.entity.statistics.TeamStats;
import com.hockeyhigh.util.StringUtil;

import java.util.HashSet;

public class Team {
    private long id;
    private String name;
    private String logo_url;
    private String info_url;
    private HashSet<TeamStats> stats;

    public Team(TeamBuilder teamBuilder) {
        this.id = teamBuilder.getId();
        this.name = teamBuilder.getName();
        this.logo_url = teamBuilder.getLogo_url();
        this.info_url = teamBuilder.getInfo_url();
        stats = new HashSet<>();
    }

    public String getName() { return name; }

    public String getInfo_url() { return info_url; }

    public void setName(String name) { this.name = name; }

    public String getLogo_url() { return logo_url; }

    public void setLogo_url(String logo_url) { this.logo_url = logo_url; }

    public long getId() { return id; }

    public void addStat(TeamStats stat) { this.stats.add(stat); }

    public void removeStat(TeamStats stat) { this.stats.remove(stat); }

    public TeamStats getStat(Season season) {
        return stats.stream().filter(stat -> stat.getSeason() == season).findFirst().get();
    }

    public String toString() {
        return  StringUtil.convertToDb(name) + "," +
                StringUtil.convertToDb(logo_url) + "," +
                StringUtil.convertToDb(info_url) ;
    }
}
