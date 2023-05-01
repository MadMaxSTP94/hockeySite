package com.hockeyhigh.util;

import com.hockeyhigh.dao.entityDAO.TeamDAO;
import com.hockeyhigh.dao.statsDAO.TeamStatsDAO;
import com.hockeyhigh.dto.HighlightTeamStatsBuilder;
import com.hockeyhigh.dto.team.HighlightTeamStatsDTO;
import com.hockeyhigh.model.builders.statsBuilder.TeamStatsBuilder;
import com.hockeyhigh.model.enums.Season;
import com.hockeyhigh.model.statistics.TeamStats;
import com.hockeyhigh.model.team.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TeamDTOUtil {
    public static List<HighlightTeamStatsDTO> getTeamDTO(Season season) {
        List<HighlightTeamStatsDTO> teamStatsDTOS = new ArrayList<>();
        TeamDAO teamDAO = TeamDAO.getInstance();
        List<Team> teams = teamDAO.getAll();
        List<TeamStats> teamStats = null;
        for(Team team : teams) {
            teamStats = TeamStatsDAO.getInstance().getSeasonStats(team.getId(),season);
            TeamStats teamSeasonStat = getSumOfEachStat(teamStats);
            teamStatsDTOS.add(generateTeamDTO(team,teamSeasonStat));
        }
        return teamStatsDTOS;
    }
    public static HighlightTeamStatsDTO generateTeamDTO(Team team, TeamStats teamStats) {
        HighlightTeamStatsBuilder highlightTeamStatsBuilder = new HighlightTeamStatsBuilder();
        highlightTeamStatsBuilder.setTeamName(team.getName());
        highlightTeamStatsBuilder.setTeamLogoUrl(team.getLogo_url());
        highlightTeamStatsBuilder.setGamesPlayed(teamStats.getGames_played());
        highlightTeamStatsBuilder.setWins(teamStats.getWins());
        highlightTeamStatsBuilder.setTies(teamStats.getTies());
        highlightTeamStatsBuilder.setLoses(teamStats.getLoses());
        highlightTeamStatsBuilder.setOTwins(teamStats.getOt_wins());
        highlightTeamStatsBuilder.setPoints(teamStats.getTotal_points());
        return highlightTeamStatsBuilder.build();
    }

    public static TeamStats getSumOfEachStat(List<TeamStats> statsList) {
        TeamStatsBuilder teamStatsBuilder = new TeamStatsBuilder();
        teamStatsBuilder.setWins(sumField(statsList,TeamStats::getWins));
        teamStatsBuilder.setTies(sumField(statsList,TeamStats::getTies));
        teamStatsBuilder.setLoses(sumField(statsList,TeamStats::getLoses));
        teamStatsBuilder.setOTWins(sumField(statsList,TeamStats::getOt_wins));
        teamStatsBuilder.setGoalsFor(sumField(statsList,TeamStats::getGoals_for));
        teamStatsBuilder.setGoalsAgainst(sumField(statsList,TeamStats::getGoals_against));
        teamStatsBuilder.setPPAttempts(sumField(statsList,TeamStats::getPp_attempts));
        teamStatsBuilder.setPKAttempts(sumField(statsList,TeamStats::getPk_attempts));
        teamStatsBuilder.setPPGoals(sumField(statsList,TeamStats::getPp_goals));
        teamStatsBuilder.setPKGoals(sumField(statsList,TeamStats::getPk_goals));
        return teamStatsBuilder.build();
    }

    public static <T> int sumField(List<T> collection, Function<T, Integer> selector) {
        int sum = 0;
        for (T obj : collection) {
            sum += selector.apply(obj);
        }
        return sum;
    }

}
