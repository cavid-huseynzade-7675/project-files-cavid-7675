package az.developia.bookshoopinfgor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.bookshoopinfgor.model.Order;

public interface OrderDAO extends JpaRepository<Order,Integer> {
  public List<Order> findAllByUsername(String username);
}
