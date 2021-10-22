package az.developia.bookshoopinfgor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.developia.bookshoopinfgor.model.BookModel;

public interface BookDao extends JpaRepository<BookModel,Integer> {
    public List<BookModel> findAllByUsername(String username);
    @Query(value = "select * from book_model where name like %?1%",nativeQuery = true)
    public List<BookModel> findALLSearch(String search);
}
