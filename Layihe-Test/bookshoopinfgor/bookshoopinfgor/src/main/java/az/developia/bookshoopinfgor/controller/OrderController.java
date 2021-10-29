package az.developia.bookshoopinfgor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.bookshoopinfgor.config.Mysession;
import az.developia.bookshoopinfgor.dao.CustomerDAO;
import az.developia.bookshoopinfgor.dao.OrderDAO;
import az.developia.bookshoopinfgor.model.Customer;
import az.developia.bookshoopinfgor.model.Order;
import az.developia.bookshoopinfgor.service.OrderService;

@Controller
public class OrderController {

    @Autowired
    private Mysession mysession;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping(path = "/orders")
    public String showOrdersPage(Model model) {
        
        model.addAttribute("orders", orderDAO.findAllByUsername(mysession.getUsername()));
        return "orders";
    }

    @GetMapping(path = "/confirm-order")
    public String showConfirmOrderPage(Model model) {
Customer customer=new Customer();
model.addAttribute("customer", customer);
        return "confirm-order";
    }

    @GetMapping(path = "/confirm-order-mesasge")
    public String showConfirmationOrderPage() {

        return "order-confirmation-message";
    }


    @PostMapping(path = "/confirm-order-procces")
    public String confirmOrderProcces(@Valid @ModelAttribute(name = "customer") Customer customer,BindingResult result) {
        if (result.hasErrors()) {
            return "confirm-order";
        }
        Customer customerFindByPhone=customerDAO.findByPhone(customer.getPhone());
        if (customerFindByPhone==null) {
            
            Customer customerFindByEmail=customerDAO.findByEmail(customer.getEmail());
            if (customerFindByEmail==null) {
                
            } else {
                Integer id=customerFindByEmail.getId();
                customer.setId(id);
                customerDAO.save(customer);
                    customer=customerDAO.findById(id).get();
            }

        } else {
            Integer id=customerFindByPhone.getId();
            customer.setId(id);
            customerDAO.save(customer);
                customer=customerDAO.findById(id).get();
        }
        orderService.save(customer);
        return "order-confirmation-message";
    }
}
