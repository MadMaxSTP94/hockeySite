package com.hockeyhigh.test;

import com.hockeyhigh.dao.mediaDAO.MediaDAO;
import com.hockeyhigh.dto.ShortGoalieDTO;
import com.hockeyhigh.dto.ShortSkaterDTO;
import com.hockeyhigh.dto.team.HighlightTeamStatsDTO;
import com.hockeyhigh.model.enums.MediaType;
import com.hockeyhigh.model.enums.Season;
import com.hockeyhigh.model.media.Media;
import com.hockeyhigh.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.SortedSet;

public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<HighlightTeamStatsDTO> list = TeamDTOUtil.getTeamDTO(Season._20_21);
        req.setAttribute("team_list",list);

        MediaDAO mediaDAO = MediaDAO.getInstance();
        List<Media> videos = mediaDAO.getAll(MediaType.VIDEO, 4);
        List<Media> article = mediaDAO.getAll(MediaType.PHOTO, 8);
        String newsTop = HTMLUtil.getNewsTop(article.get(0));
        req.setAttribute("newsTop",newsTop);
        String newTopRight = HTMLUtil.getNewsTopRights(article.get(1));
        req.setAttribute("newsRight",newTopRight);
        String otherNews = HTMLUtil.getNewsTopOther(article.subList(2,4));
        req.setAttribute("newsOther",otherNews);
        String media = HTMLUtil.getMediaRow(videos);
        req.setAttribute("mediaRow",media);
        String articles = HTMLUtil.getMediaRow(article.subList(0,4));
        req.setAttribute("articleRow",articles);
        String team_table = HTMLUtil.getTable(list);
        req.setAttribute("team_table", team_table);
        String team_schedule = HTMLUtil.getSchedule(GameDTOUtil.getSchedule());
        req.setAttribute("team_schedule", team_schedule);

        List<ShortSkaterDTO> skaterList = PlayerDTOUtil.getShortPlayerDTO(Season._22_23);
        skaterList = PlayerDTOUtil.sort(skaterList);
        String top_stats = HTMLUtil.getTopStats(skaterList);
        req.setAttribute("top_stats",top_stats);

        List<ShortSkaterDTO> defendersList = PlayerDTOUtil.getDefencemanDTO(Season._22_23);
        defendersList = PlayerDTOUtil.sort(defendersList);
        String top_defender = HTMLUtil.getTopStats(defendersList);
        req.setAttribute("top_defenders",top_defender);

        List<ShortGoalieDTO> goalieDTOS = PlayerDTOUtil.getShortGoalieDTO(Season._22_23);
        String top_GAA = HTMLUtil.getTopGAAGoalies(PlayerDTOUtil.sortByGAA(goalieDTOS));
        req.setAttribute("top_GAA", top_GAA);

        String top_SAVES = HTMLUtil.getTopSVSGoalies(PlayerDTOUtil.sortBySaves(goalieDTOS));
        req.setAttribute("top_SAVES", top_SAVES);

        String top_SO = HTMLUtil.getTopSOGoalies(PlayerDTOUtil.sortBySO(goalieDTOS));
        req.setAttribute("top_SO", top_SO);

        getServletContext().getRequestDispatcher("/views/main.jsp").forward(req,resp);
    }
}
