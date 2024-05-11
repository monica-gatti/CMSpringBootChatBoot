package com.whatsapp.connector.business.actionreply.strategy.impl;

import com.whatsapp.connector.service.impl.MessageResponseWithInteractiveList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.whatsapp.connector.business.actionreply.strategy.ActionReplyStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("welcome_postback_yes")
public class ActionAskToProceed implements ActionReplyStrategy {

    private final MessageResponseWithInteractiveList messageResponseWithInteractiveList;

    public ActionAskToProceed(MessageResponseWithInteractiveList messageResponseWithInteractiveList) {
        this.messageResponseWithInteractiveList = messageResponseWithInteractiveList;
    }

    final static Logger logger = LoggerFactory.getLogger(ActionAskToProceed.class);
    @Override
        public void replyToIncomingMessage(String inputMessage, String to) {
            logger.info(inputMessage);
            String outgoingMessage = "Great! Let's proceed. Please select one of the following options";
            messageResponseWithInteractiveList.replyToMessage(to, outgoingMessage);
    }


}
