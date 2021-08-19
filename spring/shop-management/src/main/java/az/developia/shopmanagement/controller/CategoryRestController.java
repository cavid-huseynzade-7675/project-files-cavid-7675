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

import az.developia.shopmanagement.model.Category;
import az.developia.shopmanagement.service.CategoryService;

@RestController
@RequestMapping(path = "/categories")
@CrossOrigin(origins = "*")
public class CategoryRestController {
    @Autowired
	private CategoryService categoryService;


	
	@GetMapping
	public List<Category> findAll() { 
		return categoryService.findAll();
	}
	

	@DeleteMapping(value = "/{id}")
	public void deleteShopById(@PathVariable Integer id){
	categoryService.deleteById(id);
	}

	
	@PostMapping
	public Category add( @RequestBody Category category){
	
		return 	categoryService.add(category);
		

}}
