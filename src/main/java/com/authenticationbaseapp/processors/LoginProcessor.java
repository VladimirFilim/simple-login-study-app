package com.authenticationbaseapp.processors;

import com.authenticationbaseapp.services.LoggedUserManagementService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Objects;
import java.util.logging.Logger;

@Getter
@Setter
@Component
@RequestScope
public class LoginProcessor {
    Logger logger = Logger.getLogger(LoginProcessor.class.getName());

    private LoggedUserManagementService loggedUserManagementService;
    public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    private String username;
    private String password;

    public boolean login() {
        String password = this.password;
        String username = this.username;
        logger.info(username + " is trying to login with password: " + password);

        boolean loggingResult = false;

        if("natalie".equals(username) && "1234".equals(password)) {
            loggedUserManagementService.setUsername(username);
            loggingResult = true;
            logger.info("Logged in successfully, username: " + this.username);
        }

        return loggingResult;
    }
}
