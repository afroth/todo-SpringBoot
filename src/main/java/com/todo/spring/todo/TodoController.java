package com.todo.spring.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // assigning as controller
@CrossOrigin(origins = "http://localhost:4200")//origin url for class
public class TodoController {
    @Autowired
    private TodoHardCodedService todoService;

    //***********************************************************************************
    // return the array list to the mapped url route
    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        return todoService.findAll();
    }// end method



    //***********************************************************************************
    //
    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable Long id){

        return todoService.findById(id);
    }// end method


    //***********************************************************************************
    // Deletes a to do object based on the username and id in the mapping
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Long id){
        // delete the passed in id
        Todo todo = todoService.deleteById(id);

        if(todo!=null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
