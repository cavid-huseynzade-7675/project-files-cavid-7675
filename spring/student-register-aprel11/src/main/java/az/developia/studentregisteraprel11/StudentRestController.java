package az.developia.studentregisteraprel11;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/students")
@CrossOrigin(origins="*")
public class StudentRestController {

	@GetMapping
	public List<Student> findAll(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Student> students=new ArrayList<>();
		students.add(new Student("Adil","Qafarov"));
		students.add(new Student("Serxan","Babayev"));
		students.add(new Student("Ayxan","Mirzeyev"));
		return students;
	}
	
	@GetMapping(path="/id")
	public  Student  findById(){
		 
		return new Student("Adil","Qafarov");
	}
	
}
