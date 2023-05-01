package com.hockeyhigh.test;

import com.hockeyhigh.model.entity.builders.statsBuilder.GoalieStatsBuilder;
import com.hockeyhigh.model.entity.builders.statsBuilder.SkaterStatsBuilder;
import com.hockeyhigh.model.entity.statistics.GoalieStats;
import com.hockeyhigh.model.entity.statistics.SkaterStats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test2 {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/hockeysite";
    private static final String DB_USER = "postgres";
    private static final String DB_PASS = "postgres";
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(DB_URL,DB_USER, DB_PASS);
        if(con != null)
            System.out.println("Connected");
        String insertQuery = "insert into test (name) values" + "('Bob');";
        Statement statement = con.createStatement();
        //statement.execute(insertQuery);
        //System.out.println("Values has been added");

        /*
        TeamBuilder teamBuilder = new TeamBuilder();
        teamBuilder.setInfoUrl("t1-info.txt");
        teamBuilder.setLogoUrl("logo-url.png");
        teamBuilder.setName("Boston Bruins");
        Team team = teamBuilder.build();

        teamBuilder.setInfoUrl("t1-info.txt");
        teamBuilder.setLogoUrl("logo-url.png");
        teamBuilder.setName("Tappara");
        teamBuilder.setId(5);
        Team team1 = teamBuilder.build();

        Player player1 = new Player(new PlayerBuilder()
                .setAge(34)
                .setHeight(186)
                .setId(1)
                .setName("TimThomas")
                .setNationality(Country.USA)
                .setPlaceOfBirth("MI,Alberta")
                .setDateOfBirth("12.03.1973")
                .setPhotoUrl("Photo.img")
                .setPosition(Position.GOALIE)
                .setShoots(Shoots.LEFT)
                .setWeight(98))
                ;
        System.out.println(player1.toString());
        /*String insertPlayer = "insert into player "(name,place_of_birth,photo_url,nationality,"
                            + "date_of_birth, shoots, position, age, height, weight)"
                            + "values" + "(" + player1.toString() + ");";
        statement.execute(insertPlayer);*/

        //String selectPlayer = "select * from player;";
       /* ResultSet rs = statement.executeQuery(selectPlayer);
        while(rs.next()) {
            System.out.println(rs.getRow());
        }*/
        //String insertTeam = "insert into team (name,logo_url,info_url) values(" + team1.toString() + ")";
        //statement.execute(insertTeam);
        //System.out.println("Team has been added");


        /*PlayerStatsBuilder playerStats = new PlayerStatsBuilder();
        playerStats.setPlayerId(player1.getId());
        playerStats.setSeason(Season._22_23);
        playerStats.setGamesPlayed(56);
        playerStats.setTotalIceTime("18:18");
        playerStats.setTeam(team1);*/

        /*"insert into player_stats(player_id,games_played,total_ice_time,season,team_id) values" +
                "(" + stats.toString() + ")";*/

        // PlayerStats playerStats1 = playerStats.build();


        //Создание статы игрока
        /*
        * String insertStat = "insert into skater_stats(player_stats_id,goals,assists,penalty_minutes,plus_minus," +
                "short_handed_goals,power_play_goals,game_winning_goals,shots_made,face_offs_count,face_offs_wins"
                +") values" +
                "(" + stats.toString() + ")";
        * */
        SkaterStatsBuilder skaterStatsBuilder = new SkaterStatsBuilder();
        skaterStatsBuilder.setPlayerStatsId(1);
        skaterStatsBuilder.setGoals(25);
        skaterStatsBuilder.setAssists(30);
        skaterStatsBuilder.setPenaltyMinutes(26);
        skaterStatsBuilder.setPlusMinus(5);
        skaterStatsBuilder.setShortHandedGoals(20);
        skaterStatsBuilder.setPowerPlayGoals(5);
        skaterStatsBuilder.setGameWinningGoals(3);
        skaterStatsBuilder.setShotsMade(70);
        skaterStatsBuilder.setFaceOffCount(20);
        skaterStatsBuilder.setFaceOffWins(15);

        SkaterStats stats = skaterStatsBuilder.build();

        String insertStat = "insert into skater_stats(player_stats_id,goals,assists,penalty_minutes,plus_minus," +
                "short_handed_goals,power_play_goals,game_winning_goals,shots_made,face_offs_count,face_offs_wins"
                +") values" +
                "(" + stats.toString() + ")";

       // statement.execute(insertStat);
        //System.out.println("Stats has been added");

        //Создание статы вратаря

        GoalieStatsBuilder goalieStatsBuilder = new GoalieStatsBuilder();
        goalieStatsBuilder.setPlayerStatsId(1);
        goalieStatsBuilder.setWins(10);
        goalieStatsBuilder.setLoses(5);
        goalieStatsBuilder.setShutouts(3);
        goalieStatsBuilder.setTies(2);
        goalieStatsBuilder.setSaves_count(500);
        goalieStatsBuilder.setGoals_against(20);
        goalieStatsBuilder.setShots_faced(520);

        GoalieStats goalieStats = goalieStatsBuilder.build();

        String insertGStat = "insert into goalie_stats(player_stats_id,wins,loses,shutouts,ties," +
                "saves_count,goals_against,shots_faced"
                +") values" +
                "(" + goalieStats.toString() + ")";

        statement.execute(insertStat);
        System.out.println("Stats g has been added");







    }
}
