package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserInfo;
import com.example.demo.repository.UserInfoRepository;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private UserInfoRepository userInfoRepository;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user, HttpSession session) {
        if (authService.register(user)) {
            User fullUser = authService.getUserByUsername(user.getUsername());
            session.setAttribute("userId", fullUser.getId());
            return ResponseEntity.ok("Регистрация прошла успешно");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Пользователь уже существует");
        }
    }
    @PostMapping("/fill")
    public ResponseEntity<String> saveProfile(@RequestBody UserInfo userInfo, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Вы не авторизованы");
        }

        userInfo.setUserId(userId);

        userInfoRepository.save(userInfo);

        return ResponseEntity.ok("Профиль сохранён");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user, HttpSession session) {
        if (authService.authenticate(user)) {
            User fullUser = authService.getUserByUsername(user.getUsername());
            session.setAttribute("userId", fullUser.getId());
            return ResponseEntity.ok("Авторизация успешна");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неверный логин или пароль");
        }
    }
    @GetMapping("/profile")
    public ResponseEntity<UserInfo> getProfile(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        UserInfo info = userInfoRepository.findByUserId(userId);
        System.out.println("INFO: " + info);
        if (info == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(info);
    }
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok().build();
    }
}