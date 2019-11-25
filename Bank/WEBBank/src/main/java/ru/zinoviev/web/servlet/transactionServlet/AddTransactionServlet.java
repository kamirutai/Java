package ru.zinoviev.web.servlet.transactionServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/customer_transactions")
public class AddTransactionServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //  if(ServletUtils.dataIsValid(req)){
     //     // CustomerUtils.addCustomer(ServletUtils.getCustomer(req), HibernateUtil.getSessionFactory());
     //    }

    //    resp.sendRedirect(req.getContextPath()+"/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("customer"));

        /*
        List<DBTransaction> dbTransactions = (ArrayList)
                TransactionUtils.getTransactionList("FROM DBTransaction where receiverId =:id", id, HibernateUtil.getSessionFactory());

        List<RESTTransaction> restTransactions = new ArrayList<>();

        for (DBTransaction dbc: dbTransactions) {
            restTransactions.add(dbc.toREST());
        }

        req.setAttribute("transactions", restTransactions);
        req.getRequestDispatcher("WEB-INF/view/transactions.jsp").forward(req,resp);
        */
    }
}
