package com.hockeyhigh.util;

import com.hockeyhigh.dao.entityDAO.TeamDAO;
import com.hockeyhigh.dao.statsDAO.PlayerStatsDAO;
import com.hockeyhigh.dto.GameDTO;
import com.hockeyhigh.dto.ShortSkaterDTO;
import com.hockeyhigh.dto.team.HighlightTeamStatsDTO;
import com.hockeyhigh.model.builders.TeamBuilder;
import com.hockeyhigh.model.enums.Position;
import com.hockeyhigh.model.media.Media;
import com.hockeyhigh.model.player.Player;
import com.hockeyhigh.model.statistics.PlayerStats;
import com.hockeyhigh.model.team.Team;

import java.util.List;

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

            if(gameDTO.equals(list.get(list.size() - 1))) builder.append("</div>");

            if(counter == 4) {
                builder.append("</div>");
                counter = 1;
            }

        }
        return builder.toString();
    }

    public static String getTopStats(List<ShortSkaterDTO> list) {
        StringBuilder builder = new StringBuilder();

        if(list.size() > 0){
            ShortSkaterDTO topPlayer = list.get(0);

            builder.append("<div class=\"top-player-container\">\n" +
                    "\t\t\t\t\t\t<div class=\"top-player-el\">\n" +
                    "\t\t\t\t\t\t\t<img src=\"" + topPlayer.getPhoto_url() + "\" alt=\"\" class=\"player-photo\">\n" +
                    "\t\t\t\t\t\t\t<div class=\"player-info\">\n" +
                    "\t\t\t\t\t\t\t\t<div class=\"player-info-el\">\n" +
                    "\t\t\t\t\t\t\t\t\t<img src=\"" + topPlayer.getTeam_logo() + "\" style =\"height:30px; width:40px;\" alt=\"\">\n" +
                    "\t\t\t\t\t\t\t\t\t<p class=\"player-name\">" + topPlayer.getPlayer_name() + "</p>\n" +
                    "\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t\t<div class=\"player-info-el\">\n" +
                    "\t\t\t\t\t\t\t\t\t<div class=\"player-name\">Points: " + topPlayer.getGoals() + " + " + topPlayer.getAssists() + "=" + (topPlayer.getGoals()+topPlayer.getAssists()) + "</div>\n" +
                    "\t\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t\t</div>\n" +
                    "\t\t\t\t\t\t</div>");


            for(ShortSkaterDTO skater : list) {
                builder.append("<div class=\"top-player-list\">\n" +
                        "\t\t\t\t\t\t\t<div class=\"top-player-list-el\">\n" +
                        "\t\t\t\t\t\t\t\t<img src=\"" + skater.getTeam_logo() + "\" alt=\"\" class=\"team-logo\">\n" +
                        "\t\t\t\t\t\t\t\t<span class=\"player-name\">" + skater.getPlayer_name() + "</span>\n" +
                        "\t\t\t\t\t\t\t\t<span class=\"points\">" + topPlayer.getGoals() + " + " + topPlayer.getAssists() + "=" + (topPlayer.getGoals()+topPlayer.getAssists()) + "</span>\n" +
                        "\t\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t\t</div>");
            }
        }

        builder.append("</div>");
        return builder.toString();
    }

    public static String getNewsTop(Media media) {
        return new StringBuilder("<a href=\"\" class=\"anchor\">\n" +
                "\t\t\t\t<div class=\"news-div-top\" style=\"background-image: linear-gradient(180deg, transparent ,rgba(0,0,0,0.8)), url("+media.getUrl()+")\">\n" +
                "\t\t\t\t\t<p class=\"news-header\">NEWS</p>\n" +
                "\t\t\t\t\t<p class=\"news-highlight\">"+ media.getHeader() +"</p>\n" +
                "\t\t\t\t\t<p class=\"news-date\">"+ media.getCreation_date() +"</p>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</a>").toString();
    }

    public static String getNewsTopRights(Media media) {
        return new StringBuilder("<div class=\"news-div-top-right\" style=\"background-image: linear-gradient(180deg, transparent ,rgba(0,0,0,0.8)), url("+media.getUrl()+")\">\n" +
                "\t\t\t\t\t<a href=\"\" class=\"anchor\">\n" +
                "\t\t\t\t\t\t<p class=\"news-header\">NEWS</p>\n" +
                "\t\t\t\t\t\t<p class=\"news-highlight\">"+media.getHeader()+"</p>\n" +
                "\t\t\t\t\t\t<p class=\"news-date\">"+media.getCreation_date()+"</p>\n" +
                "\t\t\t\t\t</a>\n" +
                "\t\t\t\t</div>").toString();
    }

    public static String getNewsTopOther(List<Media> media) {
        return new StringBuilder("<div class=\"news-other\">\n" +
                "\t\t\t\t\t<div class=\"news-div\" style=\"background-image: linear-gradient(180deg, transparent ,rgba(0,0,0,0.8)), url("+media.get(0).getUrl()+")\">\n" +
                "\t\t\t\t\t\t<a href=\"\" class=\"anchor\">\n" +
                "\t\t\t\t\t\t\t<p class=\"news-header\">NEWS</p>\n" +
                "\t\t\t\t\t\t\t<p class=\"news-highlight\">"+media.get(0).getHeader()+"</p>\n" +
                "\t\t\t\t\t\t\t<p class=\"news-date\">"+media.get(0).getCreation_date()+"</p>\n" +
                "\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"news-div\" style=\"background-image: linear-gradient(180deg, transparent ,rgba(0,0,0,0.8)), url("+media.get(1).getUrl()+")\">\n" +
                "\t\t\t\t\t\t<a href=\"\" class=\"anchor\">\n" +
                "\t\t\t\t\t\t\t<p class=\"news-header\">NEWS</p>\n" +
                "\t\t\t\t\t\t\t<p class=\"news-highlight\">"+media.get(1).getHeader()+"</p>\n" +
                "\t\t\t\t\t\t\t<p class=\"news-date\">"+media.get(1).getCreation_date()+"</p>\n" +
                "\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>").toString();
    }
    //добавить id
    public static String getMediaRow(List<Media> media) {
        StringBuilder stringBuilder = new StringBuilder("<div class=\"videos-list\">");
        for(Media med : media) {
            stringBuilder.append("<div class=\"video\">\n" +
                    "\t\t\t\t\t\t<a href=\"handler.java\" class=\"anchor\">\n" +
                    "\t\t\t\t\t\t\t<img src=\""+med.getUrl()+"\" alt=\"\" class=\"video-img\">\n" +
                    "\t\t\t\t\t\t\t<span class=\"video-description\">"+med.getHeader()+"</span>\n" +
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
                    "\t\t\t\t\t\t<a href=\"handler.java\" class=\"anchor\">\n" +
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
            team_id = playerStatsDAO.getTeamId(player.getId());
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
}
