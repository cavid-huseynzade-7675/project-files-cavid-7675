package az.developia.taskmanagementaprel11;

import az.developia.taskmanagementaprel11.dao.TaskRepository;
import az.developia.taskmanagementaprel11.model.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
 
public class TaskManagementAprel11Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TaskManagementAprel11Application.class, args);

		TaskRepository	repository=context.getBean(TaskRepository.class);

		Task task=new Task();
		task.setName("Java Oyren");
		task.setStatus("baslanib");
		task.setBeginDate(Date.valueOf(LocalDate.now()));
		task.setDescription("Yazmaq lazimdir");
		task.setExpireDate(Date.valueOf(LocalDate.now()));
		task.setEndDate(Date.valueOf(LocalDate.now()));
		task.setCategoryid(5);
		task.setUsername("Cavid");




		// repository.save(task);
	 
	}

}
