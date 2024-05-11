package com.whatsapp.connector.service.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.whatsapp.connector.service.MessageResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageResponseWithInteractiveList implements MessageResponse {

    Logger logger = LoggerFactory.getLogger(MessageResponseWithInteractiveList.class);
    @Override
    public void replyToMessage(String to, String message) {
        logger.info("MessageResponseWithInteractiveList");
        String payload = "{\"messages\": {\"authentication\": {\"productToken\": " + productToken + "}," +
                "\"msg\": [{\"body\": {\"type\": \"auto\",\"content\": \"Fallback Text\"}," +
                "\"to\": [{\"number\": " + to + "}],\"from\": " + from + ",\"allowedChannels\": [\"WhatsApp\"],\"richContent\": {" +
                "\"conversation\": [{\"interactive\": {\"type\": \"list\",\"header\": {\"type\": \"text\",\"text\": \"\"}," +
                "\"body\": {\"text\": " + message + "}," +
                "\"footer\": {\"text\": \"\"},\"action\": {\"button\": \"Operation\",\"sections\": {\n" +
                "            \"title\": \"Your services:\",\n" +
                "            \"rows\": [\n" +
                "                {\n" +
                "                    \"id\": \"DDDF87654\",\n" +
                "                    \"title\": \"Service 1\",\n" +
                "                    \"description\": \"Choose this service\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }}}}]}}]}}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(payload, headers);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(url, request, String.class);

        System.out.println("Response: " + response);
    }
}
