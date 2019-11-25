package ru.zinoviev.web.servlet.statement;

import ru.zinoviev.DBEngine.dao.cardOptions.CardOptions;
import ru.zinoviev.DBEngine.utils.DAOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_statement")
public class AddStatementServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CardOptions options = new CardOptions();
                options =(CardOptions) DAOUtils.get(options, Long.parseLong(req.getParameter("id")));

        req.setAttribute("options", options);

        req.getRequestDispatcher( "WEB-INF/view/statementsCards/card_options.jsp").forward(req,resp);
    }
}
