package nik.trade.tradeapp2.forms;

import nik.trade.tradeapp2.model.Delivery;

public class GoodForm {

    private String id;
    private String name;
    private int price;
    private String delivery;
    private String description;

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GoodForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", delivery=" + delivery +
                ", Description='" + description + '\'' +
                '}';
    }
}
