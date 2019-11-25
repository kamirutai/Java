package ru.zinoviev.DBEngine.dao;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
public class BankCustomer implements BankUnit {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String patronymic;

    @Column
    private String lastName;

    @Column
    private int age;

    @Column
    private String adress;

    @Column
    private Long registrationDate;

    @Column
    private int status;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CreditCustomer> customerCredits;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CustomerStatementsCard> statements;

    public BankCustomer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Long getRegistrationDate() {
        return registrationDate;
    }

    public String getTextRegistrationDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        Date date = new Date(registrationDate);

        return dateFormat.format(date);
    }

    public void setRegistrationDate(Long registrationDate){
    this.registrationDate = registrationDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<CreditCustomer> getCustomerCredits() {
        return customerCredits;
    }

    public void setCustomerCredits(List<CreditCustomer> customerCredits) {
        this.customerCredits = customerCredits;
    }

    public List<CustomerStatementsCard> getStatements() {
        return statements;
    }

    public void setStatements(List<CustomerStatementsCard> statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        Date date = new Date(registrationDate);

        return "BankCustomer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", adress='" + adress + '\'' +
                ", registrationDate=" + dateFormat.format(date) +
                '}';
    }
}
