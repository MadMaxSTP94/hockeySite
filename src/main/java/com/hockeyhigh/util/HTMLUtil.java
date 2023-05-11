package com.hockeyhigh.util;

import com.hockeyhigh.dao.entityDAO.PlayerDAO;
import com.hockeyhigh.dao.entityDAO.TeamDAO;
import com.hockeyhigh.dao.mediaDAO.ArticleDAO;
import com.hockeyhigh.dao.statsDAO.PlayerStatsDAO;
import com.hockeyhigh.dao.statsDAO.TeamStatsDAO;
import com.hockeyhigh.dto.GameDTO;
import com.hockeyhigh.dto.ShortGoalieDTO;
import com.hockeyhigh.dto.ShortSkaterDTO;
import com.hockeyhigh.dto.team.HighlightTeamStatsDTO;
import com.hockeyhigh.model.builders.TeamBuilder;
import com.hockeyhigh.model.builders.statsBuilder.TeamStatsBuilder;
import com.hockeyhigh.model.enums.MediaType;
import com.hockeyhigh.model.enums.Position;
import com.hockeyhigh.model.enums.Season;
import com.hockeyhigh.model.media.Article;
import com.hockeyhigh.model.media.Media;
import com.hockeyhigh.model.player.Player;
import com.hockeyhigh.model.statistics.PlayerStats;
import com.hockeyhigh.model.statistics.TeamStats;
import com.hockeyhigh.model.team.Team;

import java.text.DecimalFormat;
import java.util.List;
import java.util.function.Function;

public class HTMLUtil {
    public static String getTable(List<HighlightTeamStatsDTO> list){
        StringBuilder builder = new StringBuilder("<div class=\"teams-position\">\n" +
                "\t\t\t\t<table class=\"teams\">\n" +
                "\t\t\t\t\t<tr class=\"stat\">\n" +
                "\t\t\t\t\t\t<td class=\"teams-table-column\"></td>\n" +
                "\t\t\t\t\t\t<td class=\"teams-table-column\">Team</td>\n" +
                "\t\t\t\t\t\t<td class=\"teams-table-column\">GP</td>\n" +
                "\t\t\t\t\t\t<td class=\"teams-table-column\">W</td>\n" +
                "\t\t\t\t\t\t<td class=\"teams-table-column\">T</td>\n" +
                "\t\t\t\t\t\t<td class=\"teams-table-column\">L</td>\n" +
                "\t\t\t\t\t\t<td class=\"teams-table-column\">OTW</td>\n" +
                "\t\t\t\t\t\t<td class=\"teams-table-column\">P</td>\n" +
                "\t\t\t\t\t</tr>");
        int counter = 1;
        for(HighlightTeamStatsDTO teamDTO : list) {
            if(counter % 2 != 0)
                builder.append("<tr class=\"stat\" id=\"nech\">");
            else
                builder.append("<tr class=\"stat\">");

            builder.append("<td class=\"teams-table-column\">"+ counter+"</td>\n" +
                    "\t\t\t\t\t\t<td class=\"teams-table-column\">\n" +
                    "\t\t\t\t\t\t\t<div>\n" +
                    "\t\t\t\t\t\t\t\t<img src=\""+teamDTO.getTeam_logo_url()+"\" alt=\"\" class=\"team-logo\">\n" +
                    "\t\t\t\t\t\t\t\t<p class=\"team-name\">"+teamDTO.getTeam_name()+"</p>\n" +
                    "\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t\t<td class=\"teams-table-column\">" + teamDTO.getGames_played() + "</td>\n" +
                    "\t\t\t\t\t\t<td class=\"teams-table-column\">" + teamDTO.getWins() + "</td>\n" +
                    "\t\t\t\t\t\t<td class=\"teams-table-column\">" + teamDTO.getTies() + "</td>\n" +
                    "\t\t\t\t\t\t<td class=\"teams-table-column\">" + teamDTO.getLoses() + "</td>\n" +
                    "\t\t\t\t\t\t<td class=\"teams-table-column\">" + teamDTO.getOt_wins() + "</td>\n" +
                    "\t\t\t\t\t\t<td class=\"teams-table-column\">" + teamDTO.getPoints() + "</td>");
            counter++;
        }
        builder.append("\t</tr>\n" +
                "\t\t\t\t</table>\n" +
                "\t\t\t</div>");

        return builder.toString();

    }

