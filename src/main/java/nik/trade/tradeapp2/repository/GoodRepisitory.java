package nik.trade.tradeapp2.repository;

import nik.trade.tradeapp2.model.Good;
import nik.trade.tradeapp2.model.Good;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodRepisitory extends MongoRepository <Good, String> {


    List<Good> findByName(String name);
    List<Good> findByPrice(double price);
    List<Good> findByDescription(String description);
}
