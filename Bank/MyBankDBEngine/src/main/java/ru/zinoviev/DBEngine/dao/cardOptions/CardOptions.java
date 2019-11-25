package ru.zinoviev.DBEngine.dao.cardOptions;

import ru.zinoviev.DBEngine.dao.BankCard;
import ru.zinoviev.DBEngine.dao.BankUnit;

import javax.persistence.*;

@Entity
@Table(name = "cards_options")
public class CardOptions implements BankUnit{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private boolean cashBack;

    @Column
    private double cashBackValue;

    @Column
    private boolean freetoUse;

    @Column
    private boolean freeExchange;

    @Column
    private boolean fuelCashback;

    @Column
    private double fuelCashbackValue;

    @Column
    private boolean miles;

    @Column
    private int milesIncrementValue;

    @OneToOne(mappedBy = "options")
    private BankCard bankCard;

    public CardOptions() {

    }

    @Override
    public String toString() {
        return "CardOptions{" +
                "id=" + id +
                ", cashBack=" + cashBack +
                ", cashBackValue=" + cashBackValue +
                ", freetoUse=" + freetoUse +
                ", freeExchange=" + freeExchange +
                ", fuelCashback=" + fuelCashback +
                ", fuelCashbackValue=" + fuelCashbackValue +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCashBack() {
        return cashBack;
    }

    public void setCashBack(boolean cashBack) {
        this.cashBack = cashBack;
    }

    public double getCashBackValue() {
        return cashBackValue;
    }

    public void setCashBackValue(double cashBackValue) {
        this.cashBackValue = cashBackValue;
    }

    public boolean isFreetoUse() {
        return freetoUse;
    }

    public void setFreetoUse(boolean freetoUse) {
        this.freetoUse = freetoUse;
    }

    public boolean isFreeExchange() {
        return freeExchange;
    }

    public void setFreeExchange(boolean freeExchange) {
        this.freeExchange = freeExchange;
    }

    public boolean isFuelCashback() {
        return fuelCashback;
    }

    public void setFuelCashback(boolean fuelCashback) {
        this.fuelCashback = fuelCashback;
    }

    public double getFuelCashbackValue() {
        return fuelCashbackValue;
    }

    public void setFuelCashbackValue(double fuelCashbackValue) {
        this.fuelCashbackValue = fuelCashbackValue;
    }

    public boolean isMiles() {
        return miles;
    }

    public void setMiles(boolean miles) {
        this.miles = miles;
    }

    public int getMilesIncrementValue() {
        return milesIncrementValue;
    }

    public void setMilesIncrementValue(int milesIncrementValue) {
        this.milesIncrementValue = milesIncrementValue;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }
}
