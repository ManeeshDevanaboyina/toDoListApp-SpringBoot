package com.example.toDoApp.DSO;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.toDoApp.Model.ToDo;


@Repository
public interface ToDoRepo extends CrudRepository<ToDo,Integer> {
	
	public Optional<ToDo> findByTitle(String title);

	public void deleteByTitle(String title);

}
