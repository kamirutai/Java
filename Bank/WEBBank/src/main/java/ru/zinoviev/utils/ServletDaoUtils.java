package ru.zinoviev.utils;

import ru.zinoviev.DBEngine.dao.BankCredit;
import ru.zinoviev.DBEngine.dao.BankCustomer;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class ServletDaoUtils {

    public static BankCustomer newCostumer(HttpServletRequest req){
        String name = req.getParameter("firstName");
        String partonymic = req.getParameter("patronymic");
        String lastname = req.getParameter("lastName");
        String age = req.getParameter("age");
        String adress = req.getParameter("adress");

        BankCustomer customer = new BankCustomer();
        customer.setFirstName(name);
        customer.setPatronymic(partonymic);
        customer.setLastName(lastname);
        customer.setAge(Integer.parseInt(age));
        customer.setAdress(adress);
        customer.setRegistrationDate(new Date().getTime());
        customer.setStatus(0);

        return customer;
    }




    public static boolean customerDataIsValid(HttpServletRequest req){
        String name = req.getParameter("firstName");
        String partonomic = req.getParameter("patronymic");
        String lastname = req.getParameter("lastName");
        String age = req.getParameter("age");
        String adress = req.getParameter("adress");

        return (name!=null && partonomic!=null && lastname!=null &&
                age!=null && adress!=null && name.length()>0 &&
                partonomic.length()>0 && lastname.length()>0 &&
                age.length()>0 && adress.length()>0);
    };

    public static boolean creditDataIsValid(HttpServletRequest req){
        String CreditName = req.getParameter("CreditName");
        String daysLong = req.getParameter("daysLong");
        String value = req.getParameter("value");
        String interestRate = req.getParameter("interestRate");
        String customerId = req.getParameter("customerId");

        return (CreditName!=null && daysLong!=null && value!=null &&
                interestRate!=null && customerId!=null &&
                CreditName.length()>0 && daysLong.length()>0 &&
                value.length()>0 && interestRate.length()>0 && customerId.length()>0);
    };

    public static BankCredit newCredit(HttpServletRequest req){
        String CreditName = req.getParameter("CreditName");
        String daysLong = req.getParameter("daysLong");
        String value = req.getParameter("value");
        String interestRate = req.getParameter("interestRate");
        String customerId = req.getParameter("customerId");
        BankCredit credit = new BankCredit();

        return credit;
    };

    public static boolean checkSenderBalance(HttpServletRequest req){
        double value = Double.parseDouble(req.getParameter("value"));
        int id = Integer.parseInt( req.getParameter("senderId"));

        return true;
    }

    public static boolean isReciverPresent(HttpServletRequest req){
        int id = Integer.parseInt( req.getParameter("receiverId"));
        return true;
    }
}
