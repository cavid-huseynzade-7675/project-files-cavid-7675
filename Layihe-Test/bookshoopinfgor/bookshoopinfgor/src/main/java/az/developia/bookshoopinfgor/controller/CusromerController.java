package az.developia.bookshoopinfgor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import az.developia.bookshoopinfgor.config.Mysession;
import az.developia.bookshoopinfgor.dao.BookDao;
import az.developia.bookshoopinfgor.model.BookModel;

@Controller
public class CusromerController {

    @Autowired
    private Mysession mysession;

    @Autowired
    private BookDao bookDao;

    @GetMapping(path = "/customer")
    public String showCustomersPage(Model model) {

        List<BookModel> books = bookDao.findAll();
        model.addAttribute("books", books);
        System.out.println(mysession.getUsername());
        return "customer";
    }
}
