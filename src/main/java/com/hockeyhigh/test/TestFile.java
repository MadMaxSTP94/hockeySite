package com.hockeyhigh.test;

import com.hockeyhigh.dao.entityDAO.GameDAO;
import com.hockeyhigh.model.entity.game.Game;

import java.io.IOException;
import java.util.List;

public class TestFile {
    public static void main(String[] args) throws IOException {
       // List<String> rows = FileUtil.readFile("C:\\Users\\annal\\Desktop\\test1.txt");
      /*  List<String> rows = FileUtil.readFile("t");
        for(String row : rows) {
            System.out.println(row);
        }*/
       // FileUtil.createFolder();
        /*
        Player player1 = new Player(new PlayerBuilder()
                .setAge(19)
                .setHeight(188)
                .setName("Danila Klimovich")
                .setNationality(Country.BLR)
                .setPlaceOfBirth("BLR,PINSK")
                .setDateOfBirth("12.03.2003")
                .setPhotoUrl("Photo.img")
                .setPosition(Position.FORWARD)
                .setShoots(Shoots.LEFT)
                .setWeight(85))
                ;
        PlayerDAO pd = PlayerDAO.getInstance();
        List<Player> players = pd.getAll();
       Player player = pd.get(1);
        if(player != null)
        System.out.println(player);

        pd.update(player);
        pd.save(player1);
        //pd.delete(players.stream().filter(player2 -> player2.getId() == 2).findFirst().get());

         */
        /*TeamDAO teamDAO = TeamDAO.getInstance();
        List<Team> teams = teamDAO.getAll();
        System.out.println();
        Team team = teamDAO.get(teams.get(0).getId());
        System.out.println(team.toString());
        Team team1 = new TeamBuilder().setName("Neman Grodno").setInfoUrl("neman.txt").setLogoUrl("neman.png").build();
        //teamDAO.save(team1);
        team.setLogo_url("boston.jpg");
        teamDAO.update(team);
        teamDAO.delete(teamDAO.get(7));*/

        /*ArticleDAO articleDAO = ArticleDAO.getInstance();
        Article article = articleDAO.get(1);
        System.out.println(article.toString());
        //List<Article> articles = articleDAO.getAll();
        System.out.println();*/

       /* MediaDAO mediaDAO = MediaDAO.getInstance();
        //Media media = mediaDAO.get(2);
        List<Media> mediaList = mediaDAO.getAll();
        //Media mediaForSave = new Media(-10,"savedurl","saveheader", MediaType.PHOTO,"saveposter");
        //mediaDAO.save(mediaForSave);
        //mediaDAO.delete(media);*/
        /*
        PlayerStatsDAO playerStatsDAO = PlayerStatsDAO.getInstance();
        PlayerStats playerStats = playerStatsDAO.get(1);
        List<PlayerStats> playerStatsList = playerStatsDAO.getAll();

        PlayerStats playerStats1 = playerStatsList.get(1);

        playerStats1.setGame_id(2);
        //playerStatsDAO.save(playerStats1);*/
        //playerStatsDAO.update(playerStats1);
        //playerStatsDAO.delete(playerStats1);

        /*GoalieStatsDAO goalieStatsDAO = GoalieStatsDAO.getInstance();
        GoalieStats goalieStats = goalieStatsDAO.get(1);
        List<GoalieStats> goalieStatsList = goalieStatsDAO.getAll();
        GoalieStats goalieStats1 = goalieStatsList.get(0);
        //goalieStatsDAO.save(goalieStats1);
        goalieStats1.setWins(196);
        goalieStatsDAO.delete(goalieStats1);*/
        /*SkaterStatsDAO skaterStatsDAO = SkaterStatsDAO.getInstance();
        SkaterStats skaterStats = skaterStatsDAO.get(4);
        List<SkaterStats> skaterStatsList = skaterStatsDAO.getAll();
        //skaterStatsDAO.delete(skaterStats);
        skaterStats.setGoals(88);
        skaterStatsDAO.update(skaterStats);

         */

        /*
        TeamStatsDAO teamStatsDAO = TeamStatsDAO.getInstance();
        //TeamStats stats = teamStatsDAO.get(4);
        List<TeamStats> teamStatsList = teamStatsDAO.getAll();
        stats.setWins(28);
        //teamStatsDAO.save(stats);
        //teamStatsDAO.delete(stats);
        System.out.println(stats.toString());*/

        GameDAO gameDAO = GameDAO.getInstance();
        Game game = gameDAO.get(2);
        List<Game> games = gameDAO.getAll();
        gameDAO.delete(game);
        System.out.println(game.toString());
    }
}
