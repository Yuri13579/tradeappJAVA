package nik.trade.tradeapp2.controller.web;

import nik.trade.tradeapp2.forms.CustomerForm;
import nik.trade.tradeapp2.forms.GoodForm;
import nik.trade.tradeapp2.model.Customer;
import nik.trade.tradeapp2.model.Good;
import nik.trade.tradeapp2.service.good.impl.CustomerServiceImpl;
import nik.trade.tradeapp2.service.good.impl.GoodServiceImpl;
import nik.trade.tradeapp2.service.good.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    OrderServiceImpl orderService;

    @RequestMapping(value = "/customer/list", method = RequestMethod.GET)
    public String customerList(Model model){
        model.addAttribute("customers", customerService.getAll() );
        return "customerList";
    }

    @RequestMapping(value = "/customer/delete/{id}", method = RequestMethod.GET)
    public String deleteCustomer(Model model, @PathVariable("id") String id){
        customerService.delete(id);
        model.addAttribute("customers", customerService.getAll());
        return "redirect:/customer/list";

    }


    @RequestMapping(value = "/customer/add", method = RequestMethod.GET)
    public String addGood(Model model){
        CustomerForm customerForm= new CustomerForm();

        Map<String, String> mavs = customerService.getAll().stream()
                .collect(Collectors.toMap(Customer::getId, Customer::getName));

        model.addAttribute("mavs", mavs);
        model.addAttribute("customerForm", customerForm);
        return "addCustomer";

    }

    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
    public String addGCustomer(Model model,
                          @ModelAttribute("customerForm") CustomerForm customerForm){

        //Good good = goodService.get(goodForm.getId());

        Customer newCustomer = new Customer(customerForm.getId(),customerForm.getName(),
                customerForm.getAddres(),customerForm.getPhone(),customerForm.getContactPerson());
        customerService.create(newCustomer);
        model.addAttribute("customers", customerService.getAll());
        return "redirect:/customer/list";
    }

    @RequestMapping(value = "/customer/edit/{id}", method = RequestMethod.GET)
    public String editCustomer(Model model, @PathVariable("id") String id){

        Customer s = customerService.get(id);
        /*
        Map<String, String> mavs = groupService.getAll().stream()
                .collect(Collectors.toMap(Group::getId, Group::getName));
        */

        Map<String, String> mavs = customerService.getAll().stream()
                .collect(Collectors.toMap(Customer::getId, Customer::getName));

        CustomerForm customerForm = new CustomerForm();
        customerForm.setId(s.getId());
        customerForm.setName(s.getName());
        customerForm.setAddres(s.getAddres());
        customerForm.setPhone(s.getPhone());
        customerForm.setContactPerson(s.getContactPerson());

        model.addAttribute("customerForm", customerForm);
        model.addAttribute("mavs", mavs);
        return "editCustomer";
    }

    @RequestMapping(value = "/customer/edit/{id}", method = RequestMethod.POST)
    public String editCustomer(Model model,
                           @ModelAttribute("customerForm") CustomerForm customerForm,
                           @PathVariable("id") String id){

        Customer s = new Customer();
        // Good good = goodService.get(studentForm.getGroup());

        s.setId(customerForm.getId());
        s.setName(customerForm.getName());
        s.setAddres(customerForm.getAddres());
        s.setPhone(customerForm.getPhone());
        s.setContactPerson(customerForm.getContactPerson());

        customerService.update(s);
        model.addAttribute("customerForm", customerForm);
        return "redirect:/customer/list";
    }
    @RequestMapping(value = "/customer/saleCustomer/{id}", method = RequestMethod.GET)
    public String saleCustomer(Model model, @PathVariable("id") String id){

        Customer customer = customerService.get(id);
        Integer count=0;
        count= orderService.getAll().stream().filter(s ->s.getCustomer() .getName().equals(customer.getName())).mapToInt(s ->s.getSumm()).sum();
        System.out.println("/customer/saleCustomer/{id}"+count);
        model.addAttribute(count);
        model.addAttribute(customer.getName());

        return "saleGood";
    }

}
