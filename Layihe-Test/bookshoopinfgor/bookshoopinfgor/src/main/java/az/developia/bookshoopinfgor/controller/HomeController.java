package az.developia.bookshoopinfgor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import az.developia.bookshoopinfgor.config.Mysession;

@Controller
public class HomeController {
@Autowired
private Mysession mysession;

    @GetMapping(path = { "/home", "/" })
    public String showHomePage() {
        System.out.println(mysession.getBasketBooks());
        return "home";
    }
}
