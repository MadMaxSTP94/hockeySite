package com.hockeyhigh.controller;

import com.hockeyhigh.dao.entityDAO.TeamDAO;
import com.hockeyhigh.model.enums.Season;
import com.hockeyhigh.model.team.Team;
import com.hockeyhigh.util.HTMLUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TeamController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TeamDAO teamDAO = TeamDAO.getInstance();
        List<Team> teams = teamDAO.getAll();
        String allTeams = HTMLUtil.getTeamsRows(teams, Season._20_21);
        req.setAttribute("allTeams", allTeams);
        getServletContext().getRequestDispatcher("/views/teams.jsp").forward(req,resp);
    }
}