    public static String getSchedule(List<GameDTO> list) {
        StringBuilder builder = new StringBuilder();
        int counter = 1;
        for (GameDTO gameDTO : list) {
            if(counter == 1) builder.append("<div class=\"games-list\">");
            if(counter % 3 == 1 && counter > 1) builder.append("<div class=\"games-list hidden\" >");
            builder.append("<div class=\"game\">\n" +
                    "\t\t\t\t\t<div class=\"date\">" + gameDTO.getDate() + "</div>\n" +
                    "\t\t\t\t\t<div class=\"status\">" + gameDTO.getStatus() + "</div>\n" +
                    "\t\t\t\t\t<div class=\"game-score\">\n" +
                    "\t\t\t\t\t\t<div class=\"game-team\">\n" +
                    "\t\t\t\t\t\t\t<img src=\"" + gameDTO.getHome().getTeam_logo_url() + "\" alt=\"\" class=\"team-logo\">\n" +
                    "\t\t\t\t\t\t\t<p class=\"team-name\">" + gameDTO.getHome().getTeam_name() + "</p>\n" +
                    "\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t<div class=\"score\">\n" +
                    "\t\t\t\t\t\t\t<p class=\"total-score\">" + gameDTO.getHome().getGoals() + " - " + gameDTO.getGuest().getGoals() +"</p>\n" +
                    "\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t<div class=\"game-team\">\n" +
                    "\t\t\t\t\t\t\t<img src=\"" + gameDTO.getGuest().getTeam_logo_url() + "\" alt=\"\" class=\"team-logo\">\n" +
                    "\t\t\t\t\t\t\t<p class=\"team-name\">" + gameDTO.getGuest().getTeam_name() + "</p>\n" +
                    "\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t</div>\n" +
                    "\t\t\t\t</div>");

            counter++;

            if(counter % 4 == 0) {
                builder.append("</div>");
            }

        }
        if(list.size() % 3 != 0) builder.append("</div>");
        return builder.toString();
    }

    public static String getTopStats(List<ShortSkaterDTO> list) {
        StringBuilder builder = new StringBuilder();

        if(list.size() > 0){
            ShortSkaterDTO topPlayer = list.get(0);

            builder.append("<div class=\"top-player-container\" hidden >\n" +
                    "\t\t\t\t\t\t<div class=\"top-player-el\">\n" +
                    "\t\t\t\t\t\t\t<img src=\"" + topPlayer.getPhoto_url() + "\" alt=\"\" class=\"player-photo\">\n" +
                    "\t\t\t\t\t\t\t<div class=\"player-info\">\n" +
                    "\t\t\t\t\t\t\t\t<div class=\"player-info-el\">\n" +
                    "\t\t\t\t\t\t\t\t\t<img src=\"" + topPlayer.getTeam_logo() + "\" style =\"height:30px; width:30px;\" alt=\"\">\n" +
                    "\t\t\t\t\t\t\t\t\t<p class=\"player-name\">" + topPlayer.getPlayer_name() + "</p>\n" +
                    "\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t\t<div class=\"player-info-el\">\n" +
                    "\t\t\t\t\t\t\t\t\t<div class=\"player-name\">Points: " + topPlayer.getGoals() + " + " + topPlayer.getAssists() + " = " + topPlayer.getTotal() + "</div>\n" +
                    "\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t</div>");
            builder.append("<div class=\"top-player-list\">");
            for(ShortSkaterDTO skater : list) {
                builder.append("\t\t\t\t\t\t\t<div class=\"top-player-list-el\">\n" +
                        "\t\t\t\t\t\t\t\t<img src=\"" + skater.getTeam_logo() + "\" alt=\"\" class=\"team-logo\">\n" +
                        "\t\t\t\t\t\t\t\t<span class=\"player-name\">" + skater.getPlayer_name() + "</span>\n" +
                        "\t\t\t\t\t\t\t\t<span class=\"points\">" + skater.getGoals() + " + " + skater.getAssists() + "=" + skater.getTotal() + "</span>\n" +
                        "\t\t\t\t\t\t\t</div>\n"
                        );
            }
            builder.append("</div>");
        }

        builder.append("</div>");
        return builder.toString();
    }

