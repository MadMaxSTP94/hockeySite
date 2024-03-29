package com.hockeyhigh.util;

import com.hockeyhigh.dao.entityDAO.PlayerDAO;
import com.hockeyhigh.dao.entityDAO.TeamDAO;
import com.hockeyhigh.dao.statsDAO.GoalieStatsDAO;
import com.hockeyhigh.dao.statsDAO.PlayerStatsDAO;
import com.hockeyhigh.dao.statsDAO.SkaterStatsDAO;
import com.hockeyhigh.dto.ShortGoalieDTO;
import com.hockeyhigh.dto.ShortGoalieDTOBuilder;
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
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlayerDTOUtil {
    public static List<ShortSkaterDTO> getShortPlayerDTO(Season season) {
        List<ShortSkaterDTO> skaterDTOList = new ArrayList<>();

        PlayerDAO playerDAO = PlayerDAO.getInstance();
        List<Player> players = playerDAO.getAll();

        for(Player player : players) {
            if(player.getPosition() != Position.GOALIE) {
                ShortSkaterDTO shortSkaterDTO = generateSSkaterDTO(player, season);
                skaterDTOList.add(shortSkaterDTO);
            }
        }
        return  skaterDTOList;
    }

    public static List<ShortGoalieDTO> getShortGoalieDTO(Season season) {
        List<ShortGoalieDTO> skaterDTOList = new ArrayList<>();

        PlayerDAO playerDAO = PlayerDAO.getInstance();
        List<Player> players = playerDAO.getAll();

        for(Player player : players) {
            if(player.getPosition() == Position.GOALIE) {
                ShortGoalieDTO shortSkaterDTO = generateSGoalieDTO(player, season);
                skaterDTOList.add(shortSkaterDTO);
            }
        }
        return  skaterDTOList;
    }
    public static List<ShortSkaterDTO> getRookieSkaterDTO(Season season) {
        List<ShortSkaterDTO> skaterDTOList = new ArrayList<>();
        PlayerDAO playerDAO = PlayerDAO.getInstance();
        List<Player> players = playerDAO.getAll();
        for(Player player : players) {
            if(player.getPosition() != Position.GOALIE && player.getAge() < 20) {
                ShortSkaterDTO shortSkaterDTO = generateSSkaterDTO(player, season);
                skaterDTOList.add(shortSkaterDTO);
            }
        }
        return  skaterDTOList;
    }

    public static List<ShortSkaterDTO> getDefencemanDTO(Season season) {
        List<ShortSkaterDTO> skaterDTOList = new ArrayList<>();
        PlayerDAO playerDAO = PlayerDAO.getInstance();
        List<Player> players = playerDAO.getAll();
        for(Player player : players) {
            if(player.getPosition() == Position.DEFENDER) {
                ShortSkaterDTO shortSkaterDTO = generateSSkaterDTO(player, season);
                skaterDTOList.add(shortSkaterDTO);
            }
        }
        return  skaterDTOList;
    }

    public static ShortSkaterDTO generateSSkaterDTO(Player player, Season season) {
        SkaterStats skaterStats = generateSkaterStats(getSkaterStats(player.getId(), season));
        Team team = getTeamByPlayerId(player.getId());
        ShortSkaterDTOBuilder shortSkaterDTOBuilder = new ShortSkaterDTOBuilder();

        if(team != null) shortSkaterDTOBuilder.setTeamLogo(team.getLogo_url());

        shortSkaterDTOBuilder.setPlayerName(player.getName());
        shortSkaterDTOBuilder.setPhotoUrl(player.getPhoto_url());
        shortSkaterDTOBuilder.setPosition(player.getPosition());

        if(skaterStats != null) {
            shortSkaterDTOBuilder.setGoals(skaterStats.getGoals());
            shortSkaterDTOBuilder.setAssists(skaterStats.getAssists());
        }

        return shortSkaterDTOBuilder.build();

    }

    public static ShortGoalieDTO generateSGoalieDTO(Player player, Season season) {
        GoalieStats goalieStats = generateGoalieStats(getGoalieStats(player.getId(), season));
        Team team = getTeamByPlayerId(player.getId());
        ShortGoalieDTOBuilder shortGoalieDTOBuilder = new ShortGoalieDTOBuilder();
        PlayerStatsDAO playerStatsDAO = PlayerStatsDAO.getInstance();
        PlayerStats playerStats = playerStatsDAO.get(player.getId());

        if(team != null) shortGoalieDTOBuilder.setTeamLogo(team.getLogo_url());

        shortGoalieDTOBuilder.setPlayerName(player.getName());
        shortGoalieDTOBuilder.setPhotoUrl(player.getPhoto_url());
        shortGoalieDTOBuilder.setPosition(player.getPosition());

        try{
            if(goalieStats != null && playerStats != null) {
                shortGoalieDTOBuilder.setShutouts(goalieStats.getShutouts());
                float gaa = goalieStats.getGoals_against_average();
                shortGoalieDTOBuilder.setGGA(gaa);
                shortGoalieDTOBuilder.setSaves(goalieStats.getSaves_percentage());
            }
        }
        catch (Exception ex) {
            System.out.println("Exception in PlayerDTO GenerateSGoalieDTO");
        }

        return shortGoalieDTOBuilder.build();
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
        //PlayerStatsDAO playerStatsDAO = PlayerStatsDAO.getInstance();
        //PlayerStats stats = playerStatsDAO.get(player_id);
        //PlayerDAO playerDAO = PlayerDAO.getInstance();
        TeamDAO teamDAO = TeamDAO.getInstance();
        PlayerDAO playerDAO = PlayerDAO.getInstance();
        Team team = teamDAO.get(playerDAO.getTeamID(player_id));
        if(team == null) return null;
        //return  stats.getTeam(); //последняя запись в статистике
        return team;
    }

    public static List<ShortSkaterDTO> sort(List<ShortSkaterDTO> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            // внутренний цикл прохода
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j-1).getTotal() < list.get(j).getTotal()) {
                    ShortSkaterDTO tmp = list.get(j - 1);
                    list.set(j-1,list.get(j));
                    list.set(j,tmp);
                }
            }
        }
        return list;
    }

    public static List<ShortGoalieDTO> sortByGAA(List<ShortGoalieDTO> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            // внутренний цикл прохода
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j-1).getGGA() < list.get(j).getGGA()) {
                    ShortGoalieDTO tmp = list.get(j - 1);
                    list.set(j-1,list.get(j));
                    list.set(j,tmp);
                }
            }
        }
        return list;
    }

    public static List<ShortGoalieDTO> sortBySaves(List<ShortGoalieDTO> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            // внутренний цикл прохода
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j-1).getSAVES() < list.get(j).getSAVES()) {
                    ShortGoalieDTO tmp = list.get(j - 1);
                    list.set(j-1,list.get(j));
                    list.set(j,tmp);
                }
            }
        }
        return list;
    }

    public static List<ShortGoalieDTO> sortBySO(List<ShortGoalieDTO> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            // внутренний цикл прохода
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j-1).getShutouts() < list.get(j).getShutouts()) {
                    ShortGoalieDTO tmp = list.get(j - 1);
                    list.set(j-1,list.get(j));
                    list.set(j,tmp);
                }
            }
        }
        return list;
    }

}
