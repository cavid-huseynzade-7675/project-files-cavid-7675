package az.developia.bookshoopinfgor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.developia.bookshoopinfgor.model.BookModel;

public interface BookDao extends JpaRepository<BookModel,Integer> {
    public List<BookModel> findAllByUsername(String username);
    @Query(value = "select * from book_model where name like %?1%",nativeQuery = true)
    public List<BookModel> findALLSearch(String search);

    @Query(value = "select * from book_model where name like %?1% or description like %?1% or price like %?1% or page_count like %?1% or author like %?1%" ,nativeQuery = true)
    public List<BookModel> findALLSearchField(String search);


    @Query(value = "select * from book_model where name like %?1% or description like %?1% or price like %?1% or page_count like %?1% or author like %?1% limit ?2,?3" ,nativeQuery = true)
    public List<BookModel> findALLSearchFieldFindPartial(String search,Integer begin,Integer lenght);
}
