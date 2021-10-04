package az.developia.bookshopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.developia.bookshopping.model.BookModel;

@Repository
public interface BookDao extends JpaRepository<BookModel,Integer>  {
	
}
