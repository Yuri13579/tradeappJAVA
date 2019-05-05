package nik.trade.tradeapp2.repository;

import nik.trade.tradeapp2.model.Customer;
import nik.trade.tradeapp2.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order,String> {
    List<Order> findByPriseSale(int priseSale);
    List<Order> findByDate (LocalDate date);
    List<Order> findByCustomer (Customer customer);
}
