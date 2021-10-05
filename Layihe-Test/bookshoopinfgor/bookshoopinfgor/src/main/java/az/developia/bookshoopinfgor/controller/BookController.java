package az.developia.bookshoopinfgor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.bookshoopinfgor.dao.BookDao;
import az.developia.bookshoopinfgor.model.BookModel;

@Controller
public class BookController {
    

    @Autowired
    private BookDao bookDao;

    @GetMapping(path = "/books")
    public String  showBooks(Model model) {
        List<BookModel> books=bookDao.findAll();
        model.addAttribute("books", books);
        return "books";
    }
    @GetMapping(path = "/books/new")
    public String  openNewBookPage(Model model) {
        BookModel book=new BookModel();
model.addAttribute("book", book);
     return "new-book";
    }

  
    
    @PostMapping(path = "/books/new-book-procces")
    public String  saveBook(@ModelAttribute(name = "book")BookModel book,Model model) {
        book.setImage("book.image");
        book.setUsername("dea");
bookDao.save(book);
List<BookModel> books=bookDao.findAll();
model.addAttribute("books", books);
     return "books";
    }

    @GetMapping(path = "/books/delete/{id}")
    public String  deleteBook(@PathVariable(name = "id")Integer id,Model model) {

   System.out.println(id);
     return "books";
    }
}
