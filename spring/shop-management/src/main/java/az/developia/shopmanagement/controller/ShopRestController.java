	package az.developia.shopmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.shopmanagement.error.ShopValidationError;
import az.developia.shopmanagement.model.Shop;
import az.developia.shopmanagement.model.shopDeleteModel;
import az.developia.shopmanagement.service.ShopService;

@RestController
@RequestMapping(path = "/shops")
@CrossOrigin(origins = "*")

public class ShopRestController {

	@Autowired
	private ShopService shopService;


	
	@GetMapping
	public List<Shop> findAll() { 
		return shopService.findAll();
	}

	@GetMapping(path="/user/{username}")
	public List<Shop> findAllByUsername(@PathVariable String username) { 
		return shopService.findAllByUsername(username);
	}

	@GetMapping(path="/user/{username}/{search}")
	public List<Shop> findAllByUsernameSearch(@PathVariable String username,@PathVariable String search) { 
		return shopService.findAllByUsernameSearch(username,search);
	}

	@PostMapping
	public Shop add(@Valid @RequestBody Shop shop,BindingResult result){
		Shop shopSaved=null;
		if (result.hasErrors()) {
			throw new ShopValidationError(result);

		}else{
			shopSaved=shopService.add(shop);
		}
	 return shopSaved;
	}

	@DeleteMapping(value = "/delete-shop")
	public void deleteShops(@RequestBody shopDeleteModel t1){
	for (int i = 0; i < t1.getIds().size(); i++) {
		shopService.deleteById(t1.getIds().get(i));
	}
	}

	@DeleteMapping(value = "/{id}")
	public void deleteShopById(@PathVariable Integer id){
	shopService.deleteById(id);
	}
	@PutMapping
	public Shop uptade(@Valid @RequestBody Shop shop,BindingResult result){
		Shop shopSaved=null;
		if (result.hasErrors()) {
			throw new ShopValidationError(result);
			 

		}else{
			shopSaved=shopService.add(shop);
		}
	 return shopSaved;
	}
}
