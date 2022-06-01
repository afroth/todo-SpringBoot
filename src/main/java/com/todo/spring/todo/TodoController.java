package com.todo.spring.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    //***********************************************************************************
    //
    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable Long id,@RequestBody Todo todo ){

        Todo todoUpdated = todoService.saveObject(todo);

        return new ResponseEntity<>(todo, HttpStatus.OK);
    }// end updateTodo

    //***********************************************************************************
    //
    @PostMapping("/users/{username}/todos/")
    public ResponseEntity<Void> newTodo(@PathVariable String username,@RequestBody Todo todo ){

        Todo createdTodo = todoService.saveObject(todo);

        URI uri =  ServletUriComponentsBuilder.fromCurrentRequest()
              .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }// end newTodo
}
