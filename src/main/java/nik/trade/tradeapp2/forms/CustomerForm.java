package nik.trade.tradeapp2.forms;

public class CustomerForm {
    private String id;
    private String name;
    private String addres;
    private long phone;
    private String  contactPerson;


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

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    @Override
    public String toString() {
        return "CustomerForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", addres='" + addres + '\'' +
                ", phone=" + phone +
                ", contactPerson='" + contactPerson + '\'' +
                '}';
    }
}
