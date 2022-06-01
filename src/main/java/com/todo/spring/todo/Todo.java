package com.todo.spring.todo;

import java.util.Date;
import java.util.Objects;

public class Todo {

    private long id;// stores user id
    private String username;// stores the username or the user
    private String description;// description of the task
    private Date targetDate;// target date to complete the task
    private Boolean isCompleted = false;// stores if the task was completed or not

    protected Todo(){}
    //***********************************************************************************
    // class constructor
    public Todo(long id, String username, String description, Date targetDate, Boolean isCompleted) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.isCompleted = isCompleted;
    }

    //***********************************************************************************
    // getters and setters for class variables
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

//    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //***********************************************************************************



}// end class Todo
