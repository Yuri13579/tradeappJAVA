package nik.trade.tradeapp2.service.good.impl;

import nik.trade.tradeapp2.model.Customer;
import nik.trade.tradeapp2.model.Good;
import nik.trade.tradeapp2.repository.CustomerRepisitory;
import nik.trade.tradeapp2.repository.GoodRepisitory;
import nik.trade.tradeapp2.service.good.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService {

    private static List<Customer> customers = new ArrayList<>();



    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    CustomerRepisitory  customerRepisitory;

      /*@PostConstruct
        void init(){
          List<Customer> customers= new ArrayList<>(
                    Arrays.asList(
                           new Customer("Roma","вул Коломийська", 564728, "Marya"),
                            new Customer("Auchan","вул Хотинська", 414728, "Marya"),
                            new Customer("Нива","вул Головна", 509364, "Ivan"),
                            new Customer("Watsons","вул Головна", 780728, "Iren"),
                            new Customer("Сільпо","вул Головна", 987223, "Marya"),
                            new Customer("КЛАСІК-КООП","вул Коломийська", 754728, "Ivan"),
                            new Customer("Eva","вул Головна", 575528, "Iren"),
                            new Customer("Prostor","вул Головна", 981334, "Olha"),
                            new Customer("Копійочка","вул Головна", 745223, "Marya")
                    )
            );
          customerRepisitory.saveAll(customers);

        }*/
    @Override
    public Customer create(Customer customer) {
        return this.customerRepisitory.save(customer);
    }

    public List<Customer> createAll(List<Customer> customers) {
        return customerRepisitory.saveAll(customers);
    }

    @Override
    public Customer get(String id) {
        return this.customerRepisitory.findById(id).orElse(null);
    }


    @Override
    public Customer update(Customer customer) {
        return this.customerRepisitory.save(customer);
    }

    @Override
    public void delete(String id) {
        this.customerRepisitory.deleteById(id);
    }

    @Override
    public List<Customer> getAll() {

        return this.customerRepisitory.findAll();
    }



}
