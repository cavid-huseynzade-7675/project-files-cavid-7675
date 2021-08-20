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

import az.developia.shopmanagement.model.Basket;

import az.developia.shopmanagement.service.BasketService;

@RestController
@RequestMapping(path = "/baskets")
@CrossOrigin(origins = "*")
public class BasketRestController {
    @Autowired
	private BasketService basketService;


	
	@GetMapping
	public List<Basket> findAll() { 
		return basketService.findAll();
	}
	

	@DeleteMapping(value = "/{id}")
	public void deleteShopById(@PathVariable Integer id){
	basketService.deleteById(id);
	}

	
	@PostMapping
	public Basket add( @RequestBody Basket basket){
	
		return 	basketService.add(basket);
		

}}
