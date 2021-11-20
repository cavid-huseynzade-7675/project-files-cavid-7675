package az.developia.compshopcavidhuseynzade.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.compshopcavidhuseynzade.daos.*;
import az.developia.compshopcavidhuseynzade.model.*;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    private boolean userCreated = false;

    @GetMapping(path = "/show-login")
    public String showCustomersPage(Model model) {
  
        return "custom-login";
    }

    @GetMapping(path = "create-account")
    public String showCreateAccountPage(Model model) {
        UserModel user = new UserModel();
        model.addAttribute("user", user);
        return "create-account";
    }

    @PostMapping(path = "/create-account-procces")
    public String saveUser(@Valid @ModelAttribute(name = "user") UserModel user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create-account";
        }
        ;
        boolean userExists = userDao.createUser(user);
        if (userExists) {
            model.addAttribute("userExists", "");
            return "create-account";
        }
        userCreated = true;
        return "redirect:/show-login";
    }
}