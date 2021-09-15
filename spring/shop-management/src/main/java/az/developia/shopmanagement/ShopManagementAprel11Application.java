package az.developia.shopmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


import az.developia.shopmanagement.dao.ShopRepository;
import az.developia.shopmanagement.file.StorageProperties;
import az.developia.shopmanagement.file.StorageService;

import az.developia.shopmanagement.model.Shop;



@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class ShopManagementAprel11Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ShopManagementAprel11Application.class, args);

		ShopRepository	repository=context.getBean(ShopRepository.class);

		Shop order=new Shop();
		order.setName("adini");

	//repository.save(order);
	

	}
	@Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {

            storageService.init();
        };
    }
}
