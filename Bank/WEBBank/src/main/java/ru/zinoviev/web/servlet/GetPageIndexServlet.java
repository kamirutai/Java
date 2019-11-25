package ru.zinoviev.web.servlet;

import ru.zinoviev.DBEngine.dao.BankCustomer;
import ru.zinoviev.DBEngine.utils.DAOUtils;
import ru.zinoviev.utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet ("/")
public class GetPageIndexServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int startIndex = Integer.parseInt(req.getParameter("startIndex"))+ServletUtils.getResultCount();

        List<BankCustomer> customers = DAOUtils.getCustomerslist(startIndex, ServletUtils.getResultCount());

        if(customers.size() < ServletUtils.getResultCount()) {
            req.setAttribute("stop", 1);
        } else  {
            req.setAttribute("stop", 0);
        }

        req.setAttribute("startIndex", startIndex);
        req.setAttribute("resultCount", ServletUtils.getResultCount());
        req.setAttribute("userList", customers);
        req.getRequestDispatcher( "WEB-INF/view/index.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int startIndex;

        if(req.getParameter("startIndex") == null){
            startIndex = ServletUtils.getStartIndex();
        } else {
            startIndex = Integer.parseInt(req.getParameter("startIndex")) - ServletUtils.getResultCount();
            if(startIndex < 0) {startIndex = 0;}
        }

        List<BankCustomer> customers = DAOUtils.getCustomerslist(startIndex, ServletUtils.getResultCount());
        req.setAttribute("stop", 0);
        req.setAttribute("startIndex", startIndex);
        req.setAttribute("resultCount", ServletUtils.getResultCount());
        req.setAttribute("userList", customers);
        req.getRequestDispatcher( "WEB-INF/view/index.jsp").forward(req,resp);
    }

    @Override
    public void destroy() {

    }
}
