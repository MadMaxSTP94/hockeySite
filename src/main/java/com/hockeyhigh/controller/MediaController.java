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

public class MediaController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<HighlightTeamStatsDTO> list = TeamDTOUtil.getTeamDTO(Season._20_21);
        req.setAttribute("team_list",list);

        MediaDAO mediaDAO = MediaDAO.getInstance();

        String team_table = HTMLUtil.getTable(list);
        req.setAttribute("team_table", team_table);
        String team_schedule = HTMLUtil.getSchedule(GameDTOUtil.getSchedule());
        req.setAttribute("team_schedule", team_schedule);
        List<ShortSkaterDTO> skaterList = PlayerDTOUtil.getShortPlayerDTO(Season._22_23);
        String top_stats = HTMLUtil.getTopStats(skaterList);
        req.setAttribute("top_stats",top_stats);

        String parameter = req.getParameter("id");

        try{
            long id = Long.valueOf(parameter);
            Media media = mediaDAO.get(id);
            String mediaBlock = HTMLUtil.getMediaBlock(media);
            req.setAttribute("mediaBlock",mediaBlock);
        }
        catch (Exception ex) {
            resp.sendRedirect("/main");
        }
        getServletContext().getRequestDispatcher("/views/media.jsp").forward(req,resp);
    }
}
