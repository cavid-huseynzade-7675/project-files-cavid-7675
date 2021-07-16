	package az.developia.bookmangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.bookmangement.model.Book;
import az.developia.bookmangement.service.BookService;

@RestController
@RequestMapping(path = "/books")
@CrossOrigin(origins = "*")

public class BookRestController {

	@Autowired
	private BookService bookService;


	
	@GetMapping
	public List<Book> findAll() { 
		return bookService.findAll();
	}
	
	@PostMapping
	public void add(@RequestBody Book book){
		 
		bookService.add(book);
	}



}
