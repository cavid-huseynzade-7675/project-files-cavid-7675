package az.developia.bookshoopinfgor.controller;

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

import az.developia.bookshoopinfgor.config.Mysession;
import az.developia.bookshoopinfgor.dao.BookDao;
import az.developia.bookshoopinfgor.model.BookModel;

@Controller
public class BookController {
    

    @Autowired
    private BookDao bookDao;

    @Autowired
    private Mysession mysession;

    @GetMapping(path = "/books")
    public String  showBooks(Model model) {
     //   List<BookModel> books=bookDao.findAll();
     List<BookModel> books=bookDao.findAllByUsername(mysession.getUsername());
        model.addAttribute("books", books);
        model.addAttribute("username", "Istifadeci adi:"+mysession.getUsername());
        return "books";
    }
    @GetMapping(path = "/books/new")
    public String  openNewBookPage(Model model) {
        BookModel book=new BookModel();
model.addAttribute("book", book);
model.addAttribute("header", "Yeni Kitab");
     return "new-book";
    }

  
    
    @PostMapping(path = "/books/new-book-procces")
    public String  saveBook(@Valid @ModelAttribute(name = "book")BookModel book
    ,BindingResult result,Model model) {

        if (result.hasErrors()) {
            return "new-book";
        }
        book.setImage("book.image");
        book.setUsername(mysession.getUsername());
bookDao.save(book);
List<BookModel> books=bookDao.findAll();

model.addAttribute("books", books);
     return "redirect:/books";
    }

    @GetMapping(path = "/books/delete/{id}")
    public String  deleteBook(@PathVariable(name = "id")Integer id,Model model) {
boolean bookExsist=bookDao.findById(id).isPresent();

if (bookExsist) {
    bookDao.deleteById(id);
} else {
    
}
 
List<BookModel> books=bookDao.findAll();
model.addAttribute("books", books);

     return "redirect:/books";
    }

    @GetMapping(path = "/books/edit/{id}")
    public String  editBook(@PathVariable(name = "id")Integer id,Model model) {
        Optional<BookModel> bookOptional=bookDao.findById(id);
boolean bookExsist=bookOptional.isPresent();
BookModel book=new BookModel();
if (bookExsist) {
    book=bookOptional.get();
} else {
    
}
 
model.addAttribute("header", "Redakte Et");
model.addAttribute("book", book);

     return "new-book";
    }
}
