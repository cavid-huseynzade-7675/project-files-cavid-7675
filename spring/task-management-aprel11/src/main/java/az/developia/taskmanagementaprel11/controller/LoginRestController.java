 package az.developia.taskmanagementaprel11.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/login")
@CrossOrigin(origins = "*")
public class LoginRestController {
    


    @GetMapping
        public void login(){  }
    
}