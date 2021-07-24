package az.developia.taskmanagementaprel11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 import org.hibernate.cfg.IdGeneratorResolverSecondPass;
import az.developia.taskmanagementaprel11.dao.TaskRepository;
import az.developia.taskmanagementaprel11.model.Task;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> findAll(){
		return taskRepository.findAll();
	}
	public Task add(Task t){

  return taskRepository.save(t);
	
	}

	public void deleteById(Integer id){

		taskRepository.deleteById(id);;
				;
			}
	
}
