package az.developia.shopmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import az.developia.shopmanagement.dao.ShopRepository;
import az.developia.shopmanagement.model.Shop;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
 
public class ShopManagementAprel11Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ShopManagementAprel11Application.class, args);

		ShopRepository	repository=context.getBean(ShopRepository.class);

		Shop shop=new Shop();
		shop.setName("Acer");
		shop.setStatus("Yaxi");
		shop.setBeginDate(Date.valueOf(LocalDate.now()));
		shop.setDescription("Bla Bla");
		shop.setCategoryid(5);
		shop.setUsername("Cavid");
		shop.setPrice(25);




	//	repository.save(shop);
	 
	}

}
