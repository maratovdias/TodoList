package com.example.diaska.controller;
import com.example.diaska.entity.UserEntity;
import com.example.diaska.exceptions.UserAlreadyExistException;
import com.example.diaska.exceptions.UserNotFoundException;
import com.example.diaska.repository.UserRepo;
import com.example.diaska.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        }
        catch(UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("")
    public ResponseEntity getOneUser(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }catch(UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.delete(id));
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Сервер не пашет");
        }
    }

}
