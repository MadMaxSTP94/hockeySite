package com.hockeyhigh.util;

import com.hockeyhigh.dto.team.HighlightTeamStatsDTO;

import java.util.List;

public class HTMLUtil {
    public static String getTable(List< HighlightTeamStatsDTO > list){
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
}

/*<div class="teams-position">
				<table class="teams">
					<tr class="stat">
						<td class="teams-table-column"></td>
						<td class="teams-table-column">Team</td>
						<td class="teams-table-column">GP</td>
						<td class="teams-table-column">W</td>
						<td class="teams-table-column">T</td>
						<td class="teams-table-column">L</td>
						<td class="teams-table-column">OTW</td>
						<td class="teams-table-column">P</td>
					</tr>
					<tr class="stat" id="nech">
						<td class="teams-table-column">1</td>
						<td class="teams-table-column">
							<div>
								<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
								<p class="team-name">Assat</p>
							</div>
						</td>
						<td class="teams-table-column">44</td>
						<td class="teams-table-column">29</td>
						<td class="teams-table-column">13</td>
						<td class="teams-table-column">2</td>
						<td class="teams-table-column">0</td>
						<td class="teams-table-column">78</td>
					</tr>
					<tr class="stat">
						<td class="teams-table-column">2</td>
						<td class="teams-table-column">
							<div>
								<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
								<p class="team-name">Pelicans</p>
							</div>
						</td>
						<td class="teams-table-column">44</td>
						<td class="teams-table-column">29</td>
						<td class="teams-table-column">13</td>
						<td class="teams-table-column">2</td>
						<td class="teams-table-column">0</td>
						<td class="teams-table-column">78</td>
					</tr>
					<tr class="stat" id="nech">
						<td class="teams-table-column">3</td>
						<td class="teams-table-column">
							<div>
								<img src="../images/vaasan-sport-sm.png" alt="" class="team-logo">
								<p class="team-name">Arizona Coyotes</p>
							</div>
						</td>
						<td class="teams-table-column">44</td>
						<td class="teams-table-column">29</td>
						<td class="teams-table-column">13</td>
						<td class="teams-table-column">2</td>
						<td class="teams-table-column">0</td>
						<td class="teams-table-column">78</td>
					</tr>
				</table>

			</div>
*/
