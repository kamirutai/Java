package ru.zinoviev.web.servlet.cardServlets;

import ru.zinoviev.DBEngine.dao.*;
import ru.zinoviev.DBEngine.dao.cardOptions.CardOptions;
import ru.zinoviev.DBEngine.utils.DAOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

@WebServlet("/add_card")
public class AddCardServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long customerid = Long.parseLong(req.getParameter("id"));
        long cardid = Long.parseLong(req.getParameter("cardid"))+1;
        DAOUtils.addCard(customerid, cardid);

        resp.sendRedirect(req.getContextPath()+"/customer_about?id="+req.getParameter("id"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BankCard> cards = DAOUtils.getCardlist();
        req.setAttribute("cardlist", cards);

        Long id = Long.valueOf(req.getParameter("id"));
        req.setAttribute("id", id);

        int cardid = 1;
        if(req.getParameter("Events") != null){
            cardid = Integer.parseInt(req.getParameter("Events")) -1;

            req.setAttribute("cardid", cardid);
            req.setAttribute("CardName", cards.get(cardid).getCardName());
            req.setAttribute("International", cards.get(cardid).isInternationalCard());
            req.setAttribute("isMiles", cards.get(cardid).getOptions().isMiles());
            req.setAttribute("MilesCount", cards.get(cardid).getOptions().getMilesIncrementValue());
            req.setAttribute("isFuelCashback", cards.get(cardid).getOptions().isFuelCashback());
            req.setAttribute("FuelCashbackCount", cards.get(cardid).getOptions().getFuelCashbackValue());
            req.setAttribute("isFreeExchange", cards.get(cardid).getOptions().isFreeExchange());
            req.setAttribute("isFreetoUse", cards.get(cardid).getOptions().isFreetoUse());
            req.setAttribute("isCashBack", cards.get(cardid).getOptions().isCashBack());
            req.setAttribute("CashBackValue", cards.get(cardid).getOptions().getCashBackValue());

        }

        req.getRequestDispatcher( "WEB-INF/view/statementsCards/NewCard.jsp").forward(req,resp);
    }
}
