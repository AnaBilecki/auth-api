package com.authapi.resources;

import com.authapi.dto.user.UserRegisterRequestDTO;
import com.authapi.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    UserService service;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody UserRegisterRequestDTO dto) {
        service.register(dto);
        return ResponseEntity.ok().build();
    }
}
