package az.developia.compshopcavidhuseynzade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ShopController {
   
    
    

    @GetMapping(path = "/shopping")
    public String showCustomersPage() {

        
        return "shopping";
    }
}
