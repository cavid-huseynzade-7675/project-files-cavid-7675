	package az.developia.taskmanagementaprel11.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.taskmanagementaprel11.model.Task;
import az.developia.taskmanagementaprel11.model.taskDeleteModel;
import az.developia.taskmanagementaprel11.service.TaskService;

@RestController
@RequestMapping(path = "/tasks")
@CrossOrigin(origins = "*")

public class TaskRestController {

	@Autowired
	private TaskService taskService;


	
	@GetMapping
	public List<Task> findAll() { 
		return taskService.findAll();
	}
	
	@PostMapping
	public Task add(@Valid @RequestBody Task task,BindingResult result){
		Task taskSaved=null;
		if (result.hasErrors()) {
			 System.out.println("Error var");
			 System.out.println(result.getErrorCount());
			 System.out.println(result.getFieldErrorCount());
			 System.out.println(result.getFieldErrorCount("name"));
			 System.out.println("getAllerrors"+result.getAllErrors());

			 System.out.println("---------------");
			 for (ObjectError error:result.getAllErrors()){
				System.out.println(error.getDefaultMessage());
			 }

		}else{
			taskSaved=taskService.add(task);
		}
	 return taskSaved;
	}

	@DeleteMapping(value = "/delete-task")
	public void deleteTasks(@RequestBody taskDeleteModel t1){
	for (int i = 0; i < t1.getIds().size(); i++) {
		taskService.deleteById(t1.getIds().get(i));
	}
	}

	@DeleteMapping(value = "/{id}")
	public void deleteTaskById(@PathVariable Integer id){
	taskService.deleteById(id);
	}

}
