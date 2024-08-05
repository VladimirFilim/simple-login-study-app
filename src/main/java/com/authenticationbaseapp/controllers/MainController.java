package com.authenticationbaseapp.controllers;

import com.authenticationbaseapp.services.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.logging.Logger;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String main(
            @RequestParam(required = false) String Logout,
            Model model
    ) {
        if(Logout != null) {
            loggedUserManagementService.setUsername("null");
            return "redirect:/";
        }

        String username = loggedUserManagementService.getUsername();
        if (username == null) {
            logger.info("Access denied!");
            return "redirect:/";
        }
        model.addAttribute("username", username);
        return "main.html";
    }
}
