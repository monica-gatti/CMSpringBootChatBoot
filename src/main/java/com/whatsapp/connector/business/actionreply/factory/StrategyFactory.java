package com.whatsapp.connector.business.actionreply.factory;
import com.whatsapp.connector.business.actionreply.strategy.ActionReplyStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class StrategyFactory {

    @Autowired
    Map<String, ActionReplyStrategy> strategys = new ConcurrentHashMap<>(3);


    public ActionReplyStrategy getStrategy(String content) {
        return strategys.get(content);
    }
}
