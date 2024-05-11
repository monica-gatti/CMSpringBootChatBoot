package com.whatsapp.connector.business.actionreply.strategy.impl;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class ActionWelcomeTest {
    @Test
    void testReplyToInitIncomingMessage() throws IOException {
        ActionWelcome myList = mock(ActionWelcome.class);
        doNothing().when(myList).replyToIncomingMessage(isA(String.class), isA(String.class));
        myList.replyToIncomingMessage("hello", "020202");
        verify(myList, times(1)).replyToIncomingMessage("hello","020202");
    }

    @Test
    void testReplyToWrongIncomingMessage() throws IOException {
        ActionWelcome myList = mock(ActionWelcome.class);
        doNothing().when(myList).replyToIncomingMessage(isA(String.class), isA(String.class));
        myList.replyToIncomingMessage("abc", "020202");
        verify(myList, times(0)).replyToIncomingMessage("hello","020202");
    }
}
