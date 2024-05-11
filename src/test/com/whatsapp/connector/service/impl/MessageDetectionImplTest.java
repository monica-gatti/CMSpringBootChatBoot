package com.whatsapp.connector.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsapp.connector.service.MessageDetection;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageDetectionImplTest {

    private final MessageDetection messageDetection = new MessageDetectionImpl();

    static final String TEXT_MESSAGE = "{\"reference\": \"wamid.HBgLMzM2MzM1NjI2MDYVAgASGBYzRUIwNEVDQjNCNDQ2\", \"messageContext\": \"\", \"from\": {\"number\": \"+33646877202\", \"name\": \"Claude\"}, \"to\": {\"number\": \"0033720056125\"}, \"message\": {\"text\": \"hello\", \"media\": {\"mediaUri\": \"\", \"contentType\": \"\", \"title\": \"\"}, \"custom\": {\"meta_received_time\": \"2024-05-06T11:37:48\", \"message_type\": \"text\"}, \"error\": \"\"}, \"groupings\": [\"\", \"\", \"\"], \"time\": \"2024-05-06 13:37:49\", \"timeUtc\": \"2024-05-06T11:37:49\", \"channel\": \"WhatsApp\"}";

    static final String INTERACTIVE_BUTTON_MESSAGE = "{\"reference\": \"wamid.HBgLMzM2MzM1NjI2MDYVAgASGBYzRUIwRTUzQjEyODI3\", \"messageContext\": \"a7ad9045-0d3a-40dc-9363-6737e1608a71\", \"from\": {\"number\": \"+33646877202\", \"name\": \"Claude\"}, \"to\": {\"number\": \"0033720056125\"}, \"message\": {\"text\": \"Oui\", \"media\": {\"mediaUri\": \"\", \"contentType\": \"\", \"title\": \"\"}, \"custom\": {\"interactive\": {\"type\": \"button_reply\", \"list_reply\": null, \"button_reply\": {\"id\": \"welcome_postback_yes\", \"title\": \"Oui\"}, \"nfm_reply\": null}, \"meta_received_time\": \"2024-05-06T11:37:55\", \"message_type\": \"interactive\"}, \"error\": \"\"}, \"groupings\": [\"\", \"\", \"\"], \"time\": \"2024-05-06 13:37:56\", \"timeUtc\": \"2024-05-06T11:37:56\", \"channel\": \"WhatsApp\"}";

    static final String INTERACTIVE_LIST_MESSAGE = "{\"reference\": \"wamid.HBgLMzM2MzM1NjI2MDYVAgASGBYzRUIwNjI5QzUyOUJF\", \"messageContext\": \"7e2a5d15-1dea-4c83-af89-a5cc7dce47fb\", \"from\": {\"number\": \"+33646877202\", \"name\": \"Claude\"}, \"to\": {\"number\": \"0033720056125\"}, \"message\": {\"text\": \"Now TV\", \"media\": {\"mediaUri\": \"\", \"contentType\": \"\", \"title\": \"\"}, \"custom\": {\"interactive\": {\"type\": \"list_reply\", \"list_reply\": {\"id\": \"69676e2540e9237efjj4f5bf\", \"title\": \"Now TV\", \"description\": \"Select to cancel \"}, \"button_reply\": null, \"nfm_reply\": null}, \"meta_received_time\": \"2024-05-06T11:38:17\", \"message_type\": \"interactive\"}, \"error\": \"\"}, \"groupings\": [\"\", \"\", \"\"], \"time\": \"2024-05-06 13:38:18\", \"timeUtc\": \"2024-05-06T11:38:18\", \"channel\": \"WhatsApp\"}";

    @Test
    void detect_text_message_custom_type() throws JsonProcessingException, JSONException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(TEXT_MESSAGE);
        assertEquals("text", messageDetection.detectCustomType(jsonNode));
    }

    @Test
    void get_text_message() throws JsonProcessingException, JSONException {
        assertEquals("hello", messageDetection.getInputMessage(TEXT_MESSAGE));
    }

    @Test
    void detect_interactive_message_custom_type() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNodeButton = objectMapper.readTree(INTERACTIVE_BUTTON_MESSAGE);
        assertEquals("button_reply", messageDetection.detectCustomInteractiveType(jsonNodeButton));
        JsonNode jsonNodeList = objectMapper.readTree(INTERACTIVE_LIST_MESSAGE);
        assertEquals("list_reply", messageDetection.detectCustomInteractiveType(jsonNodeList));
    }

    @Test
    void get_interactive_message() throws JsonProcessingException, JSONException {
        assertEquals("welcome_postback_yes", messageDetection.getInputMessage(INTERACTIVE_BUTTON_MESSAGE));
        assertEquals("69676e2540e9237efjj4f5bf;Now TV", messageDetection.getInputMessage(INTERACTIVE_LIST_MESSAGE));
    }

    @Test
    void get_sender_test() throws JsonProcessingException {
        assertEquals("+33646877202", messageDetection.getSender(TEXT_MESSAGE));
    }


}