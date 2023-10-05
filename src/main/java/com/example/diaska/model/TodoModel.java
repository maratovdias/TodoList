package com.example.diaska.model;

import com.example.diaska.entity.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
public class TodoModel {
    private Long id;
    private String title;
    private Boolean completed ;

    public TodoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    public static TodoModel todoEntityToModel(TodoEntity todoEntity){
        TodoModel todoModel = new TodoModel();
        todoModel.setId(todoEntity.getId());
        todoModel.setCompleted(todoEntity.getCompleted());
        todoModel.setTitle(todoEntity.getTitle());
        return todoModel;
    }
}
