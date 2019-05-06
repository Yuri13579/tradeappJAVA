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
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

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


    @PostConstruct
    void init(){
        List<Order> orders= new ArrayList<>();

       for (int i=0; i<200; i++){
            Random rand = new Random();
            int x = rand.nextInt(9);
           Random rand2 = new Random();
           int y = rand.nextInt(9);
           ////System.out.println(" x "+x+" y "+y);
           Order o= new Order(RandDate(),
                   goodService.getAll().get(x),
                   customerService.getAll().get(y),
                   x+y,
                   goodService.getAll().get(x).getPrice());

           orders.add(o);

        }

      ///Order o1= new Order(RandDate(), goodService.getAll().get(2),
             /// customerService.getAll().get(3), 5, goodService.getAll().get(2).getPrice());
     /////   orderRepository.deleteAll();
        orderRepository.saveAll(orders);

    }

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

    public double getTotalSumm(){
        return this.getAll().stream()
                .mapToDouble(order->order.getCount()*order.getPriseSale())
                .sum();
    }

    public LocalDate RandDate(){
    long minDay = LocalDate.of(2019, 1, 1).toEpochDay();
    long maxDay = LocalDate.of(2019, 4, 28).toEpochDay();
    long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
   return LocalDate.ofEpochDay(randomDay);
    }
}
