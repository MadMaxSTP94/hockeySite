package com.hockeyhigh.util;

import com.hockeyhigh.dto.GameDTO;
import com.hockeyhigh.dto.team.HighlightTeamStatsDTO;

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


}