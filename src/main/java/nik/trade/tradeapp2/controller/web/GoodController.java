package nik.trade.tradeapp2.controller.web;


import nik.trade.tradeapp2.forms.GoodForm;
import nik.trade.tradeapp2.model.Good;
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
public class GoodController {
    @Autowired
    GoodServiceImpl goodService;
    @Autowired
    OrderServiceImpl orderService;


    @RequestMapping(value = {"/", "/index"}, method  = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("message", "Hello world!");
        return "index";
    }

    @RequestMapping(value = "/good/list", method = RequestMethod.GET)
    public String goodList(Model model){
        model.addAttribute("goods", goodService.getAll() );
        return "goodList";
    }


    @RequestMapping(value = "/good/delete/{id}", method = RequestMethod.GET)
    public String deleteGood(Model model, @PathVariable("id") String id){
        goodService.delete(id);
        model.addAttribute("goods", goodService.getAll());
        return "goodList";
    }


    @RequestMapping(value = "/good/add", method = RequestMethod.GET)
    public String addGood(Model model){
        GoodForm goodForm= new GoodForm();

        Map<String, String> mavs = goodService.getAll().stream()
                .collect(Collectors.toMap(Good::getId, Good::getName));

        model.addAttribute("mavs", mavs);
        model.addAttribute("goodForm", goodForm);
        return "addGood";

    }

    @RequestMapping(value = "/good/add", method = RequestMethod.POST)
    public String addGood(Model model,
                          @ModelAttribute("goodForm") GoodForm goodForm){

        //Good good = goodService.get(goodForm.getId());

        Good newGood = new Good(goodForm.getName(), goodForm.getPrice(),
                goodForm.getDelivery(),goodForm.getDescription());
        goodService.create(newGood);
        model.addAttribute("students", goodService.getAll());
        return "redirect:/good/list";
    }


    @RequestMapping(value = "/good/edit/{id}", method = RequestMethod.GET)
    public String editGood(Model model, @PathVariable("id") String id){

        Good s = goodService.get(id);
        /*
        Map<String, String> mavs = groupService.getAll().stream()
                .collect(Collectors.toMap(Group::getId, Group::getName));
        */

        Map<String, String> mavs = goodService.getAll().stream()
                .collect(Collectors.toMap(Good::getId, Good::getName));

        GoodForm goodForm = new GoodForm();
        goodForm.setId(s.getId());
        goodForm.setName(s.getName());
        goodForm.setPrice(s.getPrice());
        goodForm.setDelivery(s.getDelivery());
        goodForm.setDescription(s.getDescription());

        model.addAttribute("goodForm", goodForm);
        model.addAttribute("mavs", mavs);
        return "editGood";
    }

    @RequestMapping(value = "/good/edit/{id}", method = RequestMethod.POST)
    public String editGood(Model model,
                              @ModelAttribute("goodForm") GoodForm goodForm,
                              @PathVariable("id") String id){

        Good s = new Good();
       // Good good = goodService.get(studentForm.getGroup());

        s.setId(goodForm.getId());
        s.setName(goodForm.getName());
        s.setPrice(goodForm.getPrice());
        s.setDelivery(goodForm.getDelivery());
        s.setDescription(goodForm.getDescription());

        goodService.update(s);
        model.addAttribute("goodForm", goodForm);
       // return "goodList";
        return "redirect:/good/list";
    }
    @RequestMapping(value = "/good/saleGood/{id}", method = RequestMethod.GET)
    public String saleGood(Model model, @PathVariable("id") String id){

        Good good = goodService.get(id);
        Integer count=0;
        count= orderService.getAll().stream().filter(s ->s.getGood().getName().equals(good.getName())).mapToInt(s ->s.getSumm()).sum();
        System.out.println("/good/saleGood/{id}"+count);
        model.addAttribute(count);
        model.addAttribute(good.getName());

        return "saleGood";
    }






}


