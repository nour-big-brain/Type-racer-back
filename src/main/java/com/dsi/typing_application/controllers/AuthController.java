package com.dsi.typing_application.controllers;

import com.dsi.typing_application.entities.User;
import com.dsi.typing_application.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IAuthService iAuthService;
    @PostMapping("/signUp")
    public ResponseEntity<String> signup(@RequestBody User user){
        return ResponseEntity.ok(iAuthService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        return ResponseEntity.ok(iAuthService.login(user));
    }

}
