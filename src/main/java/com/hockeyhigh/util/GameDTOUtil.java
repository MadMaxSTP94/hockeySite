package com.hockeyhigh.util;

import com.hockeyhigh.dao.entityDAO.GameDAO;
import com.hockeyhigh.dao.entityDAO.TeamDAO;
import com.hockeyhigh.dao.statsDAO.TeamStatsDAO;
import com.hockeyhigh.dto.GameDTO;
import com.hockeyhigh.dto.GameDTOBuilder;
import com.hockeyhigh.dto.team.ShortTeamGameDTO;
import com.hockeyhigh.model.game.Game;
import com.hockeyhigh.model.statistics.TeamStats;
import com.hockeyhigh.model.team.Team;

import java.util.ArrayList;
import java.util.List;

public class GameDTOUtil {
    public static List<TeamStats> getTeamStats(long game_id) {
        TeamStatsDAO teamStatsDAO = TeamStatsDAO.getInstance();
        List<TeamStats> teamStatsList = teamStatsDAO.getAll();
        teamStatsList = getTeamsGameStats(teamStatsList, game_id);
        return teamStatsList;
    }

    public static Team getTeamByStat(long team_id) {
        return TeamDAO.getInstance().get(team_id);
    }

    public static List<GameDTO> getSchedule() {
        List<GameDTO> gameDTOS = new ArrayList<>();
        GameDAO gameDAO = GameDAO.getInstance();
        List<Game> games = gameDAO.getAll();
        for(Game game : games) {
            List<TeamStats> teamStats = getTeamStats(game.getId());
            List<ShortTeamGameDTO> shortTeamGameDTOList = new ArrayList<>();
            for(TeamStats stat : teamStats) {
                Team team = getTeamByStat(stat.getTeam_id());
                shortTeamGameDTOList.add(new ShortTeamGameDTO(team.getName(), team.getLogo_url(), stat.getGoals_for()));
            }
            GameDTOBuilder gameDTOBuilder = new GameDTOBuilder();
            gameDTOBuilder.setAttendance(game.getAttendance());
            gameDTOBuilder.setDate(game.getDate());
            gameDTOBuilder.setTime(game.getTime());
            gameDTOBuilder.setStatus(game.getStatus());
            //Опасненько
            gameDTOBuilder.setHome(shortTeamGameDTOList.get(0));
            gameDTOBuilder.setGuest(shortTeamGameDTOList.get(1));

            gameDTOS.add(gameDTOBuilder.build());

        }
        return gameDTOS;
    }

    public static List<TeamStats> getTeamsGameStats(List<TeamStats> teamStats, long game_id) {
        List<TeamStats> teamStatsList = new ArrayList<>(2);
        for(TeamStats stats : teamStats) {
            if(stats.getGame_id() == game_id) {
                teamStatsList.add(stats);
            }
        }
        return teamStatsList;
    }
}