    public static String getNewsTop(Media media) {
        return new StringBuilder("<a href=\"/media?id="+media.getId()+"\" class=\"anchor\">\n" +
                "\t\t\t\t<div class=\"news-div-top\" style=\"background-image: linear-gradient(180deg, transparent ,rgba(0,0,0,0.8)), url("+media.getUrl()+")\">\n" +
                "\t\t\t\t\t<p class=\"news-header\">NEWS</p>\n" +
                "\t\t\t\t\t<p class=\"news-highlight\">"+ media.getHeader() +"</p>\n" +
                "\t\t\t\t\t<p class=\"news-date\">"+ media.getCreation_date() +"</p>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</a>").toString();
    }

    public static String getNewsTopRights(Media media) {
        return new StringBuilder("<div class=\"news-div-top-right\" style=\"background-image: linear-gradient(180deg, transparent ,rgba(0,0,0,0.8)), url("+media.getUrl()+")\">\n" +
                "\t\t\t\t\t<a href=\"/media?id="+media.getId()+"\" class=\"anchor\">\n" +
                "\t\t\t\t\t\t<p class=\"news-header\">NEWS</p>\n" +
                "\t\t\t\t\t\t<p class=\"news-highlight\">"+media.getHeader()+"</p>\n" +
                "\t\t\t\t\t\t<p class=\"news-date\">"+media.getCreation_date()+"</p>\n" +
                "\t\t\t\t\t</a>\n" +
                "\t\t\t\t</div>").toString();
    }

    public static String getNewsTopOther(List<Media> media) {
        return new StringBuilder("<div class=\"news-other\">\n" +
                "\t\t\t\t\t<div class=\"news-div\" style=\"background-image: linear-gradient(180deg, transparent ,rgba(0,0,0,0.8)), url("+media.get(0).getUrl()+")\">\n" +
                "\t\t\t\t\t\t<a href=\"/media?id="+media.get(0).getId()+"\" class=\"anchor\">\n" +
                "\t\t\t\t\t\t\t<p class=\"news-header\">NEWS</p>\n" +
                "\t\t\t\t\t\t\t<p class=\"news-highlight\">"+media.get(0).getHeader()+"</p>\n" +
                "\t\t\t\t\t\t\t<p class=\"news-date\">"+media.get(0).getCreation_date()+"</p>\n" +
                "\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"news-div\" style=\"background-image: linear-gradient(180deg, transparent ,rgba(0,0,0,0.8)), url("+media.get(1).getUrl()+")\">\n" +
                "\t\t\t\t\t\t<a href=\"/media?id="+media.get(1).getId()+"\" class=\"anchor\">\n" +
                "\t\t\t\t\t\t\t<p class=\"news-header\">NEWS</p>\n" +
                "\t\t\t\t\t\t\t<p class=\"news-highlight\">"+media.get(1).getHeader()+"</p>\n" +
                "\t\t\t\t\t\t\t<p class=\"news-date\">"+media.get(1).getCreation_date()+"</p>\n" +
                "\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>").toString();
    }

