package com.authenticationbaseapp.processors;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Getter
@Setter
@Component
@RequestScope
public class LoginProcessor {
    private String username;
    private String password;

    public boolean login() {
        String password = this.password;
        String username = this.username;

        return "natalie".equals(username) && password.equals("1234");
    }
}
