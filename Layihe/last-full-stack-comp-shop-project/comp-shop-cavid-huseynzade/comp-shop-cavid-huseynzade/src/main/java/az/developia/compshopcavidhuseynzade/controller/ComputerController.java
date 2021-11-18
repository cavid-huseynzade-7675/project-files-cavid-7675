package az.developia.compshopcavidhuseynzade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ComputerController {
    
    @GetMapping(path = "/computers")
    public String showComputers() {
                return "computers";
    }

}
