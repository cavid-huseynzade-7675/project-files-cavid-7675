	package az.developia.computermangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.computermangement.model.Computer;

import az.developia.computermangement.service.ComputerService;

@RestController
@RequestMapping(path = "/computers")
@CrossOrigin(origins = "*")

public class ComputerRestController {

	@Autowired
	private ComputerService computerService;


	
	@GetMapping
	public List<Computer> findAll() { 
		return computerService.findAll();
	}
	
	@PostMapping
	public void add(@RequestBody Computer task){
		 
		computerService.add(task);
	}



}
