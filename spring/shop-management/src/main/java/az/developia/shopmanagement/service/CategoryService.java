package az.developia.shopmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import az.developia.shopmanagement.dao.CategoryRepository;
import az.developia.shopmanagement.model.Category;

@Service
public class CategoryService {
    

    @Autowired
	private CategoryRepository categoryRepository;

    public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	public Category add(Category s){

  return categoryRepository.save(s);
	
	}
	public void deleteById(Integer id){

		categoryRepository.deleteById(id);;
				;
			}
}
