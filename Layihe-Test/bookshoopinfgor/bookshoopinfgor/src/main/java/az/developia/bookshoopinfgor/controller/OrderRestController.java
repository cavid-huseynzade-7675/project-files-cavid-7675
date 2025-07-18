package az.developia.bookshoopinfgor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.bookshoopinfgor.config.Mysession;
import az.developia.bookshoopinfgor.dao.OrderDAO;
import az.developia.bookshoopinfgor.model.BasketBook;
import az.developia.bookshoopinfgor.model.Order;

@RestController
@RequestMapping(path = "/rest/orders")
public class OrderRestController {


    @Autowired
    private Mysession mysession;

    @Autowired
    private OrderDAO orderDAO;

    @GetMapping(path = "/{id}")
    public Order findById(@PathVariable(name = "id") Integer id) {
        return orderDAO.findById(id).get();
    }

    @PostMapping
    public List<Order> save(@RequestBody Order order) {
        ArrayList<String> usernames = new ArrayList<>();
        for (int i = 0; i < order.getBasketBooks().size(); i++) {
            BasketBook basketBook = order.getBasketBooks().get(i);
            if (usernames.contains(basketBook.getBook().getUsername())) {

            } else {
                usernames.add(basketBook.getBook().getUsername());

            } }
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < usernames.size(); i++) {
            Order o=new Order();
            o.setNote(order.getNote());
            o.setCustomer(order.getCustomer());
            double totalPrice=0;

            for (int j = 0; j < order.getBasketBooks().size(); j++) {
                if (order.getBasketBooks().get(j).getBook().getUsername().equals(usernames.get(i))) {
                    o.getBasketBooks().add(order.getBasketBooks().get(j));
                    totalPrice+=order.getBasketBooks().get(j).getBook().getPrice()*
                    order.getBasketBooks().get(j).getCount();

                }
            }

            o.setTotalPrice(totalPrice);
            o.setUsername(usernames.get(i));
            orders.add(o);
        }
return orderDAO.saveAll(orders);
    }

    @GetMapping
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @GetMapping(path = "/{username}")
    public List<Order> findByAllUsername(@PathVariable(name = "username") String username) {
        return orderDAO.findAllByUsername(username);
    }

    @PostMapping(path = "/save-basket-books")
    public Boolean saveBasketBooks(@RequestBody List<BasketBook> basketBooks) {

System.out.println(basketBooks);
mysession.setBasketBooks(basketBooks);

        return true;
        
    }
}