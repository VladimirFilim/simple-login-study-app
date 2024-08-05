package com.authenticationbaseapp.controllers;

import com.authenticationbaseapp.services.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String main() {
        String username = loggedUserManagementService.getUsername();
        if (username == null) {
            return "redirect:/";
        } else {
            return "main.html";
        }
    }
}
