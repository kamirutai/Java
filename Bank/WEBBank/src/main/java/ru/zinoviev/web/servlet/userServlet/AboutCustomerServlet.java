package ru.zinoviev.web.servlet.userServlet;

import ru.zinoviev.DBEngine.dao.*;
import ru.zinoviev.DBEngine.utils.DAOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customer_about")
public class AboutCustomerServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BankCustomer customer = new BankCustomer();

        customer = (BankCustomer) DAOUtils.get(customer, Long.parseLong(req.getParameter("id")));
        req.setAttribute("customer", customer);

        //credits
        List<CreditCustomer> creditCustomer = customer.getCustomerCredits();
        req.setAttribute("creditCustomer", creditCustomer);

        //statements
        List<CustomerStatementsCard> customerStatementsCards = customer.getStatements();
        req.setAttribute("customerStatementsCards", customerStatementsCards);


        req.getRequestDispatcher( "WEB-INF/view/customer/about.jsp").forward(req,resp);
    }
}