    public static String getMediaRow(List<Media> media) {
        StringBuilder stringBuilder = new StringBuilder("<div class=\"videos-list\">");
        for(Media med : media) {
            stringBuilder.append("<div class=\"video\">\n" +
                    "\t\t\t\t\t\t<a href=\"/media?id="+med.getId() +"\" class=\"anchor\">\n");
            if(med.getType() == MediaType.VIDEO)
                stringBuilder.append("\t\t\t\t\t\t\t<img src=\""+med.getPoster_url()+"\" alt=\"\" class=\"video-img\">\n");
            else stringBuilder.append("\t\t\t\t\t\t\t<img src=\""+med.getUrl()+"\" alt=\"\" class=\"video-img\">\n");

            stringBuilder.append("\t\t\t\t\t\t\t<span class=\"video-description\">"+med.getHeader()+"</span>\n" +
                    "\t\t\t\t\t\t</a>\n" +
                    "\t\t\t\t\t\t<span  class=\"video-date\">"+med.getCreation_date()+"</span>\n" +
                    "\t\t\t\t\t</div>");
        }
        return stringBuilder.append("</div>").toString();
    }
    //добавить скрытие новостей
    public static String getMediaRows(List<Media> media) {
        StringBuilder stringBuilder = new StringBuilder("<div class=\"news-list\">");
        for(Media med : media) {
            stringBuilder.append("<div class=\"news\">\n" +
                    "\t\t\t\t\t\t<a href=\"/media?id="+med.getId()+"\" class=\"anchor\">\n" +
                    "\t\t\t\t\t\t\t<img src=\""+med.getUrl()+"\" alt=\"\" class=\"video-img\">\n" +
                    "\t\t\t\t\t\t\t<span class=\"news-description\">"+med.getHeader()+"</span>\n" +
                    "\t\t\t\t\t\t</a>\n" +
                    "\t\t\t\t\t\t<span  class=\"news-date\">"+med.getCreation_date()+"</span>\n" +
                    "\t\t\t\t\t</div>");
        }
        return stringBuilder.append("</div>").toString();
    }

    public static String getPlayersRows(List<Player> players) {
        StringBuilder builder = new StringBuilder();
        PlayerStatsDAO playerStatsDAO = PlayerStatsDAO.getInstance();
        PlayerDAO playerDAO = PlayerDAO.getInstance();
        TeamDAO teamDAO = TeamDAO.getInstance();
        long team_id;
        int counter = 1;
        Team team;
        for(Player player : players) {
            if(counter % 2 != 0) {
                builder.append("<tr class=\"stat\" id=\"nech\">\n");
            }
            if(counter % 2 == 0) {
                builder.append("<tr class=\"stat\">\n");
            }
            team_id = playerDAO.getTeamID(player.getId());
            team = teamDAO.get(team_id);


            if(team == null) {
                team = new TeamBuilder().setName("-").setLogoUrl("https://liiga.fi/static/media/logo_liiga_small.85530e4269a1040069b7.webp").build();
            }

            builder.append("\t\t\t\t\t<td class=\"teams-table-column\">"+player.getName()+"</td>\n" +
                    "\t\t\t\t\t<td class=\"teams-table-column\">\n" +
                    "\t\t\t\t\t\t<div>\n" +
                    "\t\t\t\t\t\t\t<img src=\""+ team.getLogo_url()+"\" alt=\"\" class=\"team-logo\">\n" +
                    "\t\t\t\t\t\t\t<p class=\"team-name\">"+ team.getName()+"</p>\n" +
                    "\t\t\t\t\t\t</div>\n" +
                    "\n" +
                    "\t\t\t\t\t</td>\n" +
                    "\t\t\t\t\t<td class=\"teams-table-column\">"+player.getPlace_of_birth()+"</td>\n" +
                    "\t\t\t\t\t<td class=\"teams-table-column\">"+player.getNationality()+"</td>\n" +
                    "\t\t\t\t\t<td class=\"teams-table-column\">"+player.getAge()+"</td>\n" +
                    "\t\t\t\t\t<td class=\"teams-table-column\">"+player.getHeight()+"</td>\n" +
                    "\t\t\t\t\t<td class=\"teams-table-column\">"+player.getWeight()+"</td>\n" +
                    "\t\t\t\t\t<td class=\"teams-table-column\">"+player.getShoots()+"</td>\n" +
                    "\n" +
                    "\t\t\t\t</tr>");
            counter++;
            team=null;

        }
        return builder.toString();
    }

