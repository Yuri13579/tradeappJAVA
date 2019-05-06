package nik.trade.tradeapp2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Good {
    @Id
    private String id;
    private String name;
    private double purchasePrise;
    private double price;
    private String description;

    public double getPurchasePrise() {
        return purchasePrise;
    }

    public void setPurchasePrise(double purchasePrise) {
        this.purchasePrise = purchasePrise;
    }

    public Good(String name, double purchasePrise, double price,  String description) {
        this.name = name;
        this.purchasePrise = purchasePrise;
        this.price = price;
        this.description = description;
    }

    public Good(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Good(String id, String name, double purchasePrise, double price,  String description) {
        this.id = id;
        this.name = name;
        this.purchasePrise = purchasePrise;
        this.price = price;
        this.description = description;
    }

    public Good() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return Objects.equals(id, good.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Good{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", purchasePrise=" + purchasePrise +
                ", Description='" + description + '\'' +
                '}';
    }
}
