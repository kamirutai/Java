package ru.zinoviev.web.servlet;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
     //   ServletContext servletContext = sce.getServletContext();
        //servletContext.setAttribute("resultCount", 20);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
