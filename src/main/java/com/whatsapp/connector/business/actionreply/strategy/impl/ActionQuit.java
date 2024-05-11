package com.whatsapp.connector.business.actionreply.strategy.impl;

import com.whatsapp.connector.service.impl.MessageResponseWithSimpleText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.whatsapp.connector.business.actionreply.strategy.ActionReplyStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("welcome_postback_no")
public class ActionQuit implements ActionReplyStrategy {

    private final MessageResponseWithSimpleText messageResponseWithSimpleText;
    public ActionQuit(MessageResponseWithSimpleText messageResponseWithSimpleText) {
        this.messageResponseWithSimpleText = messageResponseWithSimpleText;
    }
    final static Logger logger = LoggerFactory.getLogger(ActionQuit.class);
    @Override
    public void replyToIncomingMessage(String inputMessage, String to) throws IOException {
        logger.info(inputMessage);
        String outgoingMessage = "Thank you for using our service. See you soon";
        messageResponseWithSimpleText.replyToMessage(to,outgoingMessage);
    }


}
