package com.hockeyhigh.test;

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

public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Media media = new Media(1,"p.jpg","Bsadfd", MediaType.PHOTO, "","12.12.2012");
        List<HighlightTeamStatsDTO> list = TeamDTOUtil.getTeamDTO(Season._20_21);
        req.setAttribute("team_list",list);
        req.setAttribute("media",media);

        String team_table = HTMLUtil.getTable(list);
        req.setAttribute("team_table", team_table);

        String team_schedule = HTMLUtil.getSchedule(GameDTOUtil.getSchedule());
        req.setAttribute("team_schedule", team_schedule);

        List<ShortSkaterDTO> skaterList = PlayerDTOUtil.getShortPlayerDTO(Season._22_23);
        String top_stats = HTMLUtil.getTopStats(skaterList);
        req.setAttribute("top_stats",top_stats);

        getServletContext().getRequestDispatcher("/views/main.jsp").forward(req,resp);
    }
}
