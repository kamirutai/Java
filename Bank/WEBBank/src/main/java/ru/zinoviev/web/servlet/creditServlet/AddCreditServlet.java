package ru.zinoviev.web.servlet.creditServlet;

import ru.zinoviev.DBEngine.dao.BankCredit;
import ru.zinoviev.DBEngine.dao.BankCustomer;
import ru.zinoviev.DBEngine.dao.CreditCustomer;
import ru.zinoviev.DBEngine.utils.DAOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/add_credit")
public class AddCreditServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        req.setAttribute("id", id);

        List<BankCredit> credits = DAOUtils.getCreditlist();
        req.setAttribute("creditList", credits);

        int creditid = 1;
        if(req.getParameter("Events")!=null){
            creditid = Integer.parseInt(req.getParameter("Events")) -1;


        req.setAttribute("creditName", credits.get(creditid).getCreditName());
        req.setAttribute("maxValue", (int)credits.get(creditid).getMaxValue());
        req.setAttribute("DLong", credits.get(creditid).getDaysLong());
        req.setAttribute("Rate", credits.get(creditid).getRate());
        req.setAttribute("creditid", creditid);
        }


        req.getRequestDispatcher("WEB-INF/view/credit/credits.jsp").forward(req,resp);
   }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        long creditid = Integer.parseInt(req.getParameter("creditid"))+1;
        double value = Double.parseDouble(req.getParameter("value"));
        DAOUtils.addCredit(id, creditid, value);

        resp.sendRedirect(req.getContextPath()+"/customer_about?id="+req.getParameter("id"));
    }
}
