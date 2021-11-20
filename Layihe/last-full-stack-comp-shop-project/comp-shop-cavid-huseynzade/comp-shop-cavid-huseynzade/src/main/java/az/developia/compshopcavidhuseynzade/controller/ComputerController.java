package az.developia.compshopcavidhuseynzade.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import az.developia.compshopcavidhuseynzade.config.Mysession;
import az.developia.compshopcavidhuseynzade.daos.ComputerDao;
import az.developia.compshopcavidhuseynzade.file.StorageService;
import az.developia.compshopcavidhuseynzade.model.Computer;

@Controller
public class ComputerController {
    
    @Autowired
    private StorageService storageService;

    @Autowired
    private ComputerDao computerDao;
    @Autowired
    private Mysession mysession;

    @GetMapping(path = "/computers")
    public String showComputers(Model model) {
        List<Computer> computers = computerDao.findAllByUsername(mysession.getUsername());
        model.addAttribute("computers", computers);

        model.addAttribute("username", "Istifadeci adi:" + mysession.getUsername());
  
    return "computers";
} 
@GetMapping(path = "/computers/new")
public String openNewBookPage(Model model) {
    Computer computer = new Computer();
    model.addAttribute("computer", computer);
    model.addAttribute("header", "Yeni Komputer");
    return "new-computer";
}

@PostMapping(path = "/computers/new-computer-procces")
    public String saveBook(@Valid @ModelAttribute(name = "computer") Computer computer, BindingResult result,
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile, Model model) {

        if (result.hasErrors()) {
            return "new-computer";
        }
        // book.setImage("book.image");
        computer.setUsername(mysession.getUsername());
        if (imageFile.isEmpty() && computer.getId() != null) {
            computer.setImage(computerDao.findById(computer.getId()).get().getImage());
        } else {
            computer.setImage(storageService.store(imageFile));
        }

        computer.setImage(storageService.store(imageFile));
        computerDao.save(computer);
      return "redirect:/computers";
    }

    @GetMapping(path = "/computers/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") Integer id, Model model) {
        boolean computerExsist = computerDao.findById(id).isPresent();

        if (computerExsist) {
         computerDao.deleteById(id);
        } else {

        }

        List<Computer> computers = computerDao.findAll();
        model.addAttribute("computers", computers);

        return "redirect:/computers";
    }

    @GetMapping(path = "/computers/edit/{id}")
    public String editBook(@PathVariable(name = "id") Integer id, Model model) {
        Optional<Computer> computerOptional = computerDao.findById(id);
        boolean computerExsist = computerOptional.isPresent();
        Computer computer = new Computer();
        if (computerExsist) {
            computer = computerOptional.get();
        } else {

        }

        model.addAttribute("header", "Redakte Et");
        model.addAttribute("computer", computer);

        return "new-computer";
    }
}
