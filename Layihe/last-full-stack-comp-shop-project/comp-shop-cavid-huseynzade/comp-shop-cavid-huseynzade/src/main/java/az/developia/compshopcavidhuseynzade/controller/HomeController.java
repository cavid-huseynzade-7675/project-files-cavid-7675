package az.developia.compshopcavidhuseynzade.controller;

import az.developia.compshopcavidhuseynzade.config.Mysession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
    @Autowired 
private Mysession mysession;
    
    @GetMapping(path = { "/home", "/" })
    public String showHomePage(Model model) {
        String username=mysession.getUsername();
        if (username.equals("anonymousUser")) {
            
        } else {
            model.addAttribute("username", "Istifadeci adi:" + mysession.getUsername());}
          
                return "home";
            }
        
 
    
}
