package az.developia.compshopcavidhuseynzade.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.developia.compshopcavidhuseynzade.model.Computer;

public interface ComputerDao extends JpaRepository<Computer,Integer> {
    public List<Computer> findAllByUsername(String username);
  

    @Query(value = "select * from computer where username like %?1% or description like %?1% or price like %?1% or marka like %?1% or model like %?1% or yaddastipi like %?1%  or emeliyyatsistemi like %?1%     limit ?2,?3" ,nativeQuery = true)
    public List<Computer> findALLSearchFieldFindPartial(String search,Integer begin,Integer lenght);

   }
