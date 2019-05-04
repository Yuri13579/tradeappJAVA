package nik.trade.tradeapp2.service.good.impl;

import nik.trade.tradeapp2.model.Good;
import nik.trade.tradeapp2.repository.GoodRepisitory;
import nik.trade.tradeapp2.service.good.interfaces.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodServiceImpl implements IGoodService {

    private static List<Good> goods = new ArrayList<>();

    @Autowired
    GoodServiceImpl goodService;

    @Autowired
    GoodRepisitory repisitory;

    @PostConstruct
    void init(){
        System.out.println(repisitory.findAll());
    }

    @Override
    public Good create(Good good) {
        return this.repisitory.save(good);
    }


    public List<Good> createAll(List<Good> goods) {
        return repisitory.saveAll(goods);  }

        @Override
    public Good get(String id) {

        return this.repisitory.findById(id).orElse(null);
    }

    @Override
    public Good update(Good good) {

        return this.repisitory.save(good);
    }

    @Override
    public void delete(String id) {
        this.repisitory.deleteById(id);
    }

    @Override
    public List<Good> getAll() {

        return this.repisitory.findAll();
    }
}
