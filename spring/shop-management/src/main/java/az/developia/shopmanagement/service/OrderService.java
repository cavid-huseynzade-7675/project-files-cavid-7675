package az.developia.shopmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import az.developia.shopmanagement.dao.OrderRepository;
import az.developia.shopmanagement.model.Orders;

@Service
public class OrderService {
    

    @Autowired
	private OrderRepository orderRepository;

    public List<Orders> findAll(){
		return orderRepository.findAll();
	}
	public Orders add(Orders s){

  return orderRepository.save(s);
	
	}
	public void deleteById(Integer id){

		orderRepository.deleteById(id);;
				;
			}
}
