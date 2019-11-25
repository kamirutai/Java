package ru.zinoviev.web.servlet.cardServlets;

import ru.zinoviev.DBEngine.dao.BankCard;
import ru.zinoviev.DBEngine.dao.BankCustomer;
import ru.zinoviev.DBEngine.dao.CreditCustomer;
import ru.zinoviev.DBEngine.dao.CustomerStatementsCard;
import ru.zinoviev.DBEngine.dao.cardOptions.CardOptions;
import ru.zinoviev.DBEngine.utils.DAOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/card_options")
public class CardOptionsServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CardOptions options = new CardOptions();
                options =(CardOptions) DAOUtils.get(options, Long.parseLong(req.getParameter("id")));

        req.setAttribute("options", options);

        req.getRequestDispatcher( "WEB-INF/view/statementsCards/card_options.jsp").forward(req,resp);
    }
}
