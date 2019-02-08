package com.list.todolist.repository;

import com.list.todolist.entity.ToDoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ListRepo extends CrudRepository<ToDoList, Integer> {
    List<ToDoList> findAll();
    String deleteByItem(String item);
    ToDoList findByItem(String item);

}
