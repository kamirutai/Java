package ru.zinoviev.DBEngine.dao;

import ru.zinoviev.DBEngine.dao.CreditCustomer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "credits")
public class BankCredit implements BankUnit{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String creditName;

    @Column
    private int daysLong;

    @Column
    private double maxValue;

    @Column
    private double Rate;

    @OneToMany(mappedBy = "credit")
    List<CreditCustomer> creditCustomers;

    public BankCredit() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public int getDaysLong() {
        return daysLong;
    }

    public void setDaysLong(int daysLong) {
        this.daysLong = daysLong;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getRate() {
        return Rate;
    }

    public void setRate(double rate) {
        Rate = rate;
    }

    public List<CreditCustomer> getCreditCustomers() {
        return creditCustomers;
    }

    public void setCreditCustomers(List<CreditCustomer> creditCustomers) {
        this.creditCustomers = creditCustomers;
    }

    @Override
    public String toString() {
        return "BankCredit{" +
                "id=" + id +
                ", creditName='" + creditName + '\'' +
                ", daysLong=" + daysLong +
                ", maxValue=" + maxValue +
                ", Rate=" + Rate +
                '}';
    }
}
