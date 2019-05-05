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
/*    @Autowired
    GoodServiceImpl goodService;
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    OrderServiceImpl orderService;



    private List<Good> goods = new ArrayList<>(
                Arrays.asList(
                        new Good("Gala",20, 17,"Gala 500ml"),
                        new Good("Palmolive",33,28,"Palmolive 350 ml"),
                        new Good("Pantine",18,15,"Pantine 250 ml"),
                        new Good("Dishware4",21,16,"Ashan")
        ));

    private List<Customer> customers = new ArrayList<>(
            Arrays.asList(
                new Customer("Roma","Kolovyiska 12",857,"Lida"),
                    new Customer("Niva","Holovna 123",691,"Katya"),
                    new Customer("Depot","Holovna 214",857,"Bob"),
                    new Customer("Orange","Holovna 233",3324,"Jack")

            ));

    private  List<Order> orders= new ArrayList<>(
            Arrays.asList(

                    new Order( LocalDate.now(),goodService.getAll().get(0) , customerService.getAll().get(0), 23,13 ),
                    new Order( LocalDate.now(),goodService.getAll().get(1) , customerService.getAll().get(1), 33,23 ),
                    new Order( LocalDate.now(),goodService.getAll().get(2) , customerService.getAll().get(2), 41,40 ),
                    new Order( LocalDate.now(),goodService.getAll().get(3) , customerService.getAll().get(3), 51,23 ),
                    new Order( LocalDate.now(),goodService.getAll().get(4) , customerService.getAll().get(4),14,34 )



            )
    );



   // public List<Good> getGoods() {
     //       return goods;
     //   }
      //  public List<Order> getOrders(){ return orders; }
    @PostConstruct
    void init(){
         //   customerService.createAll(customers);
    //   goodService.createAll(goods);
      //  orderService.createAll(orders);
    }*/

}
