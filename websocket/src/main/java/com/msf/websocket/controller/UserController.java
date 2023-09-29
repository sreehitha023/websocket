package com.msf.websocket.controller;

import com.msf.websocket.model.User;
import com.msf.websocket.model.UserResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class UserController {
    @MessageMapping("/user")
    @SendTo("/topic/user")
    public UserResponse getUser(User user) throws InterruptedException {
       Thread.sleep(2000);
        return new UserResponse("Hi " + HtmlUtils.htmlEscape( user.getName()));
    }
}
