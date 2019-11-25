package ru.zinoviev.DBEngine.dao;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "credit_customer")
public class CreditCustomer implements BankUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private BankCustomer customer;

    @ManyToOne
    @JoinColumn
    private BankCredit credit;

    @Column
    private double value;

    @Column
    private double repaidValue;

    @Column
    private Long taken;

    @Column
    private boolean closed;


    public CreditCustomer() {

    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public double getRepaidValue() {
        return repaidValue;
    }

    public void setRepaidValue(double repaidValue) {
        this.repaidValue = repaidValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BankCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(BankCustomer customer) {
        this.customer = customer;
    }

    public BankCredit getCredit() {
        return credit;
    }

    public void setCredit(BankCredit credit) {
        this.credit = credit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Long getTaken() {
        return taken;
    }

    public String getTextTaken() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        Date date = new Date(taken);

        return dateFormat.format(date);
    }

    public void setTaken(Long taken) {
        this.taken = taken;
    }

    @Override
    public String toString() {
        return "CreditCustomer{" +
                "id=" + id +
                ", customer=" + customer +
                ", credit=" + credit +
                ", value=" + value +
                ", taken=" + taken +
                '}';
    }
}
