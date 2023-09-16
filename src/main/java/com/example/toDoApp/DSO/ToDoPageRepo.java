package com.example.toDoApp.DSO;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.toDoApp.Model.ToDo;

public interface ToDoPageRepo extends PagingAndSortingRepository<ToDo, Integer> {
    // Your custom query methods (if any)
}