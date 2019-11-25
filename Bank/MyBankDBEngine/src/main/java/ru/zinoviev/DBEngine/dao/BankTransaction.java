package ru.zinoviev.DBEngine.dao;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;


//@Entity
//@Table(name = "transaction")
public class BankTransaction implements BankUnit{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactonId")
    private long transactonId;

    @Column(name = "senderId")
    private long senderId;

    @Column(name = "sender")
    private String sender;

    @Column(name = "receiverId")
    private long receiverId;

    @Column(name = "dateTime")
    private long dateTime;

    @Column(name = "value")
    private double value;

    @Column(name = "executed")
    private boolean executed;

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        Date date = new Date(dateTime);

        return "BankTransaction{" +
                "transactonId=" + transactonId +
                ", senderId=" + senderId +
                ", sender='" + sender + '\'' +
                ", receiverId=" + receiverId +
                ", dateTime=" + dateFormat.format(date) +
                ", value=" + value +
                ", executed=" + executed +
                '}';
    }
}
