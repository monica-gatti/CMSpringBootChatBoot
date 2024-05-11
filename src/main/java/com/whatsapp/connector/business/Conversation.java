package com.whatsapp.connector.business;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface Conversation {

    void processRequest(String payload) throws IOException;

}
