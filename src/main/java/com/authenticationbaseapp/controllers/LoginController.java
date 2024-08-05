package com.authenticationbaseapp.controllers;

import com.authenticationbaseapp.processors.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.logging.Logger;


@Controller
public class LoginController {
    private final LoginProcessor loginProcessor;
    Logger logger = Logger.getLogger(LoginController.class.getName());

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet(Model model) {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(
            @RequestParam(value="username") String username,
            @RequestParam(value="password") String password,
            Model model) {
        loginProcessor.setPassword(password);
        loginProcessor.setUsername(username);
        boolean loggedIn = loginProcessor.login();

        if(loggedIn) {
            model.addAttribute("message", "You're now logged in");
        } else {
            model.addAttribute("message", "Logging failed");
        }

        return "login.html";
    }
}
