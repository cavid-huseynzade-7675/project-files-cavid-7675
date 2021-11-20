package az.developia.compshopcavidhuseynzade;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import az.developia.compshopcavidhuseynzade.file.StorageProperties;
import az.developia.compshopcavidhuseynzade.file.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class CompShopCavidHuseynzadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompShopCavidHuseynzadeApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storage){
		return (args)->{
			storage.init();
		};
	}
}
