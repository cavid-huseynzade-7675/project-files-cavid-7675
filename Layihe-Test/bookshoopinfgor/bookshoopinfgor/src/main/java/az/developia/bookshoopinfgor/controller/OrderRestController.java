package az.developia.bookshoopinfgor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.bookshoopinfgor.dao.OrderDAO;
import az.developia.bookshoopinfgor.model.Order;

@RestController
@RequestMapping(path = "/rest/orders")
public class OrderRestController {
   
    @Autowired
    private OrderDAO orderDAO;

    @GetMapping(path = "/{id}")
    public Order findById(@PathVariable(name="id") Integer id) {
        return orderDAO.findById(id).get();
    }

    
@PostMapping
public Order save(@RequestBody Order order){
    return orderDAO.save(order);
}

    @GetMapping
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

 //   @GetMapping(path = "/{username}")
   // public List<Order> findByAllUsername(@PathVariable(name="username") String username) {
  //      return orderDAO.findAllByUsername(username);
  //  }
}