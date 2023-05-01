package com.hockeyhigh.model.builders;

import com.hockeyhigh.model.player.Player;
import com.hockeyhigh.model.enums.Country;
import com.hockeyhigh.model.enums.Position;
import com.hockeyhigh.model.enums.Shoots;

import java.sql.ResultSet;

public class PlayerBuilder {
    protected long id;
    protected String photo_url;
    protected String name;
    protected String place_of_birth;
    protected String date_of_birth;
    protected Country nationality;
    protected int age;
    protected int height;
    protected int weight;
    protected Shoots shoots;
    protected Position position;

    public PlayerBuilder() {}
    public PlayerBuilder(ResultSet rs) {
        if(rs != null) {
            try {
                long id = rs.getInt("id");
                String name = rs.getString("name");
                String place_of_birth = rs.getString("place_of_birth");
                String photo_url = rs.getString("photo_url");
                Country country = Country.valueOf(rs.getString("nationality"));
                String date_of_birth = rs.getString("date_of_birth");
                int age = rs.getInt("age");
                int weight = rs.getInt("weight");
                int height = rs.getInt("height");
                Shoots shoots = Shoots.valueOf(rs.getString("shoots"));
                Position position = Position.valueOf(rs.getString("position"));

                    this.setId(id)
                        .setName(name)
                        .setPlaceOfBirth(place_of_birth)
                        .setPhotoUrl(photo_url)
                        .setNationality(country)
                        .setDateOfBirth(date_of_birth)
                        .setAge(age)
                        .setWeight(weight)
                        .setHeight(height)
                        .setShoots(shoots)
                        .setPosition(position).build();
            }
            catch (Exception ex) {
                System.out.println("RS exception from constructor");
            }
        }
    }

    public PlayerBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public PlayerBuilder setPhotoUrl(String photo_url) {
        this.photo_url = photo_url;
        return this;
    }

    public PlayerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PlayerBuilder setPlaceOfBirth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
        return this;
    }

    public PlayerBuilder setNationality(Country nationality) {
        this.nationality = nationality;
        return this;
    }

    public PlayerBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PlayerBuilder setHeight(int height) {
        this.height = height;
        return this;
    }

    public PlayerBuilder setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public PlayerBuilder setShoots(Shoots shoots) {
        this.shoots = shoots;
        return this;
    }

    public PlayerBuilder setPosition(Position position) {
        this.position = position;
        return this;
    }

    public PlayerBuilder setDateOfBirth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
        return this;
    }

    public long getId() { return id; }

    public String getPhoto_url() { return photo_url; }

    public String getName() { return name; }

    public String getPlace_of_birth() { return place_of_birth; }

    public Country getNationality() { return nationality; }

    public int getAge() { return age; }

    public int getHeight() { return height; }

    public int getWeight() { return weight; }

    public Shoots getShoots() { return shoots; }

    public Position getPosition() { return position; }

    public String getDate_of_birth() { return date_of_birth; }

    public Player build() {
        return new Player(this);
    }
}
