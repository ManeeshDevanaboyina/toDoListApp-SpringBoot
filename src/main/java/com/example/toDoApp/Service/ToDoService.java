package com.example.toDoApp.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.toDoApp.DSO.ToDoRepo;
import com.example.toDoApp.Model.ToDo;

@Service
public class ToDoService {


	@Autowired
	private ToDoRepo toDoRepo;
		
	public Iterable<ToDo> getAllTodos() {
        return toDoRepo.findAll();
    }
	
	public Iterable<ToDo> insert(List<ToDo> toDos) {
	    Iterable<ToDo> insertedToDos=toDoRepo.saveAll(toDos);
	    return insertedToDos;
	

	}
	
	public Optional<ToDo> findbyTitle(String title) {
		
		return toDoRepo.findByTitle(title);
	}
	
	 public boolean deleteTodo(Integer id) {
	        Optional<ToDo> todo = toDoRepo.findById(id);
	        if (todo.isPresent()) {
	            toDoRepo.delete(todo.get());
	            return true;
	        }
	        return false;
	    }
	public Optional<ToDo> getTodoById(Integer id) {
        return toDoRepo.findById(id);
    }
	
	 public ToDo updateTodo(Integer id, ToDo updatedTodo) {
	        ToDo existingTodo = toDoRepo.findById(id).orElse(null);
	        if (existingTodo != null) {
	            existingTodo.setTitle(updatedTodo.getTitle());
	            existingTodo.setDescription(updatedTodo.getDescription());
	            existingTodo.setStatus(updatedTodo.getStatus());
	            return toDoRepo.save(existingTodo);
	        }
	        return null;
	    }
}
