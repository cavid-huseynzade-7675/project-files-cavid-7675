package az.developia.bookshoopinfgor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.bookshoopinfgor.model.BookModel;

public interface BookDao extends JpaRepository<BookModel,Integer> {
    
}
