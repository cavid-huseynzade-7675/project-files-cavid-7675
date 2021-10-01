package az.developia.bookshopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import az.developia.bookshopping.dao.BookDao;
import az.developia.bookshopping.model.Book;

import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class BookshoppingApplication {

	public static void main(String[] args) {
ApplicationContext context=		SpringApplication.run(BookshoppingApplication.class, args);

BookDao	repository=context.getBean(BookDao.class);

	Book order=new Book();
	order.setName("ss");

//repository.save(order);
	}

	
	
}
