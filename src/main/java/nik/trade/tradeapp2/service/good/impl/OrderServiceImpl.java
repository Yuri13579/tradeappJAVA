package nik.trade.tradeapp2.service.good.impl;

import nik.trade.tradeapp2.model.Good;
import nik.trade.tradeapp2.model.Order;
import nik.trade.tradeapp2.repository.GoodRepisitory;
import nik.trade.tradeapp2.repository.OrderRepository;
import nik.trade.tradeapp2.service.good.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    private static List<Order> orders= new ArrayList<>();

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    GoodServiceImpl goodService;

    @Autowired
    CustomerServiceImpl customerService;


  /*  @PostConstruct
    void init(){
          List<Order> orders= new ArrayList<>(
                Arrays.asList(

                    new Order(13, LocalDate.now(),goodService.getAll().get(0) , customerService.getAll().get(0), 80 ),
                    new Order(16, LocalDate.now(),goodService.getAll().get(1) , customerService.getAll().get(1), 15 ),
                    new Order(17, LocalDate.now(),goodService.getAll().get(2) , customerService.getAll().get(2), 56 ),
                    new Order(11, LocalDate.now(),goodService.getAll().get(3) , customerService.getAll().get(3), 14 ),
                    new Order(15, LocalDate.now(),goodService.getAll().get(4) , customerService.getAll().get(4), 12 )

                )
        );

          orderRepository.saveAll(orders);
        System.out.println(orders);
    }*/

    @Override
    public Order create(Order order) {
        return this.orderRepository.save(order);
    }

    public List<Order> createAll(List<Order> orders) {
        return  orderRepository.saveAll(orders);
    }

    @Override
    public Order get(String id) {

        return this.orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order update(Order order) {

        return this.orderRepository.save(order);
    }



    @Override
    public void delete(String id) {
        this.orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getAll() {

        return this.orderRepository.findAll();
    }

    public int getTotalSumm(){
        return this.getAll().stream()
                .mapToInt(order->order.getAmount()*order.getGood().getPrice())
                .sum();
    }

}
