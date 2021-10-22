package az.developia.bookshoopinfgor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.bookshoopinfgor.dao.BookDao;
import az.developia.bookshoopinfgor.model.BookModel;
import az.developia.bookshoopinfgor.model.SearchModel;

@RestController
@RequestMapping(path = "/rest/books")
public class BookRestController {

    @Autowired
    private BookDao bookDao;

    @GetMapping(path = "/{id}")
    public BookModel findById(@PathVariable(name = "id") Integer id) {
        return bookDao.findById(id).get();
    }

    @GetMapping
    public List<BookModel> findAll() {
        return bookDao.findAll();
    }
@PostMapping(path = "/search")
public List<BookModel> FindAllSearch(@RequestBody SearchModel search){
    return bookDao.findALLSearch(search.getSearch());
}

}
