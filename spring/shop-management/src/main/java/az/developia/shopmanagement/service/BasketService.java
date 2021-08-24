package az.developia.shopmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import az.developia.shopmanagement.dao.BasketRepository;
import az.developia.shopmanagement.model.Basket;

@Service
public class BasketService {
    

    @Autowired
	private BasketRepository basketrepository;

    public List<Basket> findAll(){
		return basketrepository.findAll();
	}
	public Basket add(Basket s){

  return basketrepository.save(s);
	}

	public void deleteById(Integer id){

		basketrepository.deleteById(id);;
				;
			}
			public void deleteAll(){

				basketrepository.deleteAll();
						;
					}
}
