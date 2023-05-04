package com.hockeyhigh.controller;

import com.hockeyhigh.dao.entityDAO.PlayerDAO;
import com.hockeyhigh.model.player.Player;
import com.hockeyhigh.util.HTMLUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PlayerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PlayerDAO playerDAO = PlayerDAO.getInstance();
        List<Player> playerList = playerDAO.getAll();
        String playerRows = HTMLUtil.getPlayersRows(playerList);
        req.setAttribute("playerRows",playerRows);

        getServletContext().getRequestDispatcher("/views/players.jsp").forward(req,resp);
    }
}
