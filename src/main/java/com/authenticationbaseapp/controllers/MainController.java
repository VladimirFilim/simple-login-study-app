package com.authenticationbaseapp.controllers;

import com.authenticationbaseapp.services.LoggedUserManagementService;
import com.authenticationbaseapp.services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.logging.Logger;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public MainController(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/main")
    public String main(
            @RequestParam(required = false) String Logout,
            Model model
    ) {

        if(Logout != null) {
            loggedUserManagementService.setUsername(null);
        }

        String username = loggedUserManagementService.getUsername();
        int loginCount = loginCountService.getCount();
        if (username == null) {
            logger.info("Access denied!");
            return "redirect:/";
        }
        model.addAttribute("username", username);
        model.addAttribute("loginCount", loginCount);
        return "main.html";
    }
}
