package ru.zinoviev.web.servlet.transactionServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/close_customer_transaction")
public class RunTransactionServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //   CustomerUtils.removeCustomer(Long.parseLong(req.getParameter("id")), HibernateUtil.getSessionFactory());
        resp.sendRedirect(req.getContextPath()+"/");
    }
}
