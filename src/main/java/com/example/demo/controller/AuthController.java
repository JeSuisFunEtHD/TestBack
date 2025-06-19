package com.example.authdemo.controller;

import com.example.authdemo.model.User;
import com.example.authdemo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (authService.register(user)) {
            return ResponseEntity.ok("Регистрация прошла успешно");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Пользователь уже существует");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        if (authService.authenticate(user)) {
            return ResponseEntity.ok("Авторизация успешна");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неверный логин или пароль");
        }
    }
}