	package az.developia.taskmanagementaprel11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Task add(@RequestBody Task task){
		 
	 return taskService.add(task);
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
