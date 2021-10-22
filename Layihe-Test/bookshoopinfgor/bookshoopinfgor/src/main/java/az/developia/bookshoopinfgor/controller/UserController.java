package az.developia.bookshoopinfgor.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.bookshoopinfgor.dao.UserDao;
import az.developia.bookshoopinfgor.model.User;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    private boolean userCreated = false;

    @GetMapping(path = "/show-login")
    public String showCustomersPage(Model model) {
        if (userCreated) {
            model.addAttribute("userCreated", "");
            userCreated = false;
        }

        return "my-custom-login";
    }

    @GetMapping(path = "create-account")
    public String showCreateAccountPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create-account";
    }

    @PostMapping(path = "/create-account-procces")
    public String saveUser(@Valid @ModelAttribute(name = "user") User user, BindingResult result, Model model) {
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