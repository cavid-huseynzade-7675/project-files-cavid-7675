package az.developia.compshopcavidhuseynzade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.compshopcavidhuseynzade.daos.UserDao;
import az.developia.compshopcavidhuseynzade.model.UserModel;

@RestController
@RequestMapping(path = "/rest/users")
public class UserRestController {

    @Autowired
    private UserDao userDao;

    @GetMapping()
    public List<UserModel> allUsers() {
        return userDao.allUsers();
    }
}
