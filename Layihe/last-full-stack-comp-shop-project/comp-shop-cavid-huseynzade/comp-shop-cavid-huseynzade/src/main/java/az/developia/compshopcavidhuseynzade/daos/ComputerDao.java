package az.developia.compshopcavidhuseynzade.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.developia.compshopcavidhuseynzade.model.Computer;

public interface ComputerDao extends JpaRepository<Computer,Integer> {
    public List<Computer> findAllByUsername(String username);
  
   }
