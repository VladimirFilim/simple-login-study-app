package com.authenticationbaseapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.logging.Logger;


@Controller
public class LoginController {
    Logger logger = Logger.getLogger(LoginController.class.getName());
    @RequestMapping("/login")
    public String login(
            @RequestParam(value="username") String username,
            @RequestParam(value="password") String password,
            Model model) {
        logger.info("username: " + username + "password: " + password);

        return "login.html";
    }
}
