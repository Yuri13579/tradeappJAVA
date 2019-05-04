package nik.trade.tradeapp2.controller.web;

import nik.trade.tradeapp2.forms.GoodForm;
import nik.trade.tradeapp2.forms.OrderForm;
import nik.trade.tradeapp2.model.Customer;
import nik.trade.tradeapp2.model.Good;
import nik.trade.tradeapp2.model.Order;
import nik.trade.tradeapp2.service.good.impl.CustomerServiceImpl;
import nik.trade.tradeapp2.service.good.impl.GoodServiceImpl;
import nik.trade.tradeapp2.service.good.impl.OrderServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    GoodServiceImpl goodService;

    @Autowired
    CustomerServiceImpl customerService;


    @RequestMapping(value = "/order/list", method = RequestMethod.GET)
    public String orderList(Model model){
        model.addAttribute("orders", orderService.getAll() );
        return "orderList";
    }

    @RequestMapping(value = "/order/add", method = RequestMethod.GET)
    public String addOrder(Model model){

        OrderForm orderForm = new OrderForm();
        Map<String, String> mavsGood = goodService.getAll().stream()
               .collect(Collectors.toMap(Good::getId, Good::getName));
        Map<String, String> mavsCustomer= customerService.getAll().stream()
               .collect(Collectors.toMap(Customer::getId, Customer::getName));

        model.addAttribute("mavsGood", mavsGood);
        model.addAttribute("mavsCustomer", mavsCustomer);
        model.addAttribute("orderForm", orderForm);


        return "addOrder";

    }

    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public String addGood(Model model,
                          @ModelAttribute("orderForm") OrderForm orderForm ){

        Customer customer= customerService.get(orderForm.getCustomer());
        Good good= goodService.get(orderForm.getGood());
        Order newOrder= new Order(orderForm.getId(), orderForm.getAmount(),
        LocalDate.parse(orderForm.getDate()) , good, customer, orderForm.getCount());
        orderService.create(newOrder);


  /*      Customer customer= customerService.getAll().stream()
                .filter(customer1 -> customer1.getName().equals(orderForm.getCustomer())).findFirst().orElse(null);
        System.out.println("********orderForm.getCustomer()"+ orderForm.getCustomer());
        Good good= goodService.getAll().stream()
                .filter(good1 -> good1.getName().equals(orderForm.getGood())).findFirst().orElse(null);
        System.out.println("*******orderForm.getGood()"+ orderForm.getGood());
        System.out.println(orderForm.toString());
        Order newOrder  = new Order( orderForm.getAmount(), LocalDate.parse(orderForm.getDate()), good,customer, orderForm.getCount());

        if ((good != null)&&(customer != null)) {
        orderService.create(newOrder);
        }
        else System.out.println("good = "+ good+"customer = "+customer);
        model.addAttribute("orders", orderService.getAll());*/
        return "redirect:/order/list";
    }


    @RequestMapping(value = "/order/summ", method = RequestMethod.GET)
    public String orderSumm(Model model){

        Integer count=0;
        count= orderService.getAll().stream().filter(s ->s.getSumm()>0 ).mapToInt(s ->s.getSumm()).sum();
        System.out.println(count);
        model.addAttribute(count);
        return "orderSumm";
    }

}
