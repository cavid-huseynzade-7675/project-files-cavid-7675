package az.developia.bookshoopinfgor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import az.developia.bookshoopinfgor.dao.BookDao;
import az.developia.bookshoopinfgor.file.StorageProperties;
import az.developia.bookshoopinfgor.file.StorageService;
import az.developia.bookshoopinfgor.model.BookModel;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class BookshoopinfgorApplication {

	public static void main(String[] args) {
			SpringApplication.run(BookshoopinfgorApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storage){
		return (args)->{
			storage.init();
		};
	}
}
