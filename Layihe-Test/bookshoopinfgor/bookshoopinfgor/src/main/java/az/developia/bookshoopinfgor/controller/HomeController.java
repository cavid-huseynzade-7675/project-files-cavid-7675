package az.developia.bookshoopinfgor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import az.developia.bookshoopinfgor.config.Mysession;

@Controller
public class HomeController {
@Autowired
private Mysession mysession;

    @GetMapping(path = { "/home", "/" })
    public String showHomePage(Model model) {
        System.out.println(mysession.getBasketBooks());
String username=mysession.getUsername();
if (username.equals("anonymousUser")) {
    
} else {
    model.addAttribute("username", username);
}

        return "home";
    }
}
