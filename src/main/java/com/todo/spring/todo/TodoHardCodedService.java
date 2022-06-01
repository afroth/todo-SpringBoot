package com.todo.spring.todo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService {

    // ArrayList of object To do, to hold the created objects
    private static List<Todo> todos = new ArrayList<>();

    private static int idCounter = 0;// counter for to do list id;

    static{
        todos.add(new Todo(++idCounter, "new-user","Become software Engineer",
                            new Date(), false));

        todos.add(new Todo(++idCounter, "new-user","get new job",
                new Date(), false));

        todos.add(new Todo(++idCounter, "new-user","meet new friends",
                new Date(), false));
    }

    //***********************************************************************************
    // Method returns the array list.
    public List<Todo> findAll(){
        return todos;
    }


    //***********************************************************************************
    // method gets object from the array list with the matching id passed in
    public Todo deleteById(long id){
        // method call to get object with matching id
        Todo todo = findById(id);
        // if object from method call is null
        if(todo == null) return null;
        // remove the returned object from array list
        todos.remove(todo);
        // return removed object
        return todo;
    }

    //***********************************************************************************
    // Method finds the Object in the array list with matching id and returns the object
    public Todo findById(Long id){
        // enhanced for-loop to loop through array list
        for (Todo todo : todos) {
            // if the array list object id matches the passed in id
            if (id == todo.getId()) {
                // return matched object
                return todo;
            }// end if
        }// end for
        // no matching id object found
        return null;
    }

    //***********************************************************************************
    // for updating a to do object, we delete the existing object with the matching id passed in
    // we then add the passed in object to the arrayList.
    public Todo saveObject(Todo todo ) {

//        todo.setCompleted(false);

        if (todo.getId() == -1 || todo.getId()== 0) {
            todo.setId(++idCounter);
            todos.add(todo);

        } else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }
}// end class
