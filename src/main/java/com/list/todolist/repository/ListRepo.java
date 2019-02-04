package com.list.todolist.repository;

import com.list.todolist.entity.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ListRepo extends CrudRepository<List, Integer> {

}
