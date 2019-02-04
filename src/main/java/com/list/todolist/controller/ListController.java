package com.list.todolist.controller;


import com.list.todolist.entity.List;
import com.list.todolist.repository.ListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class ListController {

    private ListRepo listRepo;

    @Autowired
    public ListController(ListRepo listRepo){
        this.listRepo = listRepo;
    }

    @PostMapping("/item")
    public List createItem(@RequestBody List listItem){
        return listRepo.save(listItem);
    }

    @GetMapping("/items")
    public Iterable<List> getList(){
        return listRepo.findAll();
    }

    @GetMapping("items/{id}")
    public Optional<List> getItemById(@PathVariable Integer id){
        return listRepo.findById(id);
    }

    @DeleteMapping("items/delete/{id}")
    public String deleteItemById(@PathVariable Integer id){
        listRepo.deleteById(id);
        return "Item removed successfully!";
    }




}
