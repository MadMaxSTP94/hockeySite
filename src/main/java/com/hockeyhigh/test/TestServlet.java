package com.hockeyhigh.test;

import com.hockeyhigh.model.entity.enums.MediaType;
import com.hockeyhigh.model.entity.media.Media;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Media media = new Media(1,"p.jpg","Bsadfd", MediaType.PHOTO, "");

        req.setAttribute("media",media);

        getServletContext().getRequestDispatcher("/views/main.jsp").forward(req,resp);
    }
}