    public static String getTeamsRows(List<Team> teams, Season season) {
        StringBuilder builder = new StringBuilder();
        TeamStatsDAO teamStatsDAO = TeamStatsDAO.getInstance();
        List<TeamStats> allTeamStats;
        TeamStats teamStats = null;
        int counter = 1;
        for(Team team : teams) {
            if(counter % 2 != 0) {
                builder.append("<tr class=\"stat\" id=\"nech\">\n");
            }
            if(counter % 2 == 0) {
                builder.append("<tr class=\"stat\">\n");
            }
            allTeamStats = teamStatsDAO.getAll(team.getId(),season);
            teamStats = TeamDTOUtil.getSumOfEachStat(allTeamStats);

            if(teamStats == null) {
                teamStats = new TeamStatsBuilder().build();
            }

            builder.append("<td class=\"teams-table-column\">"+ counter +"</td>\n" +
                    "                        <td class=\"teams-table-column\">\n" +
                    "                            <div>\n" +
                    "                                <img src=\""+team.getLogo_url()+"\" alt=\"\" class=\"team-logo\">\n" +
                    "                                <p class=\"team-name\">"+team.getName()+"</p>\n" +
                    "                            </div>\n" +
                    "                        </td>\n" +
                    "                        <td class=\"teams-table-column\">"+teamStats.getGames_played()+"</td>\n" +
                    "                        <td class=\"teams-table-column\">"+teamStats.getWins()+"</td>\n" +
                    "                        <td class=\"teams-table-column\">"+teamStats.getTies()+"</td>\n" +
                    "                        <td class=\"teams-table-column\">"+teamStats.getLoses()+"</td>\n" +
                    "                        <td class=\"teams-table-column\">"+teamStats.getOt_wins()+"</td>\n" +
                    "                        <td class=\"teams-table-column\">"+teamStats.getTotal_points()+"</td>\n" +
                    "\n" +
                    "                        <td class=\"teams-table-column\">"+teamStats.getPoints_per_game()+"</td>\n" +
                    "                        <td class=\"teams-table-column\">"+teamStats.getGoals_for()+"</td>\n" +
                    "                        <td class=\"teams-table-column\">"+teamStats.getGoals_against()+"</td>\n" +
                    "                        <td class=\"teams-table-column\">"+teamStats.getGoals_difference()+"</td>\n" +
                    "                        <td class=\"teams-table-column\">"+teamStats.getPP()+"</td>\n" +
                    "                        <td class=\"teams-table-column\">"+teamStats.getPK()+"</td>");
            counter++;
            teamStats = null;

        }
        return builder.toString();
    }

    public static String getTeamInfo(Team team) {
        StringBuilder builder = new StringBuilder();
        List<String> infoStr = FileUtil.readFile(team.getInfo_url());

        builder.append("<div class=\"team-info short\">\n");

        if(infoStr != null) {
            builder.append("<div class=\"text\">");
            for(String info : infoStr) {
                builder.append("<p class=\"team-name\">"+info+"</p>");
            }
            builder.append("</div>");
        }

        builder.append("\t\t<div class=\"logo\">\n" +
                "\t\t\t<img src=\""+team.getLogo_url()+"\" alt=\"\" class=\"team-info-logo\">\n" +
                "\t\t</div>\n");

        builder.append("\t</div>");


        return builder.toString();
    }

