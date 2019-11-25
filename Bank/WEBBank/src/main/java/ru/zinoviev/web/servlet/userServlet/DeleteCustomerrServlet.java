package ru.zinoviev.web.servlet.userServlet;

import ru.zinoviev.DBEngine.dao.BankCustomer;
import ru.zinoviev.DBEngine.utils.DAOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete_user")
public class DeleteCustomerrServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BankCustomer customer = new BankCustomer();
        customer = (BankCustomer)DAOUtils.get(customer, Long.parseLong(req.getParameter("id")));

        DAOUtils.remove(customer);

        resp.sendRedirect(req.getContextPath()+"/");
    }
}
