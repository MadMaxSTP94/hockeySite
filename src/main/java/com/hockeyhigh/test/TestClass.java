package com.hockeyhigh.test;

import com.hockeyhigh.model.entity.builders.PlayerBuilder;
import com.hockeyhigh.model.entity.builders.statsBuilder.GoalieStatsBuilder;
import com.hockeyhigh.model.entity.builders.statsBuilder.PlayerStatsBuilder;
import com.hockeyhigh.model.entity.enums.Country;
import com.hockeyhigh.model.entity.enums.Position;
import com.hockeyhigh.model.entity.enums.Season;
import com.hockeyhigh.model.entity.enums.Shoots;
import com.hockeyhigh.model.entity.player.Player;
import com.hockeyhigh.model.entity.statistics.GoalieStats;
import com.hockeyhigh.model.entity.statistics.PlayerStats;
import com.hockeyhigh.util.DataUtil;

import java.text.ParseException;
import java.util.HashSet;

public class TestClass {
    public static void main(String[] args) throws ParseException {
        //System.out.println(DataUtil.getSeconds("177:22"));
        System.out.println(DataUtil.getTime("177:62"));

        Player player1 = new Player(new PlayerBuilder()
                                                       .setAge(34)
                                                       .setHeight(186)
                                                       .setId(0)
                                                       .setName("Tim Thomas")
                                                       .setNationality(Country.USA)
                                                       .setPlaceOfBirth("MI,Alberta")
                                                       .setPhotoUrl("Photo.img")
                                                       .setPosition(Position.GOALIE)
                                                       .setShoots(Shoots.LEFT)
                                                       .setWeight(98));

        System.out.println(player1.getAge()+  "\n" +
                           player1.getHeight() + " " + player1.getId() + " " + player1.getName() + "\n"+
                           player1.getNationality() + " "  + player1.getPlace_of_birth() + "\n" +
                           player1.getPhoto_url() + " " + player1.getPosition() + " " + player1.getShoots() + "\n"
                           + player1.getWeight());


        PlayerStats stats1 = new PlayerStats(new PlayerStatsBuilder().setPlayerId(player1.getId()).setGameId(56)
        .setSeason(Season._19_20).setTotalIceTime("177:56"));
        PlayerStats stats2 = new GoalieStats(new GoalieStatsBuilder());
        HashSet<PlayerStats> stats = new HashSet<>();
        stats.add(stats1);
        stats.add(stats2);

        PlayerStats statv = stats.stream().filter(stat -> stat.getSeason() == Season._19_20).findFirst().get();
        System.out.println(statv.getGameId());

        GoalieStats goalieStats = (GoalieStats) new GoalieStatsBuilder()
                .setGoals_against(56)
                .setLoses(25)
                .setWins(30)
                .setTies(10)
                .setShots_faced(5000)
                .setSaves_count(4900)
                .setShutouts(4)
                .setGameId(56)
                .setPlayerId(0)
                .setSeason(Season._22_23)
                .setTotalIceTime("1000:20")
                .build();

        System.out.println(goalieStats.getGoals_against_average());
        System.out.println(goalieStats.getSaves_percentage());
        System.out.println(goalieStats.getWins());
        goalieStats.setWins(-10);
        System.out.println(goalieStats.getWins());
        System.out.println(goalieStats.getTotal_ice_time());
        System.out.println(goalieStats.getGameId());

        System.out.println("Goalie stat  id " + goalieStats.getId());

        /*Goalie Builder*/
        GoalieStatsBuilder gBuilder = new GoalieStatsBuilder();
        GoalieStats gs = gBuilder.build();

       // GoalieStats gs1 = new GoalieStats();


        GoalieStats goalieStats1 = new GoalieStatsBuilder().setGoals_against(23).build();



    }
}
