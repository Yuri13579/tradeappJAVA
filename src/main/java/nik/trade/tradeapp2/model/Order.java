package nik.trade.tradeapp2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Document
public class Order {
    @Id
    private String id;
    private int amount;
    private LocalDate date;
    private Good good;
    private Customer customer;
    private int count;
    private int summ;

    public int getSumm() {
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = this.amount* this.count;
    }



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Order{" +
                "amount=" + amount +
                '}';
    }

    public Order(int amount, LocalDate date, Good good, Customer customer, int count) {
        this.amount = amount;
        this.date = date;
        this.good = good;
        this.customer = customer;
        this.count= count;
        this.summ = this.amount* this.count;
    }

    public Order(String id, int amount, LocalDate date, Good good, Customer customer, int count) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.good = good;
        this.customer = customer;
        this.count= count;
        this.summ = this.amount* this.count;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


