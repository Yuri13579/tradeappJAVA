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
    private int count;
    private int summ;
    private int priseSale;
    private int profit;
    private float margin;

    public int getPriseSale() {
        return priseSale;
    }

    public void setPriseSale(int priseSale) {
        this.priseSale = priseSale;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
        //this.profit= (this.priseSale - this.good.getPurchasePrise()) * this.count;
    }

    public float getMargin() {
        return this.margin;
    }

    public void setMargin(float margin) {
        this.margin = margin;
    }



    public int getSumm() {
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }



    public Order( LocalDate date, Good good, Customer customer, int count, int priseSale) {
      //  this.amount = amount;
        this.date = date;
        this.good = good;
        this.customer = customer;
        this.count= count;
        this.summ = this.priseSale* this.count;
        this.priseSale= priseSale;
        this.profit= (this.priseSale - this.good.getPurchasePrise()) * this.count;
        this.margin= this.priseSale/ this.good.getPurchasePrise();
    }


    public Order(String id, LocalDate date, Good good, Customer customer, int count, int priseSale) {
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


