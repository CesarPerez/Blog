package com.cesar.blog.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import com.cesar.blog.dto.SocketMsg;

public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/channel/public")
    public SocketMsg sendMessage(@Payload SocketMsg chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/channel/public")
    public SocketMsg addUser(@Payload SocketMsg chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
	
}
