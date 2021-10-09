package az.developia.bookshoopinfgor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.bookshoopinfgor.model.BookModel;

public interface BookDao extends JpaRepository<BookModel,Integer> {
    public List<BookModel> findAllByUsername(String username);
}
