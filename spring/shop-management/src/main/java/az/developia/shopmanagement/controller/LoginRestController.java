 package az.developia.shopmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.shopmanagement.dao.UserDao;
import az.developia.shopmanagement.model.UserModel;

@RestController

@CrossOrigin(origins = "*")
public class LoginRestController {
    @Autowired
    private UserDao userDao;


    @GetMapping(path="/login")
        public List<String> login(){ 

            String username=SecurityContextHolder.getContext().getAuthentication().getName();
            return userDao.getUserRoles(username);
         }
    
         @PostMapping(path="/signup")
         public void signup(@RequestBody UserModel user){ 
 userDao.createUser(user);
             
          }
}