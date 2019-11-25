package ru.zinoviev.web.servlet.userServlet;

import ru.zinoviev.DBEngine.utils.DAOUtils;
import ru.zinoviev.utils.ServletDaoUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_customer")
public class AddCustomerServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       if(ServletDaoUtils.customerDataIsValid(req)){
           DAOUtils.add(ServletDaoUtils.newCostumer(req));
       }

        resp.sendRedirect(req.getContextPath()+"/");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/view/customer/AddNewCustomer.jsp").forward(req,resp);
    }
}
