package com.example.diaska.model;

import com.example.diaska.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserModel {
private Long id;
private String username;
private List<TodoModel>todos;
    public UserModel() {
    }

    public static UserModel userToModel(UserEntity user){
        UserModel model = new UserModel();
        model.setId(user.getId());
        model.setUsername(user.getUsername());
        model.setTodos(user.getTodos().stream().map(TodoModel::todoEntityToModel).collect(Collectors.toList()) );
        return model;
    }

    public List<TodoModel> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoModel> todos) {
        this.todos = todos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
