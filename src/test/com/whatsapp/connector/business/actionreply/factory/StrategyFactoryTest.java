package com.whatsapp.connector.business.actionreply.factory;

import com.whatsapp.connector.model.IncomingMessageType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
@SpringBootTest
class StrategyFactoryTest {

    @Autowired
    private final StrategyFactory strategyFactory;

    StrategyFactoryTest(StrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    @Test
    void getStrategyWelcomeActionTest() throws IOException {
        strategyFactory.getStrategy(IncomingMessageType.INIT).replyToIncomingMessage(IncomingMessageType.INIT, "06232323");

    }
}


