package nik.trade.tradeapp2.forms;

import nik.trade.tradeapp2.model.Customer;
import nik.trade.tradeapp2.model.Good;
import nik.trade.tradeapp2.model.Order;

import java.time.LocalDate;
import java.util.Objects;

public class OrderForm {
    private String id;
    private int amount;
    private String date;
    private String good;
    private String customer;
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
        this.summ = this.amount* this.count;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGood() {
        return good;
    }

   /* public void setGood(String goodId) {
        this.good = good;
    }*/
   public void setGood(String good) {
       this.good = good;
   }

    public String getCustomer() {
        return customer;
    }

   /* public void setCustomerID(String customerID) {
        this.customer = customer;
    }*/

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", good='" + good + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }
}
