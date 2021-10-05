package az.developia.bookshoopinfgor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    
     
    @GetMapping(path = "/show-login")
    public String showCustomersPage(){

        return "my-custom-login";
    }
}