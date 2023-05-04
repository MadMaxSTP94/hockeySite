package com.hockeyhigh.controller;

import com.hockeyhigh.dao.mediaDAO.MediaDAO;
import com.hockeyhigh.dto.ShortSkaterDTO;
import com.hockeyhigh.dto.team.HighlightTeamStatsDTO;
import com.hockeyhigh.model.enums.MediaType;
import com.hockeyhigh.model.enums.Season;
import com.hockeyhigh.model.media.Media;
import com.hockeyhigh.util.GameDTOUtil;
import com.hockeyhigh.util.HTMLUtil;
import com.hockeyhigh.util.PlayerDTOUtil;
import com.hockeyhigh.util.TeamDTOUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class NewsController extends HttpServlet {
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

        String media = HTMLUtil.getMediaRows(article.subList(0,4));
        req.setAttribute("mediaRow",media);
        String team_table = HTMLUtil.getTable(list);
        req.setAttribute("team_table", team_table);
        String team_schedule = HTMLUtil.getSchedule(GameDTOUtil.getSchedule());
        req.setAttribute("team_schedule", team_schedule);

        getServletContext().getRequestDispatcher("/views/news.jsp").forward(req,resp);

    }
}
