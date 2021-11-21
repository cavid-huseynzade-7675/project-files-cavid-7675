package az.developia.compshopcavidhuseynzade.controller;

import az.developia.compshopcavidhuseynzade.config.Mysession;
import az.developia.compshopcavidhuseynzade.daos.ComputerDao;
import az.developia.compshopcavidhuseynzade.model.Computer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ShopController {
   
    @Autowired
    private Mysession mysession;
    
    @Autowired
    private ComputerDao computerDao;

    @GetMapping(path = "/shopping")
    public String showCustomersPage(Model model) {
        List<Computer> computers = computerDao.findAll();
        model.addAttribute("computers", computers);

        
        return "shopping";
    }
}
