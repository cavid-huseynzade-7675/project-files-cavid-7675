package az.developia.compshopcavidhuseynzade.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {

 

  
    @GetMapping(path = "/create-account")
        public String showCreateAccountPage(){
        return "create-account";
    
    }

    @GetMapping(path = "/show-login")
    public String showLoginPage(){
    return "custom-login";

}
}