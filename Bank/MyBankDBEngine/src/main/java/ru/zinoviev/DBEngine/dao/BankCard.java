package ru.zinoviev.DBEngine.dao;

import ru.zinoviev.DBEngine.dao.cardOptions.CardOptions;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cards")
public class BankCard implements BankUnit{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String cardName;

    @OneToMany(mappedBy = "card")
    private List<CustomerStatementsCard> customerStatementsCard;

    @Column
    private boolean internationalCard;

    @OneToOne
    @JoinColumn
    private CardOptions options;

    public BankCard() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public List<CustomerStatementsCard> getCustomerStatementsCard() {
        return customerStatementsCard;
    }

    public void setCustomerStatementsCard(List<CustomerStatementsCard> customerStatementsCard) {
        this.customerStatementsCard = customerStatementsCard;
    }

    public boolean isInternationalCard() {
        return internationalCard;
    }

    public void setInternationalCard(boolean internationalCard) {
        this.internationalCard = internationalCard;
    }

    public CardOptions getOptions() {
        return options;
    }

    public void setOptions(CardOptions options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "id=" + id +
                ", cardName='" + cardName + '\'' +
                ", customerStatementsCard=" + customerStatementsCard +
                ", internationalCard=" + internationalCard +
                ", options=" + options +
                '}';
    }
}
