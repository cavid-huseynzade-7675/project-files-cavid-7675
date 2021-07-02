package az.developia.computermangement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import az.developia.computermangement.dao.ComputerRepository;
import az.developia.computermangement.model.Computer;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
 
public class ComputerManagamentApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ComputerManagamentApplication.class, args);

		ComputerRepository	repository=context.getBean(ComputerRepository.class);
/*
		Computer computer=new Computer();   
		computer.setPrice(500);                       
		computer.setName("Asus");
			computer.setDescription("islemesi");
			computer.setNeew("Yeni");
			computer.setCategoryname("Asus");
			computer.setUsername("Cavid");
			computer.setPhone("050 216 48 06");
			computer.setRam("64 gb");
			computer.setCpu("i9 11900K");
		computer.setGpu("RTX 3090 ti");
			computer.setStorage("1 tb");
		computer.setStoragetype("CCD");
			computer.setWind("Windows 11");




		repository.save(computer);
	 */
	}

}
