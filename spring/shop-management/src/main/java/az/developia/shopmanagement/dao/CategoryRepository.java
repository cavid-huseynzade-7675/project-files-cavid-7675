package az.developia.shopmanagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.developia.shopmanagement.model.Category;


public interface CategoryRepository  extends JpaRepository<Category,Integer> {

	



		 
	 }