package nik.trade.tradeapp2.service.good.impl;

import nik.trade.tradeapp2.model.Good;
import nik.trade.tradeapp2.repository.GoodRepisitory;
import nik.trade.tradeapp2.service.good.interfaces.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GoodServiceImpl implements IGoodService {

    private static List<Good> goods = new ArrayList<>();

    @Autowired
    GoodServiceImpl goodService;

    @Autowired
    GoodRepisitory repisitory;

   /* @PostConstruct
    void init(){
        List<Good> goods= new ArrayList<>(
                Arrays.asList(
                        new Good(" H&S 200мл Цитрус", 33, 40, "Шампунь H&S; 200 мл ЦИТРУСОВАЯ СВЕЖЕСТЬ"),
                        new Good("Shamtu 380мл",    56, 64, "Шампунь Shamtu Травяной Коктейль 380 мл"),
                        new Good("H&S 200 мл Объем", 35, 41, "Шампунь H&S 200 мл Объем от самых корней"),
                        new Good("Pantene PRO-V Aqua Light 250мл", 35,42, "Шампунь Pantene PRO-V Aqua Light (250 мл.)"),
                        new Good("Shamtu 360 мл. в асс", 41, 49, "Шампунь Shamtu 360 мл. в ассортименте"),
                        new Good("Head & Shoulders Ментол, 2в1, 400мл", 80, 91, "Шампунь и бальзам против перхоти Head & Shoulders Ментол, 2в1, 400мл"),
                        new Good("Pantene Pro-V 400мл", 89, 98, "Шампунь Pantene Pro-V Clarifying Очищение 400мл"),
                        new Good("Herbal Essences Shampoo 250мл", 132, 143,"Herbal Essences Shampoo Repair my Hair - Восстанавливающий шампунь для поврежденных волос, 250 мл"),
                        new Good("Набір Pantene(Шамп 250мл+бальз 200мл", 117,129, "Набір Pantene (Шампунь 250мл + бальзам-ополісковач 200мл) відновлення за 3 хв, Картон")
                )
        );
           repisitory.saveAll(goods);


    }*/

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
