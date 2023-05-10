package com.hockeyhigh.controller;

import com.hockeyhigh.dao.entityDAO.TeamDAO;
import com.hockeyhigh.model.team.Team;
import com.hockeyhigh.util.HTMLUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TeamInfoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("id");
        //int id = Integer.parseInt(req.getParameter("id"));
        if(parameter != null) {
            long id = Integer.valueOf(parameter);
            Team team = TeamDAO.getInstance().get(id);
            String teamInfo = HTMLUtil.getTeamInfo(team);
            req.setAttribute("teamInfo",teamInfo);
        }
        getServletContext().getRequestDispatcher("/views/team.jsp").forward(req,resp);

    }
}
