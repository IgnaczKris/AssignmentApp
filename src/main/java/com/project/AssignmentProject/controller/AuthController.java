package com.project.AssignmentProject.controller;

import com.project.AssignmentProject.repository.UserRepository;
import com.project.AssignmentProject.service.AuthService;
import com.project.AssignmentProject.web.request.AuthenticationRequest;
import com.project.AssignmentProject.web.response.AuthenticationResponse;
import com.project.AssignmentProject.web.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final AuthService authService;
    @Autowired
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> register(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok()
                .header(
                        HttpHeaders.AUTHORIZATION,
                        String.valueOf(
                                authService
                                        .authenticate(request)
                                        .getToken())
                ).body(
                        userRepository.findByUsername(
                                request.getUsername()
                        )
                                .orElseThrow()
                );
    }
}
