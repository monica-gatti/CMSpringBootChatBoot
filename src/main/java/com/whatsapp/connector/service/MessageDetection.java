package com.whatsapp.connector.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public interface MessageDetection {


    String detectCustomType(JsonNode jsonNode) throws JsonProcessingException;

    String detectCustomInteractiveType(JsonNode jsonNode) throws JsonProcessingException;

    String getInputMessage(String message) throws JsonProcessingException;

    String getSender(String message) throws JsonProcessingException;
}
