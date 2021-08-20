package az.developia.shopmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.shopmanagement.dao.ShopRepository;
import az.developia.shopmanagement.model.Shop;

import org.hibernate.cfg.IdGeneratorResolverSecondPass;   

@Service
public class ShopService {

	@Autowired
	private ShopRepository shopRepository;
	
	public List<Shop> findAll(){
		return shopRepository.findAll();
	}
	public Shop add(Shop s){

  return shopRepository.save(s);
	
	}

	public void deleteById(Integer id){

		shopRepository.deleteById(id);;
				;
			}
	
}
