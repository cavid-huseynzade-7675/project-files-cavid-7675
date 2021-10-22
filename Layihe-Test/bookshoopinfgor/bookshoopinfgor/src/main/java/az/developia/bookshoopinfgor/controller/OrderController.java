package az.developia.bookshoopinfgor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import az.developia.bookshoopinfgor.dao.OrderDAO;
import az.developia.bookshoopinfgor.model.Order;

@Controller
public class OrderController {
    
    @Autowired
    private OrderDAO orderDAO;


    @GetMapping(path = "/orders")
    public String showOrdersPage( Model model){
        List<Order> orders=orderDAO.findAll();
        model.addAttribute("orders", orders);
        return "orders";
    }
    @GetMapping(path = "/confirm-order")
        public String showConfirmOrderPage(){
         
            return "confirm-order";
        }
    
}
