package com.example.diaska.service;

import com.example.diaska.entity.TodoEntity;
import com.example.diaska.entity.UserEntity;
import com.example.diaska.model.TodoModel;
import com.example.diaska.repository.TodoRepo;
import com.example.diaska.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;
    public TodoModel createTodo(TodoEntity todoEntity, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todoEntity.setUser(user);
        return TodoModel.todoEntityToModel(todoRepo.save(todoEntity));
    }
    public TodoModel completeTodo(Long id){
        TodoEntity todoEntity = todoRepo.findById(id).get();
        todoEntity.setCompleted(!todoEntity.getCompleted());
        return TodoModel.todoEntityToModel(todoRepo.save(todoEntity));
    }
}
