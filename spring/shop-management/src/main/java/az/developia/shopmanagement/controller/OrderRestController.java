package az.developia.shopmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import az.developia.shopmanagement.model.Orders;
import az.developia.shopmanagement.service.OrderService;

@RestController
@RequestMapping(path = "/orders")
@CrossOrigin(origins = "*")
public class OrderRestController {
    @Autowired
	private OrderService orderService;


	
	@GetMapping
	public List<Orders> findAll() { 
		return orderService.findAll();
	}
	

	@DeleteMapping(value = "/{id}")
	public void deleteOrderById(@PathVariable Integer id){
	orderService.deleteById(id);
	}

	
	@PostMapping
	public Orders add( @RequestBody Orders order){
	
		return 	orderService.add(order);
		

}}
