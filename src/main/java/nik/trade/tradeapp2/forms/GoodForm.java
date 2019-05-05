package nik.trade.tradeapp2.forms;

public class GoodForm {

    private String id;
    private String name;
    private int price;
    private int purchasePrise;
    private String description;

    public int getPurchasePrise() {
        return purchasePrise;
    }

    public void setPurchasePrise(int purchasePrise) {
        this.purchasePrise = purchasePrise;
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
                ", purchasePrise=" + purchasePrise +
                ", Description='" + description + '\'' +
                '}';
    }
}
