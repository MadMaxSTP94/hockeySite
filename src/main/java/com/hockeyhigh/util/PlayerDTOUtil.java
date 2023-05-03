package com.hockeyhigh.util;

import com.hockeyhigh.dao.entityDAO.PlayerDAO;
import com.hockeyhigh.dao.entityDAO.TeamDAO;
import com.hockeyhigh.dao.statsDAO.GoalieStatsDAO;
import com.hockeyhigh.dao.statsDAO.PlayerStatsDAO;
import com.hockeyhigh.dao.statsDAO.SkaterStatsDAO;
import com.hockeyhigh.dto.ShortSkaterDTO;
import com.hockeyhigh.dto.ShortSkaterDTOBuilder;
import com.hockeyhigh.model.builders.statsBuilder.GoalieStatsBuilder;
import com.hockeyhigh.model.builders.statsBuilder.SkaterStatsBuilder;
import com.hockeyhigh.model.enums.Position;
import com.hockeyhigh.model.enums.Season;
import com.hockeyhigh.model.player.Player;
import com.hockeyhigh.model.statistics.GoalieStats;
import com.hockeyhigh.model.statistics.PlayerStats;
import com.hockeyhigh.model.statistics.SkaterStats;
import com.hockeyhigh.model.team.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlayerDTOUtil {
    public static List<ShortSkaterDTO> getShortPlayerDTO() {
        List<ShortSkaterDTO> skaterDTOList = new ArrayList<>();

        PlayerDAO playerDAO = PlayerDAO.getInstance();
        List<Player> players = playerDAO.getAll();

        SkaterStatsDAO skaterStatsDAO = SkaterStatsDAO.getInstance();
        List<SkaterStats> skaterStats = skaterStatsDAO.getAll();

        TeamDAO teamDAO = TeamDAO.getInstance();
        List<Team> teams = teamDAO.getAll();


        for(Player player : players) {
            if(player.getPosition() == Position.DEFENDER || player.getPosition() == Position.FORWARD) {
                Team team = getTeamByPlayerId(player.getId());
                ShortSkaterDTOBuilder shortSkaterDTOBuilder = new ShortSkaterDTOBuilder();
                shortSkaterDTOBuilder.setPlayerName(player.getName());
                shortSkaterDTOBuilder.setPhotoUrl(player.getPhoto_url());
                shortSkaterDTOBuilder.setPosition(player.getPosition());
                shortSkaterDTOBuilder.setTeamLogo(team.getLogo_url());


            }

        }
        return  null;
    }

    public static List<SkaterStats> getSkaterStats(long player_id, Season season) {

        PlayerStatsDAO playerStatsDAO = PlayerStatsDAO.getInstance();
        List<PlayerStats> playerStats = playerStatsDAO.getAll()
                                                      .stream()
                                                      .filter(playerStats1 -> playerStats1.getPlayer_id() == player_id && playerStats1.getSeason() == season)
                                                      .collect(Collectors.toList());
        //получили список статистики во всех командах за сезон playerStats
        playerStats.sort(new PlayerStatsComparator());

        SkaterStatsDAO skaterStatsDAO = SkaterStatsDAO.getInstance();

        List<SkaterStats> team_stats = new ArrayList<>();
        List<SkaterStats> teams_skaters_stats = new ArrayList<>();

        long team_id = -1;
        for(PlayerStats stat : playerStats) {
            long stat_team_id = stat.getTeam().getId();
            if(team_id == -1) {
                team_id = stat_team_id;
            }
            if(team_id != stat_team_id) {
                team_id = stat_team_id;
                teams_skaters_stats.add(generateSkaterStats(team_stats));
                team_stats.clear();
            }
            SkaterStats skaterStats = skaterStatsDAO.get(stat.getId());
            team_stats.add(skaterStats);
        }

        if(team_stats.size() == 1 && team_stats.get(0) == null) return null;
        if(team_stats.size() > 0) {
            teams_skaters_stats.add(generateSkaterStats(team_stats));
            team_stats.clear();
        }



        return teams_skaters_stats;
    }

    public static List<GoalieStats> getGoalieStats(long player_id, Season season) {

        PlayerStatsDAO playerStatsDAO = PlayerStatsDAO.getInstance();
        List<PlayerStats> playerStats = playerStatsDAO.getAll()
                .stream()
                .filter(playerStats1 -> playerStats1.getPlayer_id() == player_id && playerStats1.getSeason() == season)
                .collect(Collectors.toList());
        //получили список статистики во всех командах за сезон playerStats
        playerStats.sort(new PlayerStatsComparator());

        GoalieStatsDAO skaterStatsDAO = GoalieStatsDAO.getInstance();

        List<GoalieStats> team_stats = new ArrayList<>();
        List<GoalieStats> teams_skaters_stats = new ArrayList<>();

        long team_id = -1;
        for(PlayerStats stat : playerStats) {
            long stat_team_id = stat.getTeam().getId();
            if(team_id == -1) {
                team_id = stat_team_id;
            }
            if(team_id != stat_team_id) {
                team_id = stat_team_id;
                teams_skaters_stats.add(generateGoalieStats(team_stats));
                team_stats.clear();
            }
            GoalieStats skaterStats = skaterStatsDAO.get(stat.getId());
            team_stats.add(skaterStats);
        }

        if(team_stats.size() == 1 && team_stats.get(0) == null) return null;
        if(team_stats.size() > 0) {
            teams_skaters_stats.add(generateGoalieStats(team_stats));
            team_stats.clear();
        }

        return teams_skaters_stats;
    }

    public static <T> int sumField(List<T> collection, Function<T, Integer> selector) {
        int sum = 0;
        for (T obj : collection) {
            sum += selector.apply(obj);
        }
        return sum;
    }

    public static SkaterStats generateSkaterStats(List<SkaterStats> list) {
        if(list == null) return null;
        SkaterStatsBuilder skaterStatsBuilder = new SkaterStatsBuilder();
        skaterStatsBuilder.setAssists(sumField(list,SkaterStats::getAssists));
        skaterStatsBuilder.setFaceOffCount(sumField(list,SkaterStats::getFace_offs_count));
        skaterStatsBuilder.setGoals(sumField(list,SkaterStats::getGoals));
        skaterStatsBuilder.setFaceOffWins(sumField(list,SkaterStats::getFace_offs_wins));
        skaterStatsBuilder.setPenaltyMinutes(sumField(list,SkaterStats::getPenalty_minutes));
        skaterStatsBuilder.setGameWinningGoals(sumField(list,SkaterStats::getGame_winning_goals));
        skaterStatsBuilder.setPlusMinus(sumField(list,SkaterStats::getPlus_minus));
        skaterStatsBuilder.setPowerPlayGoals(sumField(list,SkaterStats::getPower_play_goals));
        skaterStatsBuilder.setShortHandedGoals(sumField(list,SkaterStats::getShort_handed_goals));
        skaterStatsBuilder.setShotsMade(sumField(list,SkaterStats::getShots_made));

        return skaterStatsBuilder.build();
    }

    public static GoalieStats generateGoalieStats(List<GoalieStats> list) {
        if(list == null) return  null;
        GoalieStatsBuilder goalieStatsBuilder = new GoalieStatsBuilder();
        goalieStatsBuilder.setLoses(sumField(list,GoalieStats::getLoses));
        goalieStatsBuilder.setWins(sumField(list,GoalieStats::getWins));
        goalieStatsBuilder.setTies(sumField(list,GoalieStats::getTies));
        goalieStatsBuilder.setGoals_against(sumField(list,GoalieStats::getGoals_against));
        goalieStatsBuilder.setSaves_count(sumField(list,GoalieStats::getSaves_count));
        goalieStatsBuilder.setShots_faced(sumField(list,GoalieStats::getShots_faced));
        goalieStatsBuilder.setShutouts(sumField(list,GoalieStats::getShutouts));

        return goalieStatsBuilder.build();
    }

    public static Team getTeamByPlayerId(long player_id) {
        PlayerStatsDAO playerStatsDAO = PlayerStatsDAO.getInstance();
        return  playerStatsDAO.get(player_id).getTeam(); //последняя запись в статистике
    }

}