    public static String getMediaBlock(Media media) {
        StringBuilder builder = new StringBuilder();
        if(media.getType() == MediaType.PHOTO) {
            ArticleDAO articleDAO = ArticleDAO.getInstance();
            Article article = articleDAO.get(media.getId());
            try{
                StringBuilder stringBuilder = new StringBuilder();
                List<String> strings = FileUtil.readFile(article.getBody());
                for(String str : strings)
                    stringBuilder.append(str+"<br>");
                article.setBody(stringBuilder.toString());
            }
            catch (Exception ex){

            }
            builder.append("<div class=\"article-img\">\n" +
                    "\t\t\t\t<img src=\""+media.getUrl()+"\" alt=\"\" class=\"news-image\">\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<div class=\"article\">\n" +
                    "\t\t\t\t<div class=\"header-date\">\n" +
                    "\t\t\t\t\t<p class=\"news-header\">NEWS</p>\n" +
                    "\t\t\t\t\t<p class=\"date\">"+media.getCreation_date()+"</p>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t\t<div class=\"article\">\n" +
                    "\t\t\t\t\t<h1 class=\"articl-header\">"+media.getHeader()+"</h1>\n" +
                    "\t\t\t\t\t<blockquote>\n" + article.getBody() + "\t\t\t\t\t</blockquote>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t</div>");

        }
        if(media.getType() == MediaType.VIDEO) {
            builder.append("<div class=\"article-img\">\n" +
                    "\t\t\t\t<video src=\""+media.getUrl()+"\" poster=\""+media.getPoster_url()+"\" class=\"news-image\" controls>\n" +
                    "\t\t\t</div>\n" +
                    "\t\t\t<div class=\"article\">\n" +
                    "\t\t\t\t<div class=\"header-date\">\n" +
                    "\t\t\t\t\t<p class=\"video-header\">VIDEO</p>\n" +
                    "\t\t\t\t\t<p class=\"date\">"+media.getCreation_date()+"</p>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t\t<div class=\"article\">\n" +
                    "\t\t\t\t\t<h1 class=\"articl-header\">"+media.getHeader()+"</h1>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t</div>");
        }

        return builder.toString();
    }

    public static String getTopGAAGoalies(List<ShortGoalieDTO> list) {
        StringBuilder builder = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.##");
        if(list.size() > 0){
            ShortGoalieDTO topPlayer = list.get(0);
            builder.append("<div class=\"top-player-container\" hidden >\n" +
                    "\t\t\t\t\t\t<div class=\"top-player-el\">\n" +
                    "\t\t\t\t\t\t\t<img src=\"" + topPlayer.getPhoto_url() + "\" alt=\"\" class=\"player-photo\">\n" +
                    "\t\t\t\t\t\t\t<div class=\"player-info\">\n" +
                    "\t\t\t\t\t\t\t\t<div class=\"player-info-el\">\n" +
                    "\t\t\t\t\t\t\t\t\t<img src=\"" + topPlayer.getTeam_logo() + "\" style =\"height:30px; width:30px;\" alt=\"\">\n" +
                    "\t\t\t\t\t\t\t\t\t<p class=\"player-name\">" + topPlayer.getPlayer_name() + "</p>\n" +
                    "\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t\t<div class=\"player-info-el\">\n" +
                    "\t\t\t\t\t\t\t\t\t<div class=\"player-name\">GAA: " + df.format(topPlayer.getGGA()) + "</div>\n" +
                    "\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t</div>");
            builder.append("<div class=\"top-player-list\">");
            for(ShortGoalieDTO skater : list) {
                builder.append("\t\t\t\t\t\t\t<div class=\"top-player-list-el\">\n" +
                        "\t\t\t\t\t\t\t\t<img src=\"" + skater.getTeam_logo() + "\" alt=\"\" class=\"team-logo\">\n" +
                        "\t\t\t\t\t\t\t\t<span class=\"player-name\">" + skater.getPlayer_name() + "</span>\n" +
                        "\t\t\t\t\t\t\t\t<span class=\"points\">" + df.format(skater.getGGA()) + "</span>\n" +
                        "\t\t\t\t\t\t\t</div>\n"
                );
            }
            builder.append("</div>");
        }

        builder.append("</div>");
        return builder.toString();
    }

