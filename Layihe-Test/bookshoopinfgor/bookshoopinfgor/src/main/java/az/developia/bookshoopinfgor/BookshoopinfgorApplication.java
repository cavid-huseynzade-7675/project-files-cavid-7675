package az.developia.bookshoopinfgor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import az.developia.bookshoopinfgor.dao.BookDao;
import az.developia.bookshoopinfgor.model.BookModel;
import javafx.application.Application;

@SpringBootApplication
public class BookshoopinfgorApplication {

	public static void main(String[] args) {
		ApplicationContext context = 	SpringApplication.run(BookshoopinfgorApplication.class, args);
		BookDao	repository=context.getBean(BookDao.class);
		BookModel bookModel=new BookModel();
		bookModel.setName("Css");
	//	repository.save(bookModel);
	}

}
