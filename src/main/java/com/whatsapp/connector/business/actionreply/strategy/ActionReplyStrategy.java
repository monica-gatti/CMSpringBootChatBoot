package com.whatsapp.connector.business.actionreply.strategy;


import java.io.IOException;

public interface ActionReplyStrategy {
    void replyToIncomingMessage(String inputMessage, String to) throws IOException;
}
