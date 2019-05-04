package nik.trade.tradeapp2.data;

import nik.trade.tradeapp2.model.*;
import nik.trade.tradeapp2.model.Good;
import nik.trade.tradeapp2.repository.GoodRepisitory;
import nik.trade.tradeapp2.repository.OrderRepository;
import nik.trade.tradeapp2.service.good.impl.CustomerServiceImpl;
import nik.trade.tradeapp2.service.good.impl.GoodServiceImpl;
import nik.trade.tradeapp2.service.good.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class FakeDataSource {
    @Autowired
    GoodServiceImpl goodService;
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    OrderServiceImpl orderService;



    private List<Good> goods = new ArrayList<>(
                Arrays.asList(
                        new Good("Dishware",20, "","Gala"),
                        new Good("Dishware2",33,"","Faity"),
                        new Good("Dishware3",18,"","MG"),
                        new Good("Dishware4",21,"","Ashan")
        ));

    private List<Customer> customers = new ArrayList<>(
            Arrays.asList(
                new Customer("Roma","Kolovyiska",857,"Lida"),
                    new Customer("Niva","Holovna",691,"Katya")

            ));

    private  List<Order> orders= new ArrayList<>(
            Arrays.asList(

                 /*   new Order(13, LocalDate.now(),goodService.getAll().get(0) , customerService.getAll().get(0) ),
                    new Order(13, LocalDate.now(),goodService.getAll().get(1) , customerService.getAll().get(1) ),
                    new Order(13, LocalDate.now(),goodService.getAll().get(2) , customerService.getAll().get(2) ),
                    new Order(13, LocalDate.now(),goodService.getAll().get(3) , customerService.getAll().get(3) ),
                    new Order(13, LocalDate.now(),goodService.getAll().get(4) , customerService.getAll().get(4) )*/



            )
    );




    public List<Good> getGoods() {
            return goods;
        }
      //  public List<Order> getOrders(){ return orders; }
    @PostConstruct
    void init(){
            // customerService.createAll(customers);
       //goodService.createAll(goods);
      //  orderService.createAll(orders);
    }

}
