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
public class MessageResponseWithInteractiveButtons implements MessageResponse {

    Logger logger = LoggerFactory.getLogger(MessageResponseWithInteractiveButtons.class);
    @Override
    public void replyToMessage(String to, String message) {
        logger.info("MessageResponseWithInteractiveButtons");

        String payload = "{\"messages\":" +
                "{\"authentication\":{\"productToken\": \""+ productToken +"\"}," +
                "\"msg\":[{\"body\":{\"type\":\"auto\",\"content\":\"Fallback Text\"}," +
                "\"to\":[{\"number\":\""+ to + "\"}]," +
                "\"from\":\"" + from + "\",\"allowedChannels\":[\"WhatsApp\"]," +
                "\"richContent\":{\"conversation\":[{\"interactive\":{\"type\":\"button\",\"header\":{\"type\":\"text\",\"text\":\"\"}," +
                "\"body\":{\"text\":\"" + message + "\"},\"footer\":{\"text\":\"\"}," +
                "\"action\":{\"buttons\":[{\"type\":\"reply\",\"reply\":{\"id\":\"welcome_postback_yes\",\"title\":\"Yes\"}}," +
                "{\"type\":\"reply\",\"reply\":{\"id\":\"welcome_postback_no\",\"title\":\"No\"}}]}}}]}}]}}";
        logger.info(payload);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(payload, headers);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(url, request, String.class);

        System.out.println("Response: " + response);

    }
}
