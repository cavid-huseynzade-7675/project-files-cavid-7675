package az.developia.compshopcavidhuseynzade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.compshopcavidhuseynzade.daos.ComputerDao;
import az.developia.compshopcavidhuseynzade.model.Computer;
import az.developia.compshopcavidhuseynzade.model.SearchModel;

@RestController
@RequestMapping(path = "/rest/computers")
public class ComputerRestController {
    
    @Autowired
    private ComputerDao computerDao;

    @GetMapping
    public List<Computer> findAll() {
        return computerDao.findAll();
    }

    @GetMapping(path = "/{id}")
    public Computer findById(@PathVariable(name = "id") Integer id) {
        return computerDao.findById(id).get();
    }
    @PostMapping(path = "/search-find-partial")
public List<Computer> FindAllSearchFindPartial(@RequestBody SearchModel search){
    return computerDao.findALLSearchFieldFindPartial(search.getSearch(),search.getBegin(),search.getLength());
}
}
