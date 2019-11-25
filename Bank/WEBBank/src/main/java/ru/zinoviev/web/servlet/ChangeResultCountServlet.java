package ru.zinoviev.web.servlet;

import ru.zinoviev.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/change_result_count")
public class ChangeResultCountServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtils.setResultCount(Integer.parseInt(req.getParameter("result")));

        resp.sendRedirect(req.getContextPath()+"/");
    }
}
