package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService AuthService;

    public AuthController(AuthService service) {
        this.AuthService = service;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email,
                                        @RequestParam String password) {
        if (AuthService.authenticate(email, password)) {
            return ResponseEntity.ok("Успешная авторизация!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неверные данные");
        }
    }
}