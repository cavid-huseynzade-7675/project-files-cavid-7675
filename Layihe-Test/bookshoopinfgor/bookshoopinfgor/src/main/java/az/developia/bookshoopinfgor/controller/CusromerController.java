package az.developia.bookshoopinfgor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CusromerController {
    
     
    @GetMapping(path = "/customer")
    public String showCustomersPage(){

        return "customer";
    }
}
