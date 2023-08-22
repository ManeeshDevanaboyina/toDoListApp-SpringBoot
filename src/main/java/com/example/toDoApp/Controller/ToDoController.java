package com.example.toDoApp.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.toDoApp.Model.ToDo;
import com.example.toDoApp.Service.ToDoService;

@RestController
@RequestMapping(value="/toDo")
public class ToDoController {
	
	@Autowired
	private ToDoService toDoService;
	
	@GetMapping(value="/all")
	public ResponseEntity<Iterable<ToDo>> findAll() {
		 Iterable<ToDo> getAll=toDoService.getAllTodos();
		 return new ResponseEntity<>(getAll,HttpStatus.OK);
	}
	
	@GetMapping(value="/{title}")
	public ResponseEntity<ToDo> findbyTitle(@PathVariable("title") String title) {
		Optional<ToDo> title1= toDoService.findbyTitle(title);
		return title1.map(value->new ResponseEntity<>(value,HttpStatus.OK)).orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Optional<ToDo>> getTodoById(@PathVariable("id") Integer id) {
		try {
            Optional<ToDo> todo = toDoService.getTodoById(id);
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	
	
	@PostMapping(value="/create")
	public ResponseEntity<ToDo> insert(@RequestBody ToDo toDo) {
		ToDo insert= toDoService.insert(toDo);
		return new ResponseEntity<>(insert,HttpStatus.CREATED);
	}

	
	
	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable("id") Integer id) {
		 if(toDoService.deleteTodo(id)) {
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 
	}
	
	
	@PutMapping(value="/{id}/{ToDo}")
	public ResponseEntity<ToDo> updateTodo(@PathVariable("id") Integer id,@PathVariable("ToDo") ToDo updatedTodo) {
		ToDo updated= toDoService.updateTodo(id,updatedTodo);
		if(updated!= null) {
			return new ResponseEntity<>(updated,HttpStatus.OK);
		}
		return new ResponseEntity<>(updated,HttpStatus.NOT_FOUND);
	}
	
	

}
