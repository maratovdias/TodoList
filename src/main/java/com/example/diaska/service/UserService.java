package com.example.diaska.service;

import com.example.diaska.entity.UserEntity;
import com.example.diaska.exceptions.UserAlreadyExistException;
import com.example.diaska.exceptions.UserNotFoundException;
import com.example.diaska.model.UserModel;
import com.example.diaska.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Имя занято");
        }
        return userRepo.save(user);
    }

    public UserModel getOne(Long id) throws UserNotFoundException{
        UserEntity user = userRepo.findById(id).get();
        if ( user == null){
            throw new UserNotFoundException("Пользователь не найден");
        }
        return UserModel.userToModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }

}
