package ru.zinoviev.DBEngine.dao;

import javax.persistence.*;

@Entity
@Table(name = "statements")
public class BankStatement implements BankUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Long statementNumber;

    @Column
    private double value;

    @OneToOne(mappedBy = "statement", cascade = CascadeType.ALL)
    private CustomerStatementsCard customerStatementsCardId;

    public BankStatement() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStatementNumber() {
        return statementNumber;
    }

    public void setStatementNumber(Long statementNumber) {
        this.statementNumber = statementNumber;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public CustomerStatementsCard getCustomerStatementsCardId() {
        return customerStatementsCardId;
    }

    public void setCustomerStatementsCardId(CustomerStatementsCard customerStatementsCardId) {
        this.customerStatementsCardId = customerStatementsCardId;
    }

    @Override
    public String toString() {
        return "BankStatement{" +
                "id=" + id +
                ", statementNumber=" + statementNumber +
                ", value=" + value +
                '}';
    }
}
