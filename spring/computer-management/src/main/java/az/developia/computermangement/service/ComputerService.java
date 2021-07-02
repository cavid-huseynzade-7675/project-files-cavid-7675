package az.developia.computermangement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.computermangement.dao.ComputerRepository;
import az.developia.computermangement.model.Computer;

import org.hibernate.cfg.IdGeneratorResolverSecondPass;

@Service
public class ComputerService {

	@Autowired
	private ComputerRepository computerRepositry;
	
	public List<Computer> findAll(){
		return computerRepositry.findAll();
	}
	public void add(Computer t){

computerRepositry.save(t);
		;
	}

	
	
}
