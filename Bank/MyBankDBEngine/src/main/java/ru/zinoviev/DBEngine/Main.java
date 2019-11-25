package ru.zinoviev.DBEngine;

import ru.zinoviev.DBEngine.dao.*;
import ru.zinoviev.DBEngine.dao.BankCredit;
import ru.zinoviev.DBEngine.utils.DAOUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
      //  BankCustomer customer = new BankCustomer();
     //   BankCredit credit = new BankCredit();
     //   CreditCustomer creditCustomer = new CreditCustomer();
     //   CustomerStatementsCard statementsCard = new CustomerStatementsCard();

        DAOUtils.addCard(3, 4);


      //  DAOUtils.createCreditTable();
      //  DAOUtils.CreateCardsTable();
      //  DAOUtils.addFakeUsers(100, true);
/*
       List<BankCard> cards = DAOUtils.getCardlist();
        for (BankCard c: cards) {
            System.out.println("----------------------------");
            System.out.println("Id :"+ c.getId());
            System.out.println("CardName :"+ c.getCardName());
            System.out.println("International :"+ c.isInternationalCard());
            System.out.println("-----Options: ");
            System.out.println("FreeExchange :"+ c.getOptions().isFreeExchange());
            System.out.println("CashBack :"+ c.getOptions().isCashBack());
            System.out.println("Miles :"+ c.getOptions().isMiles());
            System.out.println("FreetoUse :"+ c.getOptions().isFreetoUse());
            System.out.println("FuelCashback :"+ c.getOptions().isFuelCashback());
            System.out.println("-----------------------------");
        }

    //    BankCustomer customer = new BankCustomer();
     //   customer = (BankCustomer)DAOUtils.get(customer, 2);
    //    DAOUtils.remove(customer);


        /*   BankCustomer customer = new BankCustomer();
           customer = (BankCustomer)DAOUtils.get(customer, 2);

           customer.setAge(111111);
           DAOUtils.update(customer);

           List<CreditCustomer> creditCustomerList = new ArrayList<>(customer.getCustomerCredits());

           System.out.println(creditCustomerList.size());



/*
        for (int i = 1; i < 1001; i++) {
            BankCustomer customer = new BankCustomer();
            customer = (BankCustomer)DAOUtils.get(customer, i);
            DAOUtils.remover(customer);
        }



        customer =(BankCustomer)DAOUtils.get(customer, 10);
        System.out.println("------------CUSTOMER-------------");
        System.out.println(customer.toString());
        System.out.println("------------CREDISTS-------------");
        List<CreditCustomer> creditCustomers = new ArrayList<>(customer.getCustomerCredits());
           List<BankCredit> bankCredits = new ArrayList<>();
            for (CreditCustomer c: creditCustomers) {
                System.out.println("------------ CREDIT : ");
                credit = c.getCredit();
                System.out.println("Взят: "+ c.getTaken());
                System.out.println("Сумма: "+c.getValue());
                if (credit!=null) {
                    System.out.println(credit.toString());
                }
        }
        System.out.println("------------STATEMENTS-------------");

        List<CustomerStatementsCard> statementsCardList = new ArrayList<>(customer.getStatements());
        for (CustomerStatementsCard statement: statementsCardList) {
            System.out.println("------------STATEMENT :");
            BankStatement bankStatement = statement.getStatement();
            System.out.println(bankStatement);
            if(statement.getCard()!=null){
                System.out.println("------------CARD-------------");
                BankCard card = statement.getCard();
                System.out.println("Карта : "+card.toString());

                CardOptions cardOptions = statement.getCard().getOptions();
                System.out.println("------------CARD OPTIONS-------------");
                System.out.println("Опции по карте: "+cardOptions.toString());
            }
            System.out.println("------------DEPOSIT-------------");
            System.out.println(statement.getisDeposit());
            System.out.println(statement.getStatement().toString());
        }*/

    }


}
