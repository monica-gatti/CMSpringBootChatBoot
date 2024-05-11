package com.whatsapp.connector.business.actionreply.strategy.impl;

import com.whatsapp.connector.service.impl.MessageResponseWithInteractiveButtons;
import com.whatsapp.connector.service.impl.MessageResponseWithSimpleText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.whatsapp.connector.business.actionreply.strategy.ActionReplyStrategy;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("hello")
public class ActionWelcome implements ActionReplyStrategy {

    final Logger logger = LoggerFactory.getLogger(ActionWelcome.class);

    private final MessageResponseWithInteractiveButtons messageResponse;

    public ActionWelcome(MessageResponseWithInteractiveButtons messageResponse) {
        this.messageResponse = messageResponse;
    }

    @Override
    public void replyToIncomingMessage(String inputMessage, String to) throws IOException {
        logger.info(inputMessage);
        String outgoingMessage = "Hello, do you want to proceed in your account ?";
        messageResponse.replyToMessage(to, outgoingMessage);
    }

}
