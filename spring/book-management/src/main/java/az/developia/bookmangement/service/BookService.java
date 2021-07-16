package az.developia.bookmangement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.bookmangement.dao.BookRepository;
import az.developia.bookmangement.model.Book;

import org.hibernate.cfg.IdGeneratorResolverSecondPass;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepositry;
	
	public List<Book> findAll(){
		return bookRepositry.findAll();
	}
	public void add(Book t){

bookRepositry.save(t);
		;
	}

	
	
}
