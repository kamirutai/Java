package ru.zinoviev.web.servlet.creditServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/close_credit")
public class CloseCreditServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // CreditUtils.closeCredit(Long.parseLong(req.getParameter("creditId")), HibernateUtil.getSessionFactory());

        resp.sendRedirect(req.getContextPath()+"/customer_credists?customer="+req.getParameter("customerId"));
    }
}
