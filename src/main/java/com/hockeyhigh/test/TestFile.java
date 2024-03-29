package com.hockeyhigh.test;

import com.hockeyhigh.dao.entityDAO.GameDAO;
import com.hockeyhigh.dao.entityDAO.PlayerDAO;
import com.hockeyhigh.dao.entityDAO.TeamDAO;
import com.hockeyhigh.dao.mediaDAO.ArticleDAO;
import com.hockeyhigh.dao.mediaDAO.MediaDAO;
import com.hockeyhigh.dao.statsDAO.PlayerStatsDAO;
import com.hockeyhigh.dao.statsDAO.SkaterStatsDAO;
import com.hockeyhigh.dao.statsDAO.TeamStatsDAO;
import com.hockeyhigh.dto.GameDTO;
import com.hockeyhigh.dto.ShortGoalieDTO;
import com.hockeyhigh.dto.ShortSkaterDTO;
import com.hockeyhigh.dto.team.HighlightTeamStatsDTO;
import com.hockeyhigh.dto.team.ShortTeamGameDTO;
import com.hockeyhigh.model.enums.MediaType;
import com.hockeyhigh.model.enums.Season;
import com.hockeyhigh.model.game.Game;
import com.hockeyhigh.model.media.Media;
import com.hockeyhigh.model.player.Player;
import com.hockeyhigh.model.statistics.GoalieStats;
import com.hockeyhigh.model.statistics.SkaterStats;
import com.hockeyhigh.model.statistics.TeamStats;
import com.hockeyhigh.model.team.Team;
import com.hockeyhigh.util.*;

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


        /*TeamDAO teamDAO = TeamDAO.getInstance();
        Team team1 = teamDAO.get(1);
        TeamStatsDAO teamStatsDAO = TeamStatsDAO.getInstance();
        TeamStats stats = teamStatsDAO.get(3);
        List<TeamStats> teamStatsList = teamStatsDAO.getAll();

        //stats.setWins(28);
        //teamStatsDAO.save(stats);
        //teamStatsDAO.delete(stats);
        TeamStats teamStats = TeamDTOUtil.getSumOfEachStat(teamStatsList);
        HighlightTeamStatsDTO highlightTeamStatsDTO = TeamDTOUtil.generateTeamDTO(team1, teamStats);*/
        //List<HighlightTeamStatsDTO> list = TeamDTOUtil.getTeamDTO(Season._20_21);
        //List<GameDTO> gameDTOS = GameDTOUtil.getSchedule();

        SkaterStatsDAO playerStatsDAO = SkaterStatsDAO.getInstance();
        SkaterStats skaterStats = playerStatsDAO.get(2);
        //skaterStats.setPlayer_stats_id(1);
        //playerStatsDAO.save(skaterStats);
       // List<SkaterStats> stats = PlayerDTOUtil.getSkaterStats(1,Season._22_23);
        //List<GoalieStats> gstats = PlayerDTOUtil.getGoalieStats(1, Season._22_23);

        //List<ShortSkaterDTO> list =  PlayerDTOUtil.getShortPlayerDTO(Season._22_23);
        /*MediaDAO mediaDAO = MediaDAO.getInstance();
        List<Media> media = mediaDAO.getAll(MediaType.PHOTO,4);

        List<Player> players = PlayerDAO.getInstance().getAll();
        String str = HTMLUtil.getPlayersRows(players);*/


        List<ShortGoalieDTO> goalieDTOS = PlayerDTOUtil.getShortGoalieDTO(Season._22_23);
        String top_GAA = HTMLUtil.getTopGAAGoalies(PlayerDTOUtil.sortByGAA(goalieDTOS));
        //req.setAttribute("top_GAA", top_GAA);

        String top_SAVES = HTMLUtil.getTopSVSGoalies(PlayerDTOUtil.sortBySaves(goalieDTOS));
        //req.setAttribute("top_SAVES", top_SAVES);

        String top_SO = HTMLUtil.getTopSOGoalies(PlayerDTOUtil.sortBySO(goalieDTOS));
        //req.setAttribute("top_SO", top_SO);
        List<String> strings = FileUtil.readFile("D:\\Курсач_Back\\src\\main\\webapp\\teamInfo\\ilves.txt");
        System.out.println("Well done!");

    }
}
