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
 //   private int amount;
    private LocalDate date;
    private Good good;
    private Customer customer;
    private double count;
    private double summ;
    private double priseSale;
    private double profit;
    private double margin;

    public double getPriseSale() {
        return priseSale;
    }

    public void setPriseSale(double priseSale) {
        this.priseSale = priseSale;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
        //this.profit= (this.priseSale - this.good.getPurchasePrise()) * this.count;
    }

    public double getMargin() {
        return this.margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }



    public double getSumm() {
        return summ;
    }

    public void setSumm(double summ) {
        this.summ = summ;
    }



    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }



    public Order( LocalDate date, Good good, Customer customer, double count, double priseSale) {
      //  this.amount = amount;
        this.date = date;
        this.good = good;
        this.customer = customer;
        this.count= count;
        this.priseSale= priseSale;
        this.summ = this.priseSale* this.count;
        this.profit= (this.priseSale - this.good.getPurchasePrise()) * this.count;
        this.margin= this.priseSale/ this.good.getPurchasePrise();
    }


    public Order(String id, LocalDate date, Good good, Customer customer, double count, double priseSale) {
        this.id = id;
       // this.amount = amount;
        this.date = date;
        this.good = good;
        this.customer = customer;
        this.count= count;
        this.summ = this.priseSale * this.count;
        this.priseSale= priseSale;
        this.profit= (this.priseSale - this.good.getPurchasePrise()) * this.count;
        this.margin= this.priseSale/ this.good.getPurchasePrise();
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getGoodName() {
        return good.getName();
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


