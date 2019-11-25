package ru.zinoviev.DBEngine.dao;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "customer_statements_cards")
public class CustomerStatementsCard implements BankUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private BankCustomer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private BankStatement statement;

    @ManyToOne
    @JoinColumn
    private BankCard card;

    @Column
    private Long cardNumber;

    @Column
    private Long registrationDate;

    @Column
    private boolean isDeposit;

    @Column
    private int milesCount;

    public CustomerStatementsCard() {

    }

    public int getMilesCount() {
        return milesCount;
    }

    public void setMilesCount(int milesCount) {
        this.milesCount = milesCount;
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

    public BankStatement getStatement() {
        return statement;
    }

    public void setStatement(BankStatement statement) {
        this.statement = statement;
    }

    public BankCard getCard() {
        return card;
    }

    public void setCard(BankCard card) {
        this.card = card;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setDeposit(boolean deposit) {
        isDeposit = deposit;
    }

    public Long getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Long cardRegistrationDate) {
        this.registrationDate = cardRegistrationDate;
    }

    public boolean isDeposit() {
        return isDeposit;
    }

    public String getTextRegistrationDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        Date date = new Date(registrationDate);

        return dateFormat.format(date);
    }

    @Override
    public String toString() {

        return "CustomerStatementsCard{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", isDeposit=" + isDeposit +
                '}';
    }
}
