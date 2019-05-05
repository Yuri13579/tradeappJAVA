package nik.trade.tradeapp2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Customer {
    @Id
    private String id;
    private String name;
    private String addres;
    private long phone;
    private String  contactPerson;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return phone == customer.phone &&
                Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(addres, customer.addres) &&
                Objects.equals(contactPerson, customer.contactPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, addres, phone, contactPerson);
    }

    public Customer() {
    }

    public Customer(String id, String name, String addres, long phone, String contactPerson) {
        this.id = id;
        this.name = name;
        this.addres = addres;
        this.phone = phone;
        this.contactPerson = contactPerson;
    }

    public Customer(String name, String addres, long phone, String contactPerson) {
        this.name = name;
        this.addres = addres;
        this.phone = phone;
        this.contactPerson = contactPerson;
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


}
