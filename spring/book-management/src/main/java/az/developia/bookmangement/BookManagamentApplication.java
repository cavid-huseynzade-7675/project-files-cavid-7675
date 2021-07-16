package az.developia.bookmangement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import az.developia.bookmangement.dao.BookRepository;
import az.developia.bookmangement.model.Book;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
 
public class BookManagamentApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BookManagamentApplication.class, args);

		BookRepository	repository=context.getBean(BookRepository.class);
		Book book=new Book();   
		book.setPrice(500);                       
		book.setName("Master ve Margarita");
			book.setDescription("kitab bla bla haqqindadir");
			book.setSekil("images/book.png");
			book.setUsername("Cavid");
			book.setPhone("050 555 44 33");
	





		repository.save(book);
	 
	}

}
