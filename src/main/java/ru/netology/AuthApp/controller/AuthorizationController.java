package ru.netology.AuthApp.controller;



import ru.netology.AuthApp.model.Authorities;
import ru.netology.AuthApp.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {

    @Autowired
    private AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(
            @RequestParam("user") String user,
            @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}