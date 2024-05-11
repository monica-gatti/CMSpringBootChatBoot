package com.whatsapp.connector.service.impl;
import com.whatsapp.connector.service.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.web.servlet.function.ServerRequest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Service
public class MessageResponseWithSimpleText implements MessageResponse {

    private static Logger LOGGER = LoggerFactory.getLogger(MessageResponseWithSimpleText.class);

    @Override
    public void replyToMessage(String to, String outgoingmessage) throws IOException {
        LOGGER.info("MessageResponseSimpleText");

        outgoingmessage = "Hi, do you want to proceed";

        String payload = "{ \"messages\": { \"authentication\": { \"productToken\": \"" + productToken + "\" }, \"msg\": [ { \"to\": [ { \"number\": \"" + to + "\" } ], \"content\": { \"type\": \"text\", \"text\": \"" + outgoingmessage + "\" }, \"from\": \"0033786833588\" } ] } }";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(payload, headers);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(url, request, String.class);

        System.out.println("Response: " + response);

    }
}
