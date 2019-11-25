package ru.zinoviev.web.servlet.userServlet;

import ru.zinoviev.DBEngine.dao.BankCustomer;
import ru.zinoviev.DBEngine.utils.DAOUtils;
import ru.zinoviev.utils.ServletDaoUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit_customer")
public class EditCustomerServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BankCustomer customer = new BankCustomer();
        customer = (BankCustomer) DAOUtils.get(customer, Long.parseLong(req.getParameter("id")));

        req.setAttribute("customer", customer);
        req.getRequestDispatcher("WEB-INF/view/customer/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(ServletDaoUtils.customerDataIsValid(req)){

            BankCustomer customer = new BankCustomer(),
            newCustomer = ServletDaoUtils.newCostumer(req);

            customer = (BankCustomer) DAOUtils.get(customer, Long.parseLong(req.getParameter("id")));
            customer.setStatus(newCustomer.getStatus());
            customer.setAdress(newCustomer.getAdress());
            customer.setFirstName(newCustomer.getFirstName());
            customer.setLastName(newCustomer.getLastName());
            customer.setPatronymic(newCustomer.getPatronymic());
            customer.setAge(newCustomer.getAge());

            DAOUtils.update(customer);
        }

        resp.sendRedirect(req.getContextPath()+"/");
    }
}