    public static String getTopSVSGoalies(List<ShortGoalieDTO> list) {
        StringBuilder builder = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.##");
        if(list.size() > 0){
            ShortGoalieDTO topPlayer = list.get(0);
            builder.append("<div class=\"top-player-container\" hidden >\n" +
                    "\t\t\t\t\t\t<div class=\"top-player-el\">\n" +
                    "\t\t\t\t\t\t\t<img src=\"" + topPlayer.getPhoto_url() + "\" alt=\"\" class=\"player-photo\">\n" +
                    "\t\t\t\t\t\t\t<div class=\"player-info\">\n" +
                    "\t\t\t\t\t\t\t\t<div class=\"player-info-el\">\n" +
                    "\t\t\t\t\t\t\t\t\t<img src=\"" + topPlayer.getTeam_logo() + "\" style =\"height:30px; width:30px;\" alt=\"\">\n" +
                    "\t\t\t\t\t\t\t\t\t<p class=\"player-name\">" + topPlayer.getPlayer_name() + "</p>\n" +
                    "\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t\t<div class=\"player-info-el\">\n" +
                    "\t\t\t\t\t\t\t\t\t<div class=\"player-name\">SAVES%: " + df.format(topPlayer.getSAVES()) + "</div>\n" +
                    "\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t</div>");
            builder.append("<div class=\"top-player-list\">");
            for(ShortGoalieDTO skater : list) {
                builder.append("\t\t\t\t\t\t\t<div class=\"top-player-list-el\">\n" +
                        "\t\t\t\t\t\t\t\t<img src=\"" + skater.getTeam_logo() + "\" alt=\"\" class=\"team-logo\">\n" +
                        "\t\t\t\t\t\t\t\t<span class=\"player-name\">" + skater.getPlayer_name() + "</span>\n" +
                        "\t\t\t\t\t\t\t\t<span class=\"points\">" + df.format(skater.getSAVES()) + "</span>\n" +
                        "\t\t\t\t\t\t\t</div>\n"
                );
            }
            builder.append("</div>");
        }

        builder.append("</div>");
        return builder.toString();
    }

    public static String getTopSOGoalies(List<ShortGoalieDTO> list) {

        StringBuilder builder = new StringBuilder();
        if(list.size() > 0){
            ShortGoalieDTO topPlayer = list.get(0);
            builder.append("<div class=\"top-player-container\" hidden >\n" +
                    "\t\t\t\t\t\t<div class=\"top-player-el\">\n" +
                    "\t\t\t\t\t\t\t<img src=\"" + topPlayer.getPhoto_url() + "\" alt=\"\" class=\"player-photo\">\n" +
                    "\t\t\t\t\t\t\t<div class=\"player-info\">\n" +
                    "\t\t\t\t\t\t\t\t<div class=\"player-info-el\">\n" +
                    "\t\t\t\t\t\t\t\t\t<img src=\"" + topPlayer.getTeam_logo() + "\" style =\"height:30px; width:30px;\" alt=\"\">\n" +
                    "\t\t\t\t\t\t\t\t\t<p class=\"player-name\">" + topPlayer.getPlayer_name() + "</p>\n" +
                    "\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t\t<div class=\"player-info-el\">\n" +
                    "\t\t\t\t\t\t\t\t\t<div class=\"player-name\">SHUTOUTS: " + topPlayer.getShutouts() + "</div>\n" +
                    "\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t</div>");
            builder.append("<div class=\"top-player-list\">");
            for(ShortGoalieDTO skater : list) {
                builder.append("\t\t\t\t\t\t\t<div class=\"top-player-list-el\">\n" +
                        "\t\t\t\t\t\t\t\t<img src=\"" + skater.getTeam_logo() + "\" alt=\"\" class=\"team-logo\">\n" +
                        "\t\t\t\t\t\t\t\t<span class=\"player-name\">" + skater.getPlayer_name() + "</span>\n" +
                        "\t\t\t\t\t\t\t\t<span class=\"points\">" + skater.getShutouts() + "</span>\n" +
                        "\t\t\t\t\t\t\t</div>\n"
                );
            }
            builder.append("</div>");
        }

        builder.append("</div>");
        return builder.toString();
    }
}
