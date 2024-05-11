package com.whatsapp.connector.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.whatsapp.connector.business.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class ConversationController {

    @Autowired
    private Conversation conversation;

    public ConversationController(Conversation conversation) {
        this.conversation = conversation;
    }


    @PostMapping("/conversation")
    public ResponseEntity<String> responseToClient(@RequestBody String payload) throws IOException {
        conversation.processRequest(payload);
       return ResponseEntity.ok("body");
    }



}
