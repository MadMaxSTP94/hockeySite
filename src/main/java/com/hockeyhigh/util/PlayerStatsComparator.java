package com.hockeyhigh.util;

import com.hockeyhigh.model.statistics.PlayerStats;
import com.hockeyhigh.model.team.Team;

import java.util.Comparator;

public class PlayerStatsComparator implements Comparator<PlayerStats> {
    @Override
    public int compare(PlayerStats stats1, PlayerStats stats2) {
        return stats1.getTeam().getName().compareTo(stats2.getTeam().getName());
    }
}
