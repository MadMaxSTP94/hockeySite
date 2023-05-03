package com.hockeyhigh.util;

import com.hockeyhigh.dto.GameDTO;
import com.hockeyhigh.dto.ShortSkaterDTO;
import com.hockeyhigh.dto.team.HighlightTeamStatsDTO;
import com.hockeyhigh.model.enums.Position;
import com.hockeyhigh.model.statistics.PlayerStats;

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
}

/*
<div class="top-player-container">
						<div class="top-player-el">
							<img src="../images/joly.png" alt="" class="player-photo">
							<div class="player-info">
								<div class="player-info-el">
									<img src="../images/vaasan-sport-sm.png" style ="height:30px; width:40px;" alt="">
									<p class="player-name">Michael Joly</p>
								</div>
								<div class="player-info-el">
									<div class="player-name">Points: 3+9=12</div>
								</div>
							</div>
						</div>

						<div class="top-player-list">
							<div class="top-player-list-el">
								<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
								<span class="player-name">Michael Joly</span>
								<span class="points">5+4=9</span>
							</div>
						</div>
					</div>
* */