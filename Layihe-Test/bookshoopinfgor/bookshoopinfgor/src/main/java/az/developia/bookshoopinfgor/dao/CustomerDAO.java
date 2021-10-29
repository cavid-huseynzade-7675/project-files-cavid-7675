package az.developia.bookshoopinfgor.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.bookshoopinfgor.model.Customer;
import az.developia.bookshoopinfgor.model.Order;

public interface CustomerDAO extends JpaRepository<Customer,Integer> {
  public Customer findByPhone(String phone);
  public Customer findByEmail(String email);
}
