package ru.zinoviev.web.servlet.transactionServlet;

import ru.zinoviev.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/select_customer")
public class GetTransactionCustomerServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long x = Long.parseLong(req.getParameter("forEachTag"));

      //  List<DBCustomer> customers = CustomerUtils.getCustomerslist(ServletUtils.getResultCount(), HibernateUtil.getSessionFactory());

        req.setAttribute("resultCount", ServletUtils.getResultCount());
       // req.setAttribute("userList", customers);
        req.getRequestDispatcher("WEB-INF/view/select_customer.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {

    }
}
