package com.whatsapp.connector.business.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.whatsapp.connector.business.actionreply.strategy.ActionReplyStrategy;
import com.whatsapp.connector.business.Conversation;
import com.whatsapp.connector.business.actionreply.factory.StrategyFactory;
import com.whatsapp.connector.service.MessageDetection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConversationImpl implements Conversation {

    @Autowired
    private final StrategyFactory strategyFactory;

    private final MessageDetection messageDetection;

    public ConversationImpl(MessageDetection messageDetection, StrategyFactory strategyFactory) {
        this.messageDetection = messageDetection;
        this.strategyFactory = strategyFactory;
    }

    @Override
    public void processRequest(String payload) throws IOException {
        String inputMessage = messageDetection.getInputMessage(payload);
        String sender = messageDetection.getSender(payload);
        strategyFactory.getStrategy(inputMessage).replyToIncomingMessage(inputMessage, sender);

    }

}
