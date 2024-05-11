package com.whatsapp.connector.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.connector.service.MessageDetection;
import org.springframework.stereotype.Service;

@Service
public class MessageDetectionImpl implements MessageDetection {

    @Override
    public String detectCustomType(JsonNode jsonNode) throws JsonProcessingException {
        return jsonNode.get("message").get("custom").get("message_type").asText();
    }
    @Override
    public String detectCustomInteractiveType(JsonNode jsonNode) throws JsonProcessingException {
        return jsonNode.get("message").get("custom").get("interactive").get("type").asText();
    }
    @Override
    public String getInputMessage(String message) throws JsonProcessingException {
        String inputText = "";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(message);
        String type = detectCustomType(jsonNode);
        if (type.equals("text")){
            inputText = jsonNode.get("message").get("text").asText();
        } else if (type.equals("interactive")) {
            String customType = detectCustomInteractiveType(jsonNode);
            if(customType.equals("button_reply"))
                inputText = jsonNode.get("message").get("custom").get("interactive").get("button_reply").get("id").asText();
            else if (customType.equals("list_reply"))
                inputText = jsonNode.get("message").get("custom").get("interactive").get("list_reply").get("id").asText() + ";" +jsonNode.get("message").get("custom").get("interactive").get("list_reply").get("title").asText();
        }
        return inputText;
    }

    @Override
    public String getSender(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(message);
        return jsonNode.get("from").get("number").asText();
    }

}
