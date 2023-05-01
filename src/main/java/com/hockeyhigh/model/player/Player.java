package com.hockeyhigh.model.player;

import com.hockeyhigh.model.builders.PlayerBuilder;
import com.hockeyhigh.model.enums.Country;
import com.hockeyhigh.model.enums.Position;
import com.hockeyhigh.model.enums.Season;
import com.hockeyhigh.model.enums.Shoots;
import com.hockeyhigh.model.statistics.PlayerStats;
import java.util.HashSet;

import com.hockeyhigh.util.DataUtil;
import com.hockeyhigh.util.StringUtil;

public class Player {
    private long id;
    private String name;
    private String place_of_birth;
    private String photo_url;
    private Country nationality;
    private String date_of_birth;
    private int age;
    private int height;
    private int weight;
    private Shoots shoots;
    private Position position;
    private HashSet<PlayerStats> stats;

    public Player(PlayerBuilder playerBuilder) {
        this.id = playerBuilder.getId();
        this.name = playerBuilder.getName();
        this.photo_url = playerBuilder.getPhoto_url();
        this.place_of_birth = playerBuilder.getPlace_of_birth();
        this.nationality = playerBuilder.getNationality();
        this.height = playerBuilder.getHeight();
        this.weight = playerBuilder.getWeight();
        this.shoots = playerBuilder.getShoots();
        this.position = playerBuilder.getPosition();
        this.date_of_birth = playerBuilder.getDate_of_birth();
        this.age = DataUtil.getYears(date_of_birth);
        stats = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public Country getNationality() {
        return nationality;
    }

    public int getAge() { return age; }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public Shoots getShoots() {
        return shoots;
    }

    public long getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public String getDate_of_birth() { return date_of_birth; }

    public void addStat(PlayerStats stat) { this.stats.add(stat); }

    public void removeStat(PlayerStats stat) { this.stats.remove(stat); }

    public PlayerStats getStat(Season season) {
        return  stats.stream().filter(stat -> stat.getSeason() == season).findFirst().get();
    }

    public String toString()  {
        return  StringUtil.convertToDb(name) + "," + StringUtil.convertToDb(place_of_birth) + "," + StringUtil.convertToDb(photo_url) + "," +
                StringUtil.convertToDb(nationality.toString()) + "," + StringUtil.convertToDb(date_of_birth) + "," + StringUtil.convertToDb(shoots.toString()) + "," +
                StringUtil.convertToDb(position.toString()) + "," +  getAge() + "," + height + "," + weight;
    }
}
