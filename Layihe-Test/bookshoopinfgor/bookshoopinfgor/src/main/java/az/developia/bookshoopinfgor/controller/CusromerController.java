package az.developia.bookshoopinfgor.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CusromerController {
    
     
    @GetMapping(path = "/customer")
    public String showCustomersPage( Model model){
ArrayList<String> books=new ArrayList<>();
for (int i = 0; i < 100; i++) {
    books.add(" ");
}
model.addAttribute("books", books);
        return "customer";
    }
}
