package az.developia.shopmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import az.developia.shopmanagement.dao.CategoryRepository;
import az.developia.shopmanagement.dao.ShopRepository;
import az.developia.shopmanagement.model.Category;
import az.developia.shopmanagement.model.Shop;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
 
public class ShopManagementAprel11Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ShopManagementAprel11Application.class, args);

		CategoryRepository	repository=context.getBean(CategoryRepository.class);

		Category category=new Category();
		category.setCategory("Telefon");
		



		//repository.save(category);
	

	}

}
