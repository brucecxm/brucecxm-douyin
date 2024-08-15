package com.bruce.websocket.entity;

import lombok.Data;

@Data
public class ChatMessage {
    private String sender;
    private String content;
    private String type;

    // Getters and Setters
}
