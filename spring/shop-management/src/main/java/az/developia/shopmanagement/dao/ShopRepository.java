package az.developia.shopmanagement.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import az.developia.shopmanagement.model.Shop;

public interface ShopRepository  extends JpaRepository<Shop,Integer> {

	public List<Shop> findAllByUsername(String username);	

@Query(value="select * from shop where username=?1 and name like %?2%",nativeQuery = true)
	public List<Shop> findAllByUsernameSearch(String username,String search); 		
		 
	 }
	

